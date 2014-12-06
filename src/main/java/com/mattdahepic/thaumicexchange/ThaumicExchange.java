package com.mattdahepic.thaumicexchange;

import com.mattdahepic.thaumicexchange.block.BlockThaumicExchanger;
import com.mattdahepic.thaumicexchange.crafting.AspectListPrimalsOnly;
import com.mattdahepic.thaumicexchange.crafting.ItemStackArrayForCraftingThaumicExchanger;
import com.mattdahepic.thaumicexchange.crafting.ThaumicAspectorRecipe;
import com.mattdahepic.thaumicexchange.inventory.GuiHandler;
import com.mattdahepic.thaumicexchange.item.ItemAspector;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

@Mod(modid = ThaumicExchange.MODID, name = ThaumicExchange.NAME, version = ThaumicExchange.VERSION)
public class ThaumicExchange {

    @Mod.Instance("thaumicexchange")
    public static ThaumicExchange instance;

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
        proxy.registerTiles();
        proxy.registerBlocksItems();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        //thaumcraft research
        ResearchPage[] researchPagesThaumicExchanger = new ResearchPage[3];
        ResourceLocation researchTabIcon = new ResourceLocation("thaumicexchange","/textures/research/researchTabIcon.png");
        ResourceLocation researchBackground = new ResourceLocation("thaumicexchange","textures/research/researchBackground.png");
        ResearchItem researchThaumicExchanger = new ResearchItem("thaumicExchanger","thaumicExchange",new AspectListPrimalsOnly().getPrimalsXEachList(32),3,3,5,researchTabIcon); //TODO: change item location on screen
        //describe page
        ResearchPage researchPageDescribeThaumicExchanger = new ResearchPage("During a dream you peered far into the past, only to find a world filled with mystical devices that turned nothing into something. You woke up with a start hoping to abuse this power. You have now recreated this concept using your thaumaturgic powers, but not exactly as you had hoped. To create these items, you have to supply the aptly named Thaumic Exchanger with something, that something being vis. You can pump it in with pipes, deliver with golems, transfer via nodes, or convert directly from items. The Thaumic Exchanger then converts those raw aspects into whatever you choose.");
        //crafting of thaumic aspector
        ShapedArcaneRecipe arcaneRecipeThaumicAspector = new ShapedArcaneRecipe("thaumicExchanger",new ItemStack(ThaumicExchange.itemThaumicAspector,1),new AspectListPrimalsOnly().getPrimalsXEachList(64),new ThaumicAspectorRecipe().getThaumicAspectorRecipeArray()); //TODO: add research for crafting this
        ResearchPage researchPageThaumicAspector = new ResearchPage(arcaneRecipeThaumicAspector);
        //infusion crafting of thaumic exchanger
        InfusionRecipe infusionRecipeThaumicExchanger = new InfusionRecipe("thaumicExchanger",new ItemStack(blockThaumicExchanger,1),977,new AspectListPrimalsOnly().getPrimalsXEachList(512),new ItemStack(Blocks.stone,1),new ItemStackArrayForCraftingThaumicExchanger().getMaterialsArray());
        ResearchPage researchPageRecipieThaumicExchanger = new ResearchPage(infusionRecipeThaumicExchanger);

        ResearchCategories.registerCategory("thaumicExchange",researchTabIcon,researchBackground);
        researchThaumicExchanger.registerResearchItem();
        researchThaumicExchanger.setSpecial();
        researchPagesThaumicExchanger[0] = researchPageDescribeThaumicExchanger;
        researchPagesThaumicExchanger[1] = researchPageThaumicAspector;
        researchPagesThaumicExchanger[2] = researchPageRecipieThaumicExchanger;
        researchThaumicExchanger.setPages(researchPagesThaumicExchanger);
        proxy.debugMessages();
    }
    public static CreativeTabs tabThaumicExchange = new CreativeTabs("thaumicExchange") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ThaumicExchange.blockThaumicExchanger);
        }
    };
}
