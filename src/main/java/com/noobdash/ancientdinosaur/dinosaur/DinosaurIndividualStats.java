package com.noobdash.ancientdinosaur.dinosaur;

import java.util.Random;

/**
 * 恐竜個体値レベルシステム（Lv1～10）
 * 
 * 野生恐竜は決まった確率で各レベルが出現する
 */
public class DinosaurIndividualStats {
    private final int level; // 1-10
    private final float statMultiplier;

    // レベル別のステータス倍率
    private static final float[] STAT_MULTIPLIERS = {
        0.75f,   // レベル1
        0.82f,   // レベル2
        0.89f,   // レベル3
        0.95f,   // レベル4
        1.0f,    // レベル5（標準）
        1.05f,   // レベル6
        1.11f,   // レベル7
        1.18f,   // レベル8
        1.25f,   // レベル9
        1.30f    // レベル10
    };

    // 野生恐竜の出現確率（%）
    private static final float[] WILD_SPAWN_RATES = {
        2.0f,    // レベル1:   2%
        5.0f,    // レベル2:   5%
        12.0f,   // レベル3:  12%
        15.0f,   // レベル4:  15%
        20.0f,   // レベル5:  20%
        20.0f,   // レベル6:  20%
        15.0f,   // レベル7:  15%
        8.0f,    // レベル8:   8%
        2.0f,    // レベル9:   2%
        1.0f     // レベル10:  1%
    };

    private static final Random RANDOM = new Random();

    public DinosaurIndividualStats(int level) {
        if (level < 1 || level > 10) {
            throw new IllegalArgumentException("レベルは1～10の佋洙である必要があります。");
        }
        this.level = level;
        this.statMultiplier = STAT_MULTIPLIERS[level - 1];
    }

    /**
     * 野生恐竼の個体値レベルを生成
     */
    public static int generateWildLevel() {
        float random = RANDOM.nextFloat() * 100.0f;
        float cumulative = 0.0f;

        for (int i = 0; i < WILD_SPAWN_RATES.length; i++) {
            cumulative += WILD_SPAWN_RATES[i];
            if (random < cumulative) {
                return i + 1; // 1-10
            }
        }

        return 10; // フォールバック
    }

    /**
     * 交配恐竜の個体値レベルを生成
     * 粗推定: 両親の平均レベルを中心に生成
     */
    public static int generateBreedingLevel(int parent1Level, int parent2Level) {
        float averageLevel = (parent1Level + parent2Level) / 2.0f;
        // 両親の平均値を中心に、±1レベル程度のバラツを推可
        int variance = RANDOM.nextInt(3) - 1; // -1, 0, +1
        int level = (int) averageLevel + variance;

        // 1-10の範囲内に回殶
        if (level < 1) level = 1;
        if (level > 10) level = 10;

        return level;
    }

    public int getLevel() {
        return level;
    }

    public float getStatMultiplier() {
        return statMultiplier;
    }

    /**
     * 恐竜のステータスせ㇞ジを下済み値に適用
     */
    public float applyMultiplier(float baseValue) {
        return baseValue * this.statMultiplier;
    }

    @Override
    public String toString() {
        return "Lv" + level + " (倍率: " + String.format("%.2f", statMultiplier) + "x)";
    }
}
