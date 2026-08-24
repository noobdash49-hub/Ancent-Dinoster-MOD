package com.noobdash.ancientdinosaur.screen;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import com.noobdash.ancientdinosaur.dinosaur.entity.BaseDinosaurEntity;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurBehavior;

/**
 * 恐竜インベントリUI画面
 */
public class DinosaurInventoryScreen extends HandledScreen<DinosaurInventoryScreenHandler> {
    private static final Identifier TEXTURE = 
        new Identifier("ancientdinosaur", "textures/gui/dinosaur_inventory.png");

    public DinosaurInventoryScreen(DinosaurInventoryScreenHandler handler, 
                                    PlayerInventory playerInventory, Text component) {
        super(handler, playerInventory, component);
        this.backgroundWidth = 176;
        this.backgroundHeight = 222;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float tickDelta, int mouseX, int mouseY) {
        GameRenderer gameRenderer = this.client.getGameRenderer();
        gameRenderer.getCamera();

        this.client.setShaderTexture(0, TEXTURE);
        this.drawTexture(matrices, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);

        BaseDinosaurEntity dinosaur = this.handler.getDinosaur();
        
        // 恐竜情報表示
        this.textRenderer.draw(matrices, 
            "Lv. " + dinosaur.getIndividualStats().getLevel(), 
            this.x + 10, this.y + 10, 0xFFFFFF);
        
        this.textRenderer.draw(matrices,
            "Behavior: " + dinosaur.getBehavior().getJapaneseName(),
            this.x + 10, this.y + 30, 0xFFFFFF);
        
        this.textRenderer.draw(matrices,
            "Hunger: " + String.format("%.1f", dinosaur.getCurrentHunger()) + "%",
            this.x + 10, this.y + 50, 0xFFFFFF);
    }
}
