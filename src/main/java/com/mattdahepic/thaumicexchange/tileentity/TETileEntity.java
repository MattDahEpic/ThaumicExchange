package com.mattdahepic.thaumicexchange.tileentity;

import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TETileEntity extends TileEntity implements ISidedInventory {
    protected ItemStack[] inventory;
    public TETileEntity () {

    }

    public int getSizeInventory() {
        return this.inventory.length;
    }
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = this.getStackInSlot(slot);

        if (stack != null) {
            if (stack.stackSize <= amount) {
                this.setInventorySlotContents(slot,null);
            }
            else {
                stack = stack.splitStack(amount);
                if (stack.stackSize == 0) {
                    this.setInventorySlotContents(slot,null);
                }
            }
        }
        return stack;
    }
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = this.getStackInSlot(slot);
        if(stack != null) {
            setInventorySlotContents(slot,null);
        }
        return stack;
    }
    @Override
    public void setInventorySlotContents(int slot,ItemStack stack) {
        this.inventory[slot] = stack;
        if (stack != null && stack.stackSize >= this.getInventoryStackLimit()) {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }
    @Override
    public String getInventoryName() {
        return "thaumicexchange.tileentityGeneric";
    }
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord,this.yCoord,this.zCoord) == this && player.getDistanceSq(this.xCoord + 0.5F,this.yCoord + 0.5F, this.zCoord + 0.5F) < 64;
    }
    @Override
    public void openInventory () {

    }
    @Override
    public void closeInventory () {

    }
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        if (slot > 0) {
            return true;
        }
        return false;
    }
    @Override
    public void readFromNBT (NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
            byte  slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot]  = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }
    @Override
    public void writeToNBT (NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inventory.length; i++) {
            ItemStack stack = inventory[i];
            if (stack != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }
        tagCompound.setTag("Inventory", itemList);
    }
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[0];
    }
    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
        return true;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return true;
    }
}
