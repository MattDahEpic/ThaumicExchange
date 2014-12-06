package com.mattdahepic.thaumicexchange;

import com.mattdahepic.thaumicexchange.tileentity.TileEntityThaumicExchanger;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenderers() {

    }

    public void registerTiles() {
        GameRegistry.registerTileEntity(TileEntityThaumicExchanger.class,"thaumicexchange.thaumicExchanger");
        System.out.println("Tile Entity Registered!");
    }

    public void registerBlocksItems() {
        //Blocks
        GameRegistry.registerBlock(ThaumicExchange.blockThaumicExchanger, "thaumicExchanger");
        System.out.println("Thaumic Exchanger Registered.");
        //Items
        GameRegistry.registerItem(ThaumicExchange.itemThaumicAspector,"thaumicAspector");
        System.out.println("Thaumic Aspecter Registered.");
    }

    public void addRecipes() {
        //TODO: add recipies
    }

    public void debugMessages() {

    }
}
