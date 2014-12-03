package com.mattdahepic.thaumicexchange;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = ThaumicExchange.MODID, name = ThaumicExchange.NAME, version = ThaumicExchange.VERSION)
public class ThaumicExchange {
    public static final String MODID = "thaumicexchange";
    public static final String VERSION = "0.1-alpha";
    public static final String NAME = "ThaumicExchange";

    //blocks
    public static Block thaumicExchanger;
    private BlockTexture[] icon;
    //public static Block discoMissTex;

    //items
    public static Item thaumicAspecter;

    @EventHandler
    public void preInit(FMLInitializationEvent event) {
        //thaumic exchanger
        thaumicExchanger = new GenericBlock (Material.rock).setHardness(25.0F).setStepSound(Block.soundTypeStone).setBlockName("thaumicExchanger").setLightLevel(1.0F).setCreativeTab(this.tabThaumicExchange);
        thaumicExchanger.setHarvestLevel("pickaxe",3);
        GameRegistry.registerBlock(thaumicExchanger,"thaumicExchanger");

        //thaumic aspecter
        thaumicAspecter = new GenericItem().setMaxStackSize(1).setCreativeTab(this.tabThaumicExchange).setUnlocalizedName("thaumicAspecter").setTextureName("thaumicexchange:thaumicAspecter");
        GameRegistry.registerItem(thaumicAspecter,"thaumicAspecter");
        //disco miss tex, this is because of cameron
        //discoMissTex = new GenericBlock (Material.rock).setHardness(-1.0F).setStepSound(Block.soundTypeStone).setBlockName("discoMissTex").setCreativeTab(ThaumicExchange.tabThaumicExchange).setLightLevel(1.0F).setCreativeTab(this.tabThaumicExchange);
        //GameRegistry.registerBlock(discoMissTex,"discoMissTex");
    }

    //@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = new BlockTexture[1]; //total metadatas of all blocks
        icon[0] = new BlockTexture(iconRegister.registerIcon("thaumicexchange:thaumicExchanger_top"),iconRegister.registerIcon("thaumicexchange:thaumicExchanger_side"),iconRegister.registerIcon("thaumicexchange:thaumicExchanger_bottom"));
    } //register multisided icon blocks in array
    //@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcons(int side, int metadata) {
        if(metadata >= icon.length || icon[metadata] == null) {
            return null;
        } //if metadata of block is too big or doesnt exist exit with null
        return side == 0 ? icon[metadata].getBottom() : side == 1 ? icon[metadata].getTop() : icon[metadata].getSide();
    } //declare multisided textures to game

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    public static CreativeTabs tabThaumicExchange = new CreativeTabs("thaumicExchange") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ThaumicExchange.thaumicExchanger);
        }
    };
}
