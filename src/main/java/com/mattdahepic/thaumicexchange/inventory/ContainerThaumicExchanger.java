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
        addSlotToContainer(new Slot(tileEntity,0,59,36)); //input slot
        addSlotToContainer(new Slot(tileEntity,1,109,36));
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
                        8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
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
