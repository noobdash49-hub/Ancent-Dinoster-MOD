package com.noobdash.ancientdinosaur.dinosaur;

/**
 * 恐竜の行動ステート
 * インベントリUIから設定可能な命令
 */
public enum DinosaurBehavior {
    ATTACK("攻撃", "Attack", 0),
    NEUTRAL("中立", "Neutral", 1),
    PASSIVE("無抵抗", "Passive", 2),
    STAY("待機", "Stay", 3);

    private final String japaneseName;
    private final String englishName;
    private final int id;

    DinosaurBehavior(String japaneseName, String englishName, int id) {
        this.japaneseName = japaneseName;
        this.englishName = englishName;
        this.id = id;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public int getId() {
        return id;
    }

    /**
     * IDから行動ステートを取得
     */
    public static DinosaurBehavior fromId(int id) {
        for (DinosaurBehavior behavior : values()) {
            if (behavior.id == id) {
                return behavior;
            }
        }
        return NEUTRAL; // デフォルト
    }
}
