package com.noobdash.ancientdinosaur.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;
import com.noobdash.ancientdinosaur.dinosaur.entity.BaseDinosaurEntity;

/**
 * 恐竜インベントリUIハンドラー
 */
public class DinosaurInventoryScreenHandler extends ScreenHandler {
    private final Inventory dinosaurInventory;
    private final BaseDinosaurEntity dinosaur;

    public DinosaurInventoryScreenHandler(int syncId, PlayerInventory playerInventory, 
                                           BaseDinosaurEntity dinosaur) {
        super(null, syncId);
        this.dinosaur = dinosaur;
        this.dinosaurInventory = new SimpleInventory(9);

        // 恐竜インベントリスロットを追加。
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(this.dinosaurInventory, i, 8 + i * 18, 18));
        }

        // プレイヤーインベントリを追加
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 140 + row * 18));
            }
        }
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 198));
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public BaseDinosaurEntity getDinosaur() {
        return dinosaur;
    }
}
