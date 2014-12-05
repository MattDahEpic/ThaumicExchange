package com.mattdahepic.thaumicexchange.block;

import com.mattdahepic.thaumicexchange.ThaumicExchange;
import com.mattdahepic.thaumicexchange.tileentity.TileEntityThaumicExchanger;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.IAspectContainer;

public class BlockThaumicExchanger extends TEBlock implements IAspectContainer {
    public static AspectList aspectsInBlock;
    public BlockThaumicExchanger(Material material,String name) {
        super(material, name);
        this.setBlockName("thaumicexchange.thaumicExchanger");
    }

    @Override
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        TileEntityThaumicExchanger tileEntity = (TileEntityThaumicExchanger) world.getTileEntity(x,y,z);
        if (tileEntity == null || player.isSneaking()) {
            //System.out.println("Thaumic Exchanger Activated, but tile entity is null or player is sneaking. D:");
            return false;
        }
        player.openGui(ThaumicExchange.instance,0,world,x,y,z);
        //System.out.println("Thaumic Exchanger Activated Successfully!");
        return true;
    }
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityThaumicExchanger();
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
}
