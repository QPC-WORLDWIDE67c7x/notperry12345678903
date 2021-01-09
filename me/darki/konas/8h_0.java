/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.viaversion.viafabric.ViaFabric;
import java.util.function.BooleanSupplier;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.8f_0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8h
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8h_0 {
    public String c;
    public String 0;
    public T c;
    public T 0;
    public T 1;
    public T 2;
    public int c;
    public int 0 = 1000;
    public BooleanSupplier c;
    public 8h_0<8f_0> c = null;

    public T d() {
        return this.2;
    }

    public 8h_0<T> c(int n2, int n3) {
        this.c = n2;
        this.0 = n3;
        return this;
    }

    public boolean 2() {
        if (ViaFabric.getInstance().getVersion() < this.c) {
            return false;
        }
        return ViaFabric.getInstance().getVersion() <= this.0;
    }

    public void 1(String string) {
        this.c = string;
    }

    public boolean b() {
        if (this.c != null && !((8f_0)((8h_0)((Object)this.c)).6()).c()) {
            return false;
        }
        if (!this.2()) {
            return false;
        }
        return this.c.getAsBoolean();
    }

    public void 1(T t) {
        this.2 = t;
    }

    public T 7() {
        return this.1;
    }

    public String c() {
        return this.c;
    }

    public 8h_0(String string, T t) {
        this.c = string;
        this.c = t;
    }

    public int a() {
        return this.0;
    }

    public T 6() {
        return this.c;
    }

    public static boolean 4() {
        return true;
    }

    public T 8() {
        return this.0;
    }

    public 8h_0<T> 0(String string) {
        this.0 = string;
        return this;
    }

    public boolean 0() {
        return this.0.length() > 0;
    }

    public void 2(T t) {
        if (this.0 != null && this.1 != null) {
            Number number = (Number)t;
            Number number2 = (Number)((Object)this.0);
            Number number3 = (Number)this.1;
            this.c = number;
        } else {
            this.c = t;
        }
    }

    public 8h_0(String string, T t, T t2, T t3, T t4) {
        this.c = string;
        this.c = t;
        this.1 = t2;
        this.0 = t3;
        this.2 = t4;
    }

    public int e() {
        return this.c;
    }

    public 8h_0<T> c(BooleanSupplier booleanSupplier) {
        this.c = booleanSupplier;
        return this;
    }

    public String 9() {
        return this.0;
    }

    public 8h_0<T> c(8h_0<8f_0> h_02) {
        this.c = h_02;
        return this;
    }

    public 3E 1() {
        for (3E e2 : 3F.2()) {
            if (3F.c(e2.b(), this.c()) == null) continue;
            return e2;
        }
        return null;
    }

    public int 3(String string) {
        for (int i2 = 0; i2 < this.c.getClass().getEnumConstants().length; ++i2) {
            Enum enum_ = (Enum)this.c.getClass().getEnumConstants()[i2];
            if (!enum_.name().equalsIgnoreCase(string)) continue;
            return i2;
        }
        return -1;
    }

    public void 2(String string) {
        if (this.c(string) != null) {
            this.c = this.c(string);
        }
    }

    public void c(T t) {
        this.0 = t;
    }

    public void 0(T t) {
        this.1 = t;
    }

    public Enum c(String string) {
        for (Enum enum_ : (Enum[])((Enum)((Object)this.c)).getClass().getEnumConstants()) {
            if (!enum_.name().equalsIgnoreCase(string)) continue;
            return enum_;
        }
        return null;
    }

    public boolean 3() {
        return this.c != null;
    }

    public 8h_0<8f_0> 5() {
        return this.c;
    }
}

