package com.noobdash.ancientdinosaur.genetics;

/**
 * 遺伝子パッチの種類と効果定義
 * 12種類のパッチを定義
 */
public enum PatchType {
    // 戦闘向けパッチ（4種類）
    ATTACK_BOOST("攻撃力強化", "Attack Boost", SlotType.COMBAT, 
                 "damage_increase", 20.0f, false),
    DEFENSE_BOOST("防御強化", "Defense Boost", SlotType.COMBAT, 
                  "damage_reduction", 30.0f, false),
    HEALTH_BOOST("体力増加", "Health Boost", SlotType.COMBAT, 
                 "health_increase", 20.0f, false),
    AREA_ATTACK_BOOST("範囲攻撃強化", "Area Attack Boost", SlotType.COMBAT, 
                      "area_attack_increase", 20.0f, false),

    // 採取向けパッチ（3種類）
    GATHERING_AMOUNT("採取量増加", "Gathering Amount", SlotType.GATHERING, 
                     "gathering_amount", 30.0f, false),
    GATHERING_SPEED("採取速度", "Gathering Speed", SlotType.GATHERING, 
                    "gathering_speed", 25.0f, false),
    INVENTORY_CAPACITY("カバン増量", "Inventory Capacity", SlotType.GATHERING, 
                       "inventory_double", 100.0f, false),

    // 移動向けパッチ（3種類）
    MOVEMENT_SPEED("移動速度強化", "Movement Speed Boost", SlotType.MOVEMENT, 
                   "movement_speed", 30.0f, false),
    HUNGER_REDUCTION("腹減り軽減", "Hunger Reduction", SlotType.MOVEMENT, 
                     "hunger_decrease", 50.0f, false),
    JUMP_BOOST("跳躍力強化", "Jump Boost", SlotType.MOVEMENT, 
               "jump_boost", 1.0f, false),

    // 特殊レアパッチ（3種類・クラフト不可）
    TERRAIN_IMMUNITY("踏破", "Terrain Immunity", SlotType.SPECIAL_RARE, 
                     "terrain_damage_immunity", 100.0f, true),
    LEGENDARY("伝説", "Legendary", SlotType.SPECIAL_RARE, 
              "legendary", 100.0f, true),
    IMMORTAL("仙人", "Immortal", SlotType.SPECIAL_RARE, 
             "immortal", 100.0f, true);

    private final String japaneseName;
    private final String englishName;
    private final SlotType slotType;
    private final String effectId;
    private final float effectValue;
    private final boolean isRare; // レアパッチ（クラフト不可）

    PatchType(String japaneseName, String englishName, SlotType slotType,
              String effectId, float effectValue, boolean isRare) {
        this.japaneseName = japaneseName;
        this.englishName = englishName;
        this.slotType = slotType;
        this.effectId = effectId;
        this.effectValue = effectValue;
        this.isRare = isRare;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public String getEffectId() {
        return effectId;
    }

    public float getEffectValue() {
        return effectValue;
    }

    public boolean isRare() {
        return isRare;
    }

    public boolean isCraftable() {
        return !isRare;
    }
}
