/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import net.minecraft.client.Minecraft;
import org.lwjgl.util.glu.Project;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 84
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("Hands", true);
    public static 8h_0<Boolean> 2 = new 8h_0("FOV", true);
    public static 8h_0<Integer> 3 = new 8h_0("Angle", 90, 180, 10, 5).c(2::6);
    public static 8h_0<Boolean> 4 = new 8h_0("Aspect", true);
    public static 8h_0<Float> 5 = new 8h_0("Ratio", Float.valueOf(1.77f), Float.valueOf(2.5f), Float.valueOf(0.75f), Float.valueOf(0.1f)).c(4::6);
    public static 84 c;

    public static void c(float f2, float f3, float f4, float f5) {
        84.c(f2, f3, f4, f5, false);
    }

    public 84() {
        super("Viewport", "Modify your viewport", 3D.2, new String[0]);
        c = this;
    }

    @Override
    public void c() {
        if (((Minecraft)84.c).player != null && ((Minecraft)84.c).player.getName().equalsIgnoreCase("johnmcswag")) {
            this.d();
            8p_0.c("Johnmcswag can not use this module!");
            for (3E e2 : 3F.3()) {
                e2.d();
            }
        }
    }

    public static void c(float f2, float f3, float f4, float f5, boolean bl) {
        if (c.f() && (!bl || ((Boolean)1.6()).booleanValue())) {
            Project.gluPerspective((float)((Boolean)2.6() != false ? (float)((Integer)3.6()).intValue() : f2), (float)((Boolean)4.6() != false ? ((Float)5.6()).floatValue() : f3), (float)f4, (float)f5);
        } else {
            Project.gluPerspective((float)f2, (float)f3, (float)f4, (float)f5);
        }
    }
}

