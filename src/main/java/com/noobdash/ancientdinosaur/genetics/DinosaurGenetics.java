package com.noobdash.ancientdinosaur.genetics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 恐竜遺伝子育成システム
 * 各恐竜のステータスと遺伝子スロットを管理
 */
public class DinosaurGenetics {
    private final String dinosaurId;
    private final int maxSlots;
    private final List<GeneticSlot> geneticSlots;
    private final Set<PatchType> equippedPatches; // 装備済みパッチ（重複チェック用）

    public DinosaurGenetics(String dinosaurId, int maxSlots) {
        this.dinosaurId = dinosaurId;
        this.maxSlots = maxSlots;
        this.geneticSlots = new ArrayList<>();
        this.equippedPatches = new HashSet<>();
        initializeSlots();
    }

    /**
     * 遺伝子スロットの初期化
     */
    private void initializeSlots() {
        // スロットタイプを均等に配置
        SlotType[] slotTypes = SlotType.values();
        for (int i = 0; i < maxSlots; i++) {
            SlotType type = slotTypes[i % slotTypes.length];
            geneticSlots.add(new GeneticSlot(
                "slot_" + i,
                i,
                type
            ));
        }
    }

    /**
     * パッチをスロットにはめる
     * @return はめることができたかどうか
     */
    public boolean equipPatch(int slotIndex, GeneticPatch patch) {
        if (slotIndex < 0 || slotIndex >= geneticSlots.size()) {
            return false;
        }

        // 同じパッチが既に装備されているかチェック
        if (equippedPatches.contains(patch.getPatchType())) {
            return false;
        }

        GeneticSlot slot = geneticSlots.get(slotIndex);
        if (slot.getSlotType() != patch.getCompatibleSlot()) {
            return false; // スロットタイプが合わない
        }

        // 既に装備されているパッチを削除
        if (slot.hasPatch()) {
            equippedPatches.remove(slot.getCurrentPatch().getPatchType());
        }

        slot.setPatch(patch);
        equippedPatches.add(patch.getPatchType());
        return true;
    }

    /**
     * パッチを取り外す
     */
    public void removePatch(int slotIndex) {
        if (slotIndex >= 0 && slotIndex < geneticSlots.size()) {
            GeneticSlot slot = geneticSlots.get(slotIndex);
            if (slot.hasPatch()) {
                equippedPatches.remove(slot.getCurrentPatch().getPatchType());
                slot.removePatch();
            }
        }
    }

    /**
     * 全パッチの効果を計算（加算）
     */
    public float getTotalDamageBonus() {
        float total = 0.0f;
        for (GeneticSlot slot : geneticSlots) {
            if (slot.hasPatch()) {
                total += slot.getCurrentPatch().getDamageBonus();
            }
        }
        return total;
    }

    public float getTotalHealthBonus() {
        float total = 0.0f;
        for (GeneticSlot slot : geneticSlots) {
            if (slot.hasPatch()) {
                total += slot.getCurrentPatch().getHealthBonus();
            }
        }
        return total;
    }

    public float getTotalDefenseBonus() {
        float total = 0.0f;
        for (GeneticSlot slot : geneticSlots) {
            if (slot.hasPatch()) {
                total += slot.getCurrentPatch().getDefenseBonus();
            }
        }
        return total;
    }

    public float getTotalMovementSpeedBonus() {
        float total = 0.0f;
        for (GeneticSlot slot : geneticSlots) {
            if (slot.hasPatch()) {
                total += slot.getCurrentPatch().getMovementSpeedBonus();
            }
        }
        return total;
    }

    public float getTotalGatheringAmountBonus() {
        float total = 0.0f;
        for (GeneticSlot slot : geneticSlots) {
            if (slot.hasPatch()) {
                total += slot.getCurrentPatch().getGatheringAmountBonus();
            }
        }
        return total;
    }

    public float getTotalGatheringSpeedBonus() {
        float total = 0.0f;
        for (GeneticSlot slot : geneticSlots) {
            if (slot.hasPatch()) {
                total += slot.getCurrentPatch().getGatheringSpeedBonus();
            }
        }
        return total;
    }

    public float getTotalInventoryMultiplier() {
        float total = 0.0f;
        for (GeneticSlot slot : geneticSlots) {
            if (slot.hasPatch()) {
                total += slot.getCurrentPatch().getInventoryMultiplier();
            }
        }
        // インベントリは最初は1x、パッチで+1.0で2xになる
        return 1.0f + total;
    }

    // ゲッター
    public String getDinosaurId() {
        return dinosaurId;
    }

    public int getMaxSlots() {
        return maxSlots;
    }

    public List<GeneticSlot> getGeneticSlots() {
        return new ArrayList<>(geneticSlots);
    }

    public Set<PatchType> getEquippedPatches() {
        return new HashSet<>(equippedPatches);
    }
}
