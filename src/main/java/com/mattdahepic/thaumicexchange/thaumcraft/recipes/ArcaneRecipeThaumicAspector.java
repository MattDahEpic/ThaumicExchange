package com.mattdahepic.thaumicexchange.thaumcraft.recipes;

import com.mattdahepic.thaumicexchange.ThaumicExchange;
import com.mattdahepic.thaumicexchange.thaumcraft.AspectListPrimalsOnly;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.ShapedArcaneRecipe;

public class ArcaneRecipeThaumicAspector {
    //public static ShapedArcaneRecipe arcaneRecipeThaumicAspector;
    public ArcaneRecipeThaumicAspector() {

    }
    public static void registerRecipe () {
        //arcaneRecipeThaumicAspector =
        ThaumcraftApi.addArcaneCraftingRecipe("thaumicExchanger",new ItemStack(ThaumicExchange.itemThaumicAspector,1),new AspectListPrimalsOnly().getPrimalsXEachList(50),getRecipeArray());
    }
    private static Object[] getRecipeArray () {
        ItemStack nitor = new ItemApi().getItem("itemResource",1);
        ItemStack voidmetal = new ItemApi().getItem("itemResource",16);
        ItemStack alumentum = new ItemApi().getItem("itemResource",0);
        String row1 = "xyx";
        String row2 = "yzy";
        String row3 = "xyx";
        Object[] recipe = new Object[9];
        recipe[0] = row1;
        recipe[1] = row2;
        recipe[2] = row3;
        recipe[3] = 'x';
        recipe[4] = nitor;
        recipe[5] = 'y';
        recipe[6] = voidmetal;
        recipe[7] = 'z';
        recipe[8] = alumentum;
        return recipe;
    }
}
