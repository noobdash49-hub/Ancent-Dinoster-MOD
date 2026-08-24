package com.noobdash.ancientdinosaur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurRegistry;
import com.noobdash.ancientdinosaur.dinosaur.AncientDinosaurEntities;
import com.noobdash.ancientdinosaur.genetics.GeneticPatchRegistry;
import com.noobdash.ancientdinosaur.item.AncientDinosaurItems;

/**
 * Ancient Dinosaur MOD
 * メインエントリーポイント
 */
public class AncientDinosaur implements ModInitializer {
    public static final String MOD_ID = "ancent-dinoster-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("=".repeat(51));
        LOGGER.info("Ancient Dinosaur MOD v0.1.0 を初期化中...");
        LOGGER.info("=".repeat(51));
        
        // 恐竜スペック登録
        LOGGER.info("[フィーズ1] 恐竜スペックを登録中...");
        DinosaurRegistry.getAllSpecs();
        
        // 遪伝子パッチ登録
        LOGGER.info("[フィーズ1] 遪伝子パッチを登録中...");
        GeneticPatchRegistry.getAllPatches();
        
        // 恐竜エンティティ登録
        LOGGER.info("[フィーズ2] 恐竜エンティティを登録中...");
        AncientDinosaurEntities.registerEntities();
        
        // アイテム登録
        LOGGER.info("[フィーズ1] アイテムを登録中...");
        AncientDinosaurItems.initialize();
        
        LOGGER.info("=".repeat(51));
        LOGGER.info("Ancient Dinosaur MOD の初期化が完了しました!");
        LOGGER.info("=".repeat(51));
    }
}
