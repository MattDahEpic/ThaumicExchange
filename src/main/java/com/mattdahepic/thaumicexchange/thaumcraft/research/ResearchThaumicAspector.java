package com.mattdahepic.thaumicexchange.thaumcraft.research;

import com.mattdahepic.thaumicexchange.ThaumicExchange;
import com.mattdahepic.thaumicexchange.thaumcraft.AspectListPrimalsOnly;
import com.mattdahepic.thaumicexchange.thaumcraft.recipes.ArcaneRecipeThaumicAspector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ResearchThaumicAspector {
    public static ItemStack thaumicAspectorIcon = new ItemStack(ThaumicExchange.itemThaumicAspector);
    public ResearchThaumicAspector () {

    }
    public static void registerResearch () {
        EntityPlayer fake;
        ResearchPage[] researchPagesThaumicAspector = new ResearchPage[2];
        ResearchItem researchThaumicAspector = new ResearchItem("thaumicAspector","thaumicExchange",new AspectListPrimalsOnly().getPrimalsXEachList(32),2,2,5,thaumicAspectorIcon);
        //describe page
        ResearchPage researchPageDescribeThaumicAspector = new ResearchPage("While playing around, you find that singeing some Voidmetal with Nitor imbues it with the power to convert items of the fire aspect. You figure that adding some of the other aspects to the mix will allow it to transmute more that just aspects of it's type. You felt the need to place a dab of Alumentum in the middle to act as a catalyst for the reaction, as well as to make the device shiny. \n (Please note that the Thaumic Aspector does not gain any shinyness due to Alementum dabs, in fact, it\'s quite dull! It probably needs some buffing.)");
        researchPagesThaumicAspector[0] = researchPageDescribeThaumicAspector;
        //recipe page
        ResearchPage researchPageRecipeThaumicExchanger = new ResearchPage(getRecipe());
        researchPagesThaumicAspector[1] = researchPageRecipeThaumicExchanger;
        //assemble pages
        researchThaumicAspector.registerResearchItem();
        researchThaumicAspector.setPages(researchPagesThaumicAspector);
        researchThaumicAspector.setSiblings("thaumicExchanger");
    }
    public static ShapedArcaneRecipe getRecipe() {
        for (int i = 0; i < ThaumcraftApi.getCraftingRecipes().size(); i++) {
            if (ThaumcraftApi.getCraftingRecipes().get(i) instanceof ShapedArcaneRecipe) {
                return (ShapedArcaneRecipe)ThaumcraftApi.getCraftingRecipes().get(i);
            }
        }
        return null;
    }
}
