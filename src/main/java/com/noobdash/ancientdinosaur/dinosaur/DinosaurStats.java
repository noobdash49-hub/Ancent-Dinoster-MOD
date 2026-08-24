package com.noobdash.ancientdinosaur.dinosaur;

/**
 * 恐竜のベースステータス（5つ）
 * HP、攻撃、防御、食糧値、移動速度
 */
public class DinosaurStats {
    private float maxHealth;
    private float attack;
    private float defense; // ダメージ軽減率（%）
    private float maxHunger; // 食糧値
    private float movementSpeed;

    public DinosaurStats(float maxHealth, float attack, float defense, float maxHunger, float movementSpeed) {
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.maxHunger = maxHunger;
        this.movementSpeed = movementSpeed;
    }

    // ゲッター
    public float getMaxHealth() {
        return maxHealth;
    }

    public float getAttack() {
        return attack;
    }

    public float getDefense() {
        return defense;
    }

    public float getMaxHunger() {
        return maxHunger;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    // セッター
    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public void setMaxHunger(float maxHunger) {
        this.maxHunger = maxHunger;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    /**
     * テイム時のステータス調整
     * ダメージ: -30%, HP: +40%, 移動速度: -15%
     */
    public DinosaurStats getTamedStats() {
        return new DinosaurStats(
            this.maxHealth * 1.4f,      // HP: +40%
            this.attack * 0.7f,         // ダメージ: -30%
            this.defense,               // 防御: 変化なし
            this.maxHunger,             // 食糧値: 変化なし
            this.movementSpeed * 0.85f  // 移動速度: -15%
        );
    }

    @Override
    public String toString() {
        return "DinosaurStats{" +
                "maxHealth=" + maxHealth +
                ", attack=" + attack +
                ", defense=" + defense +
                ", maxHunger=" + maxHunger +
                ", movementSpeed=" + movementSpeed +
                '}';
    }
}
