/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 42
extends Enum {
    public static /* enum */ 42 c = new 42("TICK", 0);
    public static /* enum */ 42 0 = new 42("ALWAYS", 1);
    public static 42[] c = new 42[]{c, 0};

    public static 42[] values() {
        return (42[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 42() {
        void var2_-1;
        void var1_-1;
    }

    public static 42 c(String string) {
        return Enum.valueOf(42.class, string);
    }
}

