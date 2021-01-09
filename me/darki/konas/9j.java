/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.mixin.mixins.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.ARBShaderObjects;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 9j {
    public static Minecraft c = Minecraft.getMinecraft();

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int c(String string, int n2) throws Exception {
        StringBuilder stringBuilder;
        RuntimeException runtimeException;
        int n3;
        int n4 = 0;
        try {
            n3 = n2;
        }
        catch (Exception exception) {
            ARBShaderObjects.glDeleteObjectARB((int)n4);
            throw exception;
        }
        int n5 = ARBShaderObjects.glCreateShaderObjectARB((int)n3);
        n4 = n5;
        if (n4 == 0) {
            return 0;
        }
        int n6 = n4;
        String string2 = string;
        ARBShaderObjects.glShaderSourceARB((int)n6, (CharSequence)string2);
        int n7 = n4;
        ARBShaderObjects.glCompileShaderARB((int)n7);
        int n8 = n4;
        int n9 = 35713;
        int n10 = ARBShaderObjects.glGetObjectParameteriARB((int)n8, (int)n9);
        if (n10 != 0) return n4;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = runtimeException;
        StringBuilder stringBuilder2 = stringBuilder;
        StringBuilder stringBuilder3 = stringBuilder;
        stringBuilder2();
        String string3 = "Error creating shader: ";
        StringBuilder stringBuilder4 = stringBuilder3.append(string3);
        int n11 = n4;
        String string4 = 9j.c(n11);
        StringBuilder stringBuilder5 = stringBuilder4.append(string4);
        String string5 = stringBuilder5.toString();
        runtimeException2(string5);
        throw runtimeException3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean c(int n2, int n3, int n4, int n5, int n6, int n7) {
        if (n6 < n2) return false;
        if (n6 > n4) return false;
        if (n7 < n3) return false;
        if (n7 > n5) return false;
        return true;
    }

    public static double[] 1(Entity entity) {
        if (entity.lastTickPosX == 0.0 && entity.lastTickPosY == 0.0 && entity.lastTickPosZ == 0.0) {
            entity.lastTickPosX = entity.posX;
            entity.lastTickPosY = entity.posY;
            entity.lastTickPosZ = entity.posZ;
        }
        double d2 = 9j.c(entity.posX, entity.lastTickPosX) - ((IRenderManager)c.getRenderManager()).getRenderPosX();
        double d3 = 9j.c(entity.posY, entity.lastTickPosY) - ((IRenderManager)c.getRenderManager()).getRenderPosY();
        double d4 = 9j.c(entity.posZ, entity.lastTickPosZ) - ((IRenderManager)c.getRenderManager()).getRenderPosZ();
        return new double[]{d2, d3, d4};
    }

    public static double c(double d2, double d3) {
        return d3 + (d2 - d3) * (double)c.getRenderPartialTicks();
    }

    public static double 0(Entity entity) {
        return 9j.c(entity.lastTickPosY, entity.posY, c.getRenderPartialTicks());
    }

    public static double 2(Entity entity) {
        return 9j.c(entity.lastTickPosX, entity.posX, c.getRenderPartialTicks());
    }

    public static double 0() {
        return 9j.c(9j.c.player.lastTickPosX, 9j.c.player.posX, c.getRenderPartialTicks());
    }

    public static double c() {
        return 9j.c(9j.c.player.lastTickPosZ, 9j.c.player.posZ, c.getRenderPartialTicks());
    }

    public static String c(int n2) {
        return ARBShaderObjects.glGetInfoLogARB((int)n2, (int)ARBShaderObjects.glGetObjectParameteriARB((int)n2, (int)35716));
    }

    public static double c(Entity entity) {
        return 9j.c(entity.lastTickPosZ, entity.posZ, c.getRenderPartialTicks());
    }

    public static double 1() {
        return 9j.c(9j.c.player.lastTickPosY, 9j.c.player.posY, c.getRenderPartialTicks());
    }

    public static double c(double d2, double d3, double d4) {
        return d2 + (d3 - d2) * d4;
    }
}

