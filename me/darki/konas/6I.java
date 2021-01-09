/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.0h_0;
import me.darki.konas.0i_0;
import me.darki.konas.11;
import me.darki.konas.12;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.X;
import me.darki.konas.mixin.mixins.ISPacketEntityVelocity;
import me.darki.konas.mixin.mixins.ISPacketExplosion;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6I
extends 3E {
    public static 8h_0<Float> 1 = new 8h_0("Horizontal", Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(1.0f));
    public static 8h_0<Float> 2 = new 8h_0("Vertical", Float.valueOf(0.0f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(1.0f));
    public static 8h_0<Boolean> 3 = new 8h_0("NoPush", true);
    public static 8h_0<Boolean> 4 = new 8h_0("NoHook", true);
    public static 8h_0<Boolean> 5 = new 8h_0("NoPiston", false);

    @Subscriber
    public void c(11 var1_1) {
        block0: {
            if (var1_1.c() != MoverType.PISTON && var1_1.c() != MoverType.SHULKER_BOX || !((Boolean)5.6()).booleanValue()) break block0;
            var1_1.c(true);
        }
    }

    @Subscriber
    public void c(X x) {
        block0: {
            if (!((Boolean)3.6()).booleanValue()) break block0;
            x.c(true);
        }
    }

    @Subscriber
    public void c(0i_0 i_02) {
        block1: {
            block2: {
                if (6I.c.world == null || 6I.c.player == null) {
                    return;
                }
                if (!((Boolean)3.6()).booleanValue() || i_02.1() != 6I.c.player) break block1;
                if (i_02.c() != 0h_0.c) break block2;
                i_02.c(i_02.0() * (double)((Float)1.6()).floatValue());
                break block1;
            }
            if (i_02.c() != 0h_0.0) break block1;
            i_02.c(i_02.0() * (double)((Float)2.6()).floatValue());
        }
    }

    @Subscriber
    public void c(0S s) {
        block5: {
            Entity entity;
            SPacketEntityStatus sPacketEntityStatus;
            block6: {
                block4: {
                    if (6I.c.world == null || 6I.c.player == null) {
                        return;
                    }
                    if (!(s.c() instanceof SPacketEntityVelocity)) break block4;
                    SPacketEntityVelocity sPacketEntityVelocity = (SPacketEntityVelocity)s.c();
                    if (sPacketEntityVelocity.getEntityID() != 6I.c.player.getEntityId()) break block5;
                    if (((Float)1.6()).floatValue() == 0.0f && ((Float)2.6()).floatValue() == 0.0f) {
                        s.c(true);
                    } else {
                        ((ISPacketEntityVelocity)sPacketEntityVelocity).setMotionX((int)((float)sPacketEntityVelocity.getMotionX() * ((Float)1.6()).floatValue()));
                        ((ISPacketEntityVelocity)sPacketEntityVelocity).setMotionY((int)((float)sPacketEntityVelocity.getMotionY() * ((Float)2.6()).floatValue()));
                        ((ISPacketEntityVelocity)sPacketEntityVelocity).setMotionZ((int)((float)sPacketEntityVelocity.getMotionZ() * ((Float)1.6()).floatValue()));
                    }
                    break block5;
                }
                if (!(s.c() instanceof SPacketExplosion)) break block6;
                SPacketExplosion sPacketExplosion = (SPacketExplosion)s.c();
                ((ISPacketExplosion)sPacketExplosion).setMotionX((int)(sPacketExplosion.getMotionX() * ((Float)1.6()).floatValue()));
                ((ISPacketExplosion)sPacketExplosion).setMotionY((int)(sPacketExplosion.getMotionY() * ((Float)2.6()).floatValue()));
                ((ISPacketExplosion)sPacketExplosion).setMotionZ((int)(sPacketExplosion.getMotionZ() * ((Float)1.6()).floatValue()));
                break block5;
            }
            if (!(s.c() instanceof SPacketEntityStatus) || !((Boolean)4.6()).booleanValue() || (sPacketEntityStatus = (SPacketEntityStatus)s.c()).getOpCode() != 31 || (entity = sPacketEntityStatus.getEntity((World)6I.c.world)) == null || !(entity instanceof EntityFishHook)) break block5;
            EntityFishHook entityFishHook = (EntityFishHook)entity;
            if (entityFishHook.caughtEntity == 6I.c.player) {
                s.c();
            }
        }
    }

    @Subscriber
    public void c(12 var1_1) {
        block0: {
            if (!((Boolean)3.6()).booleanValue()) break block0;
            var1_1.c(true);
        }
    }

    public 6I() {
        super("Velocity", 3D.0, "AntiKnockback");
    }
}

