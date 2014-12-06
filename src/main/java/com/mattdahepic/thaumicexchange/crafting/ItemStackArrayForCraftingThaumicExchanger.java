package com.mattdahepic.thaumicexchange.crafting;

import com.mattdahepic.thaumicexchange.ThaumicExchange;
import cpw.mods.fml.common.versioning.ComparableVersion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;

public class ItemStackArrayForCraftingThaumicExchanger {
    public ItemStackArrayForCraftingThaumicExchanger() {

    }
    public ItemStack[] getMaterialsArray() {
        ItemStack[] voidMetal = new ItemStack[8];
        for (int i = 0; i < 8; i++) {
            voidMetal[i] = new ItemStack(ThaumicExchange.itemThaumicAspector,1);
            //voidMetal[i] = new ItemApi().getItem("itemResource",16);
        }
        return voidMetal;
    }
}
