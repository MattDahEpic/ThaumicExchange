package com.mattdahepic.thaumicexchange.crafting;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.util.ArrayList;

public class AspectListPrimalsOnly {
    public AspectListPrimalsOnly() {

    }
    public AspectList getPrimalsXEachList (int amount) {
        ArrayList<Aspect> primalAspects = Aspect.getPrimalAspects();
        AspectList allPrimalsXEach = new AspectList();
        for (int i = 0; i < primalAspects.size(); i++) {
            allPrimalsXEach.add(primalAspects.get(i),amount);
        }
        return allPrimalsXEach;
    }
}
