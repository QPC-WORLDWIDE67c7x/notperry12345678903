/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 81
extends Enum {
    public static /* enum */ 81 c = new 81("NONE", 0, 0.0f, 0.0f);
    public static /* enum */ 81 0 = new 81("ARROW", 1, 1.5f, 0.05f);
    public static /* enum */ 81 1 = new 81("POTION", 2, 0.5f, 0.05f);
    public static /* enum */ 81 2 = new 81("EXPERIENCE", 3, 0.7f, 0.07f);
    public static /* enum */ 81 3 = new 81("FISHING_ROD", 4, 1.5f, 0.04f);
    public static /* enum */ 81 4 = new 81("NORMAL", 5, 1.5f, 0.03f);
    public float c;
    public float 0;
    public static 81[] c = new 81[]{c, 0, 1, 2, 3, 4};

    public float c() {
        return this.0;
    }

    /*
     * WARNING - void declaration
     */
    public 81() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.c = var3_1;
        this.0 = var4_2;
    }

    public static 81 c(String string) {
        return Enum.valueOf(81.class, string);
    }

    public float 0() {
        return this.c;
    }

    public static 81[] values() {
        return (81[])c.clone();
    }
}

