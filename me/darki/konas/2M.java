/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2M
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));

    @Override
    public void 5() {
        super.5();
        String string = Minecraft.getDebugFPS() + " FPS";
        float f2 = Math.max(5.0f, 9f.0(string));
        this.c(f2 + 1.0f);
        this.0(9f.c(string) + 1.0f);
        9f.0(string, (float)((int)this.9() + (int)this.c()) - 9f.0(string), (int)this.3(), ((89)this.1.6()).c());
    }

    public 2M() {
        super("FPS", 100.0f, 250.0f, 5.0f, 10.0f);
    }
}

