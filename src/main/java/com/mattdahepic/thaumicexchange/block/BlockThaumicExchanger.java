package com.mattdahepic.thaumicexchange.block;

import com.mattdahepic.thaumicexchange.ThaumicExchange;
import com.mattdahepic.thaumicexchange.tileentity.TETileEntity;
import com.mattdahepic.thaumicexchange.tileentity.TileEntityThaumicExchanger;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockThaumicExchanger extends TEBlock {
    public BlockThaumicExchanger(Material material,String name) {
        super(material, name);
        this.setBlockName("thaumicexchange.thaumicExchanger");
    }

    @Override
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        TileEntityThaumicExchanger tileEntity = (TileEntityThaumicExchanger) world.getTileEntity(x,y,z);
        if (tileEntity == null || player.isSneaking()) {
            System.out.println("Thaumic Exchanger Activated, but tile entity is null or player is sneaking. D:");
            return false;
        }
        player.openGui(ThaumicExchange.instance,0,world,x,y,z);
        System.out.println("Thaumic Exchanger Activated Successfully!");
        return true;
    }
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityThaumicExchanger();
    }
}
