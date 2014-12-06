package com.mattdahepic.thaumicexchange.crafting;

import cpw.mods.fml.common.versioning.ComparableVersion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;

public class ItemStackArrayVoidMetalForCrafting {
    public ItemStackArrayVoidMetalForCrafting () {

    }
    public ItemStack[] getVoidMetalArray () {
        ItemStack[] voidMetal = new ItemStack[8];
        for (int i = 0; i < 8; i++) {
            voidMetal[i] = new ItemApi().getItem("itemResource",16);
        }
        return voidMetal;
    }
}
