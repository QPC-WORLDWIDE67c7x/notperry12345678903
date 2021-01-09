/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3D
extends Enum {
    public static /* enum */ 3D c = new 3D("COMBAT", 0);
    public static /* enum */ 3D 0 = new 3D("MOVEMENT", 1);
    public static /* enum */ 3D 1 = new 3D("PLAYER", 2);
    public static /* enum */ 3D 2 = new 3D("RENDER", 3);
    public static /* enum */ 3D 3 = new 3D("MISC", 4);
    public static /* enum */ 3D 4 = new 3D("EXPLOIT", 5);
    public static /* enum */ 3D 5 = new 3D("CLIENT", 6);
    public static 3D[] c = new 3D[]{c, 0, 1, 2, 3, 4, 5};

    public static 3D c(String string) {
        return Enum.valueOf(3D.class, string);
    }

    public static 3D[] values() {
        return (3D[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 3D() {
        void var2_-1;
        void var1_-1;
    }
}

