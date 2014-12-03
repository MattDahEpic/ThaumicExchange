package com.mattdahepic.thaumicexchange.block;

import com.mattdahepic.thaumicexchange.ThaumicExchange;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

public class TEBlock extends BlockContainer {
    private BlockTextureData[] icon;
    private String blockName;

    public TEBlock(Material material, String name) {
        super(material);
        this.setHardness(1.5F);

        blockName = name;
        this.setCreativeTab(ThaumicExchange.tabThaumicExchange);
    }

    @Override
    public String getUnlocalizedName() {
        return "thaumicexchange."+blockName;
    }

    @Override
    public void breakBlock (World world, int x, int y, int z, Block par5, int par6) {
        dropItems(world,x,y,z);
        super.breakBlock(world,x,y,z,par5,par6);
    }

    private void dropItems(World world, int x,  int y, int z) {
        Random rand = new Random();
        TileEntity tileEntity = world.getTileEntity(x,y,z);

        if (!(tileEntity instanceof IInventory)) {
            return;
        }

        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);
            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;
                EntityItem entityItem = new EntityItem(world,rx,ry,rz,new ItemStack(item.getItem(),item.stackSize,item.getItemDamage()));
                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                }
                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new BlockTextureData[1];
        icon[0] = new BlockTextureData(iconRegister.registerIcon("thaumicexchange:"+blockName+"_top"),iconRegister.registerIcon("thaumicexchange:"+blockName+"_side"),iconRegister.registerIcon("thaumicexchange:"+blockName+"_bottom"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        if(metadata >= icon.length || icon[metadata] == null) {
            return null;
        } //if metadata of block is too big or doesnt exist exit with null
        return side == 0 ? icon[metadata].getBottom() : side == 1 ? icon[metadata].getTop() : icon[metadata].getSide();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return null;
    }

    @Override
    public int damageDropped (int par1) {
        return par1;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
        return new ItemStack(this,1,world.getBlockMetadata(x,y,z));
    }
}
