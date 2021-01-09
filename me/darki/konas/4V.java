/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4V
extends Enum {
    public static /* enum */ 4V c = new 4V("PACKET", 0);
    public static /* enum */ 4V 0 = new 4V("ANTI", 1);
    public static /* enum */ 4V 1 = new 4V("VANILLA", 2);
    public static /* enum */ 4V 2 = new 4V("TP", 3);
    public static 4V[] c = new 4V[]{c, 0, 1, 2};

    public static 4V c(String string) {
        return Enum.valueOf(4V.class, string);
    }

    public static 4V[] values() {
        return (4V[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4V() {
        void var2_-1;
        void var1_-1;
    }
}

