package com.mattdahepic.thaumicexchange;

import net.minecraft.util.IIcon;

public class BlockTexture {
    private IIcon top;
    private IIcon side;
    private IIcon bottom;

    public BlockTexture(IIcon top, IIcon side, IIcon bottom) {
        this.top = top;
        this.side = side;
        this.bottom = bottom;
    }
    public IIcon getTop () {
        return top;
    }
    public IIcon getSide() {
        return side;
    }
    public IIcon getBottom() {
        return bottom;
    }
}
