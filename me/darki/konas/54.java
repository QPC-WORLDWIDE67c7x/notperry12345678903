/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import me.darki.konas.0S;
import me.darki.konas.0T;
import me.darki.konas.11;
import me.darki.konas.14;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.4Z;
import me.darki.konas.50;
import me.darki.konas.51;
import me.darki.konas.52;
import me.darki.konas.53;
import me.darki.konas.5c_0;
import me.darki.konas.8C;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.X;
import me.darki.konas.mixin.mixins.ISPacketPlayerPosLook;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 54
extends 3E {
    public static 8h_0<53> 1 = new 8h_0("Type", 53.c);
    public static 8h_0<51> 2 = new 8h_0("PacketMode", 51.2);
    public static 8h_0<5c_0> 3 = new 8h_0("Bounds", 5c_0.1);
    public static 8h_0<Float> 4 = new 8h_0("Factor", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(54::1);
    public static 8h_0<Float> 5 = new 8h_0("Speed", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.05f));
    public static 8h_0<52> 6 = new 8h_0("Phase", 52.1);
    public static 8h_0<4Z> 7 = new 8h_0("AntiKick", 4Z.0);
    public static 8h_0<50> 8 = new 8h_0("Limit", 50.c);
    public static 8h_0<Boolean> 9 = new 8h_0("Constrict", false);
    public static 8h_0<Boolean> a = new 8h_0("Boost", false);
    public int 1;
    public CPacketConfirmTeleport c;
    public CPacketPlayer.Position c;
    public ArrayList<CPacketPlayer> 0;
    public Map<Integer, 8C> c;
    public int 2;
    public int 3 = 0;
    public int 4 = 0;
    public boolean 1;
    public int 5 = 0;
    public int 6 = 0;
    public boolean 2 = false;
    public double c;
    public double 0 = 0.0;
    public double 1 = 0.0;
    public int 7 = 0;
    public 9m c = new 9m();
    public static Random c = new Random();

    public void c(double d2, double d3, double d4, 51 var7_4, boolean bl) {
        if (this.c != null) {
            54.c.player.connection.sendPacket((Packet)this.c);
            this.c = null;
        }
        Vec3d vec3d = new Vec3d(54.c.player.posX + d2, 54.c.player.posY + d3, 54.c.player.posZ + d4);
        Vec3d vec3d2 = this.c(d2, d3, d4, var7_4);
        CPacketPlayer.Position position = new CPacketPlayer.Position(vec3d.x, vec3d.y, vec3d.z, 54.c.player.onGround);
        this.0.add((CPacketPlayer)position);
        54.c.player.connection.sendPacket((Packet)position);
        if (8.6() != 50.c && this.5 == 0) {
            return;
        }
        CPacketPlayer.Position position2 = new CPacketPlayer.Position(vec3d2.x, vec3d2.y, vec3d2.z, 54.c.player.onGround);
        this.0.add((CPacketPlayer)position2);
        54.c.player.connection.sendPacket((Packet)position2);
        if (((Boolean)9.6()).booleanValue()) {
            for (int i2 = 0; i2 < 7; ++i2) {
                position = new CPacketPlayer.Position(vec3d.x, vec3d.y, vec3d.z, 54.c.player.onGround);
                this.0.add((CPacketPlayer)position);
                54.c.player.connection.sendPacket((Packet)position);
            }
        }
        if (bl) {
            ++this.1;
            this.c.put(this.1, new 8C(vec3d.x, vec3d.y, vec3d.z, System.currentTimeMillis()));
            this.c = new CPacketConfirmTeleport(this.1);
        }
    }

    @Subscriber
    public void c(14 var1_1) {
        if (54.c.player == null || 54.c.world == null) {
            this.d();
            return;
        }
        if (54.c.player.ticksExisted % 20 == 0) {
            this.0();
        }
        this.0(((53)((Object)1.6())).name());
        54.c.player.setVelocity(0.0, 0.0, 0.0);
        if (this.1 <= 0 && 1.6() != 53.0) {
            this.c = new CPacketPlayer.Position(54.7(), 1.0, 54.7(), 54.c.player.onGround);
            this.0.add((CPacketPlayer)this.c);
            54.c.player.connection.sendPacket((Packet)this.c);
            return;
        }
        boolean bl = this.6();
        this.c = 0.0;
        this.0 = 0.0;
        this.1 = 0.0;
        if (54.c.gameSettings.keyBindJump.isKeyDown() && (this.4 < 1 || bl)) {
            this.0 = 54.c.player.ticksExisted % (1.6() == 53.0 || 1.6() == 53.2 || 8.6() == 50.1 ? 10 : 20) == 0 ? (7.6() != 4Z.c ? -0.032 : 0.062) : 0.062;
            this.2 = 0;
            this.3 = 5;
        } else if (54.c.gameSettings.keyBindSneak.isKeyDown() && (this.4 < 1 || bl)) {
            this.0 = -0.062;
            this.2 = 0;
            this.3 = 5;
        }
        if (bl || !54.c.gameSettings.keyBindSneak.isKeyDown() || !54.c.gameSettings.keyBindJump.isKeyDown()) {
            if (8x_0.c()) {
                double[] dArray = 8x_0.c((bl && 6.6() != 52.c ? (6.6() == 52.1 ? (this.0 != 0.0 ? 0.0465 : 0.062) : 0.031) : 0.26) * (double)((Float)5.6()).floatValue());
                if (dArray[0] != 0.0 || dArray[1] != 0.0) {
                    if (this.3 < 1 || bl) {
                        this.c = dArray[0];
                        this.1 = dArray[1];
                        this.4 = 5;
                    }
                }
            }
            if (7.6() != 4Z.c && (8.6() == 50.c || this.5 != 0)) {
                if (this.2 < (2.6() == 51.3 && 3.6() == 5c_0.c ? 1 : 3)) {
                    ++this.2;
                } else {
                    this.2 = 0;
                    if (7.6() != 4Z.1 || !bl) {
                        double d2 = this.0 = 7.6() == 4Z.2 ? -0.08 : -0.04;
                    }
                }
            }
        }
        if (bl && (6.6() != 52.c && (double)54.c.player.moveForward != 0.0 || (double)54.c.player.moveStrafing != 0.0 && this.0 != 0.0)) {
            this.0 /= 2.5;
        }
        if (8.6() != 50.c && this.5 == 0) {
            this.c = 0.0;
            this.0 = 0.0;
            this.1 = 0.0;
        }
        switch ((53)((Object)1.6())) {
            case 1: {
                54.c.player.setVelocity(this.c, this.0, this.1);
                this.c(this.c, this.0, this.1, (51)((Object)2.6()), true);
                break;
            }
            case 2: {
                this.c(this.c, this.0, this.1, (51)((Object)2.6()), true);
                break;
            }
            case 0: {
                54.c.player.setVelocity(this.c, this.0, this.1);
                this.c(this.c, this.0, this.1, (51)((Object)2.6()), false);
                break;
            }
            case c: 
            case 3: {
                float f2 = ((Float)4.6()).floatValue();
                int n2 = (int)Math.floor(f2);
                float f3 = f2 - (float)n2;
                if (Math.random() <= (double)f3) {
                    ++n2;
                }
                for (int i2 = 1; i2 <= n2; ++i2) {
                    54.c.player.setVelocity(this.c * (double)i2, this.0 * (double)i2, this.1 * (double)i2);
                    this.c(this.c * (double)i2, this.0 * (double)i2, this.1 * (double)i2, (51)((Object)2.6()), true);
                }
                this.c = 54.c.player.motionX;
                this.0 = 54.c.player.motionY;
                this.1 = 54.c.player.motionZ;
            }
        }
        --this.3;
        --this.4;
        ++this.5;
        ++this.6;
        if (this.5 > (8.6() == 50.1 ? (this.1 ? 1 : 2) : 3)) {
            this.5 = 0;
            boolean bl2 = this.1 = !this.1;
        }
        if (this.6 > 7) {
            this.6 = 0;
        }
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketPlayerPosLook) {
            if (!(54.c.currentScreen instanceof GuiDownloadTerrain)) {
                SPacketPlayerPosLook sPacketPlayerPosLook = (SPacketPlayerPosLook)s.c();
                if (54.c.player.isEntityAlive()) {
                    if (this.1 <= 0) {
                        this.1 = ((SPacketPlayerPosLook)s.c()).getTeleportId();
                    } else if (54.c.world.isBlockLoaded(new BlockPos(54.c.player.posX, 54.c.player.posY, 54.c.player.posZ), false) && 1.6() != 53.0) {
                        if (1.6() == 53.3) {
                            this.c.remove(sPacketPlayerPosLook.getTeleportId());
                            s.c(true);
                            if (1.6() == 53.2) {
                                54.c.player.setPosition(sPacketPlayerPosLook.getX(), sPacketPlayerPosLook.getY(), sPacketPlayerPosLook.getZ());
                            }
                            return;
                        }
                        if (this.c.containsKey(sPacketPlayerPosLook.getTeleportId())) {
                            8C c2 = (8C)((Object)this.c.get(sPacketPlayerPosLook.getTeleportId()));
                            if (c2.x == sPacketPlayerPosLook.getX() && c2.y == sPacketPlayerPosLook.getY() && c2.z == sPacketPlayerPosLook.getZ()) {
                                this.c.remove(sPacketPlayerPosLook.getTeleportId());
                                s.c(true);
                                if (1.6() == 53.2) {
                                    54.c.player.setPosition(sPacketPlayerPosLook.getX(), sPacketPlayerPosLook.getY(), sPacketPlayerPosLook.getZ());
                                }
                                return;
                            }
                        }
                    }
                }
                ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setYaw(54.c.player.rotationYaw);
                ((ISPacketPlayerPosLook)sPacketPlayerPosLook).setPitch(54.c.player.rotationPitch);
                sPacketPlayerPosLook.getFlags().remove(SPacketPlayerPosLook.EnumFlags.X_ROT);
                sPacketPlayerPosLook.getFlags().remove(SPacketPlayerPosLook.EnumFlags.Y_ROT);
                this.1 = sPacketPlayerPosLook.getTeleportId();
            } else {
                this.1 = 0;
            }
        }
    }

    public static double 9() {
        int n2 = c.nextInt(22);
        n2 += 70;
        if (c.nextBoolean()) {
            return n2;
        }
        return -n2;
    }

    @Subscriber
    public void c(0T t) {
        block2: {
            if (t.c() instanceof CPacketPlayer && !(t.c() instanceof CPacketPlayer.Position)) {
                t.c();
            }
            if (!(t.c() instanceof CPacketPlayer)) break block2;
            CPacketPlayer cPacketPlayer = (CPacketPlayer)t.c();
            if (this.0.contains(cPacketPlayer)) {
                this.0.remove(cPacketPlayer);
                return;
            }
            t.c();
        }
    }

    @Override
    public void c() {
        if (54.c.player == null || 54.c.world == null) {
            this.d();
            return;
        }
        this.0.clear();
        this.c.clear();
        this.1 = 0;
        this.3 = 0;
        this.4 = 0;
        this.2 = 0;
        this.5 = 0;
        this.6 = 0;
        this.c = 0.0;
        this.0 = 0.0;
        this.1 = 0.0;
        this.2 = false;
        this.c = null;
        this.c = new CPacketPlayer.Position(54.7(), 1.0, 54.7(), 54.c.player.onGround);
        this.0.add((CPacketPlayer)this.c);
        54.c.player.connection.sendPacket((Packet)this.c);
    }

    @Subscriber
    public void c(11 var1_1) {
        if (1.6() != 53.0 && this.1 <= 0) {
            return;
        }
        if (1.6() != 53.2) {
            var1_1.1(this.c);
            var1_1.0(this.0);
            var1_1.c(this.1);
        }
        if (6.6() != 52.c && this.6()) {
            54.c.player.noClip = true;
        }
    }

    @Subscriber
    public void c(X x) {
        x.c(true);
    }

    public static double 7() {
        int n2 = c.nextInt(3.6() != 5c_0.c ? 80 : (2.6() == 51.4 ? (54.c.player.ticksExisted % 2 == 0 ? 480 : 100) : 29000000)) + (3.6() != 5c_0.c ? 5 : 500);
        if (c.nextBoolean()) {
            return n2;
        }
        return -n2;
    }

    @Subscriber
    public void c(1N n2) {
        if (54.c.currentScreen instanceof GuiDisconnected || 54.c.currentScreen instanceof GuiMainMenu || 54.c.currentScreen instanceof GuiMultiplayer || 54.c.currentScreen instanceof GuiDownloadTerrain) {
            this.d();
        }
        if (((Boolean)a.6()).booleanValue()) {
            8k_0.c.c.c(this, 9, 1.088f);
        } else {
            8k_0.c.c.c(this);
        }
    }

    public void c(Integer n2, 8C c2) {
        if (System.currentTimeMillis() - c2.c() > TimeUnit.SECONDS.toMillis(30L)) {
            this.c.remove(n2);
        }
    }

    public 54() {
        super("PacketFly", 3D.4, new String[0]);
    }

    public Vec3d c(double d2, double d3, double d4, 51 var7_4) {
        switch (var7_4) {
            case c: {
                return new Vec3d(54.c.player.posX + d2, 3.6() != 5c_0.c ? (double)(3.6() == 5c_0.1 ? 255 : 256) : 54.c.player.posY + 420.0, 54.c.player.posZ + d4);
            }
            case 0: {
                return new Vec3d(3.6() != 5c_0.c ? 54.c.player.posX + 54.7() : 54.7(), 3.6() == 5c_0.1 ? Math.max(54.c.player.posY, 2.0) : 54.c.player.posY, 3.6() != 5c_0.c ? 54.c.player.posZ + 54.7() : 54.7());
            }
            case 2: {
                return new Vec3d(54.c.player.posX + (3.6() == 5c_0.1 ? d2 : 54.8()), 54.c.player.posY + 54.9(), 54.c.player.posZ + (3.6() == 5c_0.1 ? d4 : 54.8()));
            }
            case 3: {
                if (3.6() != 5c_0.c) {
                    double d5 = d3 * 510.0;
                    return new Vec3d(54.c.player.posX + d2, 54.c.player.posY + (d5 > (double)(54.c.player.dimension == -1 ? 127 : 255) ? -d5 : (d5 < 1.0 ? -d5 : d5)), 54.c.player.posZ + d4);
                }
                return new Vec3d(54.c.player.posX + (d2 == 0.0 ? (double)(c.nextBoolean() ? -10 : 10) : d2 * 38.0), 54.c.player.posY + d3, 54.c.player.posX + (d4 == 0.0 ? (double)(c.nextBoolean() ? -10 : 10) : d4 * 38.0));
            }
            case 4: {
                return new Vec3d(54.c.player.posX + 54.7(), Math.max(1.5, Math.min(54.c.player.posY + d3, 253.5)), 54.c.player.posZ + 54.7());
            }
        }
        return new Vec3d(54.c.player.posX + d2, 3.6() != 5c_0.c ? (double)(3.6() == 5c_0.1 ? 1 : 0) : 54.c.player.posY - 1337.0, 54.c.player.posZ + d4);
    }

    public boolean 6() {
        if (!54.c.world.getCollisionBoxes((Entity)54.c.player, 54.c.player.getEntityBoundingBox().expand(0.0, 0.0, 0.0)).isEmpty()) {
            return true;
        }
        return !54.c.world.getCollisionBoxes((Entity)54.c.player, 54.c.player.getEntityBoundingBox().offset(0.0, 2.0, 0.0).contract(0.0, 1.99, 0.0)).isEmpty();
    }

    public static double 8() {
        int n2 = c.nextInt(10);
        if (c.nextBoolean()) {
            return n2;
        }
        return -n2;
    }

    @Override
    public void 7() {
        if (54.c.player != null) {
            54.c.player.setVelocity(0.0, 0.0, 0.0);
        }
        8k_0.c.c.c(this);
    }

    public void 0() {
        this.c.forEach(this::c);
    }

    public static boolean 1() {
        return 1.6() == 53.c || 1.6() == 53.3;
    }
}

