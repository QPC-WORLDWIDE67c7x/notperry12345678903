/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3K
extends Enum {
    public static /* enum */ 3K c = new 3K("NONE", 0);
    public static /* enum */ 3K 0 = new 3K("VANILLA", 1);
    public static /* enum */ 3K 1 = new 3K("KONAS", 2);
    public static /* enum */ 3K 2 = new 3K("BOTH", 3);
    public static 3K[] c = new 3K[]{c, 0, 1, 2};

    public static 3K[] values() {
        return (3K[])c.clone();
    }

    public static 3K c(String string) {
        return Enum.valueOf(3K.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 3K() {
        void var2_-1;
        void var1_-1;
    }
}

