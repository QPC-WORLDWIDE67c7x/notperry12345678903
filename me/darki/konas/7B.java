/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7B
extends Enum {
    public static /* enum */ 7B c = new 7B("BOTTOM", 0);
    public static /* enum */ 7B 0 = new 7B("OUTLINE", 1);
    public static /* enum */ 7B 1 = new 7B("FULL", 2);
    public static /* enum */ 7B 2 = new 7B("WIREFRAME", 3);
    public static /* enum */ 7B 3 = new 7B("FADE", 4);
    public static 7B[] c = new 7B[]{c, 0, 1, 2, 3};

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7B() {
        void var2_-1;
        void var1_-1;
    }

    public static 7B c(String string) {
        return Enum.valueOf(7B.class, string);
    }

    public static 7B[] values() {
        return (7B[])c.clone();
    }
}

