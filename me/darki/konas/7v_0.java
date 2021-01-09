/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.1I;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.EntityViewRenderEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.7v
 */
public class 7v_0
extends 3E {
    public float c = 0.0f;
    public float 0 = 0.0f;
    public static 8h_0<Boolean> 1 = new 8h_0("AutoThirdPerson", true);

    @Subscriber
    public void c(1I i2) {
        block0: {
            if (7v_0.c.gameSettings.thirdPersonView <= 0) break block0;
            this.c = (float)((double)this.c + (double)i2.0() * 0.15);
            this.0 = (float)((double)this.0 - (double)i2.c() * 0.15);
            this.0 = MathHelper.clamp((float)this.0, (float)-90.0f, (float)90.0f);
            i2.c(true);
        }
    }

    @Subscriber
    public void c(EntityViewRenderEvent.CameraSetup cameraSetup) {
        block0: {
            if (7v_0.c.gameSettings.thirdPersonView <= 0) break block0;
            cameraSetup.setYaw(cameraSetup.getYaw() + this.c);
            cameraSetup.setPitch(cameraSetup.getPitch() + this.0);
        }
    }

    public 7v_0() {
        super("FreeLook", "Look around in 3rd person", 3D.2, new String[0]);
    }

    @Override
    public void 7() {
        if (((Boolean)1.6()).booleanValue()) {
            7v_0.c.gameSettings.thirdPersonView = 0;
        }
    }

    @Override
    public void c() {
        this.c = 0.0f;
        this.0 = 0.0f;
        if (((Boolean)1.6()).booleanValue()) {
            7v_0.c.gameSettings.thirdPersonView = 1;
        }
    }
}

