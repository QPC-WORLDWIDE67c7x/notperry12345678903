/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 5Q
extends Enum {
    public static /* enum */ 5Q c = new 5Q("ROT13", 0);
    public static /* enum */ 5Q 0 = new 5Q("PROTOCOL", 1);
    public static 5Q[] c = new 5Q[]{c, 0};

    public static 5Q c(String string) {
        return Enum.valueOf(5Q.class, string);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 5Q() {
        void var2_-1;
        void var1_-1;
    }

    public static 5Q[] values() {
        return (5Q[])c.clone();
    }
}

