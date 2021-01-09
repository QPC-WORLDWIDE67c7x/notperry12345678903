/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8M {
    public Minecraft c;
    public float c;
    public float 0;
    public boolean c = false;

    public void c(float f2, float f3) {
        this.c = f2;
        this.0 = f3;
        this.c = true;
    }

    public void 2() {
        this.c = this.c.player.rotationYaw;
        this.0 = this.c.player.rotationPitch;
        this.c = false;
    }

    public boolean 0(float f2, float f3) {
        if (this.c) {
            return false;
        }
        this.c(f2, f3);
        return true;
    }

    public boolean c() {
        return this.c;
    }

    public void c(double d2, double d3, double d4) {
        Vec3d vec3d = new Vec3d(d2, d3, d4);
        this.c(vec3d);
    }

    public void c(Vec3d vec3d) {
        float[] fArray = 8M.c(this.c.player.getPositionEyes(this.c.getRenderPartialTicks()), new Vec3d(vec3d.x, vec3d.y, vec3d.z));
        this.c(fArray[0], fArray[1]);
    }

    public void c(BlockPos blockPos) {
        float[] fArray = 8M.c(this.c.player.getPositionEyes(this.c.getRenderPartialTicks()), new Vec3d((double)((float)blockPos.getX() + 0.5f), (double)((float)blockPos.getY() + 0.5f), (double)((float)blockPos.getZ() + 0.5f)));
        this.c(fArray[0], fArray[1]);
    }

    public float 0() {
        return this.0;
    }

    public float 1() {
        return this.c;
    }

    public static float[] c(Vec3d vec3d, Vec3d vec3d2) {
        double d2 = vec3d2.x - vec3d.x;
        double d3 = (vec3d2.y - vec3d.y) * -1.0;
        double d4 = vec3d2.z - vec3d.z;
        double d5 = MathHelper.sqrt((double)(d2 * d2 + d4 * d4));
        float f2 = (float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(d4, d2)) - 90.0));
        float f3 = (float)MathHelper.wrapDegrees((double)Math.toDegrees(Math.atan2(d3, d5)));
        if (f3 > 90.0f) {
            f3 = 90.0f;
        } else if (f3 < -90.0f) {
            f3 = -90.0f;
        }
        return new float[]{f2, f3};
    }
}

