package com.mattdahepic.thaumicexchange;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemAspector extends Item {
    public ItemAspector () {
        super();
        this.setUnlocalizedName("thaumicAspector");
        this.setMaxStackSize(1);
        this.setCreativeTab(ThaumicExchange.tabThaumicExchange);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("thaumicexchange:thaumicAspector");
    }

    //TODO: on item use, do something.
}
