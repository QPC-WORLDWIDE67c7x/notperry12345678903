/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6G
extends Enum {
    public static /* enum */ 6G c = new 6G("LEGIT", 0);
    public static /* enum */ 6G 0 = new 6G("RAGE", 1);
    public static 6G[] c = new 6G[]{c, 0};

    public static 6G c(String string) {
        return Enum.valueOf(6G.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6G() {
        void var2_-1;
        void var1_-1;
    }

    public static 6G[] values() {
        return (6G[])c.clone();
    }
}

