/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.darki.konas.0I;
import me.darki.konas.0X;
import me.darki.konas.0Y;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3Y;
import me.darki.konas.3Z;
import me.darki.konas.7R;
import me.darki.konas.89;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.99;
import me.darki.konas.9p;
import me.darki.konas.9r;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

/*
 * Renamed from me.darki.konas.4c
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4c_0
extends 3E {
    public 8h_0<8f_0> 1 = new 8h_0("Custom", new 8f_0(false));
    public 8h_0<Boolean> 2 = new 8h_0("CTracers", false).c(this.1);
    public 8h_0<89> 3 = new 8h_0("CTracersC", new 89(-16776961)).c(this.1);
    public 8h_0<Boolean> 4 = new 8h_0("CFill", true).c(this.1);
    public 8h_0<89> 5 = new 8h_0("CFillC", new 89(0x550000FF)).c(this.1);
    public 8h_0<Boolean> 6 = new 8h_0("COutline", true).c(this.1);
    public 8h_0<89> 7 = new 8h_0("COutlineC", new 89(-16776961)).c(this.1);
    public 8h_0<8f_0> 8 = new 8h_0("Logouts", new 8f_0(false));
    public 8h_0<Boolean> 9 = new 8h_0("RenderLogouts", true).c(this.8);
    public 8h_0<Boolean> a = new 8h_0("LTracers", false).c(this.8);
    public 8h_0<89> b = new 8h_0("LTracersC", new 89(-16777216)).c(this.8);
    public 8h_0<Boolean> d = new 8h_0("LFill", true).c(this.8);
    public 8h_0<89> e = new 8h_0("LFillC", new 89(0x55FF00FF)).c(this.8);
    public 8h_0<Boolean> f = new 8h_0("LOutline", true).c(this.8);
    public 8h_0<89> g = new 8h_0("LOutlineC", new 89(-65536)).c(this.8);
    public 8h_0<8f_0> h = new 8h_0("Deaths", new 8f_0(false));
    public 8h_0<Boolean> i = new 8h_0("RenderDeaths", true).c(this.h);
    public 8h_0<Boolean> j = new 8h_0("OnlyLast", false).c(this.h);
    public 8h_0<Boolean> k = new 8h_0("DTracers", false).c(this.h);
    public 8h_0<89> l = new 8h_0("DTracersC", new 89(-16711936)).c(this.h);
    public 8h_0<Boolean> m = new 8h_0("DFill", true).c(this.h);
    public 8h_0<89> n = new 8h_0("DFillC", new 89(0x5500FF00)).c(this.h);
    public 8h_0<Boolean> o = new 8h_0("DOutline", true).c(this.h);
    public 8h_0<89> p = new 8h_0("DOutlineC", new 89(-16711936)).c(this.h);
    public ConcurrentHashMap<EntityPlayer, Long> c;
    public DecimalFormat c = new DecimalFormat("#.##");

    @Subscriber
    public void c(0Y y) {
        if (((Minecraft)4c_0.c).player == null || ((Minecraft)4c_0.c).world == null) {
            return;
        }
        if (!((Boolean)this.9.6()).booleanValue()) {
            return;
        }
        EntityPlayer entityPlayer = ((Minecraft)4c_0.c).world.getPlayerEntityByUUID(y.c());
        if (entityPlayer != null) {
            this.c.put(entityPlayer, System.currentTimeMillis());
        }
    }

    public void c(AxisAlignedBB axisAlignedBB, 3Z z) {
        block13: {
            89 var3_3 = null;
            89 var4_4 = null;
            89 var5_5 = null;
            switch (3Y.c[z.ordinal()]) {
                case 1: {
                    if (((Boolean)this.6.6()).booleanValue()) {
                        var3_3 = (89)this.7.6();
                    }
                    if (((Boolean)this.4.6()).booleanValue()) {
                        var4_4 = (89)this.5.6();
                    }
                    if (!((Boolean)this.2.6()).booleanValue()) break;
                    var5_5 = (89)this.3.6();
                    break;
                }
                case 2: {
                    if (((Boolean)this.f.6()).booleanValue()) {
                        var3_3 = (89)this.g.6();
                    }
                    if (((Boolean)this.d.6()).booleanValue()) {
                        var4_4 = (89)this.e.6();
                    }
                    if (!((Boolean)this.a.6()).booleanValue()) break;
                    var5_5 = (89)this.b.6();
                    break;
                }
                case 3: {
                    if (((Boolean)this.o.6()).booleanValue()) {
                        var3_3 = (89)this.p.6();
                    }
                    if (((Boolean)this.m.6()).booleanValue()) {
                        var4_4 = (89)this.n.6();
                    }
                    if (!((Boolean)this.k.6()).booleanValue()) break;
                    var5_5 = (89)this.l.6();
                }
            }
            if (var4_4 != null) {
                99.c();
                99.c(axisAlignedBB, var4_4);
                99.0();
            }
            if (var3_3 != null) {
                99.c();
                99.c(axisAlignedBB, 1.5, var3_3);
                99.0();
            }
            if (var5_5 == null) break block13;
            Vec3d vec3d = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float)Math.toRadians(4c_0.c.player.rotationPitch))).rotateYaw(-((float)Math.toRadians(4c_0.c.player.rotationYaw)));
            Vec3d vec3d2 = new Vec3d(axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * 0.5, axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * 0.5, axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * 0.5);
            7R.c(vec3d.x, vec3d.y + (double)((Minecraft)4c_0.c).player.getEyeHeight(), vec3d.z, vec3d2.x - ((IRenderManager)c.getRenderManager()).getRenderPosX(), vec3d2.y - ((IRenderManager)c.getRenderManager()).getRenderPosY(), vec3d2.z - ((IRenderManager)c.getRenderManager()).getRenderPosZ(), var5_5.c());
        }
    }

    @Subscriber
    public void c(1b_0 b_02) {
        if (((Minecraft)4c_0.c).world == null || ((Minecraft)4c_0.c).player == null) {
            return;
        }
        if (((Boolean)this.9.6()).booleanValue()) {
            for (Map.Entry object : this.c.entrySet()) {
                EntityPlayer entityPlayer = (EntityPlayer)object.getKey();
                if (entityPlayer == ((Minecraft)4c_0.c).player) continue;
                this.c(entityPlayer.getEntityBoundingBox(), 3Z.0);
            }
        }
        for (9p p2 : 8k_0.c.c.c()) {
            this.c(new AxisAlignedBB(p2.4(), p2.c(), p2.5(), p2.4() + 1.0, p2.c() + 2.0, p2.5() + 1.0), p2.1() == 9r.c ? 3Z.1 : 3Z.c);
        }
    }

    @Subscriber
    public void c(0I i2) {
        if (i2.c() instanceof GuiConnecting || i2.c() instanceof GuiDownloadTerrain || i2.c() instanceof GuiDisconnected || i2.c() instanceof GuiMultiplayer) {
            this.c.clear();
        } else if (i2.c() instanceof GuiGameOver && ((Boolean)this.i.6()).booleanValue()) {
            if (((Boolean)this.j.6()).booleanValue()) {
                8k_0.c.c.0();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
            Date date = new Date();
            8k_0.c.c.c(new 9p("Death_" + simpleDateFormat.format(date), Double.parseDouble(this.c.format(4c_0.c.player.posX)), Double.parseDouble(this.c.format(4c_0.c.player.posY)), Double.parseDouble(this.c.format(4c_0.c.player.posZ)), 4c_0.c.player.dimension, 9r.c));
        }
    }

    @Subscriber
    public void c(0X x) {
        if (((Minecraft)4c_0.c).player == null || ((Minecraft)4c_0.c).world == null) {
            return;
        }
        if (!((Boolean)this.9.6()).booleanValue()) {
            return;
        }
        for (Map.Entry<EntityPlayer, Long> entry : this.c.entrySet()) {
            if (!entry.getKey().getUniqueID().equals(x.c())) continue;
            this.c.remove(entry.getKey());
        }
    }

    public 4c_0() {
        super("Waypoints", "Shows waypoints", 3D.5, new String[0]);
    }

    public ConcurrentHashMap<EntityPlayer, Long> c() {
        return this.c;
    }
}

