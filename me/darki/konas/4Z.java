/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4Z
extends Enum {
    public static /* enum */ 4Z c = new 4Z("NONE", 0);
    public static /* enum */ 4Z 0 = new 4Z("NORMAL", 1);
    public static /* enum */ 4Z 1 = new 4Z("LIMITED", 2);
    public static /* enum */ 4Z 2 = new 4Z("STRICT", 3);
    public static 4Z[] c = new 4Z[]{c, 0, 1, 2};

    public static 4Z[] values() {
        return (4Z[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4Z() {
        void var2_-1;
        void var1_-1;
    }

    public static 4Z c(String string) {
        return Enum.valueOf(4Z.class, string);
    }
}

