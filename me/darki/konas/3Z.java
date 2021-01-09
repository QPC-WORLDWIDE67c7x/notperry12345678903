/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 3Z
extends Enum {
    public static /* enum */ 3Z c = new 3Z("CUSTOM", 0);
    public static /* enum */ 3Z 0 = new 3Z("LOGOUT", 1);
    public static /* enum */ 3Z 1 = new 3Z("DEATH", 2);
    public static 3Z[] c = new 3Z[]{c, 0, 1};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 3Z() {
        void var2_-1;
        void var1_-1;
    }

    public static 3Z c(String string) {
        return Enum.valueOf(3Z.class, string);
    }

    public static 3Z[] values() {
        return (3Z[])c.clone();
    }
}

