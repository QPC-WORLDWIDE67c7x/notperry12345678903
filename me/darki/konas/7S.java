/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 7S
extends Enum {
    public static /* enum */ 7S c = new 7S("ANTIALIAS", 0);
    public static /* enum */ 7S 0 = new 7S("ART", 1);
    public static /* enum */ 7S 1 = new 7S("BITS", 2);
    public static /* enum */ 7S 2 = new 7S("BLOBS", 3);
    public static /* enum */ 7S 3 = new 7S("BLOBS2", 4);
    public static /* enum */ 7S 4 = new 7S("BLUR", 5);
    public static /* enum */ 7S 5 = new 7S("BUMPY", 6);
    public static /* enum */ 7S 6 = new 7S("COLOR_CONVOLVE", 7);
    public static /* enum */ 7S 7 = new 7S("CREEPER", 8);
    public static /* enum */ 7S 8 = new 7S("DECONVERGE", 9);
    public static /* enum */ 7S 9 = new 7S("DESATURATE", 10);
    public static /* enum */ 7S a = new 7S("ENTITY_OUTLINE", 11);
    public static /* enum */ 7S b = new 7S("FLIP", 12);
    public static /* enum */ 7S d = new 7S("FXAA", 13);
    public static /* enum */ 7S e = new 7S("GREEN", 14);
    public static /* enum */ 7S f = new 7S("INVERT", 15);
    public static /* enum */ 7S g = new 7S("NOTCH", 16);
    public static /* enum */ 7S h = new 7S("NTSC", 17);
    public static /* enum */ 7S i = new 7S("OUTLINE", 18);
    public static /* enum */ 7S j = new 7S("PENCIL", 19);
    public static /* enum */ 7S k = new 7S("PHOSPHOR", 20);
    public static /* enum */ 7S l = new 7S("SCAN_PINCUSION", 21);
    public static /* enum */ 7S m = new 7S("SOBEL", 22);
    public static /* enum */ 7S n = new 7S("SPIDER", 23);
    public static /* enum */ 7S o = new 7S("WOBBLE", 24);
    public static 7S[] c = new 7S[]{c, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, d, e, f, g, h, i, j, k, l, m, n, o};

    public static 7S[] values() {
        return (7S[])c.clone();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public 7S() {
        void var2_-1;
        void var1_-1;
    }

    public static 7S c(String string) {
        return Enum.valueOf(7S.class, string);
    }
}

