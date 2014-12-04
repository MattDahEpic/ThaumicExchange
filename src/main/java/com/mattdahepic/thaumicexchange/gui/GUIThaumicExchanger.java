package com.mattdahepic.thaumicexchange.gui;

import com.mattdahepic.thaumicexchange.inventory.ContainerThaumicExchanger;
import com.mattdahepic.thaumicexchange.tileentity.TETileEntity;
import com.mattdahepic.thaumicexchange.tileentity.TileEntityThaumicExchanger;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiThaumicExchanger extends TEGui<TETileEntity> {
    private final ResourceLocation gui_texture = new ResourceLocation("thaumicexchange","textures/gui/guiThaumicExchanger.png");

    public GuiThaumicExchanger(InventoryPlayer inventoryPlayer, TileEntityThaumicExchanger tileEntity) {
        super (new ContainerThaumicExchanger(inventoryPlayer, tileEntity));

        this.xSize = 174;
        this.ySize = 239;
        //this.te = tileEntity;
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
        this.fontRendererObj.drawString("Thaumic Exchanger", 8, 6, 4210752);
        //draws "Inventory" or your regional equivalent
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(this.gui_texture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
