/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import me.darki.konas.3E;
import me.darki.konas.4n_0;
import me.darki.konas.81;
import me.darki.konas.82;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 80 {
    public EntityLivingBase c;
    public Vec3d c;
    public Vec3d 0;
    public float c;
    public float 0;
    public float 1;
    public AxisAlignedBB c;
    public boolean c;
    public RayTraceResult c;
    public 81 c;
    public 82 c;

    public void c(Vec3d vec3d, RayTraceResult rayTraceResult) {
        Entity entity = null;
        RayTraceResult rayTraceResult2 = null;
        double d2 = 0.0;
        ArrayList arrayList = (ArrayList)3E.c.world.getEntitiesWithinAABBExcludingEntity((Entity)this.c, this.c.expand(this.0.x, this.0.y, this.0.z).grow(1.0, 1.0, 1.0));
        for (Entity entity2 : arrayList) {
            double d3;
            if (!entity2.canBeCollidedWith()) continue;
            float f2 = entity2.getCollisionBorderSize();
            AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox().expand((double)f2, (double)f2, (double)f2);
            RayTraceResult rayTraceResult3 = axisAlignedBB.calculateIntercept(this.c, vec3d);
            if (rayTraceResult3 == null || !((d3 = this.c.distanceTo(rayTraceResult3.hitVec)) < d2) && d2 != 0.0) continue;
            entity = entity2;
            rayTraceResult2 = rayTraceResult3;
            d2 = d3;
        }
        this.c = entity != null ? new RayTraceResult(entity, rayTraceResult2.hitVec) : rayTraceResult;
    }

    public float 0() {
        switch (this.c) {
            case 0: {
                int n2 = this.c.getHeldItem(EnumHand.MAIN_HAND).getItem().getMaxItemUseDuration(this.c.getHeldItem(EnumHand.MAIN_HAND)) - this.c.getItemInUseCount();
                float f2 = (float)n2 / 20.0f;
                f2 = (f2 * f2 + f2 * 2.0f) / 3.0f;
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                return f2 * 2.0f * this.c.0();
            }
        }
        return this.c.0();
    }

    public void c(double d2, double d3, double d4, float f2, float f3) {
        this.c = new Vec3d(d2, d3, d4);
        this.c = f2;
        this.0 = f3;
    }

    public void c(Vec3d vec3d) {
        this.c = new Vec3d(vec3d.x, vec3d.y, vec3d.z);
        double d2 = (this.c == 81.0 ? 0.5 : 0.25) / 2.0;
        this.c = new AxisAlignedBB(vec3d.x - d2, vec3d.y - d2, vec3d.z - d2, vec3d.x + d2, vec3d.y + d2, vec3d.z + d2);
    }

    public 80(82 var1_1, EntityLivingBase entityLivingBase, 81 var3_3) {
        this.c = var1_1;
        this.c = entityLivingBase;
        this.c = var3_3;
        this.c(this.c.posX, this.c.posY + (double)this.c.getEyeHeight(), this.c.posZ, 82.0(this.c) ? (float)4n_0.c : this.c.rotationYaw, 82.0(this.c) ? (float)4n_0.0 : this.c.rotationPitch);
        this.1 = var3_3 == 81.2 ? -20.0f : 0.0f;
        Vec3d vec3d = new Vec3d((double)(MathHelper.cos((float)(this.c / 180.0f * (float)Math.PI)) * 0.16f), 0.1, (double)(MathHelper.sin((float)(this.c / 180.0f * (float)Math.PI)) * 0.16f));
        this.c = this.c.subtract(vec3d);
        this.c(this.c);
        this.0 = new Vec3d((double)(-MathHelper.sin((float)(this.c / 180.0f * (float)Math.PI)) * MathHelper.cos((float)(this.0 / 180.0f * (float)Math.PI))), (double)(-MathHelper.sin((float)((this.0 + this.1) / 180.0f * (float)Math.PI))), (double)(MathHelper.cos((float)(this.c / 180.0f * (float)Math.PI)) * MathHelper.cos((float)(this.0 / 180.0f * (float)Math.PI))));
        this.c(this.0, this.0());
    }

    public boolean 4() {
        switch (this.c) {
            case 3: 
            case 4: {
                return true;
            }
        }
        return false;
    }

    public float 1() {
        return this.c.c();
    }

    public static boolean c(80 var0) {
        return var0.c;
    }

    public void 2() {
        Vec3d vec3d = this.c.add(this.0);
        RayTraceResult rayTraceResult = this.c.getEntityWorld().rayTraceBlocks(this.c, vec3d, this.c == 81.3, !this.4(), false);
        if (rayTraceResult != null) {
            vec3d = rayTraceResult.hitVec;
        }
        this.c(vec3d, rayTraceResult);
        if (this.c != null) {
            this.c = true;
            this.c(this.c.hitVec);
            return;
        }
        if (this.c.y <= 0.0) {
            this.c = true;
            return;
        }
        this.c = this.c.add(this.0);
        float f2 = 0.99f;
        if (this.c.getEntityWorld().isMaterialInBB(this.c, Material.WATER)) {
            float f3 = f2 = this.c == 81.0 ? 0.6f : 0.8f;
        }
        if (this.c == 81.3) {
            f2 = 0.92f;
        }
        this.0 = this.0.scale((double)f2);
        this.0 = this.0.subtract(0.0, (double)this.1(), 0.0);
        this.c(this.c);
    }

    public RayTraceResult 3() {
        return this.c;
    }

    public static Vec3d 0(80 var0) {
        return var0.c;
    }

    public static RayTraceResult 1(80 var0) {
        return var0.c;
    }

    public boolean c() {
        return this.c;
    }

    public void c(Vec3d vec3d, float f2) {
        this.0 = vec3d.scale(1.0 / vec3d.length());
        this.0 = this.0.scale((double)f2);
    }
}

