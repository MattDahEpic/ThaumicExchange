package com.mattdahepic.thaumicexchange.tileentity;

import com.mattdahepic.thaumicexchange.block.BlockThaumicExchanger;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

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
    public boolean consumeItems() {
        //boolean failed = false;
        for (int i = 1; i <= 12; i++) { //for each slot 1-12
            if (this.getStackInSlot(i) != null) { //if theres an item
                AspectList aspectsList = new AspectList(this.getStackInSlot(i)); //find aspects on the item in the slot
                Aspect[] aspectsListNames = aspectsList.getAspects(); //get the names of those aspects
                for (int j = 0; j < aspectsListNames.length; j++) { //then, for every aspect
                    int amountAspects = aspectsList.getAmount(aspectsListNames[j]); //get the amount
                    BlockThaumicExchanger.aspectsInBlock.add(aspectsListNames[j], amountAspects); //add the amount for that aspect
                    System.out.println("Consumed a " + this.getStackInSlot(i).getDisplayName() + " for " + amountAspects + aspectsListNames[j]+"."); //and tell me that you did
                }
                //TODO: actually consume the item.
            }
        }
        //TODO: theoretically add a fail to convert condition
        return true;
    }
}
