/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import me.darki.konas.1N;
import me.darki.konas.1b_0;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.42;
import me.darki.konas.89;
import me.darki.konas.8J;
import me.darki.konas.8h_0;
import me.darki.konas.8r_0;
import me.darki.konas.8y_0;
import me.darki.konas.99;
import me.darki.konas.9j;
import me.darki.konas.9m;
import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 43
extends 3E {
    public static 8h_0<Double> 1 = new 8h_0("PlayerRange", 6.0, 10.0, 1.0, 0.1);
    public static 8h_0<Double> 2 = new 8h_0("AttackRange", 3.6, 10.0, 1.0, 0.1);
    public static 8h_0<Boolean> 3 = new 8h_0("ArmorCheck", false);
    public static 8h_0<Boolean> 4 = new 8h_0("BlockShulker", false);
    public static 8h_0<Boolean> 5 = new 8h_0("KillAura", true);
    public static 8h_0<42> 6 = new 8h_0("Mode", 42.c);
    public static 8h_0<Double> 7 = new 8h_0("Delay", 0.02, 1.0, 0.01, 0.1);
    public static 8h_0<Integer> 8 = new 8h_0("Ticks", 3, 20, 0, 1);
    public static 8h_0<Boolean> 9 = new 8h_0("Friends", false);
    public static 8h_0<Boolean> a = new 8h_0("Walls", true);
    public static 8h_0<Boolean> b = new 8h_0("RangeCircles", false);
    public static 8h_0<Boolean> d = new 8h_0("Combine", false).c(b::6);
    public static 8h_0<Float> e = new 8h_0("Width", Float.valueOf(2.5f), Float.valueOf(5.0f), Float.valueOf(0.1f), Float.valueOf(0.1f)).c(b::6);
    public static 8h_0<89> f = new 8h_0("Color", new 89(-65536)).c(b::6);
    public boolean 1;
    public int 1;
    public EntityPlayer c;
    public BlockPos c;
    public BlockPos 0;
    public boolean 2;
    public int 2;
    public int 3;
    public int 4;
    public 9m c = new 9m();

    @Subscriber
    public void c(1N n2) {
        int n3;
        int n4;
        if (43.c.player == null || 43.c.world == null) {
            return;
        }
        this.c = this.c(this.c(false));
        if (!this.1) {
            this.2 = 43.c((Block)Blocks.HOPPER);
            this.3 = this.1();
            n4 = 43.c(Blocks.DISPENSER);
            n3 = 43.c(Blocks.REDSTONE_BLOCK);
            this.4 = 43.c(Blocks.OBSIDIAN);
            if (this.2 == -1 || this.3 == -1 || n4 == -1 || n3 == -1 || this.4 == -1) {
                return;
            }
            if (this.c == null) {
                this.c((EntityLivingBase)43.c.player, n4, n3, this.4);
            } else {
                this.c((EntityLivingBase)this.c, n4, n3, this.4);
            }
            this.1 = true;
        }
        if (43.c.currentScreen instanceof GuiDispenser) {
            EnumFacing enumFacing = 43.c(this.0);
            if (!(((Slot)43.c.player.openContainer.inventorySlots.get((int)0)).inventory.getStackInSlot(0).getItem() instanceof ItemShulkerBox)) {
                if (43.c.world.getBlockState(this.c.up()).getBlock() instanceof BlockShulkerBox) {
                    BlockPos blockPos = this.0.offset(enumFacing).offset(enumFacing);
                    if (((Boolean)4.6()).booleanValue() && Blocks.OBSIDIAN.canPlaceBlockAt((World)43.c.world, blockPos) && 43.c.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos)).isEmpty()) {
                        8y_0.c(blockPos);
                    }
                    43.c.player.inventory.currentItem = this.2;
                    8y_0.c(this.c);
                    43.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(this.c, EnumFacing.UP, EnumHand.MAIN_HAND, 0.5f, 0.5f, 0.5f));
                } else {
                    43.c.playerController.windowClick(43.c.player.openContainer.windowId, 0, this.3, ClickType.SWAP, (EntityPlayer)43.c.player);
                }
            } else if (!this.2) {
                EnumFacing enumFacing2 = this.c(this.0, enumFacing);
                8y_0.c(this.0.offset(enumFacing2));
                43.c.player.inventory.currentItem = this.4;
                this.2 = true;
            }
        }
        if (!this.c(43.c.player.getHeldItemMainhand()) && 43.c.currentScreen instanceof GuiHopper) {
            n4 = 43.c(Items.AIR) == -1 ? 43.c.player.inventory.currentItem : 43.c(Items.AIR);
            for (n3 = 0; n3 < 5; ++n3) {
                if (!this.c(((Slot)43.c.player.openContainer.inventorySlots.get((int)0)).inventory.getStackInSlot(n3))) continue;
                43.c.playerController.windowClick(43.c.player.openContainer.windowId, n3, n4, ClickType.SWAP, (EntityPlayer)43.c.player);
                43.c.player.inventory.currentItem = n4;
                break;
            }
        }
        if (((Boolean)5.6()).booleanValue() && this.c(43.c.player.getHeldItemMainhand()) && this.c != null && 6.6() == 42.c && this.1 >= (Integer)8.6() && (double)43.c.player.getDistance((Entity)this.c) <= (Double)2.6()) {
            43.c.playerController.attackEntity((EntityPlayer)43.c.player, (Entity)this.c);
            43.c.player.swingArm(EnumHand.MAIN_HAND);
            this.1 = 0;
        }
        ++this.1;
    }

    public 43() {
        super("Auto32k", "Automatically kills someone using 32k weapons", 3D.c, new String[0]);
    }

    public void c(EntityLivingBase entityLivingBase, int n2, int n3, int n4) {
        BlockPos blockPos;
        BlockPos blockPos2 = blockPos = 43.c.player == entityLivingBase ? this.0() : this.c(entityLivingBase);
        if (blockPos == null) {
            return;
        }
        this.0 = blockPos.up();
        EnumFacing enumFacing = 43.c(this.0);
        this.c = blockPos.offset(enumFacing);
        43.c.player.inventory.currentItem = n4;
        8y_0.c(blockPos);
        43.c.player.inventory.currentItem = n2;
        8y_0.c(this.0);
        43.c.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItemOnBlock(this.0, EnumFacing.UP, EnumHand.MAIN_HAND, 0.5f, 0.5f, 0.5f));
        43.c.player.inventory.currentItem = n3;
    }

    public void c(Entity entity, 1b_0 b_02) {
        int n2;
        99.c();
        IRenderManager iRenderManager = (IRenderManager)c.getRenderManager();
        float[] fArray = Color.RGBtoHSB(((89)f.6()).6(), ((89)f.6()).5(), ((89)f.6()).2(), null);
        float f2 = (float)(System.currentTimeMillis() % 7200L) / 7200.0f;
        int n3 = Color.getHSBColor(f2, fArray[1], fArray[2]).getRGB();
        ArrayList<Vec3d> arrayList = new ArrayList<Vec3d>();
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)b_02.c() - iRenderManager.getRenderPosX();
        double d3 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)b_02.c() - iRenderManager.getRenderPosY();
        double d4 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)b_02.c() - iRenderManager.getRenderPosZ();
        GL11.glLineWidth((float)((Float)e.6()).floatValue());
        GL11.glBegin((int)1);
        for (n2 = 0; n2 <= 360; ++n2) {
            Vec3d vec3d = new Vec3d(d2 + Math.sin((double)n2 * Math.PI / 180.0) * (Double)2.6(), d3 + 0.01, d4 + Math.cos((double)n2 * Math.PI / 180.0) * (Double)2.6());
            arrayList.add(vec3d);
        }
        for (n2 = 0; n2 < arrayList.size() - 1; ++n2) {
            int n4 = n3 >> 24 & 0xFF;
            int n5 = n3 >> 16 & 0xFF;
            int n6 = n3 >> 8 & 0xFF;
            int n7 = n3 & 0xFF;
            if (((89)f.6()).7()) {
                GL11.glColor4f((float)((float)n5 / 255.0f), (float)((float)n6 / 255.0f), (float)((float)n7 / 255.0f), (float)((float)n4 / 255.0f));
            } else {
                GL11.glColor4f((float)((float)((89)f.6()).6() / 255.0f), (float)((float)((89)f.6()).5() / 255.0f), (float)((float)((89)f.6()).2() / 255.0f), (float)((float)((89)f.6()).1() / 255.0f));
            }
            if (!((Boolean)d.6()).booleanValue() || this.c(entity, ((Vec3d)arrayList.get((int)n2)).x + iRenderManager.getRenderPosX(), entity.posY, ((Vec3d)arrayList.get((int)n2)).z + iRenderManager.getRenderPosZ())) {
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)n2)).x, (double)((Vec3d)arrayList.get((int)n2)).y, (double)((Vec3d)arrayList.get((int)n2)).z);
                GL11.glVertex3d((double)((Vec3d)arrayList.get((int)(n2 + 1))).x, (double)((Vec3d)arrayList.get((int)(n2 + 1))).y, (double)((Vec3d)arrayList.get((int)(n2 + 1))).z);
            }
            n3 = Color.getHSBColor(f2 += 0.0027777778f, fArray[1], fArray[2]).getRGB();
        }
        GL11.glEnd();
        99.0();
    }

    public List<EntityPlayer> c(boolean bl) {
        ArrayList<EntityPlayer> arrayList = new ArrayList<EntityPlayer>();
        for (Entity entity : 43.c.world.loadedEntityList) {
            if (entity == null || !(entity instanceof EntityPlayer)) continue;
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            if ((double)43.c.player.getDistance((Entity)entityPlayer) > (bl ? (Double)1.6() * 4.0 : (Double)1.6()) || entityPlayer == 43.c.player || !((Boolean)a.6()).booleanValue() && !43.c.player.canEntityBeSeen((Entity)entityPlayer) && !43.c((Entity)entityPlayer) || entityPlayer.getHealth() <= 0.0f || entityPlayer.isDead || !((Boolean)9.6()).booleanValue() && 8J.1(entityPlayer.getName())) continue;
            arrayList.add(entityPlayer);
        }
        return arrayList;
    }

    @Override
    public void c() {
        this.2 = false;
        this.1 = 0;
        this.1 = false;
    }

    public static int c(Block block) {
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemBlock itemBlock;
            ItemStack itemStack = 43.c.player.inventory.getStackInSlot(i2);
            if (!(itemStack.getItem() instanceof ItemBlock) || (itemBlock = (ItemBlock)itemStack.getItem()).getBlock() != block) continue;
            return i2;
        }
        return -1;
    }

    @Subscriber
    public void c(1b_0 b_02) {
        block2: {
            if (43.c.player == null || 43.c.world == null) {
                return;
            }
            if (!((Boolean)b.6()).booleanValue()) break block2;
            for (Entity entity : this.c(true)) {
                this.c(entity, b_02);
            }
            this.c((Entity)43.c.player, b_02);
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    public EntityPlayer c(List<EntityPlayer> list) {
        EntityPlayer entityPlayer = null;
        double d2 = (Double)1.6();
        for (EntityPlayer entityPlayer2 : list) {
            block17: {
                if (((Boolean)3.6()).booleanValue() && entityPlayer != null) {
                    EntityPlayer entityPlayer3 = entityPlayer;
                    EntityEquipmentSlot entityEquipmentSlot = EntityEquipmentSlot.HEAD;
                    ItemStack itemStack = entityPlayer3.getItemStackFromSlot(entityEquipmentSlot);
                    Item item = itemStack.getItem();
                    if (item == Items.DIAMOND_HELMET) break block17;
                    EntityPlayer entityPlayer4 = entityPlayer;
                    EntityEquipmentSlot entityEquipmentSlot2 = EntityEquipmentSlot.LEGS;
                    ItemStack itemStack2 = entityPlayer4.getItemStackFromSlot(entityEquipmentSlot2);
                    Item item2 = itemStack2.getItem();
                    if (item2 == Items.DIAMOND_LEGGINGS) break block17;
                    EntityPlayer entityPlayer5 = entityPlayer;
                    EntityEquipmentSlot entityEquipmentSlot3 = EntityEquipmentSlot.FEET;
                    ItemStack itemStack3 = entityPlayer5.getItemStackFromSlot(entityEquipmentSlot3);
                    Item item3 = itemStack3.getItem();
                    try {
                        if (item3 != Items.DIAMOND_BOOTS) {
                            continue;
                        }
                    }
                    catch (NullPointerException nullPointerException) {
                        System.out.println("Failed getting armor info fromt target");
                    }
                }
            }
            if (!((double)43.c.player.getDistance((Entity)entityPlayer2) < d2)) continue;
            d2 = 43.c.player.getDistance((Entity)entityPlayer2);
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public static int c(Item item) {
        for (int i2 = 0; i2 < 9; ++i2) {
            Item item2 = 43.c.player.inventory.getStackInSlot(i2).getItem();
            if (item2 != item) continue;
            return i2;
        }
        return -1;
    }

    public int 1() {
        for (int i2 = 0; i2 < 9; ++i2) {
            ItemStack itemStack = 43.c.player.inventory.getStackInSlot(i2);
            if (!(itemStack.getItem() instanceof ItemShulkerBox)) continue;
            return i2;
        }
        return -1;
    }

    public List<BlockPos> c() {
        if (43.c.player == null) {
            return null;
        }
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        for (BlockPos blockPos : 8r_0.c(new BlockPos((Entity)43.c.player), 3)) {
            EnumFacing enumFacing = 43.c(blockPos.up());
            if (enumFacing == null || enumFacing == EnumFacing.DOWN || enumFacing == EnumFacing.UP || !8y_0.c(blockPos, Blocks.OBSIDIAN, true) || !Blocks.DISPENSER.canPlaceBlockAt((World)43.c.world, blockPos.up()) || !43.c.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos.up())).isEmpty() || this.c(blockPos.up(), enumFacing) == null || !Blocks.HOPPER.canPlaceBlockAt((World)43.c.world, blockPos.offset(enumFacing)) || !43.c.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos.offset(enumFacing))).isEmpty() || !Blocks.SILVER_SHULKER_BOX.canPlaceBlockAt((World)43.c.world, blockPos.offset(enumFacing).up()) || !43.c.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos.offset(enumFacing).up())).isEmpty()) continue;
            arrayList.add(blockPos);
        }
        return arrayList;
    }

    public static boolean c(Entity entity) {
        return 43.c.world.rayTraceBlocks(new Vec3d(43.c.player.posX, 43.c.player.posX + (double)43.c.player.getEyeHeight(), 43.c.player.posZ), new Vec3d(entity.posX, entity.posY, entity.posZ), false, true, false) == null;
    }

    public static EnumFacing c(BlockPos blockPos) {
        Vec3d vec3d = new Vec3d(43.c.player.posX, 43.c.player.posY + (double)43.c.player.getEyeHeight(), 43.c.player.posZ);
        Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5).add(new Vec3d(EnumFacing.DOWN.getDirectionVec()).scale(0.5));
        double d2 = vec3d2.x - vec3d.x;
        double d3 = vec3d2.z - vec3d.z;
        float f2 = (float)Math.toDegrees(Math.atan2(d3, d2)) - 90.0f;
        float f3 = 43.c.player.rotationYaw + MathHelper.wrapDegrees((float)(f2 - 43.c.player.rotationYaw));
        if (Math.abs(43.c.player.posX - (double)((float)blockPos.getX() + 0.5f)) < 2.0 && Math.abs(43.c.player.posZ - (double)((float)blockPos.getZ() + 0.5f)) < 2.0) {
            double d4 = 43.c.player.posY + (double)43.c.player.getEyeHeight();
            if (d4 - (double)blockPos.getY() > 2.0) {
                return EnumFacing.UP;
            }
            if ((double)blockPos.getY() - d4 > 0.0) {
                return EnumFacing.DOWN;
            }
        }
        return EnumFacing.byHorizontalIndex((int)(MathHelper.floor((double)((double)(f3 * 4.0f / 360.0f) + 0.5)) & 3)).getOpposite();
    }

    public boolean c(Entity entity, double d2, double d3, double d4) {
        List<EntityPlayer> list = this.c(true);
        list.add((EntityPlayer)43.c.player);
        for (EntityPlayer entityPlayer : list) {
            double d5;
            if (entityPlayer.equals((Object)entity) || entityPlayer.posY != d3 || !((d5 = Math.sqrt(Math.pow(d2 - 9j.2((Entity)entityPlayer), 2.0) + Math.pow(d4 - 9j.c((Entity)entityPlayer), 2.0))) < (Double)2.6())) continue;
            return false;
        }
        return true;
    }

    public BlockPos c(EntityLivingBase entityLivingBase) {
        BlockPos blockPos = null;
        double d2 = 0.0;
        for (BlockPos blockPos2 : this.c()) {
            if (!(entityLivingBase.getDistance((double)blockPos2.getX(), (double)blockPos2.getY(), (double)blockPos2.getZ()) > d2)) continue;
            blockPos = blockPos2;
        }
        return blockPos;
    }

    @Subscriber
    public void 0(1b_0 b_02) {
        block1: {
            if (43.c.player == null || 43.c.world == null) {
                return;
            }
            if (!((Boolean)5.6()).booleanValue() || !this.c(43.c.player.getHeldItemMainhand()) || this.c == null || 6.6() != 42.0 || !this.c.c((Double)7.6() * 1000.0) || !((double)43.c.player.getDistance((Entity)this.c) <= (Double)2.6())) break block1;
            43.c.playerController.attackEntity((EntityPlayer)43.c.player, (Entity)this.c);
            43.c.player.swingArm(EnumHand.MAIN_HAND);
            this.c.c();
        }
    }

    public BlockPos 0() {
        BlockPos blockPos = null;
        double d2 = 420.0;
        for (BlockPos blockPos2 : this.c()) {
            if (!(43.c.player.getDistance((double)blockPos2.getX(), (double)blockPos2.getY(), (double)blockPos2.getZ()) < d2)) continue;
            blockPos = blockPos2;
        }
        return blockPos;
    }

    public EnumFacing c(BlockPos blockPos, EnumFacing enumFacing) {
        for (EnumFacing enumFacing2 : EnumFacing.values()) {
            if (enumFacing2 == EnumFacing.DOWN || enumFacing2 == enumFacing || !Blocks.REDSTONE_BLOCK.canPlaceBlockAt((World)43.c.world, blockPos.offset(enumFacing2)) || !43.c.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos.offset(enumFacing2))).isEmpty()) continue;
            return enumFacing2;
        }
        return null;
    }

    public boolean c(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel((Enchantment)Enchantments.SHARPNESS, (ItemStack)itemStack) >= 1000;
    }
}

