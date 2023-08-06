package com.sheb.filtertools.icon;

import com.sheb.filtertools.Loader;
import fi.dy.masa.malilib.gui.interfaces.IGuiIcon;
import fi.dy.masa.malilib.render.RenderUtils;
import net.minecraft.util.Identifier;

public enum Icons implements IGuiIcon {
    EXCLAMATION_MARK (0, 0, 8, 8),
    DUPLICATE_MARK (0, 8, 8, 8);
    private static final Identifier TEXTURE = new Identifier(Loader.MODID, "textures/gui/icons.png");

    private final int u;
    private final int v;
    private final int w;
    private final int h;
    private final int hoverOffU;
    private final int hoverOffV;

    Icons(int u, int v, int w, int h)
    {
        this(u, v, w, h, w, 0);
    }

    Icons(int u, int v, int w, int h, int hoverOffU, int hoverOffV)
    {
        this.u = u;
        this.v = v;
        this.w = w;
        this.h = h;
        this.hoverOffU = hoverOffU;
        this.hoverOffV = hoverOffV;
    }

    @Override
    public int getWidth()
    {
        return this.w;
    }

    @Override
    public int getHeight()
    {
        return this.h;
    }

    @Override
    public int getU()
    {
        return this.u;
    }

    @Override
    public int getV()
    {
        return this.v;
    }

    @Override
    public void renderAt(int x, int y, float zLevel, boolean enabled, boolean selected)
    {
        int u = this.u;
        int v = this.v;

        if (enabled)
        {
            u += this.hoverOffU;
            v += this.hoverOffV;
        }

        if (selected)
        {
            u += this.hoverOffU;
            v += this.hoverOffV;
        }

        RenderUtils.drawTexturedRect(x, y, u, v, this.w, this.h, zLevel);
    }

    @Override
    public Identifier getTexture()
    {
        return TEXTURE;
    }

}