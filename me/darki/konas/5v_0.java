/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import me.darki.konas.0S;
import me.darki.konas.14;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5u_0;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IMinecraft;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.5v
 */
public class 5v_0
extends 3E {
    public static 8h_0<5u_0> 1 = new 8h_0("Mode", 5u_0.c);
    public static 8h_0<Boolean> 2 = new 8h_0("Cast", true);
    public boolean 1 = false;
    public boolean 2 = false;
    public 9m c = new 9m();

    public 5v_0() {
        super("AutoFish", 3D.3, "AutoCaster");
    }

    @Subscriber
    public void c(14 var1_1) {
        if (((Minecraft)5v_0.c).player.getHeldItemMainhand().getItem() != Items.FISHING_ROD) {
            this.c.c();
            this.1 = false;
            this.2 = false;
            return;
        }
        if (5v_0.c.player.fishEntity == null) {
            if (this.2) {
                if (this.c.c(450.0)) {
                    ((IMinecraft)((Object)c)).invokeRightClickMouse();
                    this.c.c();
                    this.1 = false;
                    this.2 = false;
                }
            } else if (((Boolean)2.6()).booleanValue() && this.c.c(4500.0)) {
                ((IMinecraft)((Object)c)).invokeRightClickMouse();
                this.c.c();
                this.1 = false;
                this.2 = false;
            }
        } else if (this.c() && this.1()) {
            if (this.1) {
                if (this.c.c(350.0)) {
                    ((IMinecraft)((Object)c)).invokeRightClickMouse();
                    this.c.c();
                    this.1 = false;
                    this.2 = true;
                }
            } else if (1.6() != 5u_0.0 && this.0()) {
                this.c.c();
                this.1 = true;
                this.2 = false;
            }
        } else if (this.c()) {
            ((IMinecraft)((Object)c)).invokeRightClickMouse();
            this.c.c();
            this.1 = false;
            this.2 = false;
        }
    }

    @Override
    public String 0() {
        return ((5u_0)((Object)1.6())).toString().charAt(0) + ((5u_0)((Object)1.6())).toString().substring(1).toLowerCase();
    }

    public boolean c() {
        if (5v_0.c.player.fishEntity == null || 5v_0.c.player.fishEntity.isAirBorne || this.2) {
            return false;
        }
        return Math.abs(5v_0.c.player.fishEntity.motionX) + Math.abs(5v_0.c.player.fishEntity.motionZ) < 0.01;
    }

    public boolean 1() {
        if (5v_0.c.player.fishEntity == null || 5v_0.c.player.fishEntity.isAirBorne) {
            return false;
        }
        BlockPos blockPos = 5v_0.c.player.fishEntity.getPosition();
        return ((Minecraft)5v_0.c).world.getBlockState(blockPos).getBlock() instanceof BlockLiquid || ((Minecraft)5v_0.c).world.getBlockState(blockPos.down()).getBlock() instanceof BlockLiquid;
    }

    @Subscriber
    public void c(0S s) {
        block0: {
            if (!(s.c() instanceof SPacketSoundEffect) || !((SPacketSoundEffect)s.c()).getSound().getSoundName().toString().toLowerCase().contains("entity.bobber.splash") || this.2 || !this.c() || 1.6() == 5u_0.c) break block0;
            this.1 = true;
            this.c.c();
        }
    }

    public boolean 0() {
        if (5v_0.c.player.fishEntity == null || !this.1()) {
            return false;
        }
        return Math.abs(5v_0.c.player.fishEntity.motionY) > 0.05;
    }
}

