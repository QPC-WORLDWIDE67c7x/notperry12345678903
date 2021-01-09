/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.block.Block;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 88 {
    public List<Block> c = new ArrayList<Block>();
    public List<String> 0 = new ArrayList<String>();

    public boolean 1(String string) {
        return this.0.remove(string.toUpperCase(Locale.ENGLISH));
    }

    public 88(String ... stringArray) {
        for (String string : stringArray) {
            if (this.0.contains(string.toUpperCase(Locale.ENGLISH)) || Block.getBlockFromName((String)string) == null) continue;
            this.0.add(string.toUpperCase(Locale.ENGLISH));
        }
    }

    public static void c(List list, Block block) {
        String string = block.getRegistryName().getPath();
        if (string != null) {
            list.add(string);
        }
    }

    public void c(ArrayList<String> arrayList) {
        for (String string : arrayList) {
            if (this.0.contains(string.toUpperCase(Locale.ENGLISH)) || Block.getBlockFromName((String)string) == null) continue;
            this.0.add(string.toUpperCase(Locale.ENGLISH));
        }
    }

    public void 1() {
        this.c.clear();
        this.0.forEach(this::c);
    }

    public boolean 0(String string) {
        if (!this.0.contains(string.toUpperCase(Locale.ENGLISH)) && Block.getBlockFromName((String)string) != null) {
            this.0.add(string.toUpperCase(Locale.ENGLISH));
            return true;
        }
        return false;
    }

    public 88(ArrayList<String> arrayList) {
        for (String string : arrayList) {
            if (this.0.contains(string.toUpperCase(Locale.ENGLISH)) || Block.getBlockFromName((String)string) == null) continue;
            this.0.add(string.toUpperCase(Locale.ENGLISH));
        }
    }

    public List<Block> 0() {
        return this.c;
    }

    public void c(String string) {
        Block block = Block.getBlockFromName((String)string);
        if (block != null) {
            this.c.add(block);
        }
    }

    public List<String> c() {
        ArrayList<String> arrayList = new ArrayList<String>();
        this.c.forEach(arg_0 -> 88.c(arrayList, arg_0));
        return arrayList;
    }
}

