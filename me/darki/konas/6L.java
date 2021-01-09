/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6L
extends Enum {
    public static /* enum */ 6L c = new 6L("NONE", 0);
    public static /* enum */ 6L 0 = new 6L("JITTER", 1);
    public static /* enum */ 6L 1 = new 6L("STARE", 2);
    public static /* enum */ 6L 2 = new 6L("DOWN", 3);
    public static 6L[] c = new 6L[]{c, 0, 1, 2};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6L() {
        void var2_-1;
        void var1_-1;
    }

    public static 6L[] values() {
        return (6L[])c.clone();
    }

    public static 6L c(String string) {
        return Enum.valueOf(6L.class, string);
    }
}

