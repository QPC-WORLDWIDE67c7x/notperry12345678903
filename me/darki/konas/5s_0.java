/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import me.darki.konas.14;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.5q_0;
import me.darki.konas.5r_0;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import me.darki.konas.8q_0;
import me.darki.konas.8r_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IGuiBrewingStand;
import net.minecraft.block.BlockBrewingStand;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from me.darki.konas.5s
 */
public class 5s_0
extends 3E {
    public static 8h_0<5r_0> 1 = new 8h_0("Type", 5r_0.a);
    public static 8h_0<5q_0> 2 = new 8h_0("Mod", 5q_0.c);
    public static 8h_0<Boolean> 3 = new 8h_0("AutoOpen", true);
    public static 8h_0<Boolean> 4 = new 8h_0("AutoClose", false);
    public static 8h_0<Boolean> 5 = new 8h_0("AutoPlace", false);
    public int 1;
    public boolean 1;
    public int 2;
    public 9m c = new 9m();
    public boolean 2 = false;
    public boolean 3 = false;

    @Subscriber
    public void c(14 var1_1) {
        if (((Minecraft)5s_0.c).player == null && ((Minecraft)5s_0.c).world == null) {
            this.d();
            return;
        }
        if (((Minecraft)5s_0.c).currentScreen instanceof GuiBrewingStand && 5s_0.c.player.openContainer instanceof ContainerBrewingStand) {
            GuiBrewingStand guiBrewingStand;
            ++this.2;
            if (!this.1) {
                this.1 = true;
                this.1 = -2;
                this.2 = 0;
            }
            if (((IGuiBrewingStand)(guiBrewingStand = (GuiBrewingStand)((Minecraft)5s_0.c).currentScreen)).getTileBrewingStand().getField(0) != 0 || this.2 < 5) {
                return;
            }
            if (this.1 == -2) {
                for (int i2 = 0; i2 < 3; ++i2) {
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, i2, 0, ClickType.QUICK_MOVE, (EntityPlayer)((Minecraft)5s_0.c).player);
                    if (((IGuiBrewingStand)guiBrewingStand).getTileBrewingStand().getStackInSlot(i2).isEmpty()) continue;
                    this.d();
                    return;
                }
                ++this.1;
                this.2 = 0;
            } else if (this.1 == -1) {
                for (int i3 = 0; i3 < 3; ++i3) {
                    int n2 = -1;
                    for (int i4 = 5; i4 < 5s_0.c.player.openContainer.getInventory().size(); ++i4) {
                        if (!(((ItemStack)5s_0.c.player.openContainer.getInventory().get(i4)).getItem() instanceof ItemPotion) || !PotionUtils.getPotionFromItem((ItemStack)((ItemStack)5s_0.c.player.openContainer.getInventory().get(i4))).getNamePrefixed("").equalsIgnoreCase("water")) continue;
                        n2 = i4;
                        break;
                    }
                    if (n2 == -1) {
                        8p_0.1("No water bottles found!");
                        this.d();
                        return;
                    }
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, i3, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                }
                ++this.1;
                this.2 = 0;
            } else if (this.1 < ((5r_0)5s_0.1.6()).c.length) {
                if (((ItemStack)5s_0.c.player.openContainer.getInventory().get(4)).isEmpty()) {
                    int n3 = -1;
                    for (int i5 = 5; i5 < 5s_0.c.player.openContainer.getInventory().size(); ++i5) {
                        if (((ItemStack)5s_0.c.player.openContainer.getInventory().get(i5)).getItem() != Items.BLAZE_POWDER) continue;
                        n3 = i5;
                        break;
                    }
                    if (n3 == -1) {
                        8p_0.1("No blaze powder found!");
                        this.d();
                        return;
                    }
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, n3, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, 4, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                    this.2 = 0;
                    return;
                }
                Item item = ((5r_0)5s_0.1.6()).c[this.1];
                int n4 = -69;
                for (int i6 = 5; i6 < 5s_0.c.player.openContainer.getInventory().size(); ++i6) {
                    if (!((ItemStack)5s_0.c.player.openContainer.getInventory().get(i6)).getItem().equals(item)) continue;
                    n4 = i6;
                    break;
                }
                if (n4 == -69) {
                    8p_0.1("You don't have ingredients left");
                    this.d();
                    return;
                }
                ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, n4, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, 3, 1, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, n4, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                ++this.1;
                this.2 = 0;
            } else if (this.1 == ((5r_0)5s_0.1.6()).c.length) {
                if (2.6() != 5q_0.c) {
                    Item item = 2.6() == 5q_0.0 ? Items.GUNPOWDER : Items.DRAGON_BREATH;
                    int n5 = -1;
                    for (int i7 = 5; i7 < 5s_0.c.player.openContainer.getInventory().size(); ++i7) {
                        if (((ItemStack)5s_0.c.player.openContainer.getInventory().get(i7)).getItem() != item) continue;
                        n5 = i7;
                        break;
                    }
                    if (n5 == -1) {
                        8p_0.1("You don't have your modifier");
                        this.d();
                        return;
                    }
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, n5, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, 3, 1, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                    ((Minecraft)5s_0.c).playerController.windowClick(5s_0.c.player.openContainer.windowId, n5, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)5s_0.c).player);
                }
                ++this.1;
                this.2 = 0;
            } else {
                this.1 = -1;
                this.2 = 0;
            }
        } else {
            this.1 = false;
            if (((Boolean)3.6()).booleanValue() && !this.2 && this.c.c(150.0)) {
                this.c.c();
                List<BlockPos> list = 8r_0.c(((Minecraft)5s_0.c).player.getPosition(), 4);
                BlockPos blockPos = list.stream().filter(5s_0::0).min(Comparator.comparing(5s_0::c)).orElse(null);
                if (blockPos != null) {
                    8x_0.c(new Vec3d((double)blockPos.getX(), (double)blockPos.getY() + 0.5, (double)blockPos.getZ()));
                    ((Minecraft)5s_0.c).playerController.processRightClickBlock(((Minecraft)5s_0.c).player, ((Minecraft)5s_0.c).world, blockPos, EnumFacing.UP, new Vec3d((double)blockPos.getX(), (double)blockPos.getY() + 0.5, (double)blockPos.getZ()), EnumHand.MAIN_HAND);
                    ((Minecraft)5s_0.c).player.swingArm(EnumHand.MAIN_HAND);
                    this.2 = true;
                } else if (((Boolean)5.6()).booleanValue() && !this.3) {
                    int n6 = this.c();
                    if (n6 == -1) {
                        8p_0.1("You don't have a brewing stand");
                        this.d();
                        return;
                    }
                    for (BlockPos blockPos2 : list) {
                        Optional<8q_0> optional = 8r_0.0(blockPos2);
                        if (!optional.isPresent()) continue;
                        5s_0.c.player.inventory.currentItem = n6;
                        ((Minecraft)5s_0.c).playerController.updateController();
                        BlockPos blockPos3 = optional.get().c;
                        EnumFacing enumFacing = optional.get().c;
                        double[] dArray = 8r_0.c(blockPos3.getX(), blockPos3.getY(), blockPos3.getZ(), enumFacing, (EntityPlayer)((Minecraft)5s_0.c).player);
                        5s_0.c.player.connection.sendPacket((Packet)new CPacketPlayer.Rotation((float)dArray[0], (float)dArray[1], 5s_0.c.player.onGround));
                        boolean bl = ((Minecraft)5s_0.c).player.isSprinting();
                        boolean bl2 = 8r_0.7(blockPos3);
                        if (bl) {
                            5s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)5s_0.c).player, CPacketEntityAction.Action.STOP_SPRINTING));
                        }
                        if (bl2) {
                            5s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)5s_0.c).player, CPacketEntityAction.Action.START_SNEAKING));
                        }
                        ((Minecraft)5s_0.c).playerController.processRightClickBlock(((Minecraft)5s_0.c).player, ((Minecraft)5s_0.c).world, blockPos3, enumFacing, new Vec3d((Vec3i)blockPos3).add(0.5, 0.5, 0.5).add(new Vec3d(enumFacing.getDirectionVec()).scale(0.5)), EnumHand.MAIN_HAND);
                        5s_0.c.player.connection.sendPacket((Packet)new CPacketAnimation(EnumHand.MAIN_HAND));
                        if (bl2) {
                            5s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)5s_0.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
                        }
                        if (bl) {
                            5s_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)5s_0.c).player, CPacketEntityAction.Action.START_SPRINTING));
                        }
                        this.3 = true;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void 7() {
        block0: {
            if (((Minecraft)5s_0.c).player == null || ((Minecraft)5s_0.c).world == null || !((Boolean)4.6()).booleanValue() || !(((Minecraft)5s_0.c).currentScreen instanceof GuiBrewingStand)) break block0;
            ((Minecraft)5s_0.c).player.closeScreen();
        }
    }

    @Override
    public void c() {
        this.1 = false;
        this.2 = false;
        this.3 = false;
    }

    public 5s_0() {
        super("AutoBrew", 3D.3, new String[0]);
    }

    public int c() {
        ItemStack itemStack = ((Minecraft)5s_0.c).player.getHeldItemMainhand();
        if (!itemStack.isEmpty() && itemStack.getItem() == Items.BREWING_STAND) {
            return 5s_0.c.player.inventory.currentItem;
        }
        for (int i2 = 0; i2 < 9; ++i2) {
            itemStack = 5s_0.c.player.inventory.getStackInSlot(i2);
            if (itemStack.isEmpty() || itemStack.getItem() != Items.BREWING_STAND) continue;
            return i2;
        }
        return -1;
    }

    public static boolean 0(BlockPos blockPos) {
        return ((Minecraft)5s_0.c).world.getBlockState(blockPos).getBlock() instanceof BlockBrewingStand;
    }

    public static Double c(BlockPos blockPos) {
        return ((Minecraft)5s_0.c).player.getDistanceSq(blockPos);
    }
}

