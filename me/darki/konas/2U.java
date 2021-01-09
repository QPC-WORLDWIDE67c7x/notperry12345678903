/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2E;
import me.darki.konas.3F;
import me.darki.konas.6i_0;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.94;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2U
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));

    @Override
    public void 5() {
        super.5();
        if (2U.c.player == null || 2U.c.world == null) {
            return;
        }
        if (!3F.c(6i_0.class).f() || !6i_0.q()) {
            return;
        }
        94.c(this.9(), this.3(), this.c(), this.7() / 2.0f, 2U.c.player.rotationPitch <= 0.0f ? -14974014 : -15441777);
        94.c(this.9(), this.3() + this.7() / 2.0f, this.c(), this.7() / 2.0f, 2U.c.player.rotationPitch > 0.0f ? -9938892 : -11582680);
        float f2 = this.3() + (2U.c.player.rotationPitch + 90.0f) / 180.0f * this.7();
        94.c(this.9(), f2, this.c(), 2.0f, ((89)this.1.6()).c());
        94.c(this.9(), this.3(), this.c(), this.7(), 2.0f, ((89)this.1.6()).c());
    }

    public 2U() {
        super("FlightPitch", 5.0f, 100.0f, 50.0f, 100.0f);
    }
}

