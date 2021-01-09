/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7I
extends Enum {
    public static /* enum */ 7I c = new 7I("VANILLA", 0);
    public static /* enum */ 7I 0 = new 7I("CUSTOM", 1);
    public static /* enum */ 7I 1 = new 7I("HIGHRES", 2);
    public static 7I[] c = new 7I[]{c, 0, 1};

    public static 7I c(String string) {
        return Enum.valueOf(7I.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7I() {
        void var2_-1;
        void var1_-1;
    }

    public static 7I[] values() {
        return (7I[])c.clone();
    }
}

