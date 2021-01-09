/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.2;
import me.darki.konas.6;
import me.darki.konas.8p_0;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class K
extends 2 {
    public EntityPlayer c;
    public boolean c = false;

    public void c() {
        this.c = false;
        c.setRenderViewEntity((Entity)K.c.player);
        8p_0.1("Stopped spectating " + 2.c + "b" + this.c.getName());
        this.c = null;
    }

    public K() {
        super("spectate", "Makes you spectate other players", new 6("<player>"));
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    @Subscriber
    public void c(0T t) {
        block2: {
            if (K.c.world == null || K.c.player == null) {
                return;
            }
            if (!this.c) {
                return;
            }
            if (!(t.c() instanceof CPacketPlayer.PositionRotation) && !(t.c() instanceof CPacketPlayer.Position) && !(t.c() instanceof CPacketPlayer.Rotation) && (!(t.c() instanceof CPacketAnimation) || !this.c)) break block2;
            t.c(true);
        }
    }

    @Subscriber
    public void c(1N n2) {
        block2: {
            if (K.c.world == null || K.c.player == null) {
                return;
            }
            if (!this.c) {
                return;
            }
            if (K.c.world.getEntityByID(this.c.getEntityId()) != null) break block2;
            this.c();
        }
    }

    @Subscriber
    public void c(0S s) {
        block6: {
            SPacketAnimation sPacketAnimation;
            block5: {
                block4: {
                    if (K.c.world == null) break block4;
                    if (K.c.player != null) break block5;
                }
                return;
            }
            if (!this.c) {
                return;
            }
            if (!(s.c() instanceof SPacketAnimation) || (sPacketAnimation = (SPacketAnimation)s.c()).getAnimationType() != 0) break block6;
            K.c.player.swingArm(EnumHand.MAIN_HAND);
        }
    }

    @Override
    public void c(String[] stringArray) {
        if (stringArray.length != this.2().size() + 1) {
            8p_0.1(this.0());
            return;
        }
        if (stringArray[1].equals("off") && this.c != null) {
            this.c();
            return;
        }
        if (K.c.world.getPlayerEntityByName(stringArray[1]) != null) {
            this.c = K.c.world.getPlayerEntityByName(stringArray[1]);
            this.c = true;
            c.setRenderViewEntity((Entity)this.c);
            8p_0.1("You are now spectating " + 2.c + "b" + this.c.getName());
        } else {
            8p_0.1("Cant find player " + 2.c + "b" + stringArray[1]);
        }
    }
}

