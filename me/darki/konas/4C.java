/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 4C
extends Enum {
    public static /* enum */ 4C c = new 4C("DAMAGE", 0);
    public static /* enum */ 4C 0 = new 4C("PUSH", 1);
    public static 4C[] c = new 4C[]{c, 0};

    public static 4C[] values() {
        return (4C[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 4C() {
        void var2_-1;
        void var1_-1;
    }

    public static 4C c(String string) {
        return Enum.valueOf(4C.class, string);
    }
}

