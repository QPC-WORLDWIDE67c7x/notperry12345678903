/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.awt.Color;
import java.util.UUID;
import me.darki.konas.2E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.9f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2T
extends 2E {
    public 8h_0<89> 1 = new 8h_0("TextColor", new 89(new Color(255, 85, 255, 255).hashCode(), false));

    public int c() {
        Minecraft minecraft;
        if (c.getConnection() == null) {
            return 1;
        }
        if (2T.c.player == null) {
            return -1;
        }
        try {
            minecraft = c;
        }
        catch (NullPointerException nullPointerException) {
            return -1;
        }
        NetHandlerPlayClient netHandlerPlayClient = minecraft.getConnection();
        EntityPlayerSP entityPlayerSP = 2T.c.player;
        UUID uUID = entityPlayerSP.getUniqueID();
        NetworkPlayerInfo networkPlayerInfo = netHandlerPlayClient.getPlayerInfo(uUID);
        return networkPlayerInfo.getResponseTime();
    }

    @Override
    public void 5() {
        super.5();
        String string = this.c() + " ms";
        float f2 = Math.max(5.0f, 9f.0(string));
        this.c(f2 + 1.0f);
        this.0(9f.c(string) + 1.0f);
        9f.0(string, (int)this.9(), (int)this.3(), ((89)this.1.6()).c());
    }

    public 2T() {
        super("Ping", 100.0f, 200.0f, 5.0f, 10.0f);
    }
}

