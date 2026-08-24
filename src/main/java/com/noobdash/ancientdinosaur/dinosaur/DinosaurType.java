package com.noobdash.ancientdinosaur.dinosaur;

/**
 * 恐竜の種類を定義するEnum
 */
public enum DinosaurType {
    TYRANNOSAURUS("tyrannosaurus", "ティラノサウルス", "Tyrannosaurus Rex"),
    VELOCIRAPTOR("velociraptor", "ラプトル", "Velociraptor"),
    PTERANODON("pteranodon", "プテラノドン", "Pteranodon");

    private final String id;
    private final String japaneseName;
    private final String englishName;

    DinosaurType(String id, String japaneseName, String englishName) {
        this.id = id;
        this.japaneseName = japaneseName;
        this.englishName = englishName;
    }

    public String getId() {
        return id;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public String getEnglishName() {
        return englishName;
    }
}
