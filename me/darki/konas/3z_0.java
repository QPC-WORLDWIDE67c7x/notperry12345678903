/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.viaversion.viafabric.ViaFabric;
import com.viaversion.viafabric.protocol.ProtocolCollection;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;

/*
 * Renamed from me.darki.konas.3z
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3z_0
extends GuiButton {
    public float c;
    public boolean c = 1.0f;
    public float 0 = 0.0f;
    public float 1 = ProtocolCollection.values().length - 1;

    public 3z_0(int n2, int n3, int n4, int n5, int n6) {
        super(n2, n3, n4, n5, n6, "Protocol");
        for (int i2 = 0; i2 < ProtocolCollection.values().length; ++i2) {
            if (ProtocolCollection.values()[i2].getVersion().getVersion() != ViaFabric.getInstance().getVersion()) continue;
            this.c = (float)i2 / (float)ProtocolCollection.values().length;
            this.displayString = "Protocol: " + ProtocolCollection.values()[i2].getVersion().getName();
        }
    }

    public void mouseReleased(int n2, int n3) {
        this.c = false;
    }

    public int getHoverState(boolean bl) {
        return 0;
    }

    public void mouseDragged(Minecraft minecraft, int n2, int n3) {
        block1: {
            if (!this.visible) break block1;
            if (this.c) {
                this.c = (float)(n2 - (this.x + 4)) / (float)(this.width - 8);
                this.c = MathHelper.clamp((float)this.c, (float)0.0f, (float)1.0f);
                int n4 = (int)(this.c * this.1);
                ViaFabric.getInstance().setVersion(ProtocolCollection.values()[n4].getVersion().getVersion());
                this.displayString = "Protocol: " + ProtocolCollection.values()[n4].getVersion().getName();
            }
            minecraft.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            this.drawTexturedModalRect(this.x + (int)(this.c * (float)(this.width - 8)), this.y, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.x + (int)(this.c * (float)(this.width - 8)) + 4, this.y, 196, 66, 4, 20);
        }
    }

    public boolean mousePressed(Minecraft minecraft, int n2, int n3) {
        if (super.mousePressed(minecraft, n2, n3)) {
            this.c = (float)(n2 - (this.x + 4)) / (float)(this.width - 8);
            this.c = MathHelper.clamp((float)this.c, (float)0.0f, (float)1.0f);
            int n4 = (int)(this.c * this.1);
            ViaFabric.getInstance().setVersion(ProtocolCollection.values()[n4].getVersion().getVersion());
            this.displayString = "Protocol: " + ProtocolCollection.values()[n4].getVersion().getName();
            this.c = true;
            return true;
        }
        return false;
    }
}

