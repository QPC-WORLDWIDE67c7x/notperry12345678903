/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0n_0;
import me.darki.konas.0o_0;
import me.darki.konas.1N;
import me.darki.konas.1q_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.6Y;
import me.darki.konas.6Z;
import me.darki.konas.8G;
import me.darki.konas.8h_0;
import me.darki.konas.8j_0;
import me.darki.konas.8x_0;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraftforge.event.world.WorldEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.7c
 */
public class 7c_0
extends 3E {
    public static 8h_0<8j_0> 1 = new 8h_0("Control", new 8j_0(56));
    public 8h_0<Boolean> 2 = new 8h_0("Follow", false);
    public 8h_0<Boolean> 3 = new 8h_0("CopyInv", false);
    public 8h_0<Float> 4 = new 8h_0("HSpeed", Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(0.2f), Float.valueOf(0.1f));
    public 8h_0<Float> 5 = new 8h_0("VSpeed", Float.valueOf(1.0f), Float.valueOf(2.0f), Float.valueOf(0.2f), Float.valueOf(0.1f));
    public Entity c;
    public int 1 = -1;
    public Entity 0;
    public 8G c;
    public MovementInput c = null;
    public MovementInput 0 = null;

    @Override
    public void 7() {
        if (7c_0.c.player == null) {
            return;
        }
        if (this.c != null) {
            7c_0.c.world.removeEntity((Entity)this.c);
        }
        this.c = null;
        7c_0.c.player.movementInput = new MovementInputFromOptions(7c_0.c.gameSettings);
        c.setRenderViewEntity(this.0);
        7c_0.c.renderChunksMany = true;
    }

    public Entity c() {
        int n2;
        if (this.c == null) {
            this.c = 7c_0.c.player;
        }
        if (this.1 != (n2 = 7c_0.c.player.ticksExisted)) {
            this.1 = n2;
            this.c = this.f() ? (8x_0.c(((8j_0)1.6()).c()) ? 7c_0.c.player : (c.getRenderViewEntity() == null ? 7c_0.c.player : c.getRenderViewEntity())) : 7c_0.c.player;
        }
        return this.c;
    }

    @Subscriber
    public void c(1q_0 q_02) {
        q_02.c();
    }

    public 7c_0() {
        super("Freecam", "Control your camera separately to your body", 3D.1, new String[0]);
        this.c = new 6Y(this, 7c_0.c.gameSettings);
        this.0 = new 6Z(this, 7c_0.c.gameSettings);
    }

    @Subscriber
    public void c(0o_0 o_02) {
        o_02.c();
    }

    @Override
    public void c() {
        if (7c_0.c.player == null) {
            return;
        }
        this.c = new 8G((Boolean)this.3.6(), (Boolean)this.2.6(), ((Float)this.4.6()).floatValue(), ((Float)this.5.6()).floatValue());
        this.c.movementInput = this.c;
        7c_0.c.player.movementInput = this.0;
        7c_0.c.world.addEntityToWorld(-921, (Entity)this.c);
        this.0 = c.getRenderViewEntity();
        c.setRenderViewEntity((Entity)this.c);
        7c_0.c.renderChunksMany = false;
    }

    @Subscriber
    public void c(1N n2) {
        if (7c_0.c.player == null || 7c_0.c.world == null) {
            return;
        }
        this.c.0((Boolean)this.3.6());
        this.c.c((Boolean)this.2.6());
        this.c.0(((Float)this.4.6()).floatValue());
        this.c.c(((Float)this.5.6()).floatValue());
    }

    @Subscriber
    public void c(WorldEvent.Unload unload) {
        c.setRenderViewEntity((Entity)7c_0.c.player);
        this.d();
    }

    @Subscriber
    public void c(0n_0 n_02) {
        block0: {
            if (this.c() == null) break block0;
            n_02.c((Entity)((EntityPlayerSP)this.c()));
        }
    }
}

