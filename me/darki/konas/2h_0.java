/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import me.darki.konas.2e_0;
import me.darki.konas.2g_0;
import me.darki.konas.8k_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2h
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 2h_0
extends GuiListExtended {
    public static Logger c = LogManager.getLogger();
    public 2e_0 c;
    public ArrayList<2g_0> c;
    public int c = -1;

    public void c(int n2) {
        this.c = n2;
        this.c.c(this.1());
    }

    public void drawScreen(int n2, int n3, float f2) {
        block5: {
            int n4;
            if (!this.visible) break block5;
            this.mouseX = n2;
            this.mouseY = n3;
            this.drawBackground();
            int n5 = this.getScrollBarX();
            int n6 = n5 + 6;
            this.bindAmountScrolled();
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferBuilder = tessellator.getBuffer();
            this.drawContainerBackground(tessellator);
            int n7 = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            int n8 = this.top + 4 - (int)this.amountScrolled;
            if (this.hasListHeader) {
                this.drawListHeader(n7, n8, tessellator);
            }
            Logger logger = this.c;
            boolean bl = false;
            for (n4 = 0; n4 < this.c.size(); ++n4) {
                if (!((2g_0)this.c.get((int)n4)).c.1()) continue;
                Collections.swap(this.c, 0, n4);
                bl = true;
                break;
            }
            if (bl) {
                this.c(this.left, this.right, this.top, this.top + 39);
            }
            this.drawSelectionBox(n7, n8, n2, n3, f2);
            this.c = logger;
            GlStateManager.disableDepth();
            this.overlayBackground(0, this.top, 255, 255);
            this.overlayBackground(this.bottom, this.height, 255, 255);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ZERO, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            GlStateManager.shadeModel((int)7425);
            GlStateManager.disableTexture2D();
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            bufferBuilder.pos((double)this.left, (double)(this.top + 4), 0.0).tex(0.0, 1.0).color(0, 0, 0, 0).endVertex();
            bufferBuilder.pos((double)this.right, (double)(this.top + 4), 0.0).tex(1.0, 1.0).color(0, 0, 0, 0).endVertex();
            bufferBuilder.pos((double)this.right, (double)this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
            bufferBuilder.pos((double)this.left, (double)this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
            tessellator.draw();
            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            bufferBuilder.pos((double)this.left, (double)this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
            bufferBuilder.pos((double)this.right, (double)this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
            bufferBuilder.pos((double)this.right, (double)(this.bottom - 4), 0.0).tex(1.0, 0.0).color(0, 0, 0, 0).endVertex();
            bufferBuilder.pos((double)this.left, (double)(this.bottom - 4), 0.0).tex(0.0, 0.0).color(0, 0, 0, 0).endVertex();
            tessellator.draw();
            n4 = this.getMaxScroll();
            if (n4 > 0) {
                int n9 = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
                int n10 = (int)this.amountScrolled * (this.bottom - this.top - (n9 = MathHelper.clamp((int)n9, (int)32, (int)(this.bottom - this.top - 8)))) / n4 + this.top;
                if (n10 < this.top) {
                    n10 = this.top;
                }
                bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                bufferBuilder.pos((double)n5, (double)this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
                bufferBuilder.pos((double)n6, (double)this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
                bufferBuilder.pos((double)n6, (double)this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
                bufferBuilder.pos((double)n5, (double)this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
                tessellator.draw();
                bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                bufferBuilder.pos((double)n5, (double)(n10 + n9), 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
                bufferBuilder.pos((double)n6, (double)(n10 + n9), 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
                bufferBuilder.pos((double)n6, (double)n10, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
                bufferBuilder.pos((double)n5, (double)n10, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
                tessellator.draw();
                bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                bufferBuilder.pos((double)n5, (double)(n10 + n9 - 1), 0.0).tex(0.0, 1.0).color(192, 192, 192, 255).endVertex();
                bufferBuilder.pos((double)(n6 - 1), (double)(n10 + n9 - 1), 0.0).tex(1.0, 1.0).color(192, 192, 192, 255).endVertex();
                bufferBuilder.pos((double)(n6 - 1), (double)n10, 0.0).tex(1.0, 0.0).color(192, 192, 192, 255).endVertex();
                bufferBuilder.pos((double)n5, (double)n10, 0.0).tex(0.0, 0.0).color(192, 192, 192, 255).endVertex();
                tessellator.draw();
            }
            this.renderDecorations(n2, n3);
            GlStateManager.enableTexture2D();
            GlStateManager.shadeModel((int)7424);
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }

    public 2h_0(2e_0 e_02, Minecraft minecraft, int n2, int n3, int n4, int n5, int n6) {
        super(minecraft, n2, n3, n4, n5, n6);
        this.c = e_02;
    }

    public int getScrollBarX() {
        return super.getScrollBarX() + 20;
    }

    public 2e_0 0() {
        return this.c;
    }

    public boolean isSelected(int n2) {
        return n2 == this.c;
    }

    @NotNull
    public GuiListExtended.IGuiListEntry getListEntry(int n2) {
        return this.0(n2);
    }

    public int getSize() {
        return this.c.size();
    }

    @Nullable
    public 2g_0 1() {
        return this.c >= 0 && this.c < this.getSize() ? this.0(this.c) : null;
    }

    public void c(2g_0 g_02) {
        this.c.add(g_02);
        8k_0.c.c.c.add(g_02);
    }

    public void c(float f2, double d2, double d3, double d4) {
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        float f3 = 32.0f;
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        bufferBuilder.pos((double)f2, d4, 0.0).tex((double)(f2 / f3), d4 / (double)f3).color(20, 20, 20, 255).endVertex();
        bufferBuilder.pos(d2, d4, 0.0).tex(d2 / (double)f3, d4 / (double)f3).color(20, 20, 20, 255).endVertex();
        bufferBuilder.pos(d2, d3, 0.0).tex(d2 / (double)f3, d3 / (double)f3).color(20, 20, 20, 255).endVertex();
        bufferBuilder.pos((double)f2, d3, 0.0).tex((double)(f2 / f3), d3 / (double)f3).color(20, 20, 20, 255).endVertex();
        Tessellator.getInstance().draw();
    }

    public List<2g_0> c() {
        return this.c;
    }

    public int getListWidth() {
        return super.getListWidth() + 50;
    }

    @NotNull
    public 2g_0 0(int n2) {
        return (2g_0)this.c.get(n2);
    }

    public void 0(2g_0 g_02) {
        this.c.remove(g_02);
    }
}

