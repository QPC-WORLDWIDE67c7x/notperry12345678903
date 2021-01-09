/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7Q;
import me.darki.konas.88;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.99;
import me.darki.konas.9m;
import me.darki.konas.Z;
import me.darki.konas.mixin.mixins.IEntityRenderer;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.BlockCommandBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7R
extends 3E {
    public ArrayList<Block> 0;
    public CopyOnWriteArrayList<7Q> c;
    public static 8h_0<88> 1 = new 8h_0("CustomBlocks", new 88(new String[0]));
    public static 8h_0<Float> 2 = new 8h_0("Range", Float.valueOf(100.0f), Float.valueOf(500.0f), Float.valueOf(1.0f), Float.valueOf(1.0f));
    public static 8h_0<89> 3 = new 8h_0("Color", new 89(-16711681));
    public static 8h_0<Boolean> 4 = new 8h_0("Default", true);
    public static 8h_0<Boolean> 5 = new 8h_0("Custom", true);
    public static 8h_0<Boolean> 6 = new 8h_0("Illegals", true);
    public static 8h_0<Boolean> 7 = new 8h_0("Tracers", false);
    public static 8h_0<Boolean> 8 = new 8h_0("Fill", true);
    public static 8h_0<Boolean> 9 = new 8h_0("Outline", true);
    public static 8h_0<Boolean> a = new 8h_0("SoftReload", true);
    public static 8h_0<Boolean> b = new 8h_0("SlowRender", false);
    public 9m c = new 9m();

    @Override
    public void c() {
        block1: {
            if (GlStateManager.glGetString((int)7936).contains("Intel") && !((Boolean)b.6()).booleanValue()) {
                8p_0.1("You have an integrated graphics card. To increase fps, use SlowRender.");
            }
            if (!((Boolean)a.6()).booleanValue()) break block1;
            7R.1();
        }
    }

    public boolean c(7Q q) {
        if (((Boolean)4.6()).booleanValue() && this.0.contains(((Minecraft)7R.c).world.getBlockState(new BlockPos(q.c, q.0, q.1)).getBlock())) {
            return true;
        }
        if (((Boolean)5.6()).booleanValue() && ((88)1.6()).0().contains(((Minecraft)7R.c).world.getBlockState(new BlockPos(q.c, q.0, q.1)).getBlock())) {
            return true;
        }
        return (Boolean)6.6() != false && this.0(((Minecraft)7R.c).world.getBlockState(new BlockPos(q.c, q.0, q.1)).getBlock(), new BlockPos(q.c, q.0, q.1));
    }

    public static void c(double d2, double d3, double d4, double d5, double d6, double d7, int n2) {
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.5f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        GL11.glColor4f((float)((float)(n2 >> 16 & 0xFF) / 255.0f), (float)((float)(n2 >> 8 & 0xFF) / 255.0f), (float)((float)(n2 & 0xFF) / 255.0f), (float)((float)(n2 >> 24 & 0xFF) / 255.0f));
        GlStateManager.disableLighting();
        GL11.glLoadIdentity();
        ((IEntityRenderer)((Minecraft)7R.c).entityRenderer).iOrientCamera(c.getRenderPartialTicks());
        GL11.glEnable((int)2848);
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)d2, (double)d3, (double)d4);
        GL11.glVertex3d((double)d5, (double)d6, (double)d7);
        GL11.glVertex3d((double)d5, (double)d6, (double)d7);
        GL11.glEnd();
        GL11.glDisable((int)2848);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)3042);
        GL11.glColor3d((double)1.0, (double)1.0, (double)1.0);
        GlStateManager.enableLighting();
    }

    public static void 1() {
        block0: {
            if (((Minecraft)7R.c).world == null || ((Minecraft)7R.c).player == null) break block0;
            int n2 = (int)7R.c.player.posX;
            int n3 = (int)7R.c.player.posY;
            int n4 = (int)7R.c.player.posZ;
            int n5 = 7R.c.gameSettings.renderDistanceChunks * 16;
            ((Minecraft)7R.c).renderGlobal.markBlockRangeForRenderUpdate(n2 - n5, n3 - n5, n4 - n5, n2 + n5, n3 + n5, n4 + n5);
        }
    }

    @Subscriber
    public void c(1b_0 b_02) {
        BlockPos blockPos;
        if (((Minecraft)7R.c).world == null || ((Minecraft)7R.c).player == null || this.c.isEmpty()) {
            return;
        }
        if (((Boolean)8.6()).booleanValue() || ((Boolean)9.6()).booleanValue()) {
            for (7Q q : this.c) {
                if (q.c(new 7Q(7R.c.player.posX, 7R.c.player.posY, 7R.c.player.posZ)) > (double)((Float)2.6()).floatValue() || !this.c(q)) {
                    this.c.remove(q);
                    continue;
                }
                blockPos = new BlockPos(q.c, q.0, q.1);
                AxisAlignedBB axisAlignedBB = ((Minecraft)7R.c).world.getBlockState(blockPos).getBoundingBox((IBlockAccess)((Minecraft)7R.c).world, blockPos).offset(blockPos);
                if (((Boolean)8.6()).booleanValue()) {
                    99.c();
                    99.c(axisAlignedBB, (89)3.6());
                    99.0();
                }
                if (!((Boolean)9.6()).booleanValue()) continue;
                99.c();
                99.c(axisAlignedBB, 1.5, (89)3.6());
                99.0();
            }
        }
        if (((Boolean)7.6()).booleanValue()) {
            for (7Q q : this.c) {
                if (q.c(new 7Q(7R.c.player.posX, 7R.c.player.posY, 7R.c.player.posZ)) > (double)((Float)2.6()).floatValue() || !this.c(q)) {
                    this.c.remove(q);
                    continue;
                }
                blockPos = new Vec3d(0.0, 0.0, 1.0).rotatePitch(-((float)Math.toRadians(7R.c.player.rotationPitch))).rotateYaw(-((float)Math.toRadians(7R.c.player.rotationYaw)));
                7R.c(blockPos.x, blockPos.y + (double)((Minecraft)7R.c).player.getEyeHeight(), blockPos.z, q.c - ((IRenderManager)c.getRenderManager()).getRenderPosX() + 0.5, q.0 - ((IRenderManager)c.getRenderManager()).getRenderPosY() + 0.5, q.1 - ((IRenderManager)c.getRenderManager()).getRenderPosZ() + 0.5, ((89)3.6()).c());
            }
        }
    }

    public boolean 0(Block block, BlockPos blockPos) {
        if (block instanceof BlockCommandBlock || block instanceof BlockBarrier) {
            return true;
        }
        if (block == Blocks.BEDROCK) {
            if (7R.c.player.dimension == 0) {
                if (blockPos.getY() > 4) {
                    return true;
                }
            } else if (7R.c.player.dimension == -1) {
                if (blockPos.getY() > 127 || blockPos.getY() < 123 && blockPos.getY() > 4) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public 7R() {
        super("Search", 3D.2, new String[0]);
        this.0();
    }

    public void 0() {
        this.0 = new ArrayList();
        this.0.add((Block)Blocks.PORTAL);
        this.0.add(Blocks.MOB_SPAWNER);
        this.0.add(Blocks.END_PORTAL_FRAME);
        this.0.add(Blocks.END_PORTAL);
        this.0.add(Blocks.DISPENSER);
        this.0.add(Blocks.DROPPER);
        this.0.add((Block)Blocks.HOPPER);
        this.0.add(Blocks.FURNACE);
        this.0.add(Blocks.LIT_FURNACE);
        this.0.add((Block)Blocks.CHEST);
        this.0.add(Blocks.TRAPPED_CHEST);
        this.0.add(Blocks.ENDER_CHEST);
        this.0.add(Blocks.WHITE_SHULKER_BOX);
        this.0.add(Blocks.ORANGE_SHULKER_BOX);
        this.0.add(Blocks.MAGENTA_SHULKER_BOX);
        this.0.add(Blocks.LIGHT_BLUE_SHULKER_BOX);
        this.0.add(Blocks.YELLOW_SHULKER_BOX);
        this.0.add(Blocks.LIME_SHULKER_BOX);
        this.0.add(Blocks.PINK_SHULKER_BOX);
        this.0.add(Blocks.GRAY_SHULKER_BOX);
        this.0.add(Blocks.SILVER_SHULKER_BOX);
        this.0.add(Blocks.CYAN_SHULKER_BOX);
        this.0.add(Blocks.PURPLE_SHULKER_BOX);
        this.0.add(Blocks.BLUE_SHULKER_BOX);
        this.0.add(Blocks.BROWN_SHULKER_BOX);
        this.0.add(Blocks.GREEN_SHULKER_BOX);
        this.0.add(Blocks.RED_SHULKER_BOX);
        this.0.add(Blocks.BLACK_SHULKER_BOX);
    }

    @Subscriber
    public void c(Z z) {
        7Q q;
        if (((Minecraft)7R.c).world == null || ((Minecraft)7R.c).player == null) {
            return;
        }
        if (((Boolean)b.6()).booleanValue()) {
            if (this.c.c(1000.0)) {
                this.c.c();
            } else {
                return;
            }
        }
        if (this.c.size() > 100000) {
            this.c.clear();
        }
        if (this.c(z.0(), z.c()) && !this.c.contains(q = new 7Q(z.c().getX(), z.c().getY(), z.c().getZ()))) {
            this.c.add(q);
        }
    }

    public boolean c(Block block, BlockPos blockPos) {
        if (((Boolean)4.6()).booleanValue() && this.0.contains(block)) {
            return true;
        }
        if (((Boolean)5.6()).booleanValue()) {
            if (((88)1.6()).0().contains(block)) {
                return true;
            }
        }
        return (Boolean)6.6() != false && this.0(block, blockPos);
    }
}

