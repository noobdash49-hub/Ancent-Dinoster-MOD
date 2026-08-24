package com.noobdash.ancientdinosaur.genetics;

import java.util.Random;

/**
 * 恐竜交配システム
 * 
 * 両親のスロット数に基づいて、3スロット個体の出現率を計算する
 */
public class DinosaurBreedingSystem {
    private static final Random RANDOM = new Random();

    /**
     * 野生恐竜のスロット数を決定
     * 
     * 出現率:
     * 1スロット: 65%
     * 2スロット: 30%
     * 3スロット: 5%
     */
    public static int generateWildSlotCount() {
        float random = RANDOM.nextFloat();
        if (random < 0.65f) {
            return 1;
        } else if (random < 0.95f) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * 交配による子恐竜のスロット数を決定
     * 
     * 両親スロット平均値による3スロット出現率:
     * 平均 4.0 (3+3): 3スロット 100%
     * 平均 3.5 (3+2): 3スロット 90%
     * 平均 3.0 (3+1, 2+2): 3スロット 70%
     * 平均 2.5 (2+1): 3スロット 40%
     * 平均 2.0 (1+1, 2+0): 3スロット 20%
     * 平均 1.5以下: 3スロット 10%
     */
    public static int generateBreedingSlotCount(int parent1Slots, int parent2Slots) {
        float averageSlots = (parent1Slots + parent2Slots) / 2.0f;
        float threeSlotRate = calculateThreeSlotRate(averageSlots);

        // 3スロットの出現確率
        float random = RANDOM.nextFloat();
        if (random < threeSlotRate) {
            return 3;
        }

        // 残りは2スロット60%、1スロット40%
        random = RANDOM.nextFloat();
        if (random < 0.6f) {
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * 両親スロット平均値から3スロット出現率を計算
     */
    private static float calculateThreeSlotRate(float averageSlots) {
        if (averageSlots >= 3.9f) {
            return 1.0f;  // 100%
        } else if (averageSlots >= 3.4f) {
            return 0.9f;  // 90%
        } else if (averageSlots >= 2.9f) {
            return 0.7f;  // 70%
        } else if (averageSlots >= 2.4f) {
            return 0.4f;  // 40%
        } else if (averageSlots >= 1.9f) {
            return 0.2f;  // 20%
        } else {
            return 0.1f;  // 10%
        }
    }
}
