/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.text.DecimalFormat;
import me.darki.konas.2E;
import me.darki.konas.2F;
import me.darki.konas.2n_0;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2R
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));
    public static DecimalFormat c = new DecimalFormat("#.#");

    @Override
    public void 5() {
        block0: {
            long l2 = System.currentTimeMillis() - 2F.c.0();
            String string = "Server not responding for " + c.format((float)l2 / 1000.0f) + "s";
            float f2 = Math.max(5.0f, 9f.0(string));
            this.c(f2 + 1.0f);
            this.0(9f.c(string) + 1.0f);
            if (!2F.c.c(2500.0) && !(((Minecraft)2R.c).currentScreen instanceof 2n_0)) break block0;
            9f.0(string, (float)((int)this.9() + (int)this.c()) - 9f.0(string), (int)this.3(), ((89)this.1.6()).c());
        }
    }

    public 2R() {
        super("LagNotifier", 200.0f, 0.0f, 5.0f, 10.0f);
    }
}

