/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.google.common.collect.Lists;
import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.StreamSupport;
import me.darki.konas.0S;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4r_0;
import me.darki.konas.54;
import me.darki.konas.88;
import me.darki.konas.8E;
import me.darki.konas.8J;
import me.darki.konas.8K;
import me.darki.konas.8L;
import me.darki.konas.8Z;
import me.darki.konas.8h_0;
import me.darki.konas.8r_0;
import me.darki.konas.8u_0;
import me.darki.konas.mixin.mixins.IEntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.4s
 */
public class 4s_0
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Rotate", true);
    public static 8h_0<Boolean> 2 = new 8h_0("Swing", true);
    public static 8h_0<Double> 3 = new 8h_0("Range", 5.0, 6.0, 1.0, 0.1);
    public static 8h_0<Boolean> 4 = new 8h_0("StrictDirection", false);
    public static 8h_0<Integer> 5 = new 8h_0("ActionShift", 1, 3, 1, 1);
    public static 8h_0<Integer> 6 = new 8h_0("ActionInterval", 0, 5, 0, 1);
    public static 8h_0<Boolean> 7 = new 8h_0("RayTrace", false);
    public static 8h_0<Boolean> 8 = new 8h_0("Double", false);
    public static 8h_0<Boolean> 9 = new 8h_0("JumpDisable", false);
    public static 8h_0<Boolean> a = new 8h_0("Filter", false);
    public static 8h_0<88> b = new 8h_0("ValidBlocks", new 88(new String[0]));
    public static 8h_0<4r_0> d = new 8h_0("Smart", 4r_0.0);
    public static 8h_0<Double> e = new 8h_0("EnemyRange", 10.0, 15.0, 1.0, 0.5);
    public static 8h_0<Boolean> f = new 8h_0("DisableWhenNone", false);
    public Map<BlockPos, Long> c;
    public 8K c = null;
    public int 1;
    public ArrayList<BlockPos> 0;
    public Map<BlockPos, Long> 0 = new ConcurrentHashMap();
    public int 2 = 0;

    public static boolean 2(EntityPlayer entityPlayer) {
        return (double)((Minecraft)4s_0.c).player.getDistance((Entity)entityPlayer) < (Double)e.6();
    }

    public static boolean c(BlockPos blockPos) {
        return 8L.c(blockPos, (Boolean)4.6(), (Boolean)7.6(), true);
    }

    public static Float c(EntityPlayer entityPlayer, BlockPos blockPos) {
        return Float.valueOf(d.6() != 4r_0.c && entityPlayer != null ? MathHelper.sqrt((double)((Minecraft)4s_0.c).player.getDistanceSq((Entity)entityPlayer)) : MathHelper.sqrt((double)((Minecraft)4s_0.c).player.getDistanceSq(blockPos)));
    }

    public void c(int n2, BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > (long)(n2 + 100)) {
            this.0.remove(blockPos);
        }
    }

    public boolean c(Item item) {
        if (item instanceof ItemBlock) {
            if (((Boolean)a.6()).booleanValue()) {
                return ((88)b.6()).0().contains(((ItemBlock)item).getBlock());
            }
            return true;
        }
        return false;
    }

    @Subscriber(priority=60)
    public void c(1P p2) {
        block8: {
            block7: {
                this.c = null;
                if (((Boolean)9.6()).booleanValue() && 4s_0.c.player.prevPosY < 4s_0.c.player.posY) {
                    this.d();
                }
                if (p2.0() || !8L.c((Boolean)1.6())) {
                    return;
                }
                if (3F.c(54.class).f()) {
                    return;
                }
                if (this.2 < (Integer)6.6()) {
                    ++this.2;
                }
                if (this.2 < (Integer)6.6()) {
                    return;
                }
                int n2 = this.0();
                this.1 = -1;
                if (n2 == -1) {
                    return;
                }
                this.0 = Lists.newArrayList((Iterable)BlockPos.getAllInBox((BlockPos)((Minecraft)4s_0.c).player.getPosition().add(-((Double)3.6()).doubleValue(), -((Double)3.6()).doubleValue(), -((Double)3.6()).doubleValue()), (BlockPos)((Minecraft)4s_0.c).player.getPosition().add(((Double)3.6()).doubleValue(), ((Double)3.6()).doubleValue(), ((Double)3.6()).doubleValue())));
                int n3 = 8E.0();
                this.0.forEach((arg_0, arg_1) -> this.c(n3, arg_0, arg_1));
                if (d.6() == 4r_0.1 && this.c() == null) {
                    return;
                }
                BlockPos blockPos = StreamSupport.stream(this.0.spliterator(), false).filter(this::0).filter(4s_0::1).filter(4s_0::c).min(Comparator.comparing(4s_0::2)).orElse(null);
                if (blockPos == null) break block7;
                this.c = 8L.c(blockPos, (Boolean)1.6(), false, (Boolean)4.6(), (Boolean)7.6());
                if (this.c == null) break block8;
                this.2 = 0;
                this.1 = n2;
                this.c.put(blockPos, System.currentTimeMillis());
                this.0.put(blockPos, System.currentTimeMillis());
                break block8;
            }
            if (!((Boolean)f.6()).booleanValue()) break block8;
            this.d();
        }
    }

    public static boolean 1(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)4s_0.c).player;
    }

    public EntityPlayer c() {
        return 4s_0.c.world.playerEntities.stream().filter(4s_0::1).filter(4s_0::0).filter(4s_0::c).filter(4s_0::2).min(Comparator.comparing(4s_0::3)).orElse(null);
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    public void c(BlockPos blockPos, Long l2) {
        if (System.currentTimeMillis() - l2 > 1000L) {
            this.c.remove(blockPos);
        } else {
            8Z.c(blockPos);
        }
    }

    public static boolean 1(BlockPos blockPos) {
        return ((Minecraft)4s_0.c).player.getDistance((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.5, (double)blockPos.getZ() + 0.5) <= (Double)3.6();
    }

    public static Float 2(BlockPos blockPos) {
        return Float.valueOf(MathHelper.sqrt((double)((Minecraft)4s_0.c).player.getDistanceSq(blockPos)));
    }

    @Override
    public void c() {
        if (((Minecraft)4s_0.c).player == null || ((Minecraft)4s_0.c).world == null) {
            this.d();
            return;
        }
        this.0 = Lists.newArrayList((Iterable)BlockPos.getAllInBox((BlockPos)((Minecraft)4s_0.c).player.getPosition().add(-((Double)3.6()).doubleValue(), -((Double)3.6()).doubleValue(), -((Double)3.6()).doubleValue()), (BlockPos)((Minecraft)4s_0.c).player.getPosition().add(((Double)3.6()).doubleValue(), ((Double)3.6()).doubleValue(), ((Double)3.6()).doubleValue())));
        this.2 = (Integer)6.6();
    }

    @Subscriber
    public void c(1b_0 b_02) {
        if (((Minecraft)4s_0.c).world == null || ((Minecraft)4s_0.c).player == null) {
            return;
        }
        this.c.forEach(this::c);
    }

    public static boolean c(EntityPlayer entityPlayer) {
        return !8J.2(entityPlayer.getUniqueID().toString());
    }

    public 4s_0() {
        super("HoleFill", 3D.c, new String[0]);
    }

    public int 0() {
        ItemStack itemStack = ((Minecraft)4s_0.c).player.getHeldItemMainhand();
        if (!itemStack.isEmpty() && this.c(itemStack.getItem())) {
            return 4s_0.c.player.inventory.currentItem;
        }
        for (int i2 = 0; i2 < 9; ++i2) {
            itemStack = 4s_0.c.player.inventory.getStackInSlot(i2);
            if (itemStack.isEmpty() || !this.c(itemStack.getItem())) continue;
            return i2;
        }
        return -1;
    }

    @Subscriber(priority=15)
    public void c(1O o2) {
        block7: {
            if (this.c == null || this.1 == -1) break block7;
            boolean bl = 4s_0.c.player.inventory.currentItem != this.1;
            int n2 = 4s_0.c.player.inventory.currentItem;
            if (bl) {
                4s_0.c.player.inventory.currentItem = this.1;
                4s_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            }
            boolean bl2 = ((Minecraft)4s_0.c).player.isSprinting();
            boolean bl3 = 8r_0.7(this.c.3());
            if (bl2) {
                4s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4s_0.c).player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                4s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4s_0.c).player, CPacketEntityAction.Action.START_SNEAKING));
            }
            Vec3d vec3d = new Vec3d((Vec3i)this.c.3()).add(0.5, 0.5, 0.5).add(new Vec3d(this.c.c().getDirectionVec()).scale(0.5));
            8L.c(this.c.3(), vec3d, EnumHand.MAIN_HAND, this.c.c(), true, (Boolean)2.6());
            double d2 = 4s_0.c.player.posX - ((IEntityPlayerSP)((Minecraft)4s_0.c).player).getLastReportedPosX();
            double d3 = 4s_0.c.player.posY - ((IEntityPlayerSP)((Minecraft)4s_0.c).player).getLastReportedPosY();
            double d4 = 4s_0.c.player.posZ - ((IEntityPlayerSP)((Minecraft)4s_0.c).player).getLastReportedPosZ();
            boolean bl4 = d2 * d2 + d3 * d3 + d4 * d4 > 9.0E-4;
            for (int i2 = 0; i2 < (Integer)5.6() - 1 && !bl4; ++i2) {
                8K k2;
                EntityPlayer entityPlayer = this.c();
                BlockPos blockPos = StreamSupport.stream(this.0.spliterator(), false).filter(this::0).min(Comparator.comparing(arg_0 -> 4s_0.c(entityPlayer, arg_0))).orElse(null);
                if (blockPos == null || !8L.c(blockPos, (Boolean)4.6()) || (k2 = 8L.0(blockPos, (Boolean)1.6(), true, (Boolean)4.6())) == null) break;
                Vec3d vec3d2 = new Vec3d((Vec3i)k2.3()).add(0.5, 0.5, 0.5).add(new Vec3d(k2.c().getDirectionVec()).scale(0.5));
                8L.c(k2.3(), vec3d2, EnumHand.MAIN_HAND, k2.c(), true, (Boolean)2.6());
                this.0.put(blockPos, System.currentTimeMillis());
                this.c.put(blockPos, System.currentTimeMillis());
            }
            if (bl3) {
                4s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4s_0.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl2) {
                4s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4s_0.c).player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl) {
                4s_0.c.player.inventory.currentItem = n2;
                4s_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
            }
        }
    }

    @Subscriber
    public void c(0S s) {
        if (s.c() instanceof SPacketBlockChange && this.c.containsKey(((SPacketBlockChange)s.c()).getBlockPosition()) && ((SPacketBlockChange)s.c()).getBlockState().getBlock() != Blocks.AIR) {
            this.c.remove(((SPacketBlockChange)s.c()).getBlockPosition());
        }
    }

    public static Float 3(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)4s_0.c).player.getDistance((Entity)entityPlayer));
    }

    public boolean 0(BlockPos blockPos) {
        if (this.0.containsKey(blockPos)) {
            return false;
        }
        for (Entity entity : ((Minecraft)4s_0.c).world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos))) {
            if (entity instanceof EntityItem || entity instanceof EntityXPOrb || entity instanceof EntityArrow) continue;
            return false;
        }
        if (((Boolean)8.6()).booleanValue()) {
            BlockPos blockPos2 = 8r_0.3(blockPos);
            if (blockPos2 == null) {
                blockPos2 = 8r_0.6(blockPos);
            }
            if (blockPos2 != null) {
                return true;
            }
        }
        return 8r_0.1(blockPos);
    }
}

