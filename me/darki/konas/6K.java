/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 6K
extends Enum {
    public static /* enum */ 6K c = new 6K("SPIN", 0);
    public static /* enum */ 6K 0 = new 6K("JITTER", 1);
    public static /* enum */ 6K 1 = new 6K("STARE", 2);
    public static 6K[] c = new 6K[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 6K() {
        void var2_-1;
        void var1_-1;
    }

    public static 6K c(String string) {
        return Enum.valueOf(6K.class, string);
    }

    public static 6K[] values() {
        return (6K[])c.clone();
    }
}

