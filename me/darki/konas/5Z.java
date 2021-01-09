/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5Z
extends Enum {
    public static /* enum */ 5Z c = new 5Z("NORMAL", 0);
    public static /* enum */ 5Z 0 = new 5Z("RIGHTCLICK", 1);
    public static 5Z[] c = new 5Z[]{c, 0};

    public static 5Z[] values() {
        return (5Z[])c.clone();
    }

    public static 5Z c(String string) {
        return Enum.valueOf(5Z.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5Z() {
        void var2_-1;
        void var1_-1;
    }
}

