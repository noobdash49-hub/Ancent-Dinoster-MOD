package com.noobdash.ancientdinosaur.util;

import com.noobdash.ancientdinosaur.dinosaur.entity.BaseDinosaurEntity;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurBehavior;

/**
 * 恐竜エンティティデータ管理
 */
public class EntityDataManager {
    /**
     * 恐竼の粗推定情報を文字應追で認筆
     */
    public static String getDinosaurInfo(BaseDinosaurEntity dinosaur) {
        StringBuilder info = new StringBuilder();
        info.append("恐竜情報:\n");
        info.append("  種別: ").append(dinosaur.getDinosaurType().getJapaneseName()).append("\n");
        info.append("  レベル: ").append(dinosaur.getIndividualStats().getLevel()).append("\n");
        info.append("  ティム: ").append(dinosaur.isTamed()).append("\n");
        info.append("  行動: ").append(dinosaur.getBehavior().getJapaneseName()).append("\n");
        info.append("  腹減り: ").append(String.format("%.1f", dinosaur.getCurrentHunger())).append("%\n");
        return info.toString();
    }
}
