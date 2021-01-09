/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.2E;
import me.darki.konas.8h_0;
import me.darki.konas.8x_0;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2V
extends 2E {
    public 8h_0<Boolean> 1 = new 8h_0("Yaw", true);
    public 8h_0<Boolean> 2 = new 8h_0("Pitch", true);

    public 2V() {
        super("Player", 3.0f, 80.0f, 100.0f, 115.0f);
    }

    @Override
    public void 5() {
        super.5();
        if (2V.c.player == null || 2V.c.world == null) {
            return;
        }
        8x_0.c((int)(this.9() + this.c() / 2.0f), (int)(this.3() + this.7()), 50, -30.0f, 0.0f, (EntityPlayer)Minecraft.getMinecraft().player, (Boolean)this.1.6(), (Boolean)this.2.6());
    }
}

