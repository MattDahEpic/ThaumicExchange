package com.mattdahepic.thaumicexchange.thaumcraft.research;

import com.mattdahepic.thaumicexchange.thaumcraft.AspectListPrimalsOnly;
import com.mattdahepic.thaumicexchange.thaumcraft.recipes.ArcaneRecipeThaumicAspector;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ResearchThaumicAspector {
    public ResearchThaumicAspector () {

    }
    public static void registerResearch () {
        ResearchPage[] researchPagesThaumicAspector = new ResearchPage[2];
        ResearchItem researchThaumicAspector = new ResearchItem("thaumicAspector","thaumicExchange",new AspectListPrimalsOnly().getPrimalsXEachList(32),4,4,5,ResearchTab.researchTabIcon); //TODO: change item on this tab to the icon of the item
        //describe page
        ResearchPage researchPageDescribeThaumicAspector = new ResearchPage("While playing around, you find that singeing some Void Metal with Nitor imbues it with the power to convert items of the fire aspect. You figure that adding some of the other aspects to the mix will allow it to transmute more that just aspects of it's type. You felt the need to place a dab of Alumentum in the middle to act as a catalyst for the reaction, as well as to make the device shiny. \n (Please note that the Thaumic Aspector does not gain any shinyness due to Alementum dabs, in fact, it\'s quite dull! It probably needs some buffing.)");
        researchPagesThaumicAspector[0] = researchPageDescribeThaumicAspector;
        //recipe page
        ResearchPage researchPageRecipeThaumicExchanger = new ResearchPage(ArcaneRecipeThaumicAspector.arcaneRecipeThaumicAspector);
        researchPagesThaumicAspector[1] = researchPageRecipeThaumicExchanger;
        //assemble pages
        researchThaumicAspector.registerResearchItem();
        researchThaumicAspector.setPages(researchPagesThaumicAspector);
    }
}
