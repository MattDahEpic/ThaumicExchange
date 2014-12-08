package com.mattdahepic.thaumicexchange;

import com.mattdahepic.thaumicexchange.thaumcraft.recipes.ArcaneRecipeThaumicAspector;
import com.mattdahepic.thaumicexchange.thaumcraft.recipes.InfusionRecipeThaumicExchanger;
import com.mattdahepic.thaumicexchange.thaumcraft.research.ResearchTab;
import com.mattdahepic.thaumicexchange.thaumcraft.research.ResearchThaumicAspector;
import com.mattdahepic.thaumicexchange.thaumcraft.research.ResearchThaumicExchanger;
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

    public void registerRecipes() {
        ArcaneRecipeThaumicAspector.registerRecipe();
        InfusionRecipeThaumicExchanger.registerRecipe();
    }

    public void registerReserch () {
        ResearchTab.registerTab();
        ResearchThaumicExchanger.registerResearch();
        ResearchThaumicAspector.registerResearch();
    }

    public void debugMessages() {

    }
}
