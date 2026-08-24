package com.noobdash.ancientdinosaur.dinosaur;

/**
 * 恐竜のサブステータス
 * 
 * 野生恐竜用: 経験値ドロップ量、テイム難易度、攻撃速度、攻撃範囲
 * テイム恐竜用: 採取量、採取効率、採取範囲、初期カバン容量
 */
public class DinosaurSubStats {
    // 野生恐竜用
    private int experienceDropAmount;
    private int tamingDifficulty; // 麻酔矢必要本数
    private float attackSpeed; // 攻撃の頻度
    private float attackRange; // 攻撃範囲（ブロック）

    // テイム恐竜用
    private float gatheringAmount; // 採取量倍率
    private float gatheringEfficiency; // 採取効率（%）
    private float gatheringRange; // 採取範囲（ブロック）
    private int initialInventorySlots; // 初期カバン容量（スロット数）

    public DinosaurSubStats(int experienceDropAmount, int tamingDifficulty, 
                            float attackSpeed, float attackRange,
                            float gatheringAmount, float gatheringEfficiency,
                            float gatheringRange, int initialInventorySlots) {
        this.experienceDropAmount = experienceDropAmount;
        this.tamingDifficulty = tamingDifficulty;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.gatheringAmount = gatheringAmount;
        this.gatheringEfficiency = gatheringEfficiency;
        this.gatheringRange = gatheringRange;
        this.initialInventorySlots = initialInventorySlots;
    }

    // 野生恐竜用ゲッター
    public int getExperienceDropAmount() {
        return experienceDropAmount;
    }

    public int getTamingDifficulty() {
        return tamingDifficulty;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public float getAttackRange() {
        return attackRange;
    }

    // テイム恐竜用ゲッター
    public float getGatheringAmount() {
        return gatheringAmount;
    }

    public float getGatheringEfficiency() {
        return gatheringEfficiency;
    }

    public float getGatheringRange() {
        return gatheringRange;
    }

    public int getInitialInventorySlots() {
        return initialInventorySlots;
    }

    @Override
    public String toString() {
        return "DinosaurSubStats{" +
                "experienceDropAmount=" + experienceDropAmount +
                ", tamingDifficulty=" + tamingDifficulty +
                ", attackSpeed=" + attackSpeed +
                ", attackRange=" + attackRange +
                ", gatheringAmount=" + gatheringAmount +
                ", gatheringEfficiency=" + gatheringEfficiency +
                ", gatheringRange=" + gatheringRange +
                ", initialInventorySlots=" + initialInventorySlots +
                '}';
    }
}
