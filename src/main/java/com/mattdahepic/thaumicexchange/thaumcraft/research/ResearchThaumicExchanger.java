package com.mattdahepic.thaumicexchange.thaumcraft.research;

import com.mattdahepic.thaumicexchange.thaumcraft.AspectListPrimalsOnly;
import com.mattdahepic.thaumicexchange.thaumcraft.recipes.InfusionRecipeThaumicExchanger;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ResearchThaumicExchanger {
    public ResearchThaumicExchanger() {

    }
    public static void registerResearch () {
        ResearchPage[] researchPagesThaumicExchanger = new ResearchPage[2];
        ResearchItem researchThaumicExchanger = new ResearchItem("thaumicExchanger","thaumicExchange",new AspectListPrimalsOnly().getPrimalsXEachList(32),3,3,5,ResearchTab.researchTabIcon); //TODO: change item location on screen
        //describe page
        ResearchPage researchPageDescribeThaumicExchanger = new ResearchPage("During a dream you peered far into the past, only to find a world filled with mystical devices that turned nothing into something. You woke up with a start hoping to abuse this power. You have now recreated this concept using your thaumaturgic powers, but not exactly as you had hoped. To create these items, you have to supply the aptly named Thaumic Exchanger with something, that something being vis. You can pump it in with pipes, deliver by golem, and send from nodes. The Thaumic Exchanger then converts those raw aspects into whatever you choose.");
        researchPagesThaumicExchanger[0] = researchPageDescribeThaumicExchanger;
        //infusion recipe page
        ResearchPage researchPageRecipieThaumicExchanger = new ResearchPage(InfusionRecipeThaumicExchanger.infusionRecipeThaumicExchanger);
        researchPagesThaumicExchanger[1] = researchPageRecipieThaumicExchanger;
        //assemble pages
        researchThaumicExchanger.registerResearchItem();
        researchThaumicExchanger.setSpecial();
        researchThaumicExchanger.setPages(researchPagesThaumicExchanger);
    }
}
