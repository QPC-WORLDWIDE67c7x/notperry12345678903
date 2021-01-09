/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4D
extends Enum {
    public static /* enum */ 4D c = new 4D("SEARCHING", 0);
    public static /* enum */ 4D 0 = new 4D("CRYSTAL", 1);
    public static /* enum */ 4D 1 = new 4D("REDSTONE", 2);
    public static /* enum */ 4D 2 = new 4D("BREAKING", 3);
    public static /* enum */ 4D 3 = new 4D("EXPLOSION", 4);
    public static 4D[] c = new 4D[]{c, 0, 1, 2, 3};

    public static 4D[] values() {
        return (4D[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4D() {
        void var2_-1;
        void var1_-1;
    }

    public static 4D c(String string) {
        return Enum.valueOf(4D.class, string);
    }
}

