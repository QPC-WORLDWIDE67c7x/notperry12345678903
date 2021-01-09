/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0q_0;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IEntity;
import net.minecraftforge.client.GuiIngameForge;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6U
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("AllowGuis", true);
    public static 8h_0<Boolean> 2 = new 8h_0("NoRender", true);
    public static 8h_0<Boolean> 3 = new 8h_0("NoHitbox", false);
    public boolean 1 = false;

    @Subscriber
    public void c(0q_0 q_02) {
        block0: {
            if (!((Boolean)3.6()).booleanValue()) break block0;
            q_02.c();
        }
    }

    public 6U() {
        super("BetterPortals", "Remove unwanted portal functionality", 3D.1, "PortalChat");
    }

    @Override
    public void c() {
        this.1 = GuiIngameForge.renderPortal;
    }

    @Override
    public void 7() {
        GuiIngameForge.renderPortal = this.1;
    }

    @Subscriber
    public void c(1N n2) {
        if (6U.c.player == null || 6U.c.world == null) {
            return;
        }
        if (((Boolean)1.6()).booleanValue()) {
            ((IEntity)6U.c.player).setInPortal(false);
        }
        if (((Boolean)2.6()).booleanValue()) {
            GuiIngameForge.renderPortal = false;
        }
    }
}

