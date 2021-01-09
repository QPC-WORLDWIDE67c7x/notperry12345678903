/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2C;
import me.darki.konas.2n_0;
import me.darki.konas.3H;
import me.darki.konas.89;
import me.darki.konas.94;
import me.darki.konas.9b;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.2y
 */
public class 2y_0
extends 2C {
    public 2y_0() {
        super("HUD Editor", 20.0f, 100.0f, 100.0f, 16.0f);
    }

    @Override
    public boolean 0(int n2, int n3, int n4) {
        super.0(n2, n3, n4);
        if (2y_0.c(n2, n3, this.5(), this.6(), this.1(), this.3())) {
            if (n4 == 0) {
                2n_0.0(!2n_0.1());
                return true;
            }
        }
        return false;
    }

    @Override
    public void c(int n2, int n3, float f2) {
        super.c(n2, n3, f2);
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        this.3((float)scaledResolution.getScaledWidth() - this.1() - 5.0f);
        this.0((float)scaledResolution.getScaledHeight() - this.3() - 5.0f);
        int n4 = ((89)3H.2.6()).c();
        if (((Boolean)3H.9.6()).booleanValue() && 2y_0.c(n2, n3, this.5(), this.6(), this.1(), this.3())) {
            n4 = ((89)3H.2.6()).4().brighter().hashCode();
        }
        94.c(this.5() - 2.0f, this.6() - 2.0f, this.1() + 4.0f, this.3() + 4.0f, ((89)3H.4.6()).c());
        94.c(this.5(), this.6(), this.1(), this.3(), n4);
        String string = 2n_0.1() ? "Modules" : "HUD Editor";
        9b.1(string, (int)(this.5() + this.1() / 2.0f - 9b.0(string) / 2.0f), (int)(this.6() + this.3() / 2.0f - (float)9b.0() / 2.0f), 0xFFFFFF);
    }
}

