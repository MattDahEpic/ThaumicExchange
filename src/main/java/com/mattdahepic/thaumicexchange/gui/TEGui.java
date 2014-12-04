package com.mattdahepic.thaumicexchange.gui;

import com.mattdahepic.thaumicexchange.tileentity.TETileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public class TEGui<T extends TETileEntity> extends GuiContainer {
    public TEGui (Container par1Container) {
        super(par1Container);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

    }

}
