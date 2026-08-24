package com.noobdash.ancientdinosaur.dinosaur;

/**
 * 恐竜のサイズ分類
 */
public enum DinosaurSize {
    SMALL("小型", 0.6f),
    MEDIUM("中型", 1.2f),
    LARGE("大型", 1.8f);

    private final String japaneseName;
    private final float scaleModifier; // モデルスケール係数

    DinosaurSize(String japaneseName, float scaleModifier) {
        this.japaneseName = japaneseName;
        this.scaleModifier = scaleModifier;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public float getScaleModifier() {
        return scaleModifier;
    }
}
