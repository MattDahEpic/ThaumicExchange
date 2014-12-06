package com.mattdahepic.thaumicexchange.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;

public class ThaumicAspectorRecipe {
    public ThaumicAspectorRecipe () {

    }
    public Object[] getThaumicAspectorRecipeArray () {
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
