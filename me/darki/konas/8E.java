/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import me.darki.konas.3E;
import me.darki.konas.46;
import me.darki.konas.4g_0;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
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
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8E {
    public static Minecraft c = Minecraft.getMinecraft();
    public static List<Block> c;

    public static float c(float f2) {
        int n2 = 8E.c.world.getDifficulty().getId();
        return f2 * (n2 == 0 ? 0.0f : (n2 == 2 ? 1.0f : (n2 == 1 ? 0.5f : 1.5f)));
    }

    public static boolean c(double d2, double d3, double d4) {
        if (8E.c.world.rayTraceBlocks(new Vec3d(8E.c.player.posX, 8E.c.player.posY + (double)8E.c.player.getEyeHeight(), 8E.c.player.posZ), new Vec3d(d2, d3 + 1.8, d4), false, true, false) == null) {
            return true;
        }
        if (8E.c.world.rayTraceBlocks(new Vec3d(8E.c.player.posX, 8E.c.player.posY + (double)8E.c.player.getEyeHeight(), 8E.c.player.posZ), new Vec3d(d2, d3 + 1.5, d4), false, true, false) == null) {
            return true;
        }
        return 8E.c.world.rayTraceBlocks(new Vec3d(8E.c.player.posX, 8E.c.player.posY + (double)8E.c.player.getEyeHeight(), 8E.c.player.posZ), new Vec3d(d2, d3, d4), false, true, false) == null;
    }

    public static int 0() {
        Minecraft minecraft;
        if (c.getConnection() == null) {
            return 50;
        }
        if (8E.c.player == null) {
            return 50;
        }
        try {
            minecraft = c;
        }
        catch (NullPointerException nullPointerException) {
            return 50;
        }
        NetHandlerPlayClient netHandlerPlayClient = minecraft.getConnection();
        EntityPlayerSP entityPlayerSP = 8E.c.player;
        UUID uUID = entityPlayerSP.getUniqueID();
        NetworkPlayerInfo networkPlayerInfo = netHandlerPlayClient.getPlayerInfo(uUID);
        return networkPlayerInfo.getResponseTime();
    }

    public static boolean c(Vec3d vec3d) {
        Vec3d vec3d2 = new Vec3d(8E.c.player.posX, 8E.c.player.getEntityBoundingBox().minY + (double)8E.c.player.getEyeHeight(), 8E.c.player.posZ);
        return 8E.c.world.rayTraceBlocks(vec3d2, vec3d) == null;
    }

    public static Vec3d c(Entity entity, int n2) {
        double d2 = entity.posX - entity.prevPosX;
        double d3 = entity.posZ - entity.prevPosZ;
        double d4 = 0.0;
        double d5 = 0.0;
        if (((Boolean)4g_0.I.6()).booleanValue()) {
            for (int i2 = 1; i2 <= n2 && 8E.c.world.getBlockState(new BlockPos(entity.posX + d2 * (double)i2, entity.posY, entity.posZ + d3 * (double)i2)).getBlock() instanceof BlockAir; ++i2) {
                d4 = d2 * (double)i2;
                d5 = d3 * (double)i2;
            }
        } else {
            d4 = d2 * (double)n2;
            d5 = d3 * (double)n2;
        }
        return new Vec3d(d4, 0.0, d5);
    }

    /*
     * Exception decompiling
     */
    public static boolean 0(BlockPos var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [22[TRYBLOCK]], but top level block is 38[DOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Nullable
    public static RayTraceResult c(Vec3d vec3d, Vec3d vec3d2) {
        return 8E.c(vec3d, vec3d2, false, false, false);
    }

    public static int 1() {
        int n2 = -1;
        if (3E.c.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL) {
            n2 = 3E.c.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                if (3E.c.player.inventory.getStackInSlot(i2).getItem() != Items.END_CRYSTAL) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }

    @Nullable
    public static RayTraceResult c(Vec3d vec3d, Vec3d vec3d2, boolean bl, boolean bl2, boolean bl3) {
        block31: {
            block32: {
                RayTraceResult rayTraceResult;
                int n2;
                int n3;
                if (Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y) || Double.isNaN(vec3d.z)) break block31;
                if (Double.isNaN(vec3d2.x) || Double.isNaN(vec3d2.y) || Double.isNaN(vec3d2.z)) break block32;
                int n4 = MathHelper.floor((double)vec3d2.x);
                int n5 = MathHelper.floor((double)vec3d2.y);
                int n6 = MathHelper.floor((double)vec3d2.z);
                int n7 = MathHelper.floor((double)vec3d.x);
                BlockPos blockPos = new BlockPos(n7, n3 = MathHelper.floor((double)vec3d.y), n2 = MathHelper.floor((double)vec3d.z));
                IBlockState iBlockState = 8E.c.world.getBlockState(blockPos);
                Block block = iBlockState.getBlock();
                if (!c.contains(block)) {
                    block = Blocks.AIR;
                    iBlockState = Blocks.AIR.getBlockState().getBaseState();
                }
                if ((!bl2 || iBlockState.getCollisionBoundingBox((IBlockAccess)8E.c.world, blockPos) != Block.NULL_AABB) && block.canCollideCheck(iBlockState, bl) && (rayTraceResult = iBlockState.collisionRayTrace((World)8E.c.world, blockPos, vec3d, vec3d2)) != null) {
                    return rayTraceResult;
                }
                rayTraceResult = null;
                int n8 = 200;
                while (n8-- >= 0) {
                    EnumFacing enumFacing;
                    block34: {
                        block33: {
                            if (Double.isNaN(vec3d.x) || Double.isNaN(vec3d.y)) break block33;
                            if (!Double.isNaN(vec3d.z)) break block34;
                        }
                        return null;
                    }
                    if (n7 == n4 && n3 == n5 && n2 == n6) {
                        return bl3 ? rayTraceResult : null;
                    }
                    boolean bl4 = true;
                    boolean bl5 = true;
                    boolean bl6 = true;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    double d4 = 999.0;
                    if (n4 > n7) {
                        d2 = (double)n7 + 1.0;
                    } else if (n4 < n7) {
                        d2 = (double)n7 + 0.0;
                    } else {
                        bl4 = false;
                    }
                    if (n5 > n3) {
                        d3 = (double)n3 + 1.0;
                    } else if (n5 < n3) {
                        d3 = (double)n3 + 0.0;
                    } else {
                        bl5 = false;
                    }
                    if (n6 > n2) {
                        d4 = (double)n2 + 1.0;
                    } else if (n6 < n2) {
                        d4 = (double)n2 + 0.0;
                    } else {
                        bl6 = false;
                    }
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = 999.0;
                    double d8 = vec3d2.x - vec3d.x;
                    double d9 = vec3d2.y - vec3d.y;
                    double d10 = vec3d2.z - vec3d.z;
                    if (bl4) {
                        d5 = (d2 - vec3d.x) / d8;
                    }
                    if (bl5) {
                        d6 = (d3 - vec3d.y) / d9;
                    }
                    if (bl6) {
                        d7 = (d4 - vec3d.z) / d10;
                    }
                    if (d5 == -0.0) {
                        d5 = -1.0E-4;
                    }
                    if (d6 == -0.0) {
                        d6 = -1.0E-4;
                    }
                    if (d7 == -0.0) {
                        d7 = -1.0E-4;
                    }
                    if (d5 < d6 && d5 < d7) {
                        enumFacing = n4 > n7 ? EnumFacing.WEST : EnumFacing.EAST;
                        vec3d = new Vec3d(d2, vec3d.y + d9 * d5, vec3d.z + d10 * d5);
                    } else if (d6 < d7) {
                        enumFacing = n5 > n3 ? EnumFacing.DOWN : EnumFacing.UP;
                        vec3d = new Vec3d(vec3d.x + d8 * d6, d3, vec3d.z + d10 * d6);
                    } else {
                        enumFacing = n6 > n2 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                        vec3d = new Vec3d(vec3d.x + d8 * d7, vec3d.y + d9 * d7, d4);
                    }
                    n7 = MathHelper.floor((double)vec3d.x) - (enumFacing == EnumFacing.EAST ? 1 : 0);
                    n3 = MathHelper.floor((double)vec3d.y) - (enumFacing == EnumFacing.UP ? 1 : 0);
                    n2 = MathHelper.floor((double)vec3d.z) - (enumFacing == EnumFacing.SOUTH ? 1 : 0);
                    blockPos = new BlockPos(n7, n3, n2);
                    IBlockState iBlockState2 = 8E.c.world.getBlockState(blockPos);
                    Block block2 = iBlockState2.getBlock();
                    if (!c.contains(block2)) {
                        block2 = Blocks.AIR;
                        iBlockState2 = Blocks.AIR.getBlockState().getBaseState();
                    }
                    if (bl2 && iBlockState2.getMaterial() != Material.PORTAL && iBlockState2.getCollisionBoundingBox((IBlockAccess)8E.c.world, blockPos) == Block.NULL_AABB) continue;
                    if (block2.canCollideCheck(iBlockState2, bl)) {
                        RayTraceResult rayTraceResult2 = iBlockState2.collisionRayTrace((World)8E.c.world, blockPos, vec3d, vec3d2);
                        if (rayTraceResult2 == null) continue;
                        return rayTraceResult2;
                    }
                    rayTraceResult = new RayTraceResult(RayTraceResult.Type.MISS, vec3d, enumFacing, blockPos);
                }
                return bl3 ? rayTraceResult : null;
            }
            return null;
        }
        return null;
    }

    public static float c(EntityLivingBase entityLivingBase, float f2, Explosion explosion) {
        float f3 = f2;
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            DamageSource damageSource = DamageSource.causeExplosionDamage((Explosion)explosion);
            f3 = CombatRules.getDamageAfterAbsorb((float)f3, (float)entityPlayer.getTotalArmorValue(), (float)((float)entityPlayer.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
            int n2 = 0;
            EntityPlayer entityPlayer2 = entityPlayer;
            Iterable iterable = entityPlayer2.getArmorInventoryList();
            DamageSource damageSource2 = damageSource;
            int n3 = EnchantmentHelper.getEnchantmentModifierDamage((Iterable)iterable, (DamageSource)damageSource2);
            try {
                n2 = n3;
            }
            catch (Exception exception) {
                // empty catch block
            }
            float f4 = MathHelper.clamp((float)n2, (float)0.0f, (float)20.0f);
            f3 *= 1.0f - f4 / 25.0f;
            if (entityLivingBase.isPotionActive(MobEffects.RESISTANCE)) {
                f3 -= f3 / 4.0f;
            }
            f3 = Math.max(f3, 0.0f);
            return f3;
        }
        f3 = CombatRules.getDamageAfterAbsorb((float)f3, (float)entityLivingBase.getTotalArmorValue(), (float)((float)entityLivingBase.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue()));
        return f3;
    }

    /*
     * Unable to fully structure code
     */
    public static float c(double var0, double var2_1, double var4_2, Entity var6_3) {
        block44: {
            block45: {
                block43: {
                    var7_4 = 12.0f;
                    var10_5 = 8E.0(var6_3, (Integer)4g_0.J.6() > 0 ? (Integer)4g_0.J.6() : 0);
                    var8_6 = var10_5.distanceTo(new Vec3d(var0, var2_1, var4_2)) / (double)var7_4;
                    var11_7 = new Vec3d(var0, var2_1, var4_2);
                    var12_8 = 0.0;
                    v0 = 4g_0.K;
                    v1 = v0.6();
                    v2 = (Boolean)v1;
                    v3 = v2;
                    if (!v3) ** GOTO lbl54
                    v4 = var11_7;
                    v5 = 4g_0.J;
                    v6 = v5.6();
                    v7 = (Integer)v6;
                    v8 = v7;
                    if (v8 <= 0) ** GOTO lbl45
                    v9 = var6_3;
                    v10 = v9.getEntityBoundingBox();
                    v11 = var6_3;
                    v12 = 4g_0.J;
                    v13 = v12.6();
                    v14 = (Integer)v13;
                    v15 = v14;
                    v16 = 8E.c(v11, v15);
                    v17 = v10.offset(v16);
                    break block43;
lbl45:
                    // 1 sources

                    v18 = var6_3;
                    v17 = v18.getEntityBoundingBox();
                }
                v19 = 8E.c(v4, v17);
                var12_8 = v19;
                break block44;
lbl54:
                // 1 sources

                v20 = var6_3.world;
                v21 = var11_7;
                v22 = 4g_0.J;
                v23 = v22.6();
                v24 = (Integer)v23;
                v25 = v24;
                if (v25 <= 0) ** GOTO lbl83
                v26 = var6_3;
                v27 = v26.getEntityBoundingBox();
                v28 = var6_3;
                v29 = 4g_0.J;
                v30 = v29.6();
                v31 = (Integer)v30;
                v32 = v31;
                v33 = 8E.c(v28, v32);
                v34 = v27.offset(v33);
                break block45;
lbl83:
                // 1 sources

                v35 = var6_3;
                v34 = v35.getEntityBoundingBox();
            }
            v36 = v20.getBlockDensity(v21, v34);
            try {
                var12_8 = v36;
            }
            catch (Exception var14_9) {
                // empty catch block
            }
        }
        var14_10 = (1.0 - var8_6) * var12_8;
        var16_11 = (int)((var14_10 * var14_10 + var14_10) / 2.0 * 7.0 * (double)var7_4 + 1.0);
        var17_12 = 1.0;
        if (var6_3 instanceof EntityLivingBase) {
            var17_12 = 8E.c((EntityLivingBase)var6_3, 8E.c(var16_11), new Explosion((World)8E.c.world, (Entity)8E.c.player, var0, var2_1, var4_2, 6.0f, false, true));
        }
        return (float)var17_12;
    }

    public static boolean c(BlockPos blockPos) {
        if (4g_0.b.6() != 46.c) {
            double d2 = 0.45;
            double d3 = 0.05;
            double d4 = 0.95;
            Vec3d vec3d = new Vec3d(8E.c.player.posX, 8E.c.player.getEntityBoundingBox().minY + (double)8E.c.player.getEyeHeight(), 8E.c.player.posZ);
            for (double d5 = d3; d5 <= d4; d5 += d2) {
                for (double d6 = d3; d6 <= d4; d6 += d2) {
                    for (double d7 = d3; d7 <= d4; d7 += d2) {
                        Vec3d vec3d2 = new Vec3d((Vec3i)blockPos).add(d5, d6, d7);
                        double d8 = vec3d.distanceTo(vec3d2);
                        double d9 = vec3d2.x - vec3d.x;
                        double d10 = vec3d2.y - vec3d.y;
                        double d11 = vec3d2.z - vec3d.z;
                        double d12 = MathHelper.sqrt((double)(d9 * d9 + d11 * d11));
                        double[] dArray = new double[]{MathHelper.wrapDegrees((float)((float)Math.toDegrees(Math.atan2(d11, d9)) - 90.0f)), MathHelper.wrapDegrees((float)((float)(-Math.toDegrees(Math.atan2(d10, d12)))))};
                        float f2 = MathHelper.cos((float)((float)(-dArray[0] * 0.01745329238474369 - 3.1415927410125732)));
                        float f3 = MathHelper.sin((float)((float)(-dArray[0] * 0.01745329238474369 - 3.1415927410125732)));
                        float f4 = -MathHelper.cos((float)((float)(-dArray[1] * 0.01745329238474369)));
                        float f5 = MathHelper.sin((float)((float)(-dArray[1] * 0.01745329238474369)));
                        Vec3d vec3d3 = new Vec3d((double)(f3 * f4), (double)f5, (double)(f2 * f4));
                        Vec3d vec3d4 = vec3d.add(vec3d3.x * d8, vec3d3.y * d8, vec3d3.z * d8);
                        RayTraceResult rayTraceResult = 8E.c.world.rayTraceBlocks(vec3d, vec3d4, false, false, false);
                        if (rayTraceResult == null || rayTraceResult.typeOfHit != RayTraceResult.Type.BLOCK || !rayTraceResult.getBlockPos().equals((Object)blockPos)) continue;
                        return true;
                    }
                }
            }
            return false;
        }
        for (EnumFacing enumFacing : EnumFacing.values()) {
            Vec3d vec3d = new Vec3d((double)blockPos.getX() + 0.5 + (double)enumFacing.getDirectionVec().getX() * 0.5, (double)blockPos.getY() + 0.5 + (double)enumFacing.getDirectionVec().getY() * 0.5, (double)blockPos.getZ() + 0.5 + (double)enumFacing.getDirectionVec().getZ() * 0.5);
            RayTraceResult rayTraceResult = 8E.c.world.rayTraceBlocks(new Vec3d(8E.c.player.posX, 8E.c.player.posY + (double)8E.c.player.getEyeHeight(), 8E.c.player.posZ), vec3d, false, true, false);
            if (rayTraceResult == null || !rayTraceResult.typeOfHit.equals((Object)RayTraceResult.Type.BLOCK) || !rayTraceResult.getBlockPos().equals((Object)blockPos)) continue;
            return true;
        }
        return false;
    }

    public static float c(BlockPos blockPos, Entity entity) {
        return 8E.c((double)blockPos.getX() + 0.5, blockPos.getY() + 1, (double)blockPos.getZ() + 0.5, entity);
    }

    public static Vec3d 0(Entity entity, int n2) {
        return entity.getPositionVector().add(8E.c(entity, n2));
    }

    static {
        c = Arrays.asList(Blocks.OBSIDIAN, Blocks.BEDROCK, Blocks.ENDER_CHEST, Blocks.ANVIL);
    }

    public static int c() {
        int n2 = -1;
        if (3E.c.player.getHeldItemMainhand().getItem() == Items.DIAMOND_SWORD) {
            n2 = 3E.c.player.inventory.currentItem;
        }
        if (n2 == -1) {
            for (int i2 = 0; i2 < 9; ++i2) {
                if (3E.c.player.inventory.getStackInSlot(i2).getItem() != Items.DIAMOND_SWORD) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }

    public static float c(Vec3d vec3d, AxisAlignedBB axisAlignedBB) {
        double d2 = 1.0 / ((axisAlignedBB.maxX - axisAlignedBB.minX) * 2.0 + 1.0);
        double d3 = 1.0 / ((axisAlignedBB.maxY - axisAlignedBB.minY) * 2.0 + 1.0);
        double d4 = 1.0 / ((axisAlignedBB.maxZ - axisAlignedBB.minZ) * 2.0 + 1.0);
        double d5 = (1.0 - Math.floor(1.0 / d2) * d2) / 2.0;
        double d6 = (1.0 - Math.floor(1.0 / d4) * d4) / 2.0;
        if (d2 >= 0.0 && d3 >= 0.0 && d4 >= 0.0) {
            int n2 = 0;
            int n3 = 0;
            float f2 = 0.0f;
            while (f2 <= 1.0f) {
                float f3 = 0.0f;
                while (f3 <= 1.0f) {
                    float f4 = 0.0f;
                    while (f4 <= 1.0f) {
                        double d7 = axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * (double)f2;
                        double d8 = axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * (double)f3;
                        double d9 = axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * (double)f4;
                        if (8E.c(new Vec3d(d7 + d5, d8, d9 + d6), vec3d) == null) {
                            ++n2;
                        }
                        ++n3;
                        f4 = (float)((double)f4 + d4);
                    }
                    f3 = (float)((double)f3 + d3);
                }
                f2 = (float)((double)f2 + d2);
            }
            return (float)n2 / (float)n3;
        }
        return 0.0f;
    }

    public static float c(EntityEnderCrystal entityEnderCrystal, Entity entity) {
        return 8E.c(entityEnderCrystal.posX, entityEnderCrystal.posY, entityEnderCrystal.posZ, entity);
    }
}

