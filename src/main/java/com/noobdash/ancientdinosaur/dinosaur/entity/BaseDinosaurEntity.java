package com.noobdash.ancientdinosaur.dinosaur.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import com.noobdash.ancientdinosaur.dinosaur.DinosaurType;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurSpec;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurStats;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurBehavior;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurIndividualStats;
import com.noobdash.ancientdinosaur.dinosaur.data.DinosaurData;
import com.noobdash.ancientdinosaur.genetics.DinosaurGenetics;

/**
 * 恐竜エンティティの基戴クラス
 */
public abstract class BaseDinosaurEntity extends AnimalEntity {
    protected DinosaurType dinosaurType;
    protected DinosaurIndividualStats individualStats;
    protected DinosaurGenetics genetics;
    protected boolean isTamed;
    protected String ownerName;
    protected DinosaurBehavior behavior;
    protected float currentHunger;

    public BaseDinosaurEntity(EntityType<? extends BaseDinosaurEntity> entityType, World world) {
        super(entityType, world);
        this.behavior = DinosaurBehavior.NEUTRAL;
        this.currentHunger = 100.0f;
    }

    /**
     * エンティティ属性を設定
     */
    public static DefaultAttributeContainer.Builder createDinosaurAttributes() {
        return AnimalEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0);
    }

    /**
     * 恐竜スペックを初期化
     */
    protected void initializeDinosaurStats(DinosaurType type) {
        this.dinosaurType = type;
        DinosaurSpec spec = DinosaurSpec.getSpec(type);
        
        if (spec == null) return;

        // 個体値を生成（野生デフォルト）
        if (this.individualStats == null) {
            this.individualStats = new DinosaurIndividualStats(
                DinosaurIndividualStats.generateWildLevel()
            );
        }

        // 遪伝子システムを作成（スロット数はランダム）
        int slotCount = (this.random.nextInt(3) + 1); // 1-3スロット
        this.genetics = new DinosaurGenetics(
            this.getUuidAsString(),
            slotCount
        );

        // ステータスを適用
        applyDinosaurStats(spec);

        this.isTamed = false;
    }

    /**
     * 恐竜ステータスをMinecraftエンティティ属性に適用
     */
    protected void applyDinosaurStats(DinosaurSpec spec) {
        DinosaurStats baseStats = spec.getBaseStats();
        float multiplier = this.individualStats.getStatMultiplier();

        // 野生ステータスを適用
        float maxHealth = this.individualStats.applyMultiplier(baseStats.getMaxHealth());
        float attack = this.individualStats.applyMultiplier(baseStats.getAttack());
        float movementSpeed = this.individualStats.applyMultiplier(baseStats.getMovementSpeed());
        this.currentHunger = this.individualStats.applyMultiplier(baseStats.getMaxHunger());

        // 属性を設定
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(attack);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(movementSpeed);
        this.setHealth(maxHealth);
    }

    /**
     * ティム時のステータス適用
     */
    public void applyTamedStats(DinosaurSpec spec) {
        DinosaurStats baseStats = spec.getBaseStats();
        DinosaurStats tamedStats = baseStats.getTamedStats();
        float multiplier = this.individualStats.getStatMultiplier();

        // ティムステータスを適用
        float maxHealth = this.individualStats.applyMultiplier(tamedStats.getMaxHealth());
        float attack = this.individualStats.applyMultiplier(tamedStats.getAttack());
        float movementSpeed = this.individualStats.applyMultiplier(tamedStats.getMovementSpeed());
        this.currentHunger = this.individualStats.applyMultiplier(tamedStats.getMaxHunger());

        // 属性を設定
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(attack);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(movementSpeed);
        this.setHealth(maxHealth);
    }

    /**
     * プレイヤーとのインタラクション
     */
    @Override
    public ActionResult interactAtEntity(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient) {
            if (this.isTamed && this.ownerName.equals(player.getGameProfile().getName())) {
                // TODO: インベントリ UIを開く
                return ActionResult.SUCCESS;
            } else if (!this.isTamed) {
                // TODO: ティム際の処理
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    // ゲッターセッター
    public DinosaurType getDinosaurType() {
        return dinosaurType;
    }

    public DinosaurIndividualStats getIndividualStats() {
        return individualStats;
    }

    public DinosaurGenetics getGenetics() {
        return genetics;
    }

    public boolean isTamed() {
        return isTamed;
    }

    public void setTamed(boolean tamed, String ownerName) {
        this.isTamed = tamed;
        this.ownerName = ownerName;
        if (tamed && this.getWorld() instanceof ServerWorld) {
            applyTamedStats(DinosaurSpec.getSpec(this.dinosaurType));
        }
    }

    public DinosaurBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(DinosaurBehavior behavior) {
        this.behavior = behavior;
    }

    public float getCurrentHunger() {
        return currentHunger;
    }

    public void setCurrentHunger(float hunger) {
        this.currentHunger = Math.max(0, Math.min(hunger, 100.0f));
    }

    /**
     * NBT読み書き
     */
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (this.individualStats != null) {
            DinosaurData.writeToNBT(nbt, this.individualStats, this.isTamed, 
                                   this.ownerName, this.behavior, this.currentHunger, 100.0f);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.individualStats = DinosaurData.readLevelFromNBT(nbt);
        this.isTamed = DinosaurData.isTamedFromNBT(nbt);
        this.ownerName = DinosaurData.getOwnerFromNBT(nbt);
        this.behavior = DinosaurData.getBehaviorFromNBT(nbt);
        this.currentHunger = DinosaurData.getHungerFromNBT(nbt);
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null; // TODO: 交配処理
    }
}
