/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.1A;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.7A;
import me.darki.konas.7B;
import me.darki.konas.7C;
import me.darki.konas.89;
import me.darki.konas.8F;
import me.darki.konas.8J;
import me.darki.konas.8Z;
import me.darki.konas.8h_0;
import me.darki.konas.8r_0;
import me.darki.konas.96;
import me.darki.konas.99;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7D
extends 3E {
    public 8h_0<Integer> 1;
    public 8h_0<Integer> 2;
    public 8h_0<Float> 3;
    public 8h_0<Float> 4;
    public 8h_0<7B> 5;
    public 8h_0<Integer> 6;
    public 8h_0<Boolean> 7;
    public 8h_0<Boolean> 8;
    public 8h_0<7A> 9;
    public 8h_0<Boolean> a;
    public 8h_0<Boolean> b;
    public 8h_0<Boolean> d;
    public 8h_0<Boolean> e;
    public 8h_0<89> f;
    public 8h_0<89> g;
    public 8h_0<Boolean> h;
    public 8h_0<89> i;
    public 8h_0<89> j;
    public 8h_0<Boolean> k;
    public 8h_0<Boolean> l;
    public 8h_0<89> m;
    public 8h_0<89> n;
    public List<BlockPos> c;
    public List<BlockPos> 0;
    public List<7C> 1 = new 8h_0("RangeXZ", 8, 25, 1, 1);
    public List<7C> 2 = new 8h_0("RangeY", 5, 25, 1, 1);

    public 7D() {
        super("HoleESP", "Shows you holes", 3D.2, new String[0]);
        this.3 = new 8h_0("Width", Float.valueOf(1.5f), Float.valueOf(10.0f), Float.valueOf(0.0f), Float.valueOf(0.1f));
        this.4 = new 8h_0("Height", Float.valueOf(1.0f), Float.valueOf(8.0f), Float.valueOf(-2.0f), Float.valueOf(0.1f));
        this.5 = new 8h_0("Mode", 7B.1);
        this.6 = new 8h_0("FadeAlpha", 0, 255, 0, 1).c(this::5);
        this.7 = new 8h_0("Depth", true).c(this::1);
        this.8 = new 8h_0("NotLines", true).c(this::c);
        this.9 = new 8h_0("Lines", 7A.0).c(this::0);
        this.a = new 8h_0("Sides", false).c(this::7);
        this.b = new 8h_0("NotSelf", true).c(this::6);
        this.d = new 8h_0("TwoBlock", false);
        this.e = new 8h_0("Bedrock", true);
        this.f = new 8h_0("BedrockColor", new 89(-2013200640)).c(this.e::6);
        this.g = new 8h_0("BedrockLineColor", new 89(-16711936)).c(this.e::6);
        this.h = new 8h_0("Obsidian", true);
        8h_0 h_02 = new 8h_0("ObiColor", new 89(-1996554240));
        8h_0<Boolean> h_03 = this.h;
        h_03.getClass();
        this.i = h_02.c(h_03::6);
        this.j = new 8h_0("ObiLineColor", new 89(-65536)).c(this.h::6);
        this.k = new 8h_0("Vulnerable", false);
        this.l = new 8h_0("Self", false);
        this.m = new 8h_0("VunColor", new 89(0x66FF00FF)).c(this.k::6);
        this.n = new 8h_0("VunLineColor", new 89(-65281)).c(this.k::6);
        this.c = new ArrayList<BlockPos>();
        this.0 = new ArrayList<BlockPos>();
        this.1 = new ArrayList();
        this.2 = new ArrayList();
    }

    public boolean 7() {
        return this.5.6() == 7B.1 || this.5.6() == 7B.3;
    }

    public boolean 1() {
        return this.5.6() == 7B.3;
    }

    public boolean 3(Entity entity) {
        return entity != ((Minecraft)7D.c).player || (Boolean)this.l.6() != false;
    }

    public void c(BlockPos blockPos, BlockPos blockPos2, 89 var3_3, 89 var4_4) {
        block14: {
            AxisAlignedBB axisAlignedBB;
            block13: {
                block12: {
                    axisAlignedBB = new AxisAlignedBB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), (double)(blockPos2.getX() + 1), (double)((float)blockPos2.getY() + ((Float)this.4.6()).floatValue()), (double)(blockPos2.getZ() + 1));
                    if (this.5.6() == 7B.1) {
                        99.c();
                        99.c(axisAlignedBB, true, 1.0, var3_3, var3_3.1(), (Boolean)this.a.6() != false ? 60 : 63);
                        99.0();
                    }
                    if (this.5.6() == 7B.1) break block12;
                    if (this.5.6() != 7B.0) break block13;
                }
                99.c();
                99.c(axisAlignedBB, ((Float)this.3.6()).floatValue(), var4_4);
                99.0();
            }
            if (this.5.6() == 7B.2) {
                8Z.0();
                8Z.c(axisAlignedBB.offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ()), var4_4.c(), ((Float)this.3.6()).floatValue());
                8Z.c();
            }
            if (this.5.6() != 7B.3) break block14;
            AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), (double)(blockPos2.getX() + 1), (double)((float)blockPos2.getY() + ((Float)this.4.6()).floatValue()), (double)(blockPos2.getZ() + 1));
            if (axisAlignedBB2.intersects(((Minecraft)7D.c).player.getEntityBoundingBox()) && ((Boolean)this.b.6()).booleanValue()) {
                axisAlignedBB2 = axisAlignedBB2.setMaxY(Math.min(axisAlignedBB2.maxY, 7D.c.player.posY + 1.0));
            }
            99.c();
            if (((Boolean)this.7.6()).booleanValue()) {
                GlStateManager.enableDepth();
                axisAlignedBB2 = axisAlignedBB2.shrink(0.01);
            }
            99.c(axisAlignedBB2, true, (double)((Float)this.4.6()).floatValue(), var3_3, (int)((Integer)this.6.6()), (Boolean)this.a.6() != false ? 60 : 63);
            if (((Float)this.3.6()).floatValue() >= 0.1f) {
                if (this.9.6() == 7A.0) {
                    axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.minZ, axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.maxZ);
                } else if (this.9.6() == 7A.1) {
                    axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.minZ, axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ);
                }
                if (((Boolean)this.8.6()).booleanValue()) {
                    GlStateManager.disableDepth();
                }
                99.0(axisAlignedBB2, ((Float)this.3.6()).floatValue(), var4_4, (Integer)this.6.6());
            }
            99.0();
        }
    }

    public boolean c(Entity entity) {
        return entity.getDistance((Entity)((Minecraft)7D.c).player) < (float)((Integer)this.1.6()).intValue();
    }

    @Override
    public boolean 5() {
        return this.5.6() == 7B.3;
    }

    public boolean c() {
        return this.5.6() == 7B.3 && (Boolean)this.7.6() != false;
    }

    @Subscriber
    public void c(1A a2) {
        if (((Minecraft)7D.c).world == null || ((Minecraft)7D.c).player == null) {
            return;
        }
        this.c.clear();
        this.0.clear();
        this.1.clear();
        this.2.clear();
        Iterable iterable = BlockPos.getAllInBox((BlockPos)((Minecraft)7D.c).player.getPosition().add(-((Integer)this.1.6()).intValue(), -((Integer)this.2.6()).intValue(), -((Integer)this.1.6()).intValue()), (BlockPos)((Minecraft)7D.c).player.getPosition().add(((Integer)this.1.6()).intValue(), ((Integer)this.2.6()).intValue(), ((Integer)this.1.6()).intValue()));
        for (BlockPos blockPos : iterable) {
            BlockPos blockPos2;
            if (((Minecraft)7D.c).world.getBlockState(blockPos).getMaterial().blocksMovement() && ((Minecraft)7D.c).world.getBlockState(blockPos.add(0, 1, 0)).getMaterial().blocksMovement() && ((Minecraft)7D.c).world.getBlockState(blockPos.add(0, 2, 0)).getMaterial().blocksMovement()) continue;
            if (8r_0.4(blockPos) && ((Boolean)this.h.6()).booleanValue()) {
                this.c.add(blockPos);
            } else {
                blockPos2 = 8r_0.6(blockPos);
                if (blockPos2 != null && ((Boolean)this.h.6()).booleanValue() && ((Boolean)this.d.6()).booleanValue()) {
                    this.1.add(new 7C(blockPos, blockPos.add(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ())));
                }
            }
            if (8r_0.5(blockPos) && ((Boolean)this.e.6()).booleanValue()) {
                this.0.add(blockPos);
                continue;
            }
            blockPos2 = 8r_0.3(blockPos);
            if (blockPos2 == null || !((Boolean)this.e.6()).booleanValue() || !((Boolean)this.d.6()).booleanValue()) continue;
            this.2.add(new 7C(blockPos, blockPos.add(blockPos2.getX(), blockPos2.getY(), blockPos2.getZ())));
        }
    }

    public static Float 0(Entity entity) {
        return Float.valueOf(((Minecraft)7D.c).player.getDistance(entity));
    }

    public void c(BlockPos blockPos, 89 var2_2, 89 var3_3) {
        block10: {
            AxisAlignedBB axisAlignedBB = ((Minecraft)7D.c).world.getBlockState(blockPos).getBoundingBox((IBlockAccess)((Minecraft)7D.c).world, blockPos).offset(blockPos);
            axisAlignedBB = axisAlignedBB.setMaxY(axisAlignedBB.minY + (double)((Float)this.4.6()).floatValue());
            if (this.5.6() == 7B.1) {
                99.c();
                99.c(axisAlignedBB, true, 1.0, var2_2, var2_2.1(), (Boolean)this.a.6() != false ? 60 : 63);
                99.0();
            }
            if (this.5.6() == 7B.1 || this.5.6() == 7B.0) {
                99.c();
                99.c(axisAlignedBB, ((Float)this.3.6()).floatValue(), var3_3);
                99.0();
            }
            if (this.5.6() == 7B.2) {
                8Z.0();
                8Z.c(axisAlignedBB.offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ()), var3_3.c(), ((Float)this.3.6()).floatValue());
                8Z.c();
            }
            if (this.5.6() != 7B.3) break block10;
            AxisAlignedBB axisAlignedBB2 = ((Minecraft)7D.c).world.getBlockState(blockPos).getBoundingBox((IBlockAccess)((Minecraft)7D.c).world, blockPos).offset(blockPos);
            axisAlignedBB2 = axisAlignedBB2.setMaxY(axisAlignedBB2.minY + (double)((Float)this.4.6()).floatValue());
            if (((Minecraft)7D.c).player.getEntityBoundingBox() != null && axisAlignedBB2.intersects(((Minecraft)7D.c).player.getEntityBoundingBox()) && ((Boolean)this.b.6()).booleanValue()) {
                axisAlignedBB2 = axisAlignedBB2.setMaxY(Math.min(axisAlignedBB2.maxY, 7D.c.player.posY + 1.0));
            }
            99.c();
            if (((Boolean)this.7.6()).booleanValue()) {
                GlStateManager.enableDepth();
                axisAlignedBB2 = axisAlignedBB2.shrink(0.01);
            }
            99.c(axisAlignedBB2, true, (double)((Float)this.4.6()).floatValue(), var2_2, (int)((Integer)this.6.6()), (Boolean)this.a.6() != false ? 60 : 63);
            if (((Float)this.3.6()).floatValue() >= 0.1f) {
                if (this.9.6() == 7A.0) {
                    axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB2.minX, axisAlignedBB2.minY, axisAlignedBB2.minZ, axisAlignedBB2.maxX, axisAlignedBB2.minY, axisAlignedBB2.maxZ);
                } else if (this.9.6() == 7A.1) {
                    axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB2.minX, axisAlignedBB2.maxY, axisAlignedBB2.minZ, axisAlignedBB2.maxX, axisAlignedBB2.maxY, axisAlignedBB2.maxZ);
                }
                if (((Boolean)this.8.6()).booleanValue()) {
                    GlStateManager.disableDepth();
                }
                99.0(axisAlignedBB2, ((Float)this.3.6()).floatValue(), var3_3, (Integer)this.6.6());
            }
            99.0();
        }
    }

    @Override
    public String 0() {
        return ((7B)((Object)this.5.6())).toString().charAt(0) + ((7B)((Object)this.5.6())).toString().substring(1).toLowerCase();
    }

    public static boolean 2(Entity entity) {
        return !8J.1(entity.getName());
    }

    @Subscriber
    public void c(1b_0 b_02) {
        Object object;
        AxisAlignedBB axisAlignedBB;
        if (((Minecraft)7D.c).world == null || ((Minecraft)7D.c).player == null) {
            return;
        }
        if (this.5.6() == 7B.c) {
            GlStateManager.pushMatrix();
            96.1();
            GlStateManager.enableBlend();
            GlStateManager.glLineWidth((float)5.0f);
            GlStateManager.disableTexture2D();
            GlStateManager.depthMask((boolean)false);
            GlStateManager.disableDepth();
            GlStateManager.tryBlendFuncSeparate((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
            for (BlockPos object22 : this.0) {
                axisAlignedBB = new AxisAlignedBB((double)object22.getX(), (double)object22.getY(), (double)object22.getZ(), (double)(object22.getX() + 1), (double)object22.getY(), (double)(object22.getZ() + 1));
                96.1(axisAlignedBB, ((89)this.f.6()).c());
            }
            for (BlockPos blockPos : this.c) {
                axisAlignedBB = new AxisAlignedBB((double)blockPos.getX(), (double)blockPos.getY(), (double)blockPos.getZ(), (double)(blockPos.getX() + 1), (double)blockPos.getY(), (double)(blockPos.getZ() + 1));
                96.1(axisAlignedBB, ((89)this.i.6()).c());
            }
            object = this.2.iterator();
            while (object.hasNext()) {
                7C c2 = (7C)object.next();
                axisAlignedBB = new AxisAlignedBB((double)c2.0().getX(), (double)c2.0().getY(), (double)c2.0().getZ(), (double)(c2.c().getX() + 1), (double)c2.c().getY(), (double)(c2.c().getZ() + 1));
                96.1(axisAlignedBB, ((89)this.f.6()).c());
            }
            object = this.1.iterator();
            while (object.hasNext()) {
                7C c3 = (7C)object.next();
                axisAlignedBB = new AxisAlignedBB((double)c3.0().getX(), (double)c3.0().getY(), (double)c3.0().getZ(), (double)(c3.c().getX() + 1), (double)c3.c().getY(), (double)(c3.c().getZ() + 1));
                96.1(axisAlignedBB, ((89)this.i.6()).c());
            }
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GlStateManager.enableDepth();
            GlStateManager.depthMask((boolean)true);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            96.c();
            GlStateManager.popMatrix();
        } else {
            for (BlockPos blockPos : this.0) {
                this.c(blockPos, (89)this.f.6(), (89)this.g.6());
            }
            for (BlockPos blockPos : this.c) {
                this.c(blockPos, (89)this.i.6(), (89)this.j.6());
            }
            object = this.2.iterator();
            while (object.hasNext()) {
                7C c4 = (7C)object.next();
                this.c(c4.0(), c4.c(), (89)this.f.6(), (89)this.g.6());
            }
            object = this.1.iterator();
            while (object.hasNext()) {
                7C c5 = (7C)object.next();
                this.c(c5.0(), c5.c(), (89)this.i.6(), (89)this.j.6());
            }
        }
        if (((Boolean)this.k.6()).booleanValue()) {
            object = 7D.c.world.loadedEntityList.stream().filter(7D::1).filter(this::c).filter(this::3).filter(7D::2).sorted(Comparator.comparing(7D::0)).collect(Collectors.toList());
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                axisAlignedBB = (Entity)iterator.next();
                ArrayList<BlockPos> arrayList = 8F.c(new BlockPos((Entity)axisAlignedBB));
                for (BlockPos blockPos : arrayList) {
                    AxisAlignedBB axisAlignedBB2 = ((Minecraft)7D.c).world.getBlockState(blockPos).getBoundingBox((IBlockAccess)((Minecraft)7D.c).world, blockPos).offset(blockPos);
                    99.c();
                    99.c(axisAlignedBB2, true, 1.0, (89)this.m.6(), ((89)this.m.6()).1(), 63);
                    99.c(axisAlignedBB2, ((Float)this.3.6()).floatValue(), (89)this.n.6());
                    99.0();
                }
            }
        }
    }

    public boolean 0() {
        return this.5.6() == 7B.3;
    }

    public static boolean 1(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    public boolean 6() {
        return this.5.6() == 7B.3;
    }
}

