package com.mattdahepic.thaumicexchange;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy /*implements IGuiHandler */{
    public void registerRenderers() {

    }

    public void registerTiles() {
        //TODO: register tile entities
    }

    public void registerBlocksItems() {
        //Blocks
        GameRegistry.registerBlock(ThaumicExchange.blockThaumicExchanger, "thaumicExchanger");
        //Items
        GameRegistry.registerItem(ThaumicExchange.itemThaumicAspector,"thaumicAspector");
    }

    public void addRecipes() {
        //TODO: add recipies
    }

    //TODO: guis
}
