/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 2G
extends Enum {
    public static /* enum */ 2G c = new 2G("TOP_RIGHT", 0);
    public static /* enum */ 2G 0 = new 2G("TOP_LEFT", 1);
    public static /* enum */ 2G 1 = new 2G("BOTTOM_RIGHT", 2);
    public static /* enum */ 2G 2 = new 2G("BOTTOM_LEFT", 3);
    public static 2G[] c = new 2G[]{c, 0, 1, 2};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 2G() {
        void var2_-1;
        void var1_-1;
    }

    public static 2G[] values() {
        return (2G[])c.clone();
    }

    public static 2G c(String string) {
        return Enum.valueOf(2G.class, string);
    }
}

