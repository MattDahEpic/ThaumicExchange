package com.mattdahepic.thaumicexchange.inventory;

import com.mattdahepic.thaumicexchange.tileentity.TileEntityThaumicExchanger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerThaumicExchanger extends Container {
    private TileEntityThaumicExchanger tileEntity;
    public ContainerThaumicExchanger(InventoryPlayer inventoryPlayer, TileEntityThaumicExchanger tileEntity2) {
        this.tileEntity = tileEntity2;
        addSlotToContainer(new Slot(tileEntity,0,7,19)); //template slot
        //input slots
        //TODO: add for loops for these
            //row 1
                addSlotToContainer(new Slot(tileEntity,1,7,90));
                addSlotToContainer(new Slot(tileEntity,2,25,90));
                addSlotToContainer(new Slot(tileEntity,3,43,90));
                addSlotToContainer(new Slot(tileEntity,4,61,90));
            //row 2
                addSlotToContainer(new Slot(tileEntity,5,7,108));
                addSlotToContainer(new Slot(tileEntity,6,25,108));
                addSlotToContainer(new Slot(tileEntity,7,43,108));
                addSlotToContainer(new Slot(tileEntity,8,61,108));
            //row 3
                addSlotToContainer(new Slot(tileEntity,9,7,126));
                addSlotToContainer(new Slot(tileEntity,10,25,126));
                addSlotToContainer(new Slot(tileEntity,11,43,126));
                addSlotToContainer(new Slot(tileEntity,12,61,126));
        //output slots
        //TODO: add loops for these
            //row 1
                addSlotToContainer(new Slot(tileEntity,13,97,90));
                addSlotToContainer(new Slot(tileEntity,14,115,90));
                addSlotToContainer(new Slot(tileEntity,15,133,90));
                addSlotToContainer(new Slot(tileEntity,16,151,90));
            //row 2
                addSlotToContainer(new Slot(tileEntity,17,97,108));
                addSlotToContainer(new Slot(tileEntity,18,115,108));
                addSlotToContainer(new Slot(tileEntity,19,133,108));
                addSlotToContainer(new Slot(tileEntity,20,151,108));
            //row 3
                addSlotToContainer(new Slot(tileEntity,21,97,126));
                addSlotToContainer(new Slot(tileEntity,22,115,126));
                addSlotToContainer(new Slot(tileEntity,23,133,126));
                addSlotToContainer(new Slot(tileEntity,24,151,126));
        this.bindPlayerInventory(inventoryPlayer);
    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }
    protected void bindPlayerInventory (InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                        7 + j * 18, 158 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 7 + i * 18, 216));
        }
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();
            if(slot < 9) {
                if (!this.mergeItemStack(stackInSlot, 0, 35, true)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }
}
