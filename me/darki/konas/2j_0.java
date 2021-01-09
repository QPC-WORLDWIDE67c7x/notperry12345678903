/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2l_0;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

/*
 * Renamed from me.darki.konas.2j
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
@SideOnly(value=Side.CLIENT)
public class 2j_0
extends GuiButton {
    public ResourceLocation c;
    public int c;
    public int 0;
    public boolean c;

    public void c(boolean bl) {
        this.c = bl;
    }

    public boolean c() {
        return this.c;
    }

    public 2j_0(int n2, int n3, int n4, ResourceLocation resourceLocation, int n5, int n6) {
        super(n2, n3, n4, 22, 22, "");
        this.c = resourceLocation;
        this.c = n5;
        this.0 = n6;
    }

    public void drawButton(@NotNull Minecraft minecraft, int n2, int n3, float f2) {
        block6: {
            if (!this.visible) break block6;
            minecraft.getTextureManager().bindTexture(2l_0.access$200());
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.hovered = n2 >= this.x && n3 >= this.y && n2 < this.x + this.width && n3 < this.y + this.height;
            int n4 = 0;
            if (!this.enabled) {
                n4 += this.width * 2;
            } else if (this.c) {
                n4 += this.width;
            } else if (this.hovered) {
                n4 += this.width * 3;
            }
            this.drawTexturedModalRect(this.x, this.y, n4, 219, this.width, this.height);
            if (!2l_0.access$200().equals((Object)this.c)) {
                minecraft.getTextureManager().bindTexture(this.c);
            }
            this.drawTexturedModalRect(this.x + 2, this.y + 2, this.c, this.0, 18, 18);
        }
    }
}

