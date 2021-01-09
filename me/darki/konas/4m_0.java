/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.1O;
import me.darki.konas.1P;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.8J;
import me.darki.konas.8L;
import me.darki.konas.8M;
import me.darki.konas.8f_0;
import me.darki.konas.8h_0;
import me.darki.konas.8k_0;
import me.darki.konas.8r_0;
import me.darki.konas.8u_0;
import me.darki.konas.8x_0;
import me.darki.konas.9m;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.4m
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4m_0
extends 3E {
    public 8h_0<8f_0> 1;
    public 8h_0<Boolean> 2;
    public 8h_0<Boolean> 3;
    public 8h_0<Boolean> 4;
    public 8h_0<Boolean> 5;
    public 8h_0<Boolean> 6;
    public 8h_0<8f_0> 7;
    public 8h_0<Float> 8;
    public 8h_0<Float> 9;
    public 8h_0<8f_0> a;
    public 8h_0<Integer> b;
    public 8h_0<Integer> d;
    public 8h_0<8f_0> e;
    public 8h_0<Boolean> f;
    public 8h_0<Boolean> g;
    public 9m c;
    public 9m 0;
    public 9m 1;
    public static boolean 1;
    public static double c;
    public static double 0;
    public BlockPos c;
    public BlockPos 0 = null;
    public EnumFacing c = null;
    public int 1 = -1;

    public static boolean 5(EntityPlayer entityPlayer) {
        return !entityPlayer.isDead;
    }

    public static float[] c(EnumFacing enumFacing) {
        switch (enumFacing) {
            case DOWN: {
                return new float[]{4m_0.c.player.rotationYaw, 90.0f};
            }
            case UP: {
                return new float[]{4m_0.c.player.rotationYaw, -90.0f};
            }
            case NORTH: {
                return new float[]{180.0f, 0.0f};
            }
            case SOUTH: {
                return new float[]{0.0f, 0.0f};
            }
            case WEST: {
                return new float[]{90.0f, 0.0f};
            }
        }
        return new float[]{270.0f, 0.0f};
    }

    public static boolean 3(TileEntity tileEntity) {
        return ((TileEntityBed)tileEntity).isHeadPiece();
    }

    public static float c(float f2) {
        int n2 = Minecraft.getMinecraft().world.getDifficulty().getId();
        return f2 * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    @Subscriber(priority=8)
    public void c(1O o2) {
        if (this.c != null) {
            this.1(this.c);
        } else if (this.0 != null) {
            this.0();
        }
        if (this.1 != -1) {
            if (!this.6()) {
                4m_0.c.player.inventory.currentItem = this.1;
                4m_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.1));
                this.1 = -1;
            }
        }
    }

    public boolean c(BlockPos blockPos) {
        return (double)(((Minecraft)4m_0.c).player.getHealth() + ((Minecraft)4m_0.c).player.getAbsorptionAmount() - 4m_0.c((double)blockPos.getX() + 0.5, blockPos.getY() + 1, (double)blockPos.getZ() + 0.5, (Entity)((Minecraft)4m_0.c).player)) > 0.5;
    }

    public static double 0(BlockPos blockPos) {
        return ((Minecraft)4m_0.c).player.getDistanceSq(blockPos);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Subscriber(priority=100)
    public void c(1P p2) {
        block11: {
            int n2;
            block12: {
                block9: {
                    block10: {
                        if (((Minecraft)4m_0.c).player == null || ((Minecraft)4m_0.c).world == null) {
                            return;
                        }
                        this.c = null;
                        this.0 = null;
                        if (p2.0() || !8L.c((Boolean)this.2.6())) {
                            return;
                        }
                        if (4m_0.c.player.dimension == 0) {
                            return;
                        }
                        if (this.c.c((double)(1000 - (Integer)this.b.6() * 50))) {
                            this.c = this.2();
                        }
                        if (this.c != null || !this.0.c((double)(1000 - (Integer)this.d.6() * 50))) break block9;
                        if (4m_0.c.player.inventory.getCurrentItem().getItem() != Items.BED && !this.6()) break block10;
                        this.3();
                        break block11;
                    }
                    if (this.1().isEmpty() || !((Boolean)this.f.6()).booleanValue() || this.6()) break block11;
                    break block12;
                }
                if (this.c == null) break block11;
                double[] dArray = 8x_0.c((double)this.c.getX() + 0.5, (double)this.c.getY() + 0.5, (double)this.c.getZ() + 0.5, (EntityPlayer)((Minecraft)4m_0.c).player);
                c = dArray[0];
                0 = dArray[1];
                1 = true;
                this.1.c();
                break block11;
            }
            for (n2 = 0; n2 < 9; ++n2) {
                ItemStack itemStack = (ItemStack)4m_0.c.player.inventory.mainInventory.get(n2);
                if (itemStack.getItem() != Items.BED) continue;
                this.1 = 4m_0.c.player.inventory.currentItem;
                4m_0.c.player.inventory.currentItem = n2;
                4m_0.c.player.connection.sendPacket((Packet)new CPacketHeldItemChange(n2));
                this.3();
                break;
            }
            if (((Boolean)this.g.6()).booleanValue() && 4m_0.c.player.inventory.getCurrentItem().getItem() != Items.BED) {
                for (n2 = 9; n2 <= 35; ++n2) {
                    if (4m_0.c.player.inventory.getStackInSlot(n2).getItem() != Items.BED) continue;
                    ((Minecraft)4m_0.c).playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4m_0.c).player);
                    ((Minecraft)4m_0.c).playerController.windowClick(0, 4m_0.c.player.inventory.currentItem < 9 ? 4m_0.c.player.inventory.currentItem + 36 : 4m_0.c.player.inventory.currentItem, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4m_0.c).player);
                    ((Minecraft)4m_0.c).playerController.windowClick(0, n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4m_0.c).player);
                }
            }
        }
        if (1) {
            8k_0.c.c.c((float)c, (float)0);
        }
        if (this.1.c(450.0)) {
            1 = false;
        }
    }

    public static boolean 1(TileEntity tileEntity) {
        return tileEntity instanceof TileEntityBed;
    }

    public boolean 2(BlockPos blockPos) {
        IBlockState iBlockState = ((Minecraft)4m_0.c).world.getBlockState(blockPos.up());
        if (iBlockState.getBlock() == Blocks.AIR) {
            return ((Minecraft)4m_0.c).world.getBlockState(blockPos).isSideSolid((IBlockAccess)((Minecraft)4m_0.c).world, blockPos, EnumFacing.UP);
        }
        return false;
    }

    public static float c(double d2, double d3, double d4, Entity entity) {
        float f2 = 12.0f;
        double d5 = entity.getDistance(d2, d3, d4) / 12.0;
        Vec3d vec3d = new Vec3d(d2, d3, d4);
        double d6 = entity.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
        double d7 = (1.0 - d5) * d6;
        float f3 = (int)((d7 * d7 + d7) / 2.0 * 7.0 * 12.0 + 1.0);
        double d8 = 1.0;
        if (entity instanceof EntityLivingBase) {
            d8 = 4m_0.c((EntityLivingBase)entity, 4m_0.c(f3), new Explosion((World)Minecraft.getMinecraft().world, (Entity)null, d2, d3, d4, 6.0f, false, true));
        }
        return (float)d8;
    }

    public List<EntityPlayer> 1() {
        return 4m_0.c.world.playerEntities.stream().filter(4m_0::4).filter(4m_0::1).filter(4m_0::5).filter(4m_0::c).filter(4m_0::0).filter(this::2).sorted(Comparator.comparing(4m_0::3)).collect(Collectors.toList());
    }

    public static boolean 0(EntityPlayer entityPlayer) {
        return entityPlayer != ((Minecraft)4m_0.c).player;
    }

    public boolean 6() {
        return ((Minecraft)4m_0.c).player.getHeldItemOffhand().getItem() instanceof ItemBed;
    }

    public static Float 3(EntityPlayer entityPlayer) {
        return Float.valueOf(((Minecraft)4m_0.c).player.getDistance((Entity)entityPlayer));
    }

    public void c(BlockPos blockPos, boolean bl) {
        if (((Minecraft)4m_0.c).world.getBlockState(blockPos).getBlock() == Blocks.BED) {
            return;
        }
        float f2 = this.c(blockPos, (Entity)((Minecraft)4m_0.c).player);
        if ((double)f2 > (double)((Minecraft)4m_0.c).player.getHealth() + (double)((Minecraft)4m_0.c).player.getAbsorptionAmount() + 0.5) {
            if (bl && ((Boolean)this.4.6()).booleanValue()) {
                this.c(blockPos.up(), false);
            }
            return;
        }
        if (!((Minecraft)4m_0.c).world.getBlockState(blockPos).getMaterial().isReplaceable()) {
            if (bl && ((Boolean)this.4.6()).booleanValue()) {
                this.c(blockPos.up(), false);
            }
            return;
        }
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        HashMap<BlockPos, EnumFacing> hashMap = new HashMap<BlockPos, EnumFacing>();
        for (EnumFacing enumFacing : EnumFacing.values()) {
            BlockPos blockPos2;
            if (enumFacing == EnumFacing.DOWN || enumFacing == EnumFacing.UP) continue;
            BlockPos blockPos3 = blockPos.offset(enumFacing);
            if (!(((Minecraft)4m_0.c).player.getDistanceSq(blockPos2) <= Math.pow(((Float)this.9.6()).floatValue(), 2.0)) || !((Minecraft)4m_0.c).world.getBlockState(blockPos3).getMaterial().isReplaceable() || ((Minecraft)4m_0.c).world.getBlockState(blockPos3.down()).getMaterial().isReplaceable() || ((Boolean)this.2.6()).booleanValue() && EnumFacing.fromAngle((double)8r_0.c(blockPos3, EnumFacing.UP, (EntityPlayer)((Minecraft)4m_0.c).player)[0]).getOpposite() != enumFacing) continue;
            if (((Boolean)this.5.6()).booleanValue()) {
                if (((Minecraft)4m_0.c).world.rayTraceBlocks(((Minecraft)4m_0.c).player.getPositionEyes(1.0f), new Vec3d((double)blockPos3.getX() + 0.5, (double)(blockPos3.getY() + 1), (double)blockPos3.getZ() + 0.5)) != null) continue;
            }
            arrayList.add(blockPos3);
            hashMap.put(blockPos3, enumFacing.getOpposite());
        }
        if (arrayList.isEmpty()) {
            if (bl && ((Boolean)this.4.6()).booleanValue()) {
                this.c(blockPos.up(), false);
            }
            return;
        }
        arrayList.sort(Comparator.comparingDouble(4m_0::0));
        this.0 = (BlockPos)arrayList.get(0);
        this.c = (EnumFacing)hashMap.get(this.0);
        if (((Boolean)this.2.6()).booleanValue()) {
            float[] fArray = 8M.c(((Minecraft)4m_0.c).player.getPositionEyes(1.0f), new Vec3d((double)this.0.down().getX() + 0.5, (double)(this.0.down().getY() + 1), (double)this.0.down().getZ() + 0.5));
            c = fArray[0];
            0 = fArray[1];
            1 = true;
        } else {
            float[] fArray = 4m_0.c(this.c);
            c = fArray[0];
            0 = fArray[1];
            1 = true;
        }
        this.1.c();
    }

    public static Double 2(TileEntity tileEntity) {
        return ((Minecraft)4m_0.c).player.getDistance((double)tileEntity.getPos().getX(), (double)tileEntity.getPos().getY(), (double)tileEntity.getPos().getZ());
    }

    public BlockPos 2() {
        TileEntityBed tileEntityBed = 4m_0.c.world.loadedTileEntityList.stream().filter(4m_0::1).filter(4m_0::3).filter(this::c).filter(this::0).min(Comparator.comparing(4m_0::2)).orElse(null);
        if (tileEntityBed != null) {
            return tileEntityBed.getPos();
        }
        return null;
    }

    public static boolean c(EntityPlayer entityPlayer) {
        return !8J.1(entityPlayer.getName());
    }

    public void 0() {
        Vec3d vec3d = new Vec3d((Vec3i)this.0.down()).add(0.5, 0.5, 0.5).add(new Vec3d(this.c.getOpposite().getDirectionVec()).scale(0.5));
        4m_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4m_0.c).player, CPacketEntityAction.Action.START_SNEAKING));
        8L.c(this.0.down(), vec3d, this.6() ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, EnumFacing.UP, true, (Boolean)this.3.6());
        4m_0.c.player.connection.sendPacket((Packet)new CPacketEntityAction((Entity)((Minecraft)4m_0.c).player, CPacketEntityAction.Action.STOP_SNEAKING));
        this.0.c();
        this.0 = null;
    }

    public boolean 0(TileEntity tileEntity) {
        return this.c(tileEntity.getPos());
    }

    public float c(BlockPos blockPos, Entity entity) {
        return 4m_0.c((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 1.0, (double)blockPos.getZ() + 0.5, entity);
    }

    public static BlockPos 7() {
        return new BlockPos(Math.floor(4m_0.c.player.posX), Math.floor(4m_0.c.player.posY), Math.floor(4m_0.c.player.posZ));
    }

    public 4m_0() {
        super("BedAura", 3D.c, new String[0]);
        this.2 = new 8h_0("Rotate", false).c(this.1);
        this.3 = new 8h_0("Swing", true).c(this.1);
        this.4 = new 8h_0("AirPlace", false).c(this.1);
        this.5 = new 8h_0("RayTrace", false).c(this.1);
        this.6 = new 8h_0("StrictDirection", false).c(this.1);
        this.7 = new 8h_0("Ranges", new 8f_0(false));
        this.8 = new 8h_0("BreakRange", Float.valueOf(6.0f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(this.7);
        this.9 = new 8h_0("PlaceRange", Float.valueOf(5.0f), Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)).c(this.7);
        this.a = new 8h_0("Speeds", new 8f_0(false));
        this.b = new 8h_0("BreakSpeed", 20, 20, 1, 1).c(this.a);
        this.d = new 8h_0("PlaceSpeed", 20, 20, 1, 1).c(this.a);
        this.e = new 8h_0("Misc", new 8f_0(false));
        this.f = new 8h_0("Swap", true).c(this.e);
        this.g = new 8h_0("AutoMove", true).c(this.e);
        this.c = new 9m();
        this.0 = new 9m();
        this.1 = new 9m();
    }

    public static float c(EntityLivingBase entityLivingBase, float f2, Explosion explosion) {
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion)explosion);
            f2 = CombatRules.getDamageAfterAbsorb((float)f2, (float)entityPlayer.getTotalArmorValue(), (float)((float)entityPlayer.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
            int n2 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable)entityPlayer.getArmorInventoryList(), (DamageSource)damageSource);
            float f3 = MathHelper.clamp((float)n2, (float)0.0f, (float)20.0f);
            f2 *= 1.0f - f3 / 25.0f;
            if (entityLivingBase.isPotionActive(Potion.getPotionById((int)11))) {
                f2 -= f2 / 4.0f;
            }
            return f2;
        }
        f2 = CombatRules.getDamageAfterAbsorb((float)f2, (float)entityLivingBase.getTotalArmorValue(), (float)((float)entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        return f2;
    }

    public static boolean 4(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }

    public void 3() {
        List<EntityPlayer> list = this.1();
        if (list.isEmpty()) {
            return;
        }
        this.c(new BlockPos((Entity)list.get(0)), true);
    }

    public void 1(BlockPos blockPos) {
        if (blockPos == null) {
            return;
        }
        RayTraceResult rayTraceResult = (Boolean)this.6.6() != false ? ((Minecraft)4m_0.c).world.rayTraceBlocks(((Minecraft)4m_0.c).player.getPositionEyes(1.0f), new Vec3d((double)blockPos.getX() + 0.5, (double)blockPos.getY(), (double)blockPos.getZ() + 0.5)) : null;
        Vec3d vec3d = new Vec3d((Vec3i)blockPos).add(0.5, 0.5, 0.5);
        EnumFacing enumFacing = rayTraceResult == null || rayTraceResult.sideHit == null ? EnumFacing.UP : rayTraceResult.sideHit;
        8L.c(blockPos, vec3d, EnumHand.MAIN_HAND, enumFacing, true, (Boolean)this.3.6());
        this.c.c();
    }

    public List<BlockPos> c(BlockPos blockPos, float f2, float f3, boolean bl, boolean bl2, int n2) {
        ArrayList<BlockPos> arrayList = new ArrayList<BlockPos>();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        int n6 = n3 - (int)f2;
        while ((float)n6 <= (float)n3 + f2) {
            int n7 = n5 - (int)f2;
            while ((float)n7 <= (float)n5 + f2) {
                int n8 = bl2 ? n4 - (int)f2 : n4;
                while (true) {
                    float f4 = n8;
                    float f5 = bl2 ? (float)n4 + f2 : (float)n4 + f3;
                    if (!(f4 < f5)) break;
                    double d2 = (n3 - n6) * (n3 - n6) + (n5 - n7) * (n5 - n7) + (bl2 ? (n4 - n8) * (n4 - n8) : 0);
                    if (!(!(d2 < (double)(f2 * f2)) || bl && d2 < (double)((f2 - 1.0f) * (f2 - 1.0f)))) {
                        BlockPos blockPos2 = new BlockPos(n6, n8 + n2, n7);
                        arrayList.add(blockPos2);
                    }
                    ++n8;
                }
                ++n7;
            }
            ++n6;
        }
        return arrayList;
    }

    public boolean c(TileEntity tileEntity) {
        return ((Minecraft)4m_0.c).player.getDistance((double)tileEntity.getPos().getX(), (double)tileEntity.getPos().getY(), (double)tileEntity.getPos().getZ()) <= (double)((Float)this.8.6()).floatValue();
    }

    public boolean 2(EntityPlayer entityPlayer) {
        return ((Minecraft)4m_0.c).player.getDistance((Entity)entityPlayer) < ((Float)this.9.6()).floatValue() + 2.0f;
    }

    public static boolean 1(EntityPlayer entityPlayer) {
        return !8u_0.c((Entity)entityPlayer);
    }
}

