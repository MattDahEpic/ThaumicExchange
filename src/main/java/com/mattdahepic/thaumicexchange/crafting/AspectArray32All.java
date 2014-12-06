package com.mattdahepic.thaumicexchange.crafting;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.util.ArrayList;

public class AspectArray32All {
    public AspectArray32All () {

    }
    public AspectList getArray32All () {
        ArrayList<Aspect> allPrimals = Aspect.getPrimalAspects();
        ArrayList<Aspect> allCompounds = Aspect.getCompoundAspects();
        AspectList allEach32 = new AspectList();
        for (int i = 0; i < allPrimals.size(); i++) {
            allEach32.add(allPrimals.get(i),32);
            System.out.println("Added 32 "+allPrimals.get(i)+" of type primary. Run: "+i);
        }
        //for (int i = 0; i < allCompounds.size(); i++) {
        //    allEach32.add(allCompounds.get(i),32);
        //    System.out.println("Added 32 "+allCompounds.get(i)+" of type compound. Run: "+i);
        //}
        System.out.println(allEach32.aspects);
        return allEach32;
    }
}
