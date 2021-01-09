/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.concurrent.CopyOnWriteArrayList;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4n_0;
import me.darki.konas.7g_0;
import me.darki.konas.80;
import me.darki.konas.81;
import me.darki.konas.89;
import me.darki.konas.8h_0;
import me.darki.konas.96;
import me.darki.konas.99;
import me.darki.konas.mixin.mixins.IEntityRenderer;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 82
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Block", true);
    public static 8h_0<Boolean> 2 = new 8h_0("Facing", true).c(1::6);
    public static 8h_0<Boolean> 3 = new 8h_0("Vector", true);
    public static 8h_0<Float> 4 = new 8h_0("Radius", Float.valueOf(0.1f), Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(82::0);
    public static 8h_0<Integer> 5 = new 8h_0("Slices", 8, 24, 3, 1).c(82::c);
    public static 8h_0<89> 6 = new 8h_0("Fill", new 89(584587545, false));
    public static 8h_0<89> 7 = new 8h_0("Outline", new 89(-2615015, false));
    public static 8h_0<89> 8 = new 8h_0("Line", new 89(-2615015, false));
    public static 8h_0<89> 9 = new 8h_0("VectorColor", new 89(-2615015, false));
    public static 8h_0<89> a = new 8h_0("SelfFill", new 89(575714484, false));
    public static 8h_0<89> b = new 8h_0("SelfOutline", new 89(-11488076, false));
    public static 8h_0<89> d = new 8h_0("SelfLine", new 89(-11488076, false));
    public static 8h_0<89> e = new 8h_0("SelfVector", new 89(-11488076, false));
    public static 8h_0<Float> f = new 8h_0("LineWidth", Float.valueOf(3.0f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Float> g = new 8h_0("OutlineWidth", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public static 8h_0<Float> h = new 8h_0("VectorWidth", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(0.1f), Float.valueOf(0.1f));
    public CopyOnWriteArrayList<Vec3d> c = new CopyOnWriteArrayList();

    public void c(1b_0 b_02, EntityLivingBase entityLivingBase) {
        this.0(entityLivingBase, b_02.c());
    }

    public 82() {
        super("Trajectories", 3D.2, "ThrowLines", "PearlLines", "ArrowPaths");
    }

    public static boolean 0(EntityLivingBase entityLivingBase) {
        3E e2 = 3F.c("BowAim");
        if (entityLivingBase == ((Minecraft)82.c).player && e2 != null) {
            return e2.f() && !4n_0.c.c(350.0);
        }
        return false;
    }

    public 81 c(EntityLivingBase entityLivingBase) {
        if (entityLivingBase.getHeldItemMainhand().isEmpty()) {
            return 81.c;
        }
        ItemStack itemStack = entityLivingBase.getHeldItem(EnumHand.MAIN_HAND);
        switch (Item.getIdFromItem((Item)itemStack.getItem())) {
            case 261: {
                if (!entityLivingBase.isHandActive()) break;
                return 81.0;
            }
            case 346: {
                return 81.3;
            }
            case 438: 
            case 441: {
                return 81.1;
            }
            case 384: {
                return 81.2;
            }
            case 332: 
            case 344: 
            case 368: {
                return 81.4;
            }
        }
        return 81.c;
    }

    public static boolean c() {
        return (Boolean)3.6();
    }

    public static boolean 0(Entity entity) {
        return entity instanceof EntityLivingBase;
    }

    public void c(EntityLivingBase entityLivingBase, float f2) {
        boolean bl = 82.c.gameSettings.viewBobbing;
        82.c.gameSettings.viewBobbing = false;
        ((IEntityRenderer)((Minecraft)82.c).entityRenderer).iSetupCameraTransform(f2, 0);
        GL11.glPushAttrib((int)1048575);
        GL11.glPushMatrix();
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2884);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glDepthMask((boolean)false);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glLineWidth((float)((Float)f.6()).floatValue());
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        Vec3d vec3d = this.c.get(0);
        Color color = entityLivingBase == ((Minecraft)82.c).player ? ((89)d.6()).4() : ((89)8.6()).4();
        for (Vec3d vec3d2 : this.c) {
            bufferBuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
            bufferBuilder.pos(vec3d.x, vec3d.y, vec3d.z).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            bufferBuilder.pos(vec3d2.x, vec3d2.y, vec3d2.z).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            vec3d = vec3d2;
            tessellator.draw();
        }
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2884);
        GL11.glEnable((int)2896);
        GL11.glPopMatrix();
        GL11.glPopAttrib();
        82.c.gameSettings.viewBobbing = bl;
        ((IEntityRenderer)((Minecraft)82.c).entityRenderer).iSetupCameraTransform(f2, 0);
    }

    public void 0(EntityLivingBase entityLivingBase, float f2) {
        block18: {
            81 var3_3 = this.c(entityLivingBase);
            if (var3_3 == 81.c) {
                return;
            }
            80 var4_4 = new 80(this, entityLivingBase, var3_3);
            this.c.clear();
            while (!var4_4.c()) {
                var4_4.2();
                this.c.add(new Vec3d(80.0((80)var4_4).x - 82.c.getRenderManager().viewerPosX, 80.0((80)var4_4).y - 82.c.getRenderManager().viewerPosY, 80.0((80)var4_4).z - 82.c.getRenderManager().viewerPosZ));
            }
            this.c(entityLivingBase, f2);
            if (!80.c(var4_4)) break block18;
            RayTraceResult rayTraceResult = 80.1(var4_4);
            AxisAlignedBB axisAlignedBB = null;
            if (rayTraceResult == null) {
                return;
            }
            if (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos blockPos = rayTraceResult.getBlockPos();
                IBlockState iBlockState = ((Minecraft)82.c).world.getBlockState(blockPos);
                if (iBlockState.getMaterial() != Material.AIR && ((Minecraft)82.c).world.getWorldBorder().contains(blockPos)) {
                    if (((Boolean)3.6()).booleanValue()) {
                        this.c(entityLivingBase, rayTraceResult);
                    }
                    axisAlignedBB = iBlockState.getSelectedBoundingBox((World)((Minecraft)82.c).world, blockPos).grow((double)0.002f);
                }
            } else if (rayTraceResult.typeOfHit == RayTraceResult.Type.ENTITY && rayTraceResult.entityHit != null && rayTraceResult.entityHit != ((Minecraft)82.c).player) {
                axisAlignedBB = rayTraceResult.entityHit.getEntityBoundingBox();
            }
            if (axisAlignedBB != null && ((Boolean)1.6()).booleanValue()) {
                if (((Boolean)2.6()).booleanValue() && rayTraceResult.sideHit != null) {
                    switch (rayTraceResult.sideHit) {
                        case DOWN: {
                            axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.maxZ);
                            break;
                        }
                        case UP: {
                            axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                            break;
                        }
                        case NORTH: {
                            axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.minZ);
                            break;
                        }
                        case SOUTH: {
                            axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.maxZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                            break;
                        }
                        case EAST: {
                            axisAlignedBB = new AxisAlignedBB(axisAlignedBB.maxX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                            break;
                        }
                        case WEST: {
                            axisAlignedBB = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.minX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
                        }
                    }
                }
                99.c();
                99.c(axisAlignedBB, true, 1.0, entityLivingBase == ((Minecraft)82.c).player ? (89)a.6() : (89)6.6(), entityLivingBase == ((Minecraft)82.c).player ? ((89)a.6()).1() : ((89)6.6()).1(), 63);
                99.c(axisAlignedBB, ((Float)g.6()).floatValue(), entityLivingBase == ((Minecraft)82.c).player ? (89)b.6() : (89)7.6());
                99.0();
                7g_0.c.c();
            }
        }
    }

    public static boolean 0() {
        return (Boolean)3.6();
    }

    public void c(EntityLivingBase entityLivingBase, RayTraceResult rayTraceResult) {
        GlStateManager.pushMatrix();
        96.1();
        GlStateManager.glLineWidth((float)((Float)h.6()).floatValue());
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask((boolean)false);
        GlStateManager.disableDepth();
        GL11.glLineWidth((float)((Float)h.6()).floatValue());
        if (entityLivingBase == ((Minecraft)82.c).player) {
            GL11.glColor4f((float)((float)((89)e.6()).6() / 255.0f), (float)((float)((89)e.6()).5() / 255.0f), (float)((float)((89)e.6()).2() / 255.0f), (float)((float)((89)e.6()).1() / 255.0f));
        } else {
            GL11.glColor4f((float)((float)((89)9.6()).6() / 255.0f), (float)((float)((89)9.6()).5() / 255.0f), (float)((float)((89)9.6()).2() / 255.0f), (float)((float)((89)9.6()).1() / 255.0f));
        }
        GlStateManager.translate((double)(rayTraceResult.hitVec.x - ((IRenderManager)c.getRenderManager()).getRenderPosX()), (double)(rayTraceResult.hitVec.y - ((IRenderManager)c.getRenderManager()).getRenderPosY()), (double)(rayTraceResult.hitVec.z - ((IRenderManager)c.getRenderManager()).getRenderPosZ()));
        EnumFacing enumFacing = rayTraceResult.sideHit;
        switch (enumFacing) {
            case NORTH: 
            case SOUTH: {
                GlStateManager.rotate((float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
                break;
            }
            case EAST: 
            case WEST: {
                GlStateManager.rotate((float)90.0f, (float)0.0f, (float)0.0f, (float)1.0f);
                break;
            }
        }
        Cylinder cylinder = new Cylinder();
        GlStateManager.rotate((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
        cylinder.setDrawStyle(100011);
        cylinder.draw(((Float)4.6()).floatValue() * 2.0f, ((Float)4.6()).floatValue(), 0.0f, ((Integer)5.6()).intValue(), 1);
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.enableDepth();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.enableTexture2D();
        96.c();
        GlStateManager.popMatrix();
    }

    @Subscriber
    public void c(1b_0 b_02) {
        82.c.world.loadedEntityList.stream().filter(82::0).map(82::c).forEach(arg_0 -> this.c(b_02, arg_0));
    }

    public static EntityLivingBase c(Entity entity) {
        return (EntityLivingBase)entity;
    }
}

