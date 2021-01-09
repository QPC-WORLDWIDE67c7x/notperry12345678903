/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Locale;
import me.darki.konas.0T;
import me.darki.konas.0W;
import me.darki.konas.10;
import me.darki.konas.14;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5U;
import me.darki.konas.8d_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5V
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Place", true);
    public static 8h_0<Boolean> 2 = new 8h_0("Destroy", false);
    public static 8h_0<Boolean> 3 = new 8h_0("Limit", false);
    public static 8h_0<Boolean> 4 = new 8h_0("RightClick", false);
    public 8h_0<Float> 5 = new 8h_0("Timeout", Float.valueOf(1.0f), Float.valueOf(30.0f), Float.valueOf(0.5f), Float.valueOf(0.5f)).c(4::6);
    public static 8h_0<Boolean> 6 = new 8h_0("Use", false);
    public static 8h_0<5U> 7 = new 8h_0("Mode", 5U.0).c(6::6);
    public static 8h_0<8d_0> 8 = new 8h_0("Items", new 8d_0(new String[0]));
    public static 9m c = new 9m();
    public static boolean 1 = false;
    public long c;
    public float[] c = new float[22];
    public int 1 = 0;
    public int 2 = -1;

    @Subscriber
    public void c(1N n2) {
        block6: {
            if (((Minecraft)5V.c).player == null || ((Minecraft)5V.c).world == null) {
                return;
            }
            if (n2.c() != TickEvent.Phase.END) break block6;
            if (((Boolean)6.6()).booleanValue() && this.c(((Minecraft)5V.c).player.getActiveItemStack()) && ((Minecraft)5V.c).player.getItemInUseCount() <= 0) {
                this.2 = 5V.c.player.inventory.currentItem;
            }
            if (((Boolean)3.6()).booleanValue()) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (float f4 : this.c) {
                    if (!(f4 > 0.0f)) continue;
                    f2 += f4;
                    f3 += 1.0f;
                }
                f2 /= f3;
                if ((f2 = Math.max(f2, 0.5f)) < 0.9f) {
                    8k_0.c.c.c(this, 1000, f2);
                } else {
                    8k_0.c.c.c(this);
                }
            }
        }
    }

    public 5V() {
        super("NoDesync", "Helps prevent desync", 3D.3, "NoGlitchBlocks");
    }

    @Subscriber
    public void c(0T t) {
        if (((Boolean)4.6()).booleanValue() && !1 && !c.c(1000.0f * ((Float)this.5.6()).floatValue()) && t.c() instanceof CPacketPlayerTryUseItemOnBlock) {
            c.c(0L);
            5V.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation(5V.c.player.rotationYaw, 5V.c.player.rotationPitch, 5V.c.player.onGround));
        }
        if (t.c() instanceof CPacketPlayer) {
            if (((Boolean)3.6()).booleanValue()) {
                if (this.c != -1L) {
                    float f2;
                    this.c[this.1 % this.c.length] = f2 = (float)(System.currentTimeMillis() - this.c) / 50.0f;
                    ++this.1;
                }
                this.c = System.currentTimeMillis();
            }
        }
    }

    @Subscriber
    public void c(0W w) {
        block0: {
            if (!((Boolean)1.6()).booleanValue()) break block0;
            w.c(true);
        }
    }

    @Subscriber
    public void c(14 var1_1) {
        if (this.2 != -1 && ((Boolean)6.6()).booleanValue()) {
            5V.c.player.inventory.currentItem = this.2;
            5V.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.2));
            this.2 = -1;
            return;
        }
    }

    @Override
    public void c() {
        1 = false;
        this.c = -1L;
        this.c = new float[44];
        this.1 = 0;
    }

    public boolean c(ItemStack itemStack) {
        if (7.6() == 5U.c) {
            return true;
        }
        if (7.6() == 5U.0) {
            return itemStack.getItem() instanceof ItemFood;
        }
        return ((8d_0)8.6()).c().contains(itemStack.getDisplayName().toLowerCase(Locale.ENGLISH));
    }

    @Subscriber
    public void c(10 var1_1) {
        block0: {
            if (!((Boolean)2.6()).booleanValue()) break block0;
            var1_1.c(true);
        }
    }
}

