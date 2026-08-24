package com.noobdash.ancientdinosaur.genetics;

import java.util.HashMap;
import java.util.Map;
import com.noobdash.ancientdinosaur.AncientDinosaur;

/**
 * 遺伝子パッチの登録・管理
 * 12種類のパッチを管理
 */
public class GeneticPatchRegistry {
    private static final Map<PatchType, GeneticPatch> PATCHES = new HashMap<>();

    static {
        registerPatches();
    }

    /**
     * 全パッチを登録
     */
    private static void registerPatches() {
        // 戦闘向けパッチ
        PATCHES.put(PatchType.ATTACK_BOOST, new GeneticPatch(
            PatchType.ATTACK_BOOST,
            "攻撃力強化",
            SlotType.COMBAT,
            20.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.DEFENSE_BOOST, new GeneticPatch(
            PatchType.DEFENSE_BOOST,
            "防御強化",
            SlotType.COMBAT,
            0.0f, 0.0f, 30.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.HEALTH_BOOST, new GeneticPatch(
            PatchType.HEALTH_BOOST,
            "体力増加",
            SlotType.COMBAT,
            0.0f, 20.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.AREA_ATTACK_BOOST, new GeneticPatch(
            PatchType.AREA_ATTACK_BOOST,
            "範囲攻撃強化",
            SlotType.COMBAT,
            20.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        // 採取向けパッチ
        PATCHES.put(PatchType.GATHERING_AMOUNT, new GeneticPatch(
            PatchType.GATHERING_AMOUNT,
            "採取量増加",
            SlotType.GATHERING,
            0.0f, 0.0f, 0.0f, 0.0f, 30.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.GATHERING_SPEED, new GeneticPatch(
            PatchType.GATHERING_SPEED,
            "採取速度",
            SlotType.GATHERING,
            0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 25.0f, 0.0f
        ));

        PATCHES.put(PatchType.INVENTORY_CAPACITY, new GeneticPatch(
            PatchType.INVENTORY_CAPACITY,
            "カバン増量",
            SlotType.GATHERING,
            0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 100.0f
        ));

        // 移動向けパッチ
        PATCHES.put(PatchType.MOVEMENT_SPEED, new GeneticPatch(
            PatchType.MOVEMENT_SPEED,
            "移動速度強化",
            SlotType.MOVEMENT,
            0.0f, 0.0f, 0.0f, 30.0f, 0.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.HUNGER_REDUCTION, new GeneticPatch(
            PatchType.HUNGER_REDUCTION,
            "腹減り軽減",
            SlotType.MOVEMENT,
            0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.JUMP_BOOST, new GeneticPatch(
            PatchType.JUMP_BOOST,
            "跳躍力強化",
            SlotType.MOVEMENT,
            0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        // 特殊レアパッチ
        PATCHES.put(PatchType.TERRAIN_IMMUNITY, new GeneticPatch(
            PatchType.TERRAIN_IMMUNITY,
            "踏破",
            SlotType.SPECIAL_RARE,
            0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.LEGENDARY, new GeneticPatch(
            PatchType.LEGENDARY,
            "伝説",
            SlotType.SPECIAL_RARE,
            25.0f, 25.0f, 25.0f, 0.0f, 0.0f, 0.0f, 0.0f
        ));

        PATCHES.put(PatchType.IMMORTAL, new GeneticPatch(
            PatchType.IMMORTAL,
            "仙人",
            SlotType.SPECIAL_RARE,
            0.0f, 0.0f, 0.0f, 50.0f, 0.0f, 0.0f, 0.0f
        ));

        AncientDinosaur.LOGGER.info("遺伝子パッチが登録されました: " + PATCHES.size() + "種類");
    }

    /**
     * パッチを取得
     */
    public static GeneticPatch getPatch(PatchType type) {
        return PATCHES.get(type);
    }

    /**
     * 全パッチを取得
     */
    public static Map<PatchType, GeneticPatch> getAllPatches() {
        return new HashMap<>(PATCHES);
    }
}
