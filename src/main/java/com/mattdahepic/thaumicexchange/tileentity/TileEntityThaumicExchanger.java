package com.mattdahepic.thaumicexchange.tileentity;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public class TileEntityThaumicExchanger extends TETileEntity implements ISidedInventory{
    public TileEntityThaumicExchanger () {
        super();
        inventory = new ItemStack[37];
    }

    @Override
    public String getInventoryName () {
        return "thaumicexchange.thaumicExchanger";
    }
    @Override
    public boolean canInsertItem (int slot, ItemStack stack, int side) {
        if (slot == 0) {
            if (side == 1) {
                return true; //if inserting into top, put into the template slot
            }
        }
        else if (slot > 0) {
            if (side != 1) {
                return true; // if inserting into any other side, go into the fuel slot
            }
        }
        return false;
    }
    @Override
    public boolean canExtractItem (int slot, ItemStack stack, int side) {
        if (slot == 0) {
            if (side == 1) {
                return true; //if inserting into top, put into the template slot
            }
        }
        else if (slot > 0) {
            if (side != 1) {
                return true; // if inserting into any other side, go into the fuel slot
            }
        }
        return false;
    }
}
