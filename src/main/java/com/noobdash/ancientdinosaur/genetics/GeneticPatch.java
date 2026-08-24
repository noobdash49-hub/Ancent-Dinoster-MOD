package com.noobdash.ancientdinosaur.genetics;

/**
 * 遺伝子パッチ
 * スロットにはめるアイテムで、恐竜のステータスを向上させたり特性を追加したりする
 */
public class GeneticPatch {
    private final PatchType patchType;
    private final String japaneseName;
    private final SlotType compatibleSlot;

    // 効果値（加算）
    private final float damageBonus;              // 攻撃力 (%)
    private final float healthBonus;             // HP (%)
    private final float defenseBonus;            // 防御 (%)
    private final float movementSpeedBonus;      // 移動速度 (%)
    private final float gatheringAmountBonus;    // 採取量 (%)
    private final float gatheringSpeedBonus;     // 採取速度 (%)
    private final float inventoryMultiplier;     // インベントリ倍率 (0 = 変化なし, 1.0 = 2倍)

    public GeneticPatch(PatchType patchType, String japaneseName, SlotType compatibleSlot,
                       float damageBonus, float healthBonus, float defenseBonus,
                       float movementSpeedBonus, float gatheringAmountBonus,
                       float gatheringSpeedBonus, float inventoryMultiplier) {
        this.patchType = patchType;
        this.japaneseName = japaneseName;
        this.compatibleSlot = compatibleSlot;
        this.damageBonus = damageBonus;
        this.healthBonus = healthBonus;
        this.defenseBonus = defenseBonus;
        this.movementSpeedBonus = movementSpeedBonus;
        this.gatheringAmountBonus = gatheringAmountBonus;
        this.gatheringSpeedBonus = gatheringSpeedBonus;
        this.inventoryMultiplier = inventoryMultiplier;
    }

    // ゲッター
    public PatchType getPatchType() {
        return patchType;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public SlotType getCompatibleSlot() {
        return compatibleSlot;
    }

    public float getDamageBonus() {
        return damageBonus;
    }

    public float getHealthBonus() {
        return healthBonus;
    }

    public float getDefenseBonus() {
        return defenseBonus;
    }

    public float getMovementSpeedBonus() {
        return movementSpeedBonus;
    }

    public float getGatheringAmountBonus() {
        return gatheringAmountBonus;
    }

    public float getGatheringSpeedBonus() {
        return gatheringSpeedBonus;
    }

    public float getInventoryMultiplier() {
        return inventoryMultiplier;
    }

    @Override
    public String toString() {
        return japaneseName;
    }
}
