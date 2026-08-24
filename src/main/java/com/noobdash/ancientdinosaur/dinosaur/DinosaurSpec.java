package com.noobdash.ancientdinosaur.dinosaur;

/**
 * 恐竜のスペック定義
 * 各恐竜のベースステータスとサブステータスを保持
 */
public class DinosaurSpec {
    private final DinosaurType type;
    private final DinosaurSize size;
    private final DinosaurStats baseStats;
    private final DinosaurSubStats subStats;

    public DinosaurSpec(DinosaurType type, DinosaurSize size, 
                       DinosaurStats baseStats, DinosaurSubStats subStats) {
        this.type = type;
        this.size = size;
        this.baseStats = baseStats;
        this.subStats = subStats;
    }

    public DinosaurType getType() {
        return type;
    }

    public DinosaurSize getSize() {
        return size;
    }

    public DinosaurStats getBaseStats() {
        return baseStats;
    }

    public DinosaurSubStats getSubStats() {
        return subStats;
    }

    /**
     * 恐竜スペックを取得（種別から）
     */
    public static DinosaurSpec getSpec(DinosaurType type) {
        return DinosaurRegistry.getSpec(type);
    }

    @Override
    public String toString() {
        return "DinosaurSpec{" +
                "type=" + type.getJapaneseName() +
                ", size=" + size.getJapaneseName() +
                ", baseStats=" + baseStats +
                ", subStats=" + subStats +
                '}';
    }
}
