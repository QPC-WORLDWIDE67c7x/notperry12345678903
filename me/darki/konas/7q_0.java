/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import me.darki.konas.0S;
import me.darki.konas.17;
import me.darki.konas.1N;
import me.darki.konas.1b_0;
import me.darki.konas.1m_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.7o_0;
import me.darki.konas.7p_0;
import me.darki.konas.89;
import me.darki.konas.8O;
import me.darki.konas.8Z;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8u_0;
import me.darki.konas.95;
import me.darki.konas.96;
import me.darki.konas.97;
import me.darki.konas.9i;
import me.darki.konas.9j;
import me.darki.konas.9k;
import me.darki.konas.mixin.mixins.IEntityRenderer;
import me.darki.konas.mixin.mixins.IRenderGlobal;
import me.darki.konas.mixin.mixins.IRenderManager;
import me.darki.konas.mixin.mixins.IShaderGroup;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderUniform;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.INpc;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.7q
 */
public class 7q_0
extends 3E {
    public static 8h_0<8f_0> 1 = new 8h_0("Entities", new 8f_0(true));
    public static 8h_0<7o_0> 2 = new 8h_0("Mode", 7o_0.2).c(1);
    public static 8h_0<Boolean> 3 = new 8h_0("Skeleton", false).c(1);
    public static 8h_0<Boolean> 4 = new 8h_0("Csgo", false).c(1);
    public static 8h_0<Float> 5 = new 8h_0("Width", Float.valueOf(5.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(1);
    public static 8h_0<Double> 6 = new 8h_0("Quality", 2.0, 10.0, 0.1, 0.1).c(1).c(7q_0::c);
    public static 8h_0<Boolean> 7 = new 8h_0("ShaderOutline", true).c(1).c(7q_0::b);
    public static 8h_0<Boolean> 8 = new 8h_0("ShaderFade", true).c(1).c(7q_0::1);
    public static 8h_0<89> 9 = new 8h_0("ShaderColor", new 89(-65281)).c(1).c(7q_0::0);
    public static 8h_0<Boolean> a = new 8h_0("ShaderFill", false).c(1).c(7q_0::9);
    public static 8h_0<89> b = new 8h_0("ShaderFillColor", new 89(-1996553985)).c(1).c(7q_0::8);
    public static 8h_0<Boolean> d = new 8h_0("Show Targets", true).c(1);
    public static 8h_0<Boolean> e = new 8h_0("Crystals", true).c(1).c(7q_0::7);
    public static 8h_0<Boolean> f = new 8h_0("Players", true).c(1);
    public static 8h_0<89> g = new 8h_0("PlayerColor", new 89(-52237)).c(1).c(f::6);
    public static 8h_0<Boolean> h = new 8h_0("Animals", false).c(1);
    public static 8h_0<89> i = new 8h_0("AnimalColor", new 89(-12779725)).c(1).c(h::6);
    public static 8h_0<Boolean> j = new 8h_0("Mobs", true).c(1);
    public static 8h_0<89> k;
    public static 8h_0<Boolean> l;
    public static 8h_0<89> m;
    public static 8h_0<Boolean> n;
    public static 8h_0<89> o;
    public static 8h_0<8f_0> p;
    public static 8h_0<Boolean> q;
    public static 8h_0<7p_0> r;
    public static 8h_0<Float> s;
    public static 8h_0<Boolean> t;
    public static 8h_0<89> u;
    public static 8h_0<89> v;
    public static 8h_0<89> w;
    public static 8h_0<8f_0> x;
    public static 8h_0<Boolean> y;
    public static 8h_0<7p_0> z;
    public static 8h_0<89> A;
    public static 8h_0<89> B;
    public static 8h_0<89> C;
    public static 8h_0<89> D;
    public static 8h_0<Integer> E;
    public static 8h_0<Float> F;
    public static 8h_0<Double> G;
    public static 8h_0<Boolean> H;
    public static 8h_0<89> I;
    public static 8h_0<Long> J;
    public static ICamera c;
    public CopyOnWriteArrayList<BlockPos> c;
    public CopyOnWriteArrayList<8O> 0;
    public static boolean 1;
    public Framebuffer c;
    public 9i c = new CopyOnWriteArrayList();
    public static boolean 2;

    public static void c(BufferBuilder bufferBuilder, float f2) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((double)0.0, (double)((double)f2 + 0.55), (double)0.0);
        int n2 = ((89)g.6()).2(100);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(-0.375, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.375, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
    }

    public Integer 3(Entity entity) {
        if (entity instanceof EntityPlayer) {
            if (((Boolean)d.6()).booleanValue() && 8k_0.c.c.c(entity)) {
                int n2 = 8k_0.c.c.2(entity);
                return new Color(255, n2 / 5, (int)((double)n2 / 1.0493)).hashCode();
            }
            return ((89)g.6()).c();
        }
        if (entity instanceof IMob) {
            return ((89)k.6()).c();
        }
        if (entity instanceof IAnimals || entity instanceof INpc) {
            return ((89)i.6()).c();
        }
        return ((89)o.6()).c();
    }

    public static boolean 7() {
        return 2.6() == 7o_0.2;
    }

    public Integer c(TileEntity tileEntity) {
        if (tileEntity instanceof TileEntityChest) {
            return Color.YELLOW.getRGB();
        }
        if (tileEntity instanceof TileEntityEnderChest) {
            return Color.GREEN.darker().getRGB();
        }
        if (tileEntity instanceof TileEntityShulkerBox) {
            return ((TileEntityShulkerBox)tileEntity).getColor().getColorValue();
        }
        if (tileEntity instanceof TileEntityFurnace || tileEntity instanceof TileEntityHopper || tileEntity instanceof TileEntityDispenser) {
            return Color.GRAY.getRGB();
        }
        return null;
    }

    public static void 0(BufferBuilder bufferBuilder, float f2) {
        GlStateManager.pushMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.translate((double)0.0, (double)f2, (double)0.0);
        int n2 = ((89)g.6()).2(300);
        int n3 = ((89)g.6()).2(100);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(0.0, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.0, 0.55, 0.0).color(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
    }

    public boolean c(Entity entity) {
        if (1) {
            return false;
        }
        if (entity instanceof EntityEnderCrystal && ((Boolean)e.6()).booleanValue() && 2.6() == 7o_0.2) {
            return true;
        }
        if (entity instanceof EntityPlayer && ((Boolean)f.6()).booleanValue() && entity != 7q_0.c.player && entity != c.getRenderViewEntity() && !8u_0.c(entity)) {
            return true;
        }
        if (entity instanceof IAnimals && ((Boolean)h.6()).booleanValue()) {
            return true;
        }
        return entity instanceof IMob && (Boolean)j.6() != false;
    }

    public 7q_0() {
        super("ESP", 0, 3D.2, new String[0]);
        this.0 = new CopyOnWriteArrayList();
    }

    public static void 1(Entity entity) {
        GL11.glEnable((int)3553);
        double[] dArray = 9j.1(entity);
        double d2 = dArray[0];
        double d3 = dArray[1];
        double d4 = dArray[2];
        GL11.glPushMatrix();
        Render render = c.getRenderManager().getEntityRenderObject(entity);
        if (render != null) {
            2 = true;
            render.doRender(entity, d2, d3, d4, 0.0f, c.getRenderPartialTicks());
            2 = false;
        }
        GL11.glDisable((int)3553);
        GL11.glPopMatrix();
    }

    public static boolean b() {
        return 2.6() == 7o_0.2;
    }

    @Subscriber
    public void c(1m_0 m_02) {
        block1: {
            if (7q_0.c.world == null || 7q_0.c.player == null) {
                return;
            }
            if (2.6() != 7o_0.3 || !this.c(m_02.6())) break block1;
            95.c(((Float)5.6()).intValue());
            m_02.0().render(m_02.6(), m_02.5(), m_02.2(), m_02.1(), m_02.c(), m_02.3(), m_02.4());
            95.0();
            m_02.0().render(m_02.6(), m_02.5(), m_02.2(), m_02.1(), m_02.c(), m_02.3(), m_02.4());
            95.c();
            95.c(this.3(m_02.6()), 3.0f);
            m_02.0().render(m_02.6(), m_02.5(), m_02.2(), m_02.1(), m_02.c(), m_02.3(), m_02.4());
            95.c(3.0f);
        }
    }

    public static boolean 8() {
        return (Boolean)a.6() != false && 2.6() == 7o_0.2;
    }

    public void e() {
        if (7q_0.c.world.loadedEntityList.stream().filter(this::c).count() == 0L) {
            return;
        }
        ScaledResolution scaledResolution = new ScaledResolution((Minecraft)c);
        if (this.c == null) {
            this.c = new Framebuffer(7q_0.c.displayWidth, 7q_0.c.displayHeight, false);
        } else if (this.c.framebufferWidth != 7q_0.c.displayWidth || this.c.framebufferHeight != 7q_0.c.displayHeight) {
            this.c.unbindFramebuffer();
            this.c = new Framebuffer(7q_0.c.displayWidth, 7q_0.c.displayHeight, false);
            if (this.c != null) {
                this.c.2();
                this.c = new 9i(this.c);
            }
        }
        if ((Double)6.6() != 9i.c) {
            9i.c = (int)((Double)6.6()).doubleValue();
            this.c.2();
            this.c = new 9i(this.c);
        } else if (this.c == null) {
            this.c = new 9i(this.c);
        }
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)2896);
        GL11.glDepthMask((boolean)false);
        ((IEntityRenderer)7q_0.c.entityRenderer).iSetupCameraTransform(c.getRenderPartialTicks(), 0);
        GL11.glMatrixMode((int)5888);
        this.c.bindFramebuffer(false);
        GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
        GL11.glClear((int)16640);
        7q_0.c.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        7q_0.c.world.loadedEntityList.stream().filter(this::c).forEach(7q_0::1);
        7q_0.c.entityRenderer.disableLightmap();
        RenderHelper.disableStandardItemLighting();
        7q_0.c.entityRenderer.setupOverlayRendering();
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        this.c.c();
        this.c.unbindFramebuffer();
        c.getFramebuffer().bindFramebuffer(true);
        GL11.glScaled((double)(1.0 / 9k.c), (double)(1.0 / 9k.c), (double)(1.0 / 9k.c));
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glEnable((int)3553);
        GL11.glBindTexture((int)3553, (int)this.c.3());
        GL11.glBegin((int)4);
        GL11.glTexCoord2d((double)0.0, (double)1.0);
        GL11.glVertex2d((double)0.0, (double)0.0);
        GL11.glTexCoord2d((double)0.0, (double)0.0);
        GL11.glVertex2d((double)0.0, (double)((double)scaledResolution.getScaledHeight() * 9i.c));
        GL11.glTexCoord2d((double)1.0, (double)0.0);
        GL11.glVertex2d((double)((double)scaledResolution.getScaledWidth() * 9i.c), (double)((double)scaledResolution.getScaledHeight() * 9i.c));
        GL11.glTexCoord2d((double)1.0, (double)0.0);
        GL11.glVertex2d((double)((double)scaledResolution.getScaledWidth() * 9i.c), (double)((double)scaledResolution.getScaledHeight() * 9i.c));
        GL11.glTexCoord2d((double)1.0, (double)1.0);
        GL11.glVertex2d((double)((double)scaledResolution.getScaledWidth() * 9i.c), (double)0.0);
        GL11.glTexCoord2d((double)0.0, (double)1.0);
        GL11.glVertex2d((double)0.0, (double)0.0);
        GL11.glEnd();
        GL11.glScaled((double)9k.c, (double)9k.c, (double)9k.c);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        c.getFramebuffer().bindFramebuffer(false);
        RenderHelper.enableStandardItemLighting();
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
    }

    public static void c(BufferBuilder bufferBuilder, EntityPlayer entityPlayer, float f2) {
        GL11.glRotatef((float)(entityPlayer.isSneaking() ? 25.0f : 0.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.translate((double)0.0, (double)(entityPlayer.isSneaking() ? -0.16175 : 0.0), (double)(entityPlayer.isSneaking() ? -0.48025 : 0.0));
        GlStateManager.pushMatrix();
        GlStateManager.translate((double)0.0, (double)f2, (double)0.0);
        int n2 = ((89)g.6()).2(300);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(-0.125, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.125, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
    }

    public void 4(Entity entity) {
        block8: {
            if (entity == 7q_0.c.player || !this.c(entity)) break block8;
            float f2 = c.getRenderViewEntity().getDistance(entity);
            if (f2 < 3.0f) {
                f2 = 3.0f;
            }
            float f3 = 1.0f / (f2 / 3.0f);
            GL11.glBlendFunc((int)770, (int)771);
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.enableBlend();
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.pushMatrix();
            Vec3d vec3d = new Vec3d(entity.lastTickPosX, entity.lastTickPosY, entity.lastTickPosZ).add(new Vec3d((entity.posX - entity.lastTickPosX) * (double)c.getRenderPartialTicks(), (entity.posY - entity.lastTickPosY) * (double)c.getRenderPartialTicks(), (entity.posZ - entity.lastTickPosZ) * (double)c.getRenderPartialTicks()));
            GlStateManager.translate((double)(vec3d.x - ((IRenderManager)c.getRenderManager()).getRenderPosX()), (double)(vec3d.y - ((IRenderManager)c.getRenderManager()).getRenderPosY()), (double)(vec3d.z - ((IRenderManager)c.getRenderManager()).getRenderPosZ()));
            GlStateManager.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(-7q_0.c.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
            ICamera iCamera = c;
            RenderManager renderManager = iCamera.getRenderManager();
            float f4 = renderManager.options.thirdPersonView == 2 ? -1 : 1;
            float f5 = 1.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            try {
                GlStateManager.rotate((float)f4, (float)f5, (float)f6, (float)f7);
            }
            catch (NullPointerException nullPointerException) {
                GlStateManager.rotate((float)1.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            }
            int n2 = this.3(entity);
            float f8 = (float)(n2 >> 16 & 0xFF) / 255.0f;
            float f9 = (float)(n2 >> 8 & 0xFF) / 255.0f;
            float f10 = (float)(n2 & 0xFF) / 255.0f;
            GL11.glColor4f((float)f8, (float)f9, (float)f10, (float)1.0f);
            GL11.glLineWidth((float)(3.0f * f3));
            GL11.glEnable((int)2848);
            GL11.glBegin((int)2);
            GL11.glVertex2d((double)((double)(-entity.width) * 1.2), (double)(-((double)entity.height * 0.2)));
            GL11.glVertex2d((double)((double)(-entity.width) * 1.2), (double)((double)entity.height * 1.2));
            GL11.glVertex2d((double)((double)entity.width * 1.2), (double)((double)entity.height * 1.2));
            GL11.glVertex2d((double)((double)entity.width * 1.2), (double)(-((double)entity.height * 0.2)));
            GL11.glEnd();
            if (entity instanceof EntityLivingBase) {
                GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)0.3f);
                GL11.glLineWidth((float)(5.0f * f3));
                GL11.glBegin((int)1);
                GL11.glVertex2d((double)((double)entity.width * 1.4), (double)((double)entity.height * 1.2));
                GL11.glVertex2d((double)((double)entity.width * 1.4), (double)(-((double)entity.height * 0.2)));
                GL11.glEnd();
                GL11.glColor4f((float)0.0f, (float)1.0f, (float)0.0f, (float)1.0f);
                float f11 = ((EntityLivingBase)entity).getHealth() / ((EntityLivingBase)entity).getMaxHealth();
                GL11.glBegin((int)1);
                GL11.glVertex2d((double)((double)entity.width * 1.4), (double)((double)entity.height * 1.2 * (double)f11));
                GL11.glVertex2d((double)((double)entity.width * 1.4), (double)(-((double)entity.height * 0.2)));
                GL11.glEnd();
                float f12 = ((EntityLivingBase)entity).getAbsorptionAmount() / 16.0f;
                if (f12 > 0.0f) {
                    GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)0.3f);
                    GL11.glBegin((int)1);
                    GL11.glVertex2d((double)((double)entity.width * 1.6), (double)((double)entity.height * 0.92));
                    GL11.glVertex2d((double)((double)entity.width * 1.6), (double)(-((double)entity.height * 0.2)));
                    GL11.glEnd();
                    GL11.glColor4f((float)0.0f, (float)1.0f, (float)0.0f, (float)1.0f);
                    GL11.glColor4f((float)1.0f, (float)1.0f, (float)0.0f, (float)1.0f);
                    GL11.glBegin((int)1);
                    GL11.glVertex2d((double)((double)entity.width * 1.6), (double)((double)entity.height * 0.92 * (double)f12));
                    GL11.glVertex2d((double)((double)entity.width * 1.6), (double)(-((double)entity.height * 0.2)));
                    GL11.glEnd();
                }
            }
            GlStateManager.enableCull();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.enableDepth();
            GlStateManager.resetColor();
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.popMatrix();
        }
    }

    @Subscriber
    public void c(1b_0 b_02) {
        AxisAlignedBB axisAlignedBB;
        if (7q_0.c.world == null || 7q_0.c.player == null) {
            return;
        }
        if (((Boolean)l.6()).booleanValue()) {
            GlStateManager.pushMatrix();
            96.1();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.disableDepth();
            for (Entity object : 7q_0.c.world.loadedEntityList) {
                if (!(object instanceof EntityEnderPearl) || !((double)c.getRenderViewEntity().getDistance(object) < 250.0)) continue;
                96.c(object, ((89)m.6()).c(), (double)b_02.c());
                GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth((float)1.0f);
                96.c(object, ((89)m.6()).c(), b_02.c());
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableDepth();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            96.c();
            GlStateManager.popMatrix();
        }
        if (((Boolean)4.6()).booleanValue()) {
            if (c.getRenderManager() == null) {
                return;
            }
            7q_0.c.world.loadedEntityList.stream().filter(7q_0::2).forEach(this::4);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
        if (2.6() == 7o_0.1) {
            GlStateManager.pushMatrix();
            96.1();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.disableDepth();
            for (Entity entity : 7q_0.c.world.loadedEntityList) {
                if (entity == 7q_0.c.player || !this.c(entity)) continue;
                96.c(entity, (int)this.3(entity), (double)b_02.c());
                GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth((float)1.0f);
                96.c(entity, (int)this.3(entity), b_02.c());
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableDepth();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            96.c();
            GlStateManager.popMatrix();
        }
        if (((Boolean)n.6()).booleanValue()) {
            GlStateManager.pushMatrix();
            96.1();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.disableDepth();
            for (Entity entity : 7q_0.c.world.loadedEntityList) {
                if (entity == 7q_0.c.player || !(entity instanceof EntityItem)) continue;
                96.c(entity, (int)this.3(entity), (double)b_02.c());
                GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                GlStateManager.glLineWidth((float)1.0f);
                96.c(entity, (int)this.3(entity), b_02.c());
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableDepth();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            96.c();
            GlStateManager.popMatrix();
        }
        if (((Boolean)y.6()).booleanValue()) {
            int n2;
            if (z.6() == 7p_0.c) {
                GlStateManager.pushMatrix();
                96.1();
                GlStateManager.enableBlend();
                GlStateManager.glLineWidth((float)((Float)F.6()).floatValue());
                GlStateManager.disableTexture2D();
                GlStateManager.depthMask((boolean)false);
                GlStateManager.disableDepth();
                GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
                for (BlockPos blockPos : this.c) {
                    axisAlignedBB = new AxisAlignedBB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), (double)(blockPos.getX() + 1), (double)blockPos.getY(), (double)(blockPos.getZ() + 1));
                    n2 = ((89)B.6()).c();
                    if (7q_0.c.world.getBlockState(blockPos.up()).getBlock() == Blocks.AIR) {
                        n2 = ((89)D.6()).c();
                    }
                    96.1(axisAlignedBB, n2);
                }
                GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.enableDepth();
                GlStateManager.depthMask((boolean)true);
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
                96.c();
                GlStateManager.popMatrix();
            } else if (z.6() == 7p_0.0) {
                for (BlockPos blockPos : this.c) {
                    axisAlignedBB = 7q_0.c.world.getBlockState(blockPos).getBoundingBox((IBlockAccess)7q_0.c.world, blockPos).offset(blockPos);
                    axisAlignedBB = axisAlignedBB.setMaxY(axisAlignedBB.minY + (Double)G.6()).offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ());
                    n2 = ((89)B.6()).c();
                    if (7q_0.c.world.getBlockState(blockPos.up()).getBlock() == Blocks.AIR) {
                        n2 = ((89)D.6()).c();
                    }
                    8Z.0();
                    8Z.0(axisAlignedBB, n2, ((Float)F.6()).floatValue());
                    8Z.c();
                }
            } else {
                for (BlockPos blockPos : this.c) {
                    axisAlignedBB = 7q_0.c.world.getBlockState(blockPos).getBoundingBox((IBlockAccess)7q_0.c.world, blockPos).offset(blockPos);
                    axisAlignedBB = axisAlignedBB.setMaxY(axisAlignedBB.minY + (Double)G.6()).offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ());
                    n2 = ((89)A.6()).c();
                    if (7q_0.c.world.getBlockState(blockPos.up()).getBlock() == Blocks.AIR) {
                        n2 = ((89)C.6()).c();
                    }
                    8Z.0();
                    8Z.c(axisAlignedBB, n2);
                    8Z.c();
                    n2 = ((89)B.6()).c();
                    if (7q_0.c.world.getBlockState(blockPos.up()).getBlock() == Blocks.AIR) {
                        n2 = ((89)D.6()).c();
                    }
                    8Z.0();
                    8Z.0(axisAlignedBB, n2, ((Float)F.6()).floatValue());
                    8Z.c();
                }
            }
        }
        if (((Boolean)H.6()).booleanValue()) {
            if (c.getRenderViewEntity() == null) {
                return;
            }
            c.setPosition(7q_0.c.getRenderViewEntity().posX, 7q_0.c.getRenderViewEntity().posY, 7q_0.c.getRenderViewEntity().posZ);
            GlStateManager.pushMatrix();
            96.1();
            GlStateManager.disableTexture2D();
            GlStateManager.disableAlpha();
            GlStateManager.disableDepth();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.glLineWidth((float)2.0f);
            for (8O o2 : this.0) {
                axisAlignedBB = new AxisAlignedBB((double)o2.c(), 0.0, (double)o2.0(), (double)(o2.c() + 16), 0.0, (double)(o2.0() + 16));
                GlStateManager.pushMatrix();
                if (c.isBoundingBoxInFrustum(axisAlignedBB)) {
                    double d2 = 7q_0.c.getRenderViewEntity().lastTickPosX + (7q_0.c.getRenderViewEntity().posX - 7q_0.c.getRenderViewEntity().lastTickPosX) * (double)b_02.c();
                    double d3 = 7q_0.c.getRenderViewEntity().lastTickPosY + (7q_0.c.getRenderViewEntity().posY - 7q_0.c.getRenderViewEntity().lastTickPosY) * (double)b_02.c();
                    double d4 = 7q_0.c.getRenderViewEntity().lastTickPosZ + (7q_0.c.getRenderViewEntity().posZ - 7q_0.c.getRenderViewEntity().lastTickPosZ) * (double)b_02.c();
                    97.c(axisAlignedBB.offset(-d2, -d3, -d4), 3, ((89)I.6()).c());
                }
                GlStateManager.popMatrix();
            }
            GlStateManager.glLineWidth((float)1.0f);
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableAlpha();
            96.c();
            GlStateManager.popMatrix();
        }
        if (!((Boolean)q.6()).booleanValue()) {
            return;
        }
        if (r.6() == 7p_0.c) {
            GlStateManager.pushMatrix();
            96.1();
            GlStateManager.enableBlend();
            GlStateManager.glLineWidth((float)((Float)s.6()).floatValue());
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            for (TileEntity tileEntity : 7q_0.c.world.loadedTileEntityList) {
                axisAlignedBB = tileEntity.getPos();
                IBlockState iBlockState = 7q_0.c.world.getBlockState((BlockPos)axisAlignedBB);
                Integer n3 = this.0(tileEntity);
                if (n3 == null) continue;
                96.0(iBlockState.getSelectedBoundingBox((World)7q_0.c.world, (BlockPos)axisAlignedBB), new Color(n3));
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableDepth();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            96.c();
            GlStateManager.popMatrix();
        } else if (r.6() == 7p_0.0) {
            for (TileEntity tileEntity : 7q_0.c.world.loadedTileEntityList) {
                axisAlignedBB = tileEntity.getPos();
                Integer n4 = this.0(tileEntity);
                if (n4 == null) continue;
                AxisAlignedBB axisAlignedBB2 = 7q_0.c.world.getBlockState((BlockPos)axisAlignedBB).getBoundingBox((IBlockAccess)7q_0.c.world, (BlockPos)axisAlignedBB).offset((BlockPos)axisAlignedBB);
                axisAlignedBB2 = axisAlignedBB2.offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ());
                8Z.0();
                8Z.0(axisAlignedBB2, n4, ((Float)s.6()).floatValue());
                8Z.c();
            }
        } else {
            for (TileEntity tileEntity : 7q_0.c.world.loadedTileEntityList) {
                axisAlignedBB = tileEntity.getPos();
                Integer n5 = this.0(tileEntity);
                if (n5 == null) continue;
                AxisAlignedBB axisAlignedBB3 = 7q_0.c.world.getBlockState((BlockPos)axisAlignedBB).getBoundingBox((IBlockAccess)7q_0.c.world, (BlockPos)axisAlignedBB).offset((BlockPos)axisAlignedBB);
                axisAlignedBB3 = axisAlignedBB3.offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ());
                8Z.0();
                8Z.c(axisAlignedBB3, n5);
                8Z.c();
                8Z.0();
                8Z.0(axisAlignedBB3, n5, ((Float)s.6()).floatValue());
                8Z.c();
            }
        }
    }

    public boolean c(long l2, int n2, int n3) {
        Random random = new Random(l2 + (long)(n2 * n2 * 4987142) + (long)(n2 * 5947611) + (long)(n3 * n3) * 4392871L + (long)(n3 * 389711) ^ 0x3AD8025FL);
        return random.nextInt(10) == 0;
    }

    public static void 0(BufferBuilder bufferBuilder, EntityPlayer entityPlayer, float f2, ModelRenderer modelRenderer) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((double)0.375, (double)((double)f2 + 0.55), (double)0.0);
        if (modelRenderer.rotateAngleX != 0.0f) {
            GlStateManager.rotate((float)(modelRenderer.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleY != 0.0f) {
            GlStateManager.rotate((float)(modelRenderer.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleZ != 0.0f) {
            GlStateManager.rotate((float)(-modelRenderer.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        int n2 = ((89)g.6()).2(100);
        int n3 = ((89)g.6()).2(300);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(0.0, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.0, -0.5, 0.0).color(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
    }

    public static void c(BufferBuilder bufferBuilder, EntityPlayer entityPlayer, float f2, float f3, ModelRenderer modelRenderer) {
        GL11.glRotatef((float)(f3 - entityPlayer.rotationYawHead), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.pushMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.translate((double)0.0, (double)((double)f2 + 0.55), (double)0.0);
        if (modelRenderer.rotateAngleX != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        int n2 = ((89)g.6()).2(100);
        int n3 = ((89)g.6()).2(0);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(0.0, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.0, 0.3, 0.0).color(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
    }

    public static void c(EntityPlayer entityPlayer, ModelPlayer modelPlayer, float f2) {
        if (!((Boolean)3.6()).booleanValue() || !3F.c("ESP").f()) {
            return;
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GL11.glEnable((int)2848);
        GlStateManager.disableDepth();
        GlStateManager.disableTexture2D();
        GL11.glHint((int)3154, (int)4354);
        GlStateManager.depthMask((boolean)false);
        GL11.glEnable((int)2903);
        GL11.glDisable((int)2848);
        double d2 = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double)f2;
        double d3 = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * (double)f2;
        double d4 = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double)f2;
        c.setPosition(d2, d3, d4);
        if (!c.isBoundingBoxInFrustum(entityPlayer.getEntityBoundingBox()) || entityPlayer.isDead || !entityPlayer.isEntityAlive() || entityPlayer.isPlayerSleeping()) {
            return;
        }
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)2.0f);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.translate((double)(d2 - ((IRenderManager)c.getRenderManager()).getRenderPosX()), (double)(d3 - ((IRenderManager)c.getRenderManager()).getRenderPosY()), (double)(d4 - ((IRenderManager)c.getRenderManager()).getRenderPosZ()));
        float f3 = entityPlayer.prevRenderYawOffset + (entityPlayer.renderYawOffset - entityPlayer.prevRenderYawOffset) * f2;
        GL11.glRotatef((float)(-f3), (float)0.0f, (float)1.0f, (float)0.0f);
        float f4 = entityPlayer.isSneaking() ? 0.6f : 0.75f;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        7q_0.1(bufferBuilder, entityPlayer, f4, modelPlayer.bipedRightLeg);
        7q_0.2(bufferBuilder, entityPlayer, f4, modelPlayer.bipedLeftLeg);
        7q_0.c(bufferBuilder, entityPlayer, f4, modelPlayer.bipedRightArm);
        7q_0.0(bufferBuilder, entityPlayer, f4, modelPlayer.bipedLeftArm);
        7q_0.c(bufferBuilder, entityPlayer, f4, f3, modelPlayer.bipedHead);
        7q_0.c(bufferBuilder, entityPlayer, f4);
        7q_0.0(bufferBuilder, f4);
        7q_0.c(bufferBuilder, f4);
        Gui.drawRect((int)0, (int)0, (int)0, (int)0, (int)0);
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GL11.glDisable((int)2848);
        GlStateManager.enableDepth();
        GlStateManager.popMatrix();
        GlStateManager.depthMask((boolean)true);
    }

    public static void c(BufferBuilder bufferBuilder, EntityPlayer entityPlayer, float f2, ModelRenderer modelRenderer) {
        GlStateManager.translate((double)0.0, (double)0.0, (double)(entityPlayer.isSneaking() ? 0.25 : 0.0));
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.translate((double)0.0, (double)(entityPlayer.isSneaking() ? -0.05 : 0.0), (double)(entityPlayer.isSneaking() ? -0.01725 : 0.0));
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.translate((double)-0.375, (double)((double)f2 + 0.55), (double)0.0);
        if (modelRenderer.rotateAngleX != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleY != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleZ != 0.0f) {
            GL11.glRotatef((float)(-modelRenderer.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        int n2 = ((89)g.6()).2(100);
        int n3 = ((89)g.6()).2(300);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(0.0, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.0, -0.5, 0.0).color(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
    }

    @Subscriber
    public void c(17 var1_1) {
        if (2.6() == 7o_0.2) {
            7q_0 q_02 = this;
            try {
                q_02.e();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static boolean 2(Entity entity) {
        return 7q_0.c.player != entity && entity != c.getRenderViewEntity();
    }

    public static boolean 1() {
        return (Boolean)7.6() != false && 2.6() == 7o_0.2;
    }

    static {
        8h_0 h_02 = new 8h_0("MobColor", new 89(-65536)).c(1);
        8h_0<Boolean> h_03 = j;
        h_03.getClass();
        k = h_02.c(h_03::6);
        l = new 8h_0("Pearls", true).c(1);
        m = new 8h_0("PearlColor", new 89(-1442775245)).c(1).c(l::6);
        n = new 8h_0("Items", false).c(1);
        8h_0 h_04 = new 8h_0("ItemColor", new 89(-2509)).c(1);
        8h_0<Boolean> h_05 = n;
        h_05.getClass();
        o = h_04.c(h_05::6);
        p = new 8h_0("Storage", new 8f_0(false));
        q = new 8h_0("Storages", true).c(p);
        r = new 8h_0("StorageMode", 7p_0.1).c(p);
        s = new 8h_0("StorageWidth", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(1.0f)).c(p);
        t = new 8h_0("CustomColors", false).c(p);
        u = new 8h_0("ChestColor", new 89(Color.YELLOW.getRGB())).c(p);
        v = new 8h_0("EChestColor", new 89(Color.GREEN.darker().getRGB())).c(p);
        w = new 8h_0("OtherColor", new 89(Color.GRAY.getRGB())).c(p);
        x = new 8h_0("Void", new 8f_0(false));
        y = new 8h_0("Voids", true).c(x);
        z = new 8h_0("VoidMode", 7p_0.1).c(x);
        A = new 8h_0("VoidFillColor", new 89(301950208)).c(x);
        B = new 8h_0("VoidColor", new 89(-39680)).c(x);
        C = new 8h_0("OpenVoidFill", new 89(0x11FF0000)).c(x);
        D = new 8h_0("OpenVoid", new 89(-65536)).c(x);
        E = new 8h_0("VRange", 25, 255, 5, 5).c(x);
        F = new 8h_0("VoidWidth", Float.valueOf(1.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(1.0f)).c(x);
        G = new 8h_0("VoidHeight", 0.5, 3.0, -3.0, 0.1).c(x);
        H = new 8h_0("SlimeChunks", false);
        I = new 8h_0("SlimeChunkColor", new 89(-16711936, false)).c(H::6);
        J = new 8h_0("Seed", 0L, Long.MAX_VALUE, Long.MIN_VALUE, 1L).c(7q_0::6);
        c = new Frustum();
        1 = false;
        2 = false;
    }

    @Override
    public void 7() {
        for (Entity entity : 7q_0.c.world.loadedEntityList) {
            entity.setGlowing(false);
        }
    }

    public void c(Entity entity, TextFormatting textFormatting, String string) {
        ScorePlayerTeam scorePlayerTeam = 7q_0.c.world.getScoreboard().getTeamNames().contains(string) ? 7q_0.c.world.getScoreboard().getTeam(string) : 7q_0.c.world.getScoreboard().createTeam(string);
        WorldClient worldClient = 7q_0.c.world;
        Scoreboard scoreboard = worldClient.getScoreboard();
        Entity entity2 = entity;
        String string2 = entity2.getName();
        ScorePlayerTeam scorePlayerTeam2 = scorePlayerTeam;
        String string3 = scorePlayerTeam2.getName();
        scoreboard.addPlayerToTeam(string2, string3);
        WorldClient worldClient2 = 7q_0.c.world;
        Scoreboard scoreboard2 = worldClient2.getScoreboard();
        String string4 = string;
        ScorePlayerTeam scorePlayerTeam3 = scoreboard2.getTeam(string4);
        TextFormatting textFormatting2 = textFormatting;
        try {
            scorePlayerTeam3.setColor(textFormatting2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        entity.setGlowing(true);
    }

    public static boolean 9() {
        return 2.6() == 7o_0.2;
    }

    public static boolean c() {
        return 2.6() == 7o_0.2;
    }

    public static void 1(BufferBuilder bufferBuilder, EntityPlayer entityPlayer, float f2, ModelRenderer modelRenderer) {
        GlStateManager.translate((double)0.0, (double)0.0, (double)(entityPlayer.isSneaking() ? -0.235 : 0.0));
        GlStateManager.pushMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.translate((double)-0.125, (double)f2, (double)0.0);
        if (modelRenderer.rotateAngleX != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleY != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleZ != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        int n2 = ((89)g.6()).2(300);
        int n3 = ((89)g.6()).2(500);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(0.0, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.0, (double)(-f2), 0.0).color(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
    }

    public Integer 0(TileEntity tileEntity) {
        Integer n2;
        if (((Boolean)t.6()).booleanValue()) {
            if (tileEntity instanceof TileEntityChest) {
                return ((89)u.6()).c();
            }
            if (tileEntity instanceof TileEntityEnderChest) {
                return ((89)v.6()).c();
            }
            if (tileEntity instanceof TileEntityFurnace || tileEntity instanceof TileEntityHopper || tileEntity instanceof TileEntityDispenser) {
                return ((89)w.6()).c();
            }
        }
        if ((n2 = this.c(tileEntity)) == null) {
            return null;
        }
        int n3 = 40;
        int n4 = n2 >> 16 & 0xFF;
        int n5 = n2 >> 8 & 0xFF;
        int n6 = n2 & 0xFF;
        return new Integer((n3 & 0xFF) << 24 | (n4 & 0xFF) << 16 | (n5 & 0xFF) << 8 | n6 & 0xFF);
    }

    @Subscriber
    public void c(0S s) {
        SPacketChunkData sPacketChunkData;
        8O o2;
        if (s.c() instanceof SPacketChunkData && !this.0.contains(o2 = new 8O((sPacketChunkData = (SPacketChunkData)s.c()).getChunkX() * 16, sPacketChunkData.getChunkZ() * 16)) && this.c((Long)J.6(), sPacketChunkData.getChunkX(), sPacketChunkData.getChunkZ()) && 7q_0.c.player.dimension == 0) {
            this.0.add(o2);
        }
    }

    public static void 2(BufferBuilder bufferBuilder, EntityPlayer entityPlayer, float f2, ModelRenderer modelRenderer) {
        GlStateManager.pushMatrix();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.translate((double)0.125, (double)f2, (double)0.0);
        if (modelRenderer.rotateAngleX != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleX * 57.295776f), (float)1.0f, (float)0.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleY != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleY * 57.295776f), (float)0.0f, (float)1.0f, (float)0.0f);
        }
        if (modelRenderer.rotateAngleZ != 0.0f) {
            GL11.glRotatef((float)(modelRenderer.rotateAngleZ * 57.295776f), (float)0.0f, (float)0.0f, (float)1.0f);
        }
        int n2 = ((89)g.6()).2(300);
        int n3 = ((89)g.6()).2(500);
        bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos(0.0, 0.0, 0.0).color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, n2 >> 24 & 0xFF).endVertex();
        bufferBuilder.pos(0.0, (double)(-f2), 0.0).color(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, n3 >> 24 & 0xFF).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.popMatrix();
    }

    @Override
    public void c() {
        this.0.clear();
    }

    public TextFormatting 0(Entity entity) {
        if (entity instanceof EntityPlayer) {
            return TextFormatting.LIGHT_PURPLE;
        }
        if (entity instanceof IMob) {
            return TextFormatting.RED;
        }
        if (entity instanceof IAnimals) {
            return TextFormatting.GREEN;
        }
        return TextFormatting.YELLOW;
    }

    public static boolean 0() {
        return (Boolean)7.6() != false && 2.6() == 7o_0.2;
    }

    @Subscriber
    public void c(1N n2) {
        if (7q_0.c.world == null || 7q_0.c.player == null) {
            return;
        }
        if (((7o_0)((Object)2.6())).equals((Object)7o_0.0)) {
            ((IShaderGroup)((IRenderGlobal)7q_0.c.renderGlobal).getEntityOutlineShader()).getListShaders().forEach(7q_0::c);
            for (Object object : 7q_0.c.world.loadedEntityList) {
                if (object.getTeam() == null) {
                    this.c((Entity)object, this.0((Entity)object), "");
                    continue;
                }
                this.c((Entity)object, this.0((Entity)object), object.getTeam().getName());
            }
        } else {
            for (Object object : 7q_0.c.world.loadedEntityList) {
                object.setGlowing(false);
            }
        }
        if (((Boolean)y.6()).booleanValue()) {
            this.c.clear();
            if (7q_0.c.player.posY < (double)((Integer)E.6()).intValue()) {
                Object object;
                Iterable iterable = BlockPos.getAllInBox((BlockPos)new BlockPos(7q_0.c.player.posX - 6.0, 0.0, 7q_0.c.player.posZ - 6.0), (BlockPos)new BlockPos(7q_0.c.player.posX + 6.0, 0.0, 7q_0.c.player.posZ + 6.0));
                object = iterable.iterator();
                while (object.hasNext()) {
                    IBlockState iBlockState;
                    IBlockState iBlockState2;
                    BlockPos blockPos = (BlockPos)object.next();
                    IBlockState iBlockState3 = 7q_0.c.world.getBlockState(blockPos);
                    if (iBlockState3.getBlock() == Blocks.BEDROCK || iBlockState3.getBlock() == Blocks.END_PORTAL_FRAME || (iBlockState2 = 7q_0.c.world.getBlockState(blockPos.add(0, 1, 0))).getBlock() == Blocks.BEDROCK || iBlockState2.getBlock() == Blocks.END_PORTAL_FRAME || (iBlockState = 7q_0.c.world.getBlockState(blockPos.add(0, 2, 0))).getBlock() == Blocks.BEDROCK || iBlockState.getBlock() == Blocks.END_PORTAL_FRAME) continue;
                    this.c.add(blockPos);
                }
            }
        }
    }

    public static void c(Shader shader) {
        block0: {
            ShaderUniform shaderUniform = shader.getShaderManager().getShaderUniform("Radius");
            if (shaderUniform == null) break block0;
            shaderUniform.set(((Float)5.6()).floatValue());
        }
    }

    public static boolean 6() {
        return false;
    }
}

