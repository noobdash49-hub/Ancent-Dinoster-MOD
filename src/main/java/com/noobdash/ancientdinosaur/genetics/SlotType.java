package com.noobdash.ancientdinosaur.genetics;

/**
 * 遺伝子スロットのタイプ分類
 */
public enum SlotType {
    COMBAT("戦闘", "Combat"),
    GATHERING("採取", "Gathering"),
    MOVEMENT("移動", "Movement"),
    SPECIAL_RARE("特殊", "Special Rare");

    private final String japaneseName;
    private final String englishName;

    SlotType(String japaneseName, String englishName) {
        this.japaneseName = japaneseName;
        this.englishName = englishName;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public String getEnglishName() {
        return englishName;
    }
}
