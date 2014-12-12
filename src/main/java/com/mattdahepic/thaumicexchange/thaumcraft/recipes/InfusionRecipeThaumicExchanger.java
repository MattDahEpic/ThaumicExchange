package com.mattdahepic.thaumicexchange.thaumcraft.recipes;

import com.mattdahepic.thaumicexchange.ThaumicExchange;
import com.mattdahepic.thaumicexchange.thaumcraft.AspectListPrimalsOnly;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;

public class InfusionRecipeThaumicExchanger {
    //public static InfusionRecipe infusionRecipeThaumicExchanger;
    public InfusionRecipeThaumicExchanger () {

    }
    public static void registerRecipe () {
        //infusionRecipeThaumicExchanger =
        ThaumcraftApi.addInfusionCraftingRecipe("thaumicExchanger", new ItemStack(ThaumicExchange.blockThaumicExchanger, 1), 70, new AspectListPrimalsOnly().getPrimalsXEachList(512), new ItemStack(Blocks.stone, 1), getMaterialsArray());
    }
    private static ItemStack[] getMaterialsArray() {
        ItemStack[] voidMetal = new ItemStack[8];
        for (int i = 0; i < 8; i++) {
            voidMetal[i] = new ItemStack(ThaumicExchange.itemThaumicAspector,1);
        }
        return voidMetal;
    }
}
