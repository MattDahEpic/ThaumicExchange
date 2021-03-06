package com.mattdahepic.thaumicexchange.tileentity;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.IAspectContainer;
import thaumcraft.api.aspects.IEssentiaTransport;

import javax.xml.bind.SchemaOutputResolver;

public class TileEntityThaumicExchanger extends TETileEntity implements ISidedInventory, IEssentiaTransport, IAspectContainer {
    public static AspectList aspectsInBlock;
    //public static ItemStack[] inventory;
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
    @Override
    public boolean doesContainerAccept(Aspect tag) {
        return true;
    }
    @Override
    public boolean doesContainerContainAmount(Aspect tag,int amount) {
        if (aspectsInBlock.getAmount(tag) == amount) {
            return true;
        }
        return false;
    }
    @Override
    public void setAspects(AspectList aspects) {}
    @Override
    public int addToContainer (Aspect tag, int amount) {
        aspectsInBlock.add(tag,amount);
        return aspectsInBlock.getAmount(tag);
    }
    @Override
    public boolean takeFromContainer(Aspect tag, int amount) {
        return aspectsInBlock.reduce(tag,amount);
    }
    @Override
    public int containerContains(Aspect tag) {
        return aspectsInBlock.getAmount(tag);
    }
    @Override
    public AspectList getAspects() {
        return aspectsInBlock;
    }

    @Override
    public boolean doesContainerContain(AspectList ot) {
        //TODO: remove this, its deprecated! returns false always because i dont want to override deprecated methods.
        return false;
    }
    @Override
    public boolean takeFromContainer(AspectList ot) {
        return false;
        //TODO: remove this, its deprecated! returns false always because i dont want to override deprecated methods.
    }
    @Override
    public boolean isConnectable(ForgeDirection face) {
        return true;
    }
    @Override
    public boolean canInputFrom(ForgeDirection face) {
        return true;
    }
    @Override
    public boolean canOutputTo(ForgeDirection face) {
        return true;
    }
    @Override
    public void setSuction(Aspect aspect, int amount) {}
    @Override
    public Aspect getSuctionType(ForgeDirection face) {
        return null;
    }
    @Override
    public int getSuctionAmount(ForgeDirection face) {
        return 1;
    }
    @Override
    public int takeEssentia(Aspect aspect, int amount, ForgeDirection face) {
        if (aspectsInBlock.getAmount(aspect) >= amount) {
            aspectsInBlock.reduce(aspect,amount);
            return amount;
        }
        else {
            int aspectsRemaining = aspectsInBlock.getAmount(aspect);
            aspectsInBlock.remove(aspect);
            return aspectsRemaining;
        }
    }
    @Override
    public int addEssentia(Aspect aspect, int amount, ForgeDirection face) {
        aspectsInBlock.add(aspect, amount);
        return amount;
    }
    @Override
    public Aspect getEssentiaType(ForgeDirection face) {
        return null;
    }
    @Override
    public int getEssentiaAmount(ForgeDirection face) {
        return aspectsInBlock.visSize();
    }
    @Override
    public int getMinimumSuction() {
        return 5;
    }
    @Override
    public boolean renderExtendedTube() {
        return false;
    }

    public static AspectList getAspectsOfTemplate () {
        if (inventory[0] != null) {
            return new AspectList(new ItemStack(inventory[0].getItem()));
        }
        return null;
    }
    public static void produceItem() {
        //we are PRODUCING items here matt! no need to write the consume code 3 different ways now.
        AspectList aspectsOnTemplate = getAspectsOfTemplate();
        int correctAspects = 0;
        if (aspectsOnTemplate != null && aspectsInBlock != null) {
            for (Aspect tag : aspectsOnTemplate.getAspects()) {
                if (aspectsInBlock.getAmount(tag) >= aspectsOnTemplate.getAmount(tag) && aspectsInBlock.aspects.containsKey(tag)) {
                    //aspect is true
                    correctAspects++;
                } else {
                    //at least one of the aspects doesnt have enough!
                    System.out.println("Not enough aspects to create item!");
                    return;
                }
            }
            if (correctAspects == aspectsOnTemplate.size()) {
                for (Aspect tag:aspectsOnTemplate.getAspects()) {
                    aspectsInBlock.reduce(tag,aspectsOnTemplate.getAmount(tag));
                }
                System.out.println("Item works and aspects are avaliable! Producing 1 item now.");
                ItemStack newStack = null;
                if (inventory[0] != null) {
                    newStack = new ItemStack(inventory[0].getItem());
                }
                for (int i = 1; i <= inventory.length; i++) {
                    if (inventory[i] == newStack) {
                        newStack = inventory[i];
                        newStack.stackSize++;
                        return;
                        //TODO: something about packets making sure to let the client know
                    } else {
                        inventory[i] = newStack;
                        inventory[i].stackSize=1;
                        //TODO: something about packets making sure to let the client know
                    }
                }
            }
        } else {
            System.out.println("No aspects in block! Oh Noes!");
        }
    }
}
