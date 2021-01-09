/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import me.darki.konas.0S;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.4C;
import me.darki.konas.4D;
import me.darki.konas.4g_0;
import me.darki.konas.6X;
import me.darki.konas.89;
import me.darki.konas.8E;
import me.darki.konas.8J;
import me.darki.konas.8K;
import me.darki.konas.8L;
import me.darki.konas.8M;
import me.darki.konas.8Z;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8p_0;
import me.darki.konas.8q_0;
import me.darki.konas.8r_0;
import me.darki.konas.8u_0;
import me.darki.konas.8z_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4E
extends 3E {
    public 8h_0<4C> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Boolean> 4;
    public 8h_0<Integer> 5;
    public 8h_0<Integer> 6;
    public static 8h_0<Integer> 7 = new 8h_0("ActionShift", 3, 8, 1, 1);
    public static 8h_0<Integer> 8 = new 8h_0("ActionInterval", 0, 10, 0, 1);
    public 8h_0<Boolean> 9;
    public 8h_0<Boolean> a;
    public 8h_0<Boolean> b;
    public 8h_0<Boolean> d;
    public static 8h_0<8f_0> e = new 8h_0("Render", new 8f_0(false));
    public static 8h_0<Boolean> f = new 8h_0("Current", true).c(e);
    public static 8h_0<89> g = new 8h_0("ColorC", new 89(1354711231)).c(e);
    public static 8h_0<89> h = new 8h_0("OutlineC", new 89(-4243265)).c(e);
    public static 8h_0<Boolean> i = new 8h_0("Full", true).c(e);
    public static 8h_0<89> j = new 8h_0("ColorF", new 89(817840192)).c(e);
    public static 8h_0<89> k = new 8h_0("OutlineF", new 89(-809549760)).c(e);
    public static 8h_0<Boolean> l = new 8h_0("Arrow", true).c(e);
    public static 8h_0<89> m = new 8h_0("ArrowColor", new 89(-65281)).c(e);
    public static 8h_0<Boolean> n = new 8h_0("Top", false).c(e);
    public static 8h_0<Boolean> o = new 8h_0("Bottom", true).c(e);
    public 4D c;
    public BlockPos c;
    public EnumFacing c;
    public BlockPos 0;
    public BlockPos 1;
    public EnumFacing 0;
    public BlockPos 2;
    public 9m c;
    public boolean 1;
    public 9m 0;
    public int 1;
    public 9m 1 = new 8h_0("Mode", 4C.c);
    public Runnable c = null;
    public int 2;
    public BlockPos 3;
    public 9m 2 = 0;
    public 9m 3 = null;

    public boolean c(EntityPlayer entityPlayer) {
        if (this.2() == -1) {
            8p_0.c("No redstone found!");
            this.d();
            return false;
        }
        BlockPos blockPos = new BlockPos((Entity)entityPlayer).up();
        if (this.2(blockPos)) {
            return true;
        }
        blockPos = new BlockPos((Entity)entityPlayer).up().up();
        return this.2(blockPos);
    }

    public static boolean c(BlockPos blockPos) {
        if (((Minecraft)4E.c).world.getBlockState(blockPos).getBlock() != Blocks.BEDROCK && ((Minecraft)4E.c).world.getBlockState(blockPos).getBlock() != Blocks.OBSIDIAN) {
            return false;
        }
        BlockPos blockPos2 = blockPos.add(0, 1, 0);
        if (((Minecraft)4E.c).world.getBlockState(blockPos2).getBlock() != Blocks.AIR && ((Minecraft)4E.c).world.getBlockState(blockPos2).getBlock() != Blocks.PISTON_HEAD) {
            return false;
        }
        BlockPos blockPos3 = blockPos.add(0, 2, 0);
        if (!((Boolean)4g_0.d.6()).booleanValue() && ((Minecraft)4E.c).world.getBlockState(blockPos3).getBlock() != Blocks.AIR) {
            return false;
        }
        return ((Minecraft)4E.c).world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(blockPos2, blockPos3.add(1, 1, 1))).isEmpty();
    }

    public static boolean 3(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    public static boolean 0(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    public boolean 4(EntityPlayer entityPlayer) {
        return ((Minecraft)4E.c).player.getDistance((Entity)entityPlayer) < (float)((Integer)this.5.6()).intValue();
    }

    public static Float 1(Entity entity) {
        return Float.valueOf(((Minecraft)4E.c).player.getDistance(entity));
    }

    @Override
    public void c() {
        if (((Minecraft)4E.c).player == null || ((Minecraft)4E.c).world == null) {
            return;
        }
        this.c = 4D.c;
        this.c = null;
        this.c = null;
        this.0 = null;
        this.1 = null;
        this.0 = null;
        this.1 = 0;
        this.2 = 0;
        this.c = null;
        this.2 = null;
        this.1 = false;
        this.3 = null;
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return !8J.1(entityPlayer.getName());
    }

    public boolean 0(BlockPos blockPos) {
        return ((Minecraft)4E.c).world.getBlockState(blockPos).getBlock() instanceof BlockAir;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block26: {
            AxisAlignedBB axisAlignedBB;
            BlockPos blockPos;
            if (this.c == null || this.c == null) {
                return;
            }
            if (this.1.c(1000.0)) {
                return;
            }
            if (((Boolean)f.6()).booleanValue()) {
                blockPos = null;
                switch (this.c) {
                    case c: {
                        blockPos = this.c.down().offset(this.c, 2);
                        break;
                    }
                    case 0: 
                    case 2: {
                        blockPos = this.c.down().offset(this.c, 1);
                        break;
                    }
                    case 1: {
                        blockPos = this.c.down().offset(this.c, 3);
                    }
                }
                if (blockPos != null) {
                    axisAlignedBB = ((Minecraft)4E.c).world.getBlockState(blockPos).getBoundingBox((IBlockAccess)((Minecraft)4E.c).world, blockPos).offset(blockPos);
                    axisAlignedBB = axisAlignedBB.offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ());
                    8Z.0();
                    8Z.c(axisAlignedBB, ((89)g.6()).c());
                    8Z.c();
                    8Z.0();
                    8Z.0(axisAlignedBB, ((89)h.6()).c(), 1.5f);
                    8Z.c();
                }
            }
            if (((Boolean)i.6()).booleanValue()) {
                blockPos = null;
                switch (this.c) {
                    case NORTH: {
                        blockPos = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, -3.0).offset(this.c.down());
                        break;
                    }
                    case SOUTH: {
                        blockPos = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 3.0).offset(this.c.down());
                        break;
                    }
                    case EAST: {
                        blockPos = new AxisAlignedBB(0.0, 0.0, 0.0, 3.0, 1.0, 1.0).offset(this.c.down());
                        break;
                    }
                    case WEST: {
                        blockPos = new AxisAlignedBB(0.0, 0.0, 0.0, -3.0, 1.0, 1.0).offset(this.c.down());
                    }
                }
                if (blockPos != null) {
                    blockPos = blockPos.offset(-((IRenderManager)c.getRenderManager()).getRenderPosX(), -((IRenderManager)c.getRenderManager()).getRenderPosY(), -((IRenderManager)c.getRenderManager()).getRenderPosZ());
                    8Z.0();
                    8Z.c((AxisAlignedBB)blockPos, ((89)j.6()).c());
                    8Z.c();
                    8Z.0();
                    8Z.0((AxisAlignedBB)blockPos, ((89)k.6()).c(), 1.5f);
                    8Z.c();
                }
            }
            if (!((Boolean)l.6()).booleanValue()) break block26;
            blockPos = null;
            axisAlignedBB = null;
            Vec3d vec3d = null;
            BlockPos blockPos2 = this.c.offset(this.c, 2);
            Vec3d vec3d2 = new Vec3d((double)blockPos2.getX() + 0.5 - ((IRenderManager)c.getRenderManager()).getRenderPosX(), (double)(blockPos2.getY() + 1) - ((IRenderManager)c.getRenderManager()).getRenderPosY(), (double)blockPos2.getZ() + 0.5 - ((IRenderManager)c.getRenderManager()).getRenderPosZ());
            switch (this.c) {
                case NORTH: {
                    blockPos = new Vec3d(vec3d2.x - 0.5, vec3d2.y, vec3d2.z - 0.5);
                    axisAlignedBB = new Vec3d(vec3d2.x, vec3d2.y, vec3d2.z + 0.5);
                    vec3d = new Vec3d(vec3d2.x + 0.5, vec3d2.y, vec3d2.z - 0.5);
                    break;
                }
                case SOUTH: {
                    blockPos = new Vec3d(vec3d2.x - 0.5, vec3d2.y, vec3d2.z + 0.5);
                    axisAlignedBB = new Vec3d(vec3d2.x, vec3d2.y, vec3d2.z - 0.5);
                    vec3d = new Vec3d(vec3d2.x + 0.5, vec3d2.y, vec3d2.z + 0.5);
                    break;
                }
                case EAST: {
                    blockPos = new Vec3d(vec3d2.x + 0.5, vec3d2.y, vec3d2.z - 0.5);
                    axisAlignedBB = new Vec3d(vec3d2.x - 0.5, vec3d2.y, vec3d2.z);
                    vec3d = new Vec3d(vec3d2.x + 0.5, vec3d2.y, vec3d2.z + 0.5);
                    break;
                }
                case WEST: {
                    blockPos = new Vec3d(vec3d2.x - 0.5, vec3d2.y, vec3d2.z - 0.5);
                    axisAlignedBB = new Vec3d(vec3d2.x + 0.5, vec3d2.y, vec3d2.z);
                    vec3d = new Vec3d(vec3d2.x - 0.5, vec3d2.y, vec3d2.z + 0.5);
                }
            }
            if (blockPos != null) {
                8Z.0();
                GL11.glPushMatrix();
                GL11.glEnable((int)3042);
                GL11.glBlendFunc((int)770, (int)771);
                GL11.glDisable((int)2896);
                GL11.glDisable((int)3553);
                GL11.glEnable((int)2848);
                GL11.glDisable((int)2929);
                GL11.glDepthMask((boolean)false);
                GL11.glLineWidth((float)5.0f);
                GL11.glColor4f((float)((float)(((89)m.6()).c() >> 16 & 0xFF) / 255.0f), (float)((float)(((89)m.6()).c() >> 8 & 0xFF) / 255.0f), (float)((float)(((89)m.6()).c() & 0xFF) / 255.0f), (float)((float)(((89)m.6()).c() >> 24 & 0xFF) / 255.0f));
                if (((Boolean)n.6()).booleanValue()) {
                    GL11.glBegin((int)1);
                    GL11.glVertex3d((double)blockPos.x, (double)blockPos.y, (double)blockPos.z);
                    GL11.glVertex3d((double)axisAlignedBB.x, (double)axisAlignedBB.y, (double)axisAlignedBB.z);
                    GL11.glEnd();
                    GL11.glBegin((int)1);
                    GL11.glVertex3d((double)vec3d.x, (double)vec3d.y, (double)vec3d.z);
                    GL11.glVertex3d((double)axisAlignedBB.x, (double)axisAlignedBB.y, (double)axisAlignedBB.z);
                    GL11.glEnd();
                }
                if (((Boolean)o.6()).booleanValue()) {
                    GL11.glBegin((int)1);
                    GL11.glVertex3d((double)blockPos.x, (double)(blockPos.y - 1.0), (double)blockPos.z);
                    GL11.glVertex3d((double)axisAlignedBB.x, (double)(axisAlignedBB.y - 1.0), (double)axisAlignedBB.z);
                    GL11.glEnd();
                    GL11.glBegin((int)1);
                    GL11.glVertex3d((double)vec3d.x, (double)(vec3d.y - 1.0), (double)vec3d.z);
                    GL11.glVertex3d((double)axisAlignedBB.x, (double)(axisAlignedBB.y - 1.0), (double)axisAlignedBB.z);
                    GL11.glEnd();
                }
                GL11.glLineWidth((float)1.0f);
                GL11.glDisable((int)2848);
                GL11.glEnable((int)3553);
                GL11.glEnable((int)2896);
                GL11.glEnable((int)2929);
                GL11.glDepthMask((boolean)true);
                GL11.glDisable((int)3042);
                GL11.glPopMatrix();
                8Z.c();
            }
        }
    }

    public void c(boolean bl, int n2, boolean bl2, boolean bl3, Vec3d vec3d) {
        this.1.c();
        if (bl) {
            4E.c.player.inventory.currentItem = n2;
            4E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
        }
        if (bl2) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (bl3) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.START_SNEAKING));
        }
        ((Minecraft)4E.c).playerController.processRightClickBlock(((Minecraft)4E.c).player, ((Minecraft)4E.c).world, this.1, this.0, vec3d, EnumHand.MAIN_HAND);
        4E.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        if (bl3) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (bl2) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.START_SPRINTING));
        }
        this.c = 4D.0;
    }

    public void 3() {
        this.1.c();
        RayTraceResult rayTraceResult = ((Minecraft)4E.c).world.rayTraceBlocks(new Vec3d(4E.c.player.posX, 4E.c.player.posY + (double)((Minecraft)4E.c).player.getEyeHeight(), 4E.c.player.posZ), new Vec3d((double)this.0.getX() + 0.5, (double)this.0.getY() - 0.5, (double)this.0.getZ() + 0.5));
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        6X.1 = true;
        8r_0.c(this.0, ((Minecraft)4E.c).player.getPositionVector().add(0.0, (double)((Minecraft)4E.c).player.getEyeHeight(), 0.0), this.6() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, enumFacing, true);
        this.c = 4D.1;
        this.c.c(0L);
    }

    public void 2(Entity entity) {
        ((Minecraft)4E.c).playerController.attackEntity((EntityPlayer)((Minecraft)4E.c).player, entity);
        4E.c.player.connection.sendPacket((Packet)new CPacketAnimation(this.6() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND));
    }

    public boolean 6() {
        return ((Minecraft)4E.c).player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL;
    }

    public static Float 2(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)4E.c).player.getDistance((Entity)entityPlayer));
    }

    public List<EntityPlayer> 4() {
        return 4E.c.world.playerEntities.stream().filter(4E::3).filter(4E::0).filter(4E::1).filter(this::4).sorted(Comparator.comparing(4E::2)).collect(Collectors.toList());
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketBlockChange && this.2 != null && ((SPacketBlockChange)s.c()).getBlockPosition().equals((Object)this.2) && ((SPacketBlockChange)s.c()).getBlockState().getBlock() instanceof BlockAir) {
            this.2 = null;
        }
    }

    public boolean 2(BlockPos blockPos) {
        if (!this.0(blockPos) && !((Boolean)this.d.6()).booleanValue()) {
            return false;
        }
        for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
            Optional<8q_0> optional;
            this.2 = null;
            this.1 = false;
            if (!4E.c(blockPos.offset(enumFacing).down())) continue;
            if (this.2() == -1) {
                return false;
            }
            ItemStack itemStack = 4E.c.player.inventory.getStackInSlot(this.2());
            Block block = ((ItemBlock)itemStack.getItem()).getBlock();
            if (block == Blocks.REDSTONE_BLOCK) {
                if (!this.0(blockPos.offset(enumFacing, 3))) {
                    if (!((Boolean)this.d.6()).booleanValue() || ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() != Blocks.REDSTONE_TORCH && ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() != Blocks.REDSTONE_BLOCK) continue;
                    this.2 = blockPos.offset(enumFacing, 3);
                }
            } else {
                optional = 8r_0.c(blockPos.offset(enumFacing, 3), false, true);
                if (!optional.isPresent() && ((Boolean)this.d.6()).booleanValue() && (((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() == Blocks.REDSTONE_TORCH || ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 3)).getBlock() == Blocks.REDSTONE_BLOCK)) {
                    this.2 = blockPos.offset(enumFacing, 3);
                }
                if (!optional.isPresent() && this.2 == null && ((ItemBlock)4E.c.player.inventory.getStackInSlot(this.2()).getItem()).getBlock() == Blocks.REDSTONE_TORCH) {
                    for (BlockPos blockPos2 : EnumFacing.HORIZONTALS) {
                        if (blockPos2.equals((Object)enumFacing) || blockPos2.equals((Object)enumFacing.getOpposite())) continue;
                        optional = 8r_0.c(blockPos.offset(enumFacing, 2).offset((EnumFacing)blockPos2), false, true);
                        if (optional.isPresent()) break;
                        if (!((Boolean)this.d.6()).booleanValue() || ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 2).offset((EnumFacing)blockPos2)).getBlock() != Blocks.REDSTONE_TORCH) continue;
                        this.2 = blockPos.offset(enumFacing, 2).offset((EnumFacing)blockPos2);
                        break;
                    }
                }
                if (!optional.isPresent() && this.2 == null) continue;
            }
            optional = 8r_0.0(blockPos.offset(enumFacing, 2));
            boolean bl = this.1 = (Boolean)this.d.6() != false && ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() instanceof BlockPistonBase;
            if (!optional.isPresent() && !this.1) continue;
            if (!this.1) {
                BlockPos blockPos2;
                BlockPos blockPos3 = optional.get().c;
                EnumFacing enumFacing2 = optional.get().c;
                double[] dArray = 8r_0.c(blockPos3.getX(), blockPos3.getY(), blockPos3.getZ(), enumFacing2, (EntityPlayer)((Minecraft)4E.c).player);
                blockPos2 = EnumFacing.fromAngle((double)dArray[0]);
                if (Math.abs(dArray[1]) > 55.0 || blockPos2 != enumFacing || ((Boolean)this.a.6()).booleanValue() && !this.1(optional.get().c)) continue;
                this.1 = blockPos3;
                this.0 = enumFacing2;
            }
            this.c = blockPos;
            this.c = enumFacing;
            this.0 = blockPos.offset(enumFacing).down();
            return true;
        }
        return false;
    }

    public boolean c() {
        return this.1.6() == 4C.0;
    }

    public 4E() {
        super("PistonAura", "Automatically faceplaces people using pistons", 3D.c, new String[0]);
        this.4 = new 8h_0("DisableWhenNone", false).c(this::1);
        this.5 = new 8h_0("TargetRange", 3, 6, 1, 1);
        this.6 = new 8h_0("Delay", 25, 100, 0, 1);
        this.9 = new 8h_0("Strict", false);
        this.a = new 8h_0("RayTrace", false);
        this.b = new 8h_0("AntiSuicide", false);
        this.d = new 8h_0("Mine", false);
        this.c = 4D.c;
        this.c = new 9m();
        this.0 = new 9m();
        this.1 = new 9m();
        this.2 = new 9m();
        this.3 = new 9m();
    }

    public void c(int n2, 8K k2, BlockPos blockPos, EnumFacing enumFacing) {
        block1: {
            boolean bl = 4E.c.player.inventory.currentItem != n2;
            int n3 = 4E.c.player.inventory.currentItem;
            if (bl) {
                4E.c.player.inventory.currentItem = n2;
                4E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
            }
            8L.0(k2, EnumHand.MAIN_HAND, true);
            this.3 = blockPos.offset(enumFacing);
            this.2.c();
            if (!bl) break block1;
            4E.c.player.inventory.currentItem = n3;
            4E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
        }
    }

    @Subscriber(priority=20)
    public void c(1O o2) {
        if (this.c != null) {
            this.3.c();
            this.2 = 0;
            this.c.run();
            this.c = null;
            for (int i2 = 0; i2 < (Integer)7.6() - 1; ++i2) {
                this.2(true);
                if (this.c == null) {
                    return;
                }
                this.c.run();
                this.c = null;
            }
        }
        this.c = null;
    }

    public static int 0() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            Block block;
            ItemStack itemStack = 4E.c.player.inventory.getStackInSlot(i2);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || !((block = ((ItemBlock)itemStack.getItem()).getBlock()) instanceof BlockPistonBase)) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    @Override
    public boolean 5() {
        return this.1.6() == 4C.0;
    }

    public static boolean 1(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)4E.c).player;
    }

    public void c(boolean bl, int n2, boolean bl2, boolean bl3, Optional optional, Vec3d vec3d) {
        this.0.c();
        this.1.c();
        this.1 = (Integer)this.6.6() * 10;
        if (bl) {
            4E.c.player.inventory.currentItem = n2;
            4E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
        }
        if (bl2) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.STOP_SPRINTING));
        }
        if (bl3) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.START_SNEAKING));
        }
        ((Minecraft)4E.c).playerController.processRightClickBlock(((Minecraft)4E.c).player, ((Minecraft)4E.c).world, ((8q_0)optional.get()).c, ((8q_0)optional.get()).c, vec3d, EnumHand.MAIN_HAND);
        4E.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
        if (bl3) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
        }
        if (bl2) {
            4E.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4E.c).player, CPacketEntityAction.Action.START_SPRINTING));
        }
        this.c = 4D.2;
    }

    public boolean c(Entity entity) {
        return ((Minecraft)4E.c).player.getDistance(entity) <= (float)((Integer)this.5.6() + 4);
    }

    @Subscriber(priority=99)
    public void c(1P p2) {
        if (this.2 < (Integer)8.6()) {
            ++this.2;
        }
        if (p2.0() || !8L.c()) {
            return;
        }
        if (this.c == 4D.2) {
            8k_0.c.c.c((double)this.c.getX() + 0.5, this.c.getY(), (double)this.c.getZ() + 0.5);
        }
        if (this.2 < (Integer)8.6()) {
            return;
        }
        this.2(false);
    }

    public boolean 1(BlockPos blockPos) {
        for (double d2 = 0.1; d2 < 0.9; d2 += 0.1) {
            for (double d3 = 0.1; d3 < 0.9; d3 += 0.1) {
                for (double d4 = 0.1; d4 < 0.9; d4 += 0.1) {
                    Vec3d vec3d = new Vec3d(4E.c.player.posX, 4E.c.player.getEntityBoundingBox().minY + (double)((Minecraft)4E.c).player.getEyeHeight(), 4E.c.player.posZ);
                    Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).add(d2, d3, d4);
                    double d5 = vec3d.distanceTo(vec3d2);
                    double d6 = vec3d2.x - vec3d.x;
                    double d7 = vec3d2.y - vec3d.y;
                    double d8 = vec3d2.z - vec3d.z;
                    double d9 = MathHelper.sqrt((double)(d6 * d6 + d8 * d8));
                    double[] dArray = new double[]{MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d8, d6)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d7, d9)))))};
                    float f2 = MathHelper.cos((float)((float)(-dArray[0] * 0.01745329238474369 - 3.1415927410125732)));
                    float f3 = MathHelper.sin((float)((float)(-dArray[0] * 0.01745329238474369 - 3.1415927410125732)));
                    float f4 = -MathHelper.cos((float)((float)(-dArray[1] * 0.01745329238474369)));
                    float f5 = MathHelper.sin((float)((float)(-dArray[1] * 0.01745329238474369)));
                    Vec3d vec3d3 = new Vec3d((double)(f3 * f4), (double)f5, (double)(f2 * f4));
                    Vec3d vec3d4 = vec3d.add(vec3d3.x * d5, vec3d3.y * d5, vec3d3.z * d5);
                    RayTraceResult rayTraceResult = ((Minecraft)4E.c).world.rayTraceBlocks(vec3d, vec3d4, false, false, false);
                    if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object)blockPos)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public int 2() {
        int n2 = -1;
        for (int i2 = 0; i2 < 9; ++i2) {
            Block block;
            ItemStack itemStack = 4E.c.player.inventory.getStackInSlot(i2);
            if (itemStack == ItemStack.EMPTY || !(itemStack.getItem() instanceof ItemBlock) || (block = ((ItemBlock)itemStack.getItem()).getBlock()) != Blocks.REDSTONE_BLOCK && block != Blocks.REDSTONE_TORCH) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public void 2(boolean bl) {
        block43: {
            block42: {
                if (this.3.c(1000.0) && ((Boolean)this.4.6()).booleanValue()) {
                    this.d();
                }
                if (!this.0.c((double)this.1)) {
                    return;
                }
                if (((Boolean)this.9.6()).booleanValue() && Math.sqrt(4E.c.player.motionX * 4E.c.player.motionX + 4E.c.player.motionZ * 4E.c.player.motionZ) > 9.0E-4) {
                    return;
                }
                if (this.1.6() != 4C.c) break block42;
                switch (this.c) {
                    case c: {
                        List<EntityPlayer> list = this.4();
                        for (EntityPlayer entityPlayer : list) {
                            if (!this.c(entityPlayer)) continue;
                            int n2 = 4E.0();
                            if (n2 == -1) {
                                8p_0.c("No pistons found!");
                                this.d();
                                return;
                            }
                            if (this.1) {
                                this.c = 4D.0;
                                this.1 = false;
                                return;
                            }
                            boolean bl2 = 4E.c.player.inventory.currentItem != n2;
                            boolean bl3 = ((Minecraft)4E.c).player.isSprinting();
                            boolean bl4 = 8r_0.7(this.1);
                            Vec3d vec3d = new Vec3d((Vec3i)this.1).add(0.5, 0.5, 0.5).add(new Vec3d(this.0.getDirectionVec()).scale(0.5));
                            if (bl) {
                                float[] fArray = 8M.c(((Minecraft)4E.c).player.getPositionEyes(c.getRenderPartialTicks()), vec3d);
                                8z_0.c(fArray[0], fArray[1]);
                            } else {
                                8k_0.c.c.c(vec3d);
                            }
                            this.c = () -> this.c(bl2, n2, bl3, bl4, vec3d);
                            return;
                        }
                        break block43;
                    }
                    case 0: {
                        if (this.2 != null && ((Minecraft)4E.c).world.getBlockState(this.2).getBlock() == Blocks.AIR) {
                            this.2 = null;
                        }
                        if (this.2 != null) {
                            if (this.c.c(1000.0)) {
                                RayTraceResult rayTraceResult = ((Minecraft)4E.c).world.rayTraceBlocks(new Vec3d(4E.c.player.posX, 4E.c.player.posY + (double)((Minecraft)4E.c).player.getEyeHeight(), 4E.c.player.posZ), new Vec3d((double)this.2.getX() + 0.5, (double)this.2.getY() + 0.5, (double)this.2.getZ() + 0.5));
                                EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
                                Vec3d vec3d = new Vec3d((Vec3i)this.2).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5));
                                if (bl) {
                                    float[] fArray = 8M.c(((Minecraft)4E.c).player.getPositionEyes(c.getRenderPartialTicks()), vec3d);
                                    8z_0.c(fArray[0], fArray[1]);
                                } else {
                                    8k_0.c.c.c(vec3d);
                                }
                                this.c = () -> this.c(enumFacing);
                            }
                            return;
                        }
                        if (!this.6()) {
                            int n3 = 8E.1();
                            if (n3 == -1) {
                                8p_0.c("No crystals found!");
                                this.d();
                                return;
                            }
                            if (4E.c.player.inventory.currentItem != n3) {
                                4E.c.player.inventory.currentItem = n3;
                                ((Minecraft)4E.c).playerController.updateController();
                            }
                        }
                        if (this.0 == null) {
                            this.c = 4D.c;
                            return;
                        }
                        if (bl) {
                            float[] fArray = 8M.c(((Minecraft)4E.c).player.getPositionEyes(c.getRenderPartialTicks()), new Vec3d((double)this.0.getX() + 0.5, (double)this.0.getY() + 0.5, (double)this.0.getZ() + 0.5));
                            8z_0.c(fArray[0], fArray[1]);
                        } else {
                            8k_0.c.c.c(new Vec3d((double)this.0.getX() + 0.5, (double)this.0.getY() + 0.5, (double)this.0.getZ() + 0.5));
                        }
                        this.c = this::3;
                        return;
                    }
                    case 1: {
                        if (this.c == null) {
                            this.c = 4D.c;
                            return;
                        }
                        int n4 = this.2();
                        if (n4 == -1) {
                            8p_0.c("No redstone found!");
                            this.d();
                            return;
                        }
                        Optional<8q_0> optional = 8r_0.c(this.c.offset(this.c, 3), false, ((ItemBlock)4E.c.player.inventory.getStackInSlot(this.2()).getItem()).getBlock() == Blocks.REDSTONE_TORCH);
                        if (!optional.isPresent() && ((ItemBlock)4E.c.player.inventory.getStackInSlot(this.2()).getItem()).getBlock() == Blocks.REDSTONE_TORCH) {
                            for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                                if (!enumFacing.equals((Object)this.c) && !enumFacing.equals((Object)this.c.getOpposite()) && (optional = 8r_0.c(this.c.offset(this.c, 2).offset(enumFacing), false, ((ItemBlock)4E.c.player.inventory.getStackInSlot(this.2()).getItem()).getBlock() == Blocks.REDSTONE_TORCH)).isPresent()) break;
                            }
                        }
                        if (optional.isPresent()) {
                            Object object;
                            EnumFacing enumFacing;
                            boolean bl5 = 4E.c.player.inventory.currentItem != n4;
                            int n5 = ((Minecraft)4E.c).player.isSprinting();
                            int n6 = 8r_0.7(optional.get().c);
                            enumFacing = new Vec3d((Vec3i)optional.get().c).add(0.5, 0.5, 0.5).add(new Vec3d(optional.get().c.getDirectionVec()).scale(0.5));
                            if (bl) {
                                object = 8M.c(((Minecraft)4E.c).player.getPositionEyes(c.getRenderPartialTicks()), (Vec3d)enumFacing);
                                8z_0.c((float)object[0], (float)object[1]);
                            } else {
                                8k_0.c.c.c((Vec3d)enumFacing);
                            }
                            object = optional;
                            this.c = () -> this.c(bl5, n4, n5 != 0, n6 != 0, (Optional)object, (Vec3d)enumFacing);
                            return;
                        }
                        this.c = 4D.2;
                        return;
                    }
                    case 2: {
                        Entity entity = 4E.c.world.loadedEntityList.stream().filter(4E::0).filter(this::c).min(Comparator.comparing(4E::1)).orElse(null);
                        if (entity != null) {
                            if (((Boolean)this.b.6()).booleanValue() && 8E.c((EntityEnderCrystal)entity, (Entity)((Minecraft)4E.c).player) >= ((Minecraft)4E.c).player.getHealth() + ((Minecraft)4E.c).player.getAbsorptionAmount()) {
                                return;
                            }
                            this.0.c();
                            this.1.c();
                            this.1 = (Integer)this.6.6() * 10;
                            if (bl) {
                                float[] fArray = 8M.c(((Minecraft)4E.c).player.getPositionEyes(c.getRenderPartialTicks()), entity.getPositionVector());
                                8z_0.c(fArray[0], fArray[1]);
                            } else {
                                8k_0.c.c.c(entity.getPositionVector());
                            }
                            this.c = () -> this.2(entity);
                            break;
                        }
                        if (bl) {
                            float[] fArray = 8M.c(((Minecraft)4E.c).player.getPositionEyes(c.getRenderPartialTicks()), new Vec3d((double)this.c.getX() + 0.5, (double)this.c.getY(), (double)this.c.getZ() + 0.5));
                            8z_0.c(fArray[0], fArray[1]);
                            break;
                        }
                        8k_0.c.c.c((double)this.c.getX() + 0.5, this.c.getY(), (double)this.c.getZ() + 0.5);
                        break;
                    }
                }
                break block43;
            }
            this.c = 4D.c;
            int n7 = 4E.0();
            if (n7 == -1) {
                8p_0.c("No pistons found!");
                this.d();
                return;
            }
            int n8 = this.2();
            if (n8 == -1) {
                8p_0.c("No redstone found!");
                this.d();
                return;
            }
            List<EntityPlayer> list = this.4();
            block8: for (EntityPlayer entityPlayer : list) {
                Object object;
                if (((Boolean)this.2.6()).booleanValue() && !8r_0.1(new BlockPos((Entity)entityPlayer)) && ((Minecraft)4E.c).world.getBlockState(new BlockPos((Entity)entityPlayer)).getBlock() == Blocks.AIR) continue;
                BlockPos blockPos = new BlockPos((Entity)entityPlayer).up();
                if (((Boolean)this.b.6()).booleanValue() && blockPos.equals((Object)new BlockPos((Entity)((Minecraft)4E.c).player))) continue;
                for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                    if (!(((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockPistonBase) && (this.2.c((double)(8E.0() + 150)) || !blockPos.offset(enumFacing).equals((Object)this.3)) || ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing)).getBlock() instanceof BlockPistonBase && !(object = (EnumFacing)((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing)).getValue((IProperty)BlockDirectional.FACING)).equals((Object)enumFacing.getOpposite())) continue;
                    if (((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() == Blocks.REDSTONE_BLOCK || ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() == Blocks.REDSTONE_TORCH || !8L.c(blockPos.offset(enumFacing, 2), (Boolean)this.a.6()) || (object = 8L.0(blockPos.offset(enumFacing, 2), true, bl, (Boolean)this.a.6())) == null) break block8;
                    this.c = () -> this.c(n8, (8K)object);
                    return;
                }
                for (EnumFacing enumFacing : EnumFacing.HORIZONTALS) {
                    8K k2;
                    if (!8L.c(blockPos.offset(enumFacing), (Boolean)this.a.6()) || !((Boolean)this.a.6() != false ? 8L.c(blockPos.offset(enumFacing, 2), true) : ((Minecraft)4E.c).world.getBlockState(blockPos.offset(enumFacing, 2)).getBlock() == Blocks.AIR)) continue;
                    object = 8M.c(((Minecraft)4E.c).player.getPositionEyes(1.0f), new Vec3d((double)blockPos.offset(enumFacing).getX() + 0.5, (double)blockPos.offset(enumFacing).getY() + 1.0, (double)blockPos.offset(enumFacing).getZ() + 0.5));
                    EnumFacing enumFacing2 = EnumFacing.fromAngle((double)((double)object[0]));
                    if (Math.abs((float)object[1]) > 55.0f || enumFacing2 != enumFacing || (k2 = 8L.0(blockPos.offset(enumFacing), true, bl, (Boolean)this.a.6())) == null) continue;
                    this.c = () -> this.c(n7, k2, blockPos, enumFacing);
                    return;
                }
            }
        }
    }

    public void c(EnumFacing enumFacing) {
        4E.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, this.2, enumFacing));
        4E.c.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, this.2, enumFacing));
        this.c.c();
    }

    public boolean 1() {
        return this.1.6() == 4C.c;
    }

    public void c(int n2, 8K k2) {
        block2: {
            boolean bl = 4E.c.player.inventory.currentItem != n2;
            int n3 = 4E.c.player.inventory.currentItem;
            if (bl) {
                4E.c.player.inventory.currentItem = n2;
                4E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
            }
            8L.0(k2, EnumHand.MAIN_HAND, true);
            this.0.c();
            this.1 = 8E.0() + 150;
            if (bl) {
                4E.c.player.inventory.currentItem = n3;
                4E.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
            }
            if (!((Boolean)this.3.6()).booleanValue()) break block2;
            this.d();
        }
    }

    @Subscriber
    public void 0(0S s) {
        if (s.c() instanceof SPacketSoundEffect) {
            SPacketSoundEffect sPacketSoundEffect = (SPacketSoundEffect)s.c();
            if (this.0 == null) {
                return;
            }
            if (sPacketSoundEffect.getCategory() == SoundCategory.BLOCKS && sPacketSoundEffect.getSound() == SoundEvents.ENTITY_GENERIC_EXPLODE && this.0.up().getDistance((int)sPacketSoundEffect.getX(), (int)sPacketSoundEffect.getY(), (int)sPacketSoundEffect.getZ()) <= 2.0) {
                this.c = 4D.c;
                this.1 = 0;
            }
        }
    }
}

