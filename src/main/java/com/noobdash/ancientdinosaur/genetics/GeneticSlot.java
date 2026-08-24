package com.noobdash.ancientdinosaur.genetics;

/**
 * 恐竜遺伝子スロット
 * 各恐竜にはスロットが設定されており、
 * 「パッチ」と呼ばれる遺伝子アイテムをはめることで
 * ステータスをカスタマイズできる
 */
public class GeneticSlot {
    private final String slotId;
    private final int slotIndex;
    private final SlotType slotType;
    private GeneticPatch currentPatch;

    public GeneticSlot(String slotId, int slotIndex, SlotType slotType) {
        this.slotId = slotId;
        this.slotIndex = slotIndex;
        this.slotType = slotType;
        this.currentPatch = null;
    }

    public String getSlotId() {
        return slotId;
    }

    public int getSlotIndex() {
        return slotIndex;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public GeneticPatch getCurrentPatch() {
        return currentPatch;
    }

    public void setPatch(GeneticPatch patch) {
        if (patch != null && patch.getCompatibleSlot() != this.slotType) {
            throw new IllegalArgumentException(
                "パッチ " + patch.getJapaneseName() + " はこのスロットに装備できません。"
            );
        }
        this.currentPatch = patch;
    }

    public void removePatch() {
        this.currentPatch = null;
    }

    public boolean hasPatch() {
        return currentPatch != null;
    }

    @Override
    public String toString() {
        if (hasPatch()) {
            return slotType.getJapaneseName() + " スロット [" + currentPatch.getJapaneseName() + "]";
        }
        return slotType.getJapaneseName() + " スロット [空]";
    }
}
