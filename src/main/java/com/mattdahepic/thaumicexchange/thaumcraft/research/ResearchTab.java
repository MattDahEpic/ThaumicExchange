package com.mattdahepic.thaumicexchange.thaumcraft.research;

import net.minecraft.util.ResourceLocation;
import thaumcraft.api.research.ResearchCategories;

public class ResearchTab {
    public static ResourceLocation researchTabIcon = new ResourceLocation("thaumicexchange","/textures/research/researchTabIcon.png");
    public static ResourceLocation researchBackground = new ResourceLocation("thaumicexchange","textures/research/researchBackground.png");
    public ResearchTab () {

    }
    public static void registerTab () {
        ResearchCategories.registerCategory("thaumicExchange", researchTabIcon, researchBackground);
    }
}
