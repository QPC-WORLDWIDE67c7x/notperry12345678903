/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.client.CPacketClientStatus;
import net.minecraft.network.play.client.CPacketConfirmTeleport;
import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketTabComplete;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4L
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Pulse", false);
    public 8h_0<Boolean> 2 = new 8h_0("Strict", false);
    public 8h_0<Float> 3 = new 8h_0("Factor", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Boolean> 4 = new 8h_0("Render", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Fill", true).c(4::6);
    public static 8h_0<Float> 6 = new 8h_0("Width", Float.valueOf(2.5f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(4::6);
    public static 8h_0<89> 7 = new 8h_0("Color", new 89(869950564, true)).c(4::6);
    public Queue<Packet> c;
    public Vec3d c;
    public AtomicBoolean c = new AtomicBoolean(false);

    @Override
    public void c() {
        if (((Minecraft)4L.c).player == null || ((Minecraft)4L.c).world == null || c.isIntegratedServerRunning()) {
            this.d();
            return;
        }
        this.c = ((Minecraft)4L.c).player.getPositionVector();
        this.c.set(false);
        this.c.clear();
        this.0();
    }

    public 4L() {
        super("Blink", 3D.4, "FakeLag", "InstantMove");
    }

    @Subscriber
    public void c(1N n2) {
        block1: {
            if (!((Boolean)this.1.6()).booleanValue() || n2.c() != TickEvent.Phase.START || ((Minecraft)4L.c).player == null || ((Minecraft)4L.c).world == null || !((float)this.c.size() >= ((Float)this.3.6()).floatValue() * 10.0f)) break block1;
            this.c.set(true);
            while (!this.c.isEmpty()) {
                Packet packet = this.c.poll();
                4L.c.player.connection.sendPacket(packet);
                if (!(packet instanceof CPacketPlayer)) continue;
                this.c = new Vec3d(((CPacketPlayer)packet).getX(4L.c.player.posX), ((CPacketPlayer)packet).getY(4L.c.player.posY), ((CPacketPlayer)packet).getZ(4L.c.player.posZ));
            }
            this.c.set(false);
            this.c.clear();
            this.0();
        }
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block9: {
            int n2;
            int n3;
            int n4;
            float f2;
            if (((Minecraft)4L.c).player == null || ((Minecraft)4L.c).world == null) {
                return;
            }
            if (!((Boolean)4.6()).booleanValue() || this.c == null) break block9;
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            GL11.glEnable((int)3008);
            GL11.glBlendFunc((int)770, (int)771);
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            IRenderManager iRenderManager = (IRenderManager)c.getRenderManager();
            float[] fArray = Color.RGBtoHSB(((89)7.6()).6(), ((89)7.6()).5(), ((89)7.6()).2(), null);
            float f3 = f2 = (float)(System.currentTimeMillis() % 7200L) / 7200.0f;
            int n5 = Color.getHSBColor(f3, fArray[1], fArray[2]).getRGB();
            ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
            double d2 = this.c.x - iRenderManager.getRenderPosX();
            double d3 = this.c.y - iRenderManager.getRenderPosY();
            double d4 = this.c.z - iRenderManager.getRenderPosZ();
            GL11.glShadeModel((int)7425);
            GlStateManager.disableCull();
            GL11.glLineWidth((float)((Float)6.6()).floatValue());
            GL11.glBegin((int)1);
            for (n4 = 0; n4 <= 360; ++n4) {
                Vec3d vec3d = new Vec3d(d2 + Math.sin((double)n4 * Math.PI / 180.0) * 0.5, d3 + 0.01, d4 + Math.cos((double)n4 * Math.PI / 180.0) * 0.5);
                arrayList.add(vec3d);
            }
            for (n4 = 0; n4 < arrayList.size() - 1; ++n4) {
                int n6 = n5 >> 16 & 0xFF;
                n3 = n5 >> 8 & 0xFF;
                n2 = n5 & 0xFF;
                if (((89)7.6()).7()) {
                    GL11.glColor4f((float)((float)n6 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n2 / 255.0f), (float)((Boolean)5.6() != false ? 1.0f : (float)((89)7.6()).1() / 255.0f));
                } else {
                    GL11.glColor4f((float)((float)((89)7.6()).6() / 255.0f), (float)((float)((89)7.6()).5() / 255.0f), (float)((float)((89)7.6()).2() / 255.0f), (float)((Boolean)5.6() != false ? 1.0f : (float)((89)7.6()).1() / 255.0f));
                }
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)n4)).x, (double)((Vec3d)arrayList.get((int)n4)).y, (double)((Vec3d)arrayList.get((int)n4)).z);
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)(n4 + 1))).x, (double)((Vec3d)arrayList.get((int)(n4 + 1))).y, (double)((Vec3d)arrayList.get((int)(n4 + 1))).z);
                n5 = Color.getHSBColor(f3 += 0.0027777778f, fArray[1], fArray[2]).getRGB();
            }
            GL11.glEnd();
            if (((Boolean)5.6()).booleanValue()) {
                f3 = f2;
                GL11.glBegin((int)9);
                for (n4 = 0; n4 < arrayList.size() - 1; ++n4) {
                    int n7 = n5 >> 16 & 0xFF;
                    n3 = n5 >> 8 & 0xFF;
                    n2 = n5 & 0xFF;
                    if (((89)7.6()).7()) {
                        GL11.glColor4f((float)((float)n7 / 255.0f), (float)((float)n3 / 255.0f), (float)((float)n2 / 255.0f), (float)((float)((89)7.6()).1() / 255.0f));
                    } else {
                        GL11.glColor4f((float)((float)((89)7.6()).6() / 255.0f), (float)((float)((89)7.6()).5() / 255.0f), (float)((float)((89)7.6()).2() / 255.0f), (float)((float)((89)7.6()).1() / 255.0f));
                    }
                    GL11.glVertex3d((double)((Vec3d)arrayList.get((int)n4)).x, (double)((Vec3d)arrayList.get((int)n4)).y, (double)((Vec3d)arrayList.get((int)n4)).z);
                    GL11.glVertex3d((double)((Vec3d)arrayList.get((int)(n4 + 1))).x, (double)((Vec3d)arrayList.get((int)(n4 + 1))).y, (double)((Vec3d)arrayList.get((int)(n4 + 1))).z);
                    n5 = Color.getHSBColor(f3 += 0.0027777778f, fArray[1], fArray[2]).getRGB();
                }
                GL11.glEnd();
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glDisable((int)3008);
            GlStateManager.enableCull();
            GL11.glShadeModel((int)7424);
            GlStateManager.enableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public void 0() {
        this.0(this.c.size() + "");
    }

    @Subscriber
    public void c(0T t) {
        block5: {
            Packet packet;
            block4: {
                packet = t.c();
                if (this.c.get()) {
                    return;
                }
                if (!((Boolean)this.1.6()).booleanValue()) break block4;
                if (!(t.c() instanceof CPacketPlayer)) break block5;
                if (((Boolean)this.2.6()).booleanValue() && !((CPacketPlayer)t.c()).isOnGround()) {
                    this.c.set(true);
                    while (!this.c.isEmpty()) {
                        Packet packet2 = this.c.poll();
                        4L.c.player.connection.sendPacket(packet2);
                        if (!(packet2 instanceof CPacketPlayer)) continue;
                        this.c = new Vec3d(((CPacketPlayer)packet2).getX(4L.c.player.posX), ((CPacketPlayer)packet2).getY(4L.c.player.posY), ((CPacketPlayer)packet2).getZ(4L.c.player.posZ));
                    }
                    this.c.set(false);
                    this.c.clear();
                    this.0();
                } else {
                    t.c();
                    this.c.add(t.c());
                    this.0();
                }
                break block5;
            }
            if (packet instanceof CPacketChatMessage || packet instanceof CPacketConfirmTeleport || packet instanceof CPacketKeepAlive || packet instanceof CPacketTabComplete || packet instanceof CPacketClientStatus) break block5;
            t.c();
            this.c.add(t.c());
            this.0();
        }
    }

    @Override
    public void 7() {
        if (((Minecraft)4L.c).world == null || ((Minecraft)4L.c).player == null) {
            return;
        }
        while (!this.c.isEmpty()) {
            4L.c.player.connection.sendPacket(this.c.poll());
        }
    }
}

