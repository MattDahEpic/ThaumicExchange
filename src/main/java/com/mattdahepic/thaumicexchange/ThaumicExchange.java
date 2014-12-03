package com.mattdahepic.thaumicexchange;

import com.mattdahepic.thaumicexchange.block.BlockTextureData;
import com.mattdahepic.thaumicexchange.block.BlockThaumicExchanger;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

@Mod(modid = ThaumicExchange.MODID, name = ThaumicExchange.NAME, version = ThaumicExchange.VERSION)
public class ThaumicExchange {
    public static final String MODID = "thaumicexchange";
    public static final String VERSION = "0.1-alpha";
    public static final String NAME = "ThaumicExchange";

    @SidedProxy(clientSide = "com.mattdahepic.thaumicexchange.client.ClientProxy", serverSide = "com.mattdahepic.thaumicexchange.CommonProxy")
    public static CommonProxy proxy;

    //blocks
    public static Block blockThaumicExchanger;

    //items
    public static Item itemThaumicAspector;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {}

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //Blocks
        blockThaumicExchanger = new BlockThaumicExchanger(Material.rock,"thaumicExchanger").setLightLevel(1.0F);
        //Items
        itemThaumicAspector = new ItemAspector();
        //proxy.registerTiles();
        proxy.registerBlocksItems();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    public static CreativeTabs tabThaumicExchange = new CreativeTabs("thaumicExchange") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ThaumicExchange.blockThaumicExchanger);
        }
    };
}
