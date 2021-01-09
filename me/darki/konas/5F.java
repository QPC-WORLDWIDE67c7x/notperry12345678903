/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.annotation.Nullable;
import me.darki.konas.0I;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.1P;
import me.darki.konas.1Q;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8h_0;
import me.darki.konas.8q_0;
import me.darki.konas.8r_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.ICPacketPlayer;
import me.darki.konas.mixin.mixins.IGuiEditSign;
import net.minecraft.block.BlockSign;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUpdateSign;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 5F
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Grass", true);
    public static 8h_0<Boolean> 2 = new 8h_0("AutoSign", true);
    public static 8h_0<Boolean> 3 = new 8h_0("SourceRemover", true);
    public static 8h_0<Boolean> 4 = new 8h_0("AutoSwitch", true);
    public static 8h_0<Integer> 5 = new 8h_0("PlaceDelay", 40, 100, 1, 1);
    public static 8h_0<Integer> 6 = new 8h_0("BreakDelay", 2, 20, 1, 1);
    public static 8h_0<Integer> 7 = new 8h_0("RangeXZ", 3, 10, 1, 1);
    public static 8h_0<Integer> 8 = new 8h_0("RangeY", 3, 10, 1, 1);
    public static 8h_0<Boolean> 9 = new 8h_0("Rotations", true);
    public ArrayList<BlockPos> 0;
    public ArrayList<BlockPos> 1;
    public static ArrayList<String> 2;
    public BlockPos c;
    public EnumFacing c;
    public int 1;
    public boolean 1;
    public float c;
    public float 0 = new ArrayList();
    public 9m c = null;

    public static Float 9(BlockPos blockPos) {
        return Float.valueOf(MathHelper.sqrt((double)5F.c.player.getDistanceSq(blockPos)));
    }

    public boolean 1(BlockPos blockPos) {
        return !this.0.contains(blockPos);
    }

    @Subscriber
    public void c(0T t) {
        block3: {
            if (5F.c.world == null || 5F.c.player == null) {
                return;
            }
            if (!(t.c() instanceof CPacketPlayer) || !this.1) break block3;
            CPacketPlayer cPacketPlayer = (CPacketPlayer)t.c();
            if (t.c() instanceof CPacketPlayer.Position) {
                t.c(true);
                5F.c.player.connection.sendPacket((Packet)new CPacketPlayer.PositionRotation(cPacketPlayer.getX(5F.c.player.posX), cPacketPlayer.getY(5F.c.player.posY), cPacketPlayer.getZ(5F.c.player.posZ), this.c, this.0, cPacketPlayer.isOnGround()));
            } else {
                ((ICPacketPlayer)cPacketPlayer).setYaw(this.c);
                ((ICPacketPlayer)cPacketPlayer).setPitch(this.0);
            }
        }
    }

    public 5F() {
        super("BlockAura", 3D.3, "Lawnmower", "LiquidRemover");
        this.1 = new ArrayList();
        this.c = new 9m();
        ((ArrayList)((Object)2)).add("Signed by <player>");
        ((ArrayList)((Object)2)).add("using Konas");
        ((ArrayList)((Object)2)).add("<date>");
    }

    @Subscriber
    public void c(1Q q) {
        block13: {
            block12: {
                if (!((Boolean)3.6()).booleanValue()) {
                    return;
                }
                if (!(q instanceof 1P)) break block12;
                this.c = null;
                this.c = null;
                int n2 = this.c();
                this.1 = -1;
                Iterable iterable = BlockPos.getAllInBox((BlockPos)5F.c.player.getPosition().add(-((Integer)7.6()).intValue(), -((Integer)8.6()).intValue(), -((Integer)7.6()).intValue()), (BlockPos)5F.c.player.getPosition().add(((Integer)7.6()).intValue(), ((Integer)8.6()).intValue(), ((Integer)7.6()).intValue()));
                BlockPos blockPos = StreamSupport.stream(iterable.spliterator(), false).filter(5F::c).filter(5F::3).min(Comparator.comparing(5F::b)).orElse(null);
                if (blockPos != null) {
                    if (5F.c.world.getBlockState(blockPos).getMaterial().isReplaceable()) {
                        Optional<8q_0> optional = 8r_0.0(blockPos);
                        this.1 = n2;
                        if (optional.isPresent()) {
                            this.c = optional.get().c;
                            this.c = optional.get().c;
                            double[] dArray = 8r_0.c(this.c.getX(), this.c.getY(), this.c.getZ(), this.c, (EntityPlayer)5F.c.player);
                            this.c = (float)dArray[0];
                            this.0 = (float)dArray[1];
                            this.1 = true;
                            return;
                        }
                    } else if (this.c.c((double)((Integer)5.6() * 10))) {
                        this.1 = false;
                        return;
                    }
                }
                break block13;
            }
            if (this.c == null || this.c == null || !this.c.c((double)((Integer)5.6() * 2)) || this.1 == -1) break block13;
            boolean bl = 5F.c.player.inventory.currentItem != this.1;
            boolean bl2 = 5F.c.player.isSprinting();
            int n3 = 5F.c.player.inventory.currentItem;
            boolean bl3 = 8r_0.7(this.c);
            if (bl) {
                5F.c.player.inventory.currentItem = this.1;
                5F.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
            }
            if (bl2) {
                5F.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)5F.c.player, CPacketEntityAction.Action.STOP_SPRINTING));
            }
            if (bl3) {
                5F.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)5F.c.player, CPacketEntityAction.Action.START_SNEAKING));
            }
            5F.c.playerController.processRightClickBlock(5F.c.player, 5F.c.world, this.c, this.c, new Vec3d((Vec3i)this.c).add(0.5, 0.5, 0.5).add(new Vec3d(this.c.getDirectionVec()).scale(0.5)), EnumHand.MAIN_HAND);
            5F.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
            if (bl3) {
                5F.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)5F.c.player, CPacketEntityAction.Action.STOP_SNEAKING));
            }
            if (bl2) {
                5F.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)5F.c.player, CPacketEntityAction.Action.START_SPRINTING));
            }
            if (bl) {
                5F.c.player.inventory.currentItem = n3;
                5F.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n3));
            }
            this.c.c();
        }
    }

    public void c(double d2, double d3, double d4, EntityPlayer entityPlayer) {
        double[] dArray = 8x_0.c(d2, d3, d4, entityPlayer);
        5F.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation((float)dArray[0], (float)dArray[1], false));
    }

    public static Float 4(BlockPos blockPos) {
        return Float.valueOf(MathHelper.sqrt((double)5F.c.player.getDistanceSq(blockPos)));
    }

    public static boolean 2(BlockPos blockPos) {
        return 5F.c.world.getBlockState(blockPos).getMaterial() == Material.VINE || 5F.c.world.getBlockState(blockPos).getMaterial() == Material.PLANTS;
    }

    public boolean 0(BlockPos blockPos) {
        return !this.7(blockPos);
    }

    public void 6(BlockPos blockPos) {
        if (((Boolean)9.6()).booleanValue()) {
            this.c((double)blockPos.getX() + 0.5, blockPos.getY(), (double)blockPos.getZ() + 0.5, (EntityPlayer)5F.c.player);
        }
        5F.c.playerController.clickBlock(blockPos, EnumFacing.UP);
        5F.c.player.swingArm(EnumHand.MAIN_HAND);
        this.0.remove(blockPos);
    }

    @Subscriber
    public void c(0I i2) {
        block1: {
            if (5F.c.world == null || 5F.c.player == null) {
                return;
            }
            if (!(i2.c() instanceof GuiEditSign) || !((Boolean)2.6()).booleanValue()) break block1;
            GuiEditSign guiEditSign = (GuiEditSign)i2.c();
            TileEntitySign tileEntitySign = ((IGuiEditSign)guiEditSign).getTileEntitySign();
            this.8(tileEntitySign.getPos());
            i2.c();
        }
    }

    public void 8(BlockPos blockPos) {
        ITextComponent[] iTextComponentArray = new ITextComponent[]{new TextComponentString(""), new TextComponentString(""), new TextComponentString(""), new TextComponentString("")};
        iTextComponentArray[0] = new TextComponentString(((String)((ArrayList)((Object)2)).get(0)).replaceAll("<player>", 5F.c.player.getName()).replaceAll("<date>", new SimpleDateFormat("dd/MM/yy").format(new Date())));
        iTextComponentArray[1] = new TextComponentString(((String)((ArrayList)((Object)2)).get(1)).replaceAll("<player>", 5F.c.player.getName()).replaceAll("<date>", new SimpleDateFormat("dd/MM/yy").format(new Date())));
        iTextComponentArray[2] = new TextComponentString(((String)((ArrayList)((Object)2)).get(2)).replaceAll("<player>", 5F.c.player.getName()).replaceAll("<date>", new SimpleDateFormat("dd/MM/yy").format(new Date())));
        iTextComponentArray[3] = new TextComponentString(((String)((ArrayList)((Object)2)).get(3)).replaceAll("<player>", 5F.c.player.getName()).replaceAll("<date>", new SimpleDateFormat("dd/MM/yy").format(new Date())));
        5F.c.player.connection.sendPacket((Packet)new CPacketUpdateSign(blockPos, iTextComponentArray));
    }

    public boolean 5(BlockPos blockPos) {
        return !((ArrayList)((Object)this.1)).contains(blockPos);
    }

    public boolean 7(BlockPos blockPos) {
        TileEntitySign tileEntitySign = (TileEntitySign)5F.c.world.getTileEntity(blockPos);
        if (tileEntitySign == null) {
            return false;
        }
        return tileEntitySign.signText[0].getUnformattedText().equals(((ArrayList)((Object)2)).get(0)) && tileEntitySign.signText[1].getUnformattedText().equals(((ArrayList)((Object)2)).get(1)) && tileEntitySign.signText[2].getUnformattedText().equals(((ArrayList)((Object)2)).get(2)) && tileEntitySign.signText[3].getUnformattedText().equals(((ArrayList)((Object)2)).get(3));
    }

    public static boolean 3(BlockPos blockPos) {
        return 5F.c.world.getBlockState(blockPos).getBlock().getMetaFromState(5F.c.world.getBlockState(blockPos)) == 0;
    }

    public int c() {
        ItemStack itemStack = 5F.c.player.getHeldItemMainhand();
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof ItemBlock) {
            return 5F.c.player.inventory.currentItem;
        }
        if (((Boolean)4.6()).booleanValue()) {
            for (int i2 = 0; i2 < 9; ++i2) {
                itemStack = 5F.c.player.inventory.getStackInSlot(i2);
                if (itemStack.isEmpty() || !(itemStack.getItem() instanceof ItemBlock)) continue;
                return i2;
            }
        }
        return -1;
    }

    public static boolean c(BlockPos blockPos) {
        return 5F.c.world.getBlockState(blockPos).getMaterial() == Material.WATER || 5F.c.world.getBlockState(blockPos).getMaterial() == Material.LAVA;
    }

    public static boolean a(BlockPos blockPos) {
        return 5F.c.world.getBlockState(blockPos).getBlock() instanceof BlockSign;
    }

    static {
        2 = new ArrayList();
    }

    @Subscriber
    public void c(1N n2) {
        block4: {
            if (5F.c.world == null || 5F.c.player == null) {
                return;
            }
            this.0.clear();
            Iterable iterable = BlockPos.getAllInBox((BlockPos)5F.c.player.getPosition().add(-((Integer)7.6()).intValue(), -((Integer)8.6()).intValue(), -((Integer)7.6()).intValue()), (BlockPos)5F.c.player.getPosition().add(((Integer)7.6()).intValue(), ((Integer)8.6()).intValue(), ((Integer)7.6()).intValue()));
            if (((Boolean)1.6()).booleanValue()) {
                this.0 = (ArrayList)StreamSupport.stream(iterable.spliterator(), false).filter(5F::2).filter(this::1).sorted(Comparator.comparing(5F::4)).collect(Collectors.toList());
                if (!this.0.isEmpty() && 5F.c.player.ticksExisted % (Integer)6.6() == 0) {
                    this.6(this.0.get(0));
                }
            }
            if (!((Boolean)2.6()).booleanValue()) break block4;
            this.1 = (ArrayList)StreamSupport.stream(iterable.spliterator(), false).filter(5F::a).filter(this::5).filter(this::0).sorted(Comparator.comparing(5F::9)).collect(Collectors.toList());
            if (!((ArrayList)((Object)this.1)).isEmpty() && 5F.c.player.ticksExisted % (Integer)6.6() == 0) {
                this.8((BlockPos)((ArrayList)((Object)this.1)).get(0));
            }
        }
    }

    public static boolean c(Iterator<?> iterator, @Nullable Object object) {
        if (object == null) {
            while (iterator.hasNext()) {
                if (iterator.next() != null) continue;
                return true;
            }
        } else {
            while (iterator.hasNext()) {
                if (!object.equals(iterator.next())) continue;
                return true;
            }
        }
        return false;
    }

    public static Float b(BlockPos blockPos) {
        return Float.valueOf(MathHelper.sqrt((double)5F.c.player.getDistanceSq(blockPos)));
    }
}

