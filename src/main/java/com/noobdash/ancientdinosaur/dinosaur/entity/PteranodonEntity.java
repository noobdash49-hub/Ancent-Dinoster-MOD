package com.noobdash.ancientdinosaur.dinosaur.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.world.World;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurType;

/**
 * プテラノドンエンティティ（飛行可能）
 */
public class PteranodonEntity extends BaseDinosaurEntity {
    private boolean isFlying;

    public PteranodonEntity(EntityType<? extends PteranodonEntity> entityType, World world) {
        super(entityType, world);
        this.isFlying = false;
    }

    @Override
    protected void initLiving() {
        super.initLiving();
        this.initializeDinosaurStats(DinosaurType.PTERANODON);
    }

    /**
     * 飛行初期化
     */
    public void startFlying() {
        if (this.currentHunger > 0) {
            this.isFlying = true;
            this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
                .setBaseValue(this.getIndividualStats().applyMultiplier(1.8f));
        }
    }

    /**
     * 飛行終了
     */
    public void stopFlying() {
        this.isFlying = false;
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED)
            .setBaseValue(this.getIndividualStats().applyMultiplier(1.2f));
    }

    public boolean isFlying() {
        return isFlying;
    }
}
