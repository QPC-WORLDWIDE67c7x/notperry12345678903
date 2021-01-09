/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3L
extends Enum {
    public static /* enum */ 3L c = new 3L("STATIC", 0);
    public static /* enum */ 3L 0 = new 3L("DYNAMIC", 1);
    public static 3L[] c = new 3L[]{c, 0};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 3L() {
        void var2_-1;
        void var1_-1;
    }

    public static 3L[] values() {
        return (3L[])c.clone();
    }

    public static 3L c(String string) {
        return Enum.valueOf(3L.class, string);
    }
}

