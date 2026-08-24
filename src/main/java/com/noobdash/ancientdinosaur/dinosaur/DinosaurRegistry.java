package com.noobdash.ancientdinosaur.dinosaur;

import java.util.HashMap;
import java.util.Map;
import com.noobdash.ancientdinosaur.AncientDinosaur;

/**
 * 恐竜のスペック登録・管理
 */
public class DinosaurRegistry {
    private static final Map<DinosaurType, DinosaurSpec> DINOSAUR_SPECS = new HashMap<>();

    static {
        registerDinosaurs();
    }

    /**
     * 全恐竜のスペックを登録
     */
    private static void registerDinosaurs() {
        // ティラノサウルス
        DINOSAUR_SPECS.put(DinosaurType.TYRANNOSAURUS, new DinosaurSpec(
            DinosaurType.TYRANNOSAURUS,
            DinosaurSize.LARGE,
            new DinosaurStats(
                100.0f,     // HP
                10.0f,      // 攻撃
                15.0f,      // 防御（%）
                100.0f,     // 食糧値
                0.8f        // 移動速度
            ),
            new DinosaurSubStats(
                50,         // 経験値ドロップ
                8,          // テイム難易度（麻酔矢本数）
                0.8f,       // 攻撃速度
                3.0f,       // 攻撃範囲
                2.0f,       // 採取量
                80.0f,      // 採取効率（%）
                3.0f,       // 採取範囲
                54          // 初期カバン容量（1 LC = 54スロット）
            )
        ));

        // ラプトル
        DINOSAUR_SPECS.put(DinosaurType.VELOCIRAPTOR, new DinosaurSpec(
            DinosaurType.VELOCIRAPTOR,
            DinosaurSize.SMALL,
            new DinosaurStats(
                30.0f,      // HP
                5.0f,       // 攻撃
                8.0f,       // 防御（%）
                60.0f,      // 食糧値
                1.5f        // 移動速度
            ),
            new DinosaurSubStats(
                30,         // 経験値ドロップ
                4,          // テイム難易度（麻酔矢本数）
                1.5f,       // 攻撃速度
                2.0f,       // 攻撃範囲
                1.0f,       // 採取量
                120.0f,     // 採取効率（%）
                2.0f,       // 採取範囲
                27          // 初期カバン容量（0.5 LC = 27スロット）
            )
        ));

        // プテラノドン
        DINOSAUR_SPECS.put(DinosaurType.PTERANODON, new DinosaurSpec(
            DinosaurType.PTERANODON,
            DinosaurSize.MEDIUM,
            new DinosaurStats(
                40.0f,      // HP
                3.0f,       // 攻撃
                5.0f,       // 防御（%）
                80.0f,      // 食糧値
                1.8f        // 移動速度
            ),
            new DinosaurSubStats(
                25,         // 経験値ドロップ
                5,          // テイム難易度（麻酔矢本数）
                1.0f,       // 攻撃速度
                2.0f,       // 攻撃範囲
                0.8f,       // 採取量
                100.0f,     // 採取効率（%）
                2.5f,       // 採取範囲
                27          // 初期カバン容量（0.5 LC = 27スロット）
            )
        ));

        AncientDinosaur.LOGGER.info("恐竜スペックが登録されました: " + DINOSAUR_SPECS.size() + "体");
    }

    /**
     * 恐竜スペックを取得
     */
    public static DinosaurSpec getSpec(DinosaurType type) {
        return DINOSAUR_SPECS.get(type);
    }

    /**
     * 全ての登録済み恐竜を取得
     */
    public static Map<DinosaurType, DinosaurSpec> getAllSpecs() {
        return new HashMap<>(DINOSAUR_SPECS);
    }
}
