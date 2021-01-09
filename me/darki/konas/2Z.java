/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2Z
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));

    @Override
    public void 5() {
        block0: {
            super.5();
            if (2Z.c.player == null) break block0;
            String string = (c.isIntegratedServerRunning() ? "Singleplayer: " : "Server: ") + (2Z.c.player.getServerBrand() == null ? "Unknown" : 2Z.c.player.getServerBrand());
            this.0(9f.c(string) + 1.0f);
            this.c(9f.0(string) + 1.0f);
            9f.0(string, this.9(), this.3(), ((89)this.1.6()).c());
        }
    }

    public 2Z() {
        super("ServerBrand", 200.0f, 1000.0f, 50.0f, 10.0f);
    }
}

