package com.noobdash.ancientdinosaur.dinosaur.data;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.Entity;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurBehavior;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurIndividualStats;
import com.noobdash.ancientdinosaur.genetics.DinosaurGenetics;

/**
 * 恐竜エンティティのデータ管理
 * NBTを用いた永続化
 */
public class DinosaurData {
    private static final String TAG_LEVEL = "DinosaurLevel";
    private static final String TAG_TAMED = "DinosaurTamed";
    private static final String TAG_OWNER = "DinosaurOwner";
    private static final String TAG_BEHAVIOR = "DinosaurBehavior";
    private static final String TAG_HUNGER = "DinosaurHunger";
    private static final String TAG_MAX_HUNGER = "DinosaurMaxHunger";
    private static final String TAG_GENETICS = "DinosaurGenetics";

    /**
     * NBTにデータを書き込む
     */
    public static void writeToNBT(NbtCompound tag, DinosaurIndividualStats stats, 
                                   boolean isTamed, String ownerName,
                                   DinosaurBehavior behavior, float hunger, float maxHunger) {
        tag.putInt(TAG_LEVEL, stats.getLevel());
        tag.putBoolean(TAG_TAMED, isTamed);
        if (ownerName != null && !ownerName.isEmpty()) {
            tag.putString(TAG_OWNER, ownerName);
        }
        tag.putInt(TAG_BEHAVIOR, behavior.getId());
        tag.putFloat(TAG_HUNGER, hunger);
        tag.putFloat(TAG_MAX_HUNGER, maxHunger);
    }

    /**
     * NBTからデータを読み込む
     */
    public static DinosaurIndividualStats readLevelFromNBT(NbtCompound tag) {
        int level = tag.getInt(TAG_LEVEL);
        if (level < 1 || level > 10) {
            level = 5; // デフォルト
        }
        return new DinosaurIndividualStats(level);
    }

    public static boolean isTamedFromNBT(NbtCompound tag) {
        return tag.getBoolean(TAG_TAMED);
    }

    public static String getOwnerFromNBT(NbtCompound tag) {
        return tag.getString(TAG_OWNER);
    }

    public static DinosaurBehavior getBehaviorFromNBT(NbtCompound tag) {
        int behaviorId = tag.getInt(TAG_BEHAVIOR);
        return DinosaurBehavior.fromId(behaviorId);
    }

    public static float getHungerFromNBT(NbtCompound tag) {
        return tag.getFloat(TAG_HUNGER);
    }

    public static float getMaxHungerFromNBT(NbtCompound tag) {
        return tag.getFloat(TAG_MAX_HUNGER);
    }
}
