/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.viaversion.viafabric.ViaFabric;
import cookiedragon.eventsystem.EventDispatcher;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.Collections;
import me.darki.konas.2;
import me.darki.konas.3D;
import me.darki.konas.3F;
import me.darki.konas.3S;
import me.darki.konas.87;
import me.darki.konas.8h_0;
import me.darki.konas.8p_0;
import net.minecraft.client.Minecraft;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class 3E {
    public String c;
    public String 0;
    public String 1 = "";
    public 8h_0<87> c;
    public 8h_0<Boolean> 0;
    public 3D c;
    public ArrayList<String> c;
    public boolean c;
    public boolean 0;
    public static Minecraft c = Minecraft.getMinecraft();
    public int c = 0;
    public int 0 = 1000;

    public int 9() {
        return this.0;
    }

    public String b() {
        return this.c;
    }

    public boolean 2() {
        if (ViaFabric.getInstance().getVersion() < this.c) {
            return false;
        }
        return ViaFabric.getInstance().getVersion() <= this.0;
    }

    public boolean 3() {
        return (Boolean)((8h_0)((Object)this.0)).6();
    }

    public void d() {
        if (!this.c && this.2()) {
            EventDispatcher.Companion.subscribe(this);
            this.c = true;
            this.c();
            3E.0(this);
        } else {
            EventDispatcher.Companion.unsubscribe(this);
            this.c = false;
            this.7();
            3E.c(this);
        }
    }

    public 3E(String string, String string2, 3D d2, String ... stringArray) {
        this.c = new ArrayList();
        this.c = string;
        this.1 = string2;
        this.c = d2;
        Collections.addAll(this.c, stringArray);
        EventDispatcher.Companion.register(this);
    }

    public 3E(String string, int n2, 3D d2, String ... stringArray) {
        this.c = new ArrayList();
        this.c = string;
        ((87)((8h_0)((Object)this.c)).6()).c(n2);
        this.c = d2;
        Collections.addAll(this.c, stringArray);
        EventDispatcher.Companion.register(this);
    }

    public boolean 4() {
        return 3F.c(3S.class).f();
    }

    public void c(int n2, int n3) {
        this.c = n2;
        this.0 = n3;
    }

    public void c(boolean bl) {
        this.0 = bl;
    }

    public boolean a() {
        return this.0;
    }

    public static boolean 5() {
        return false;
    }

    public static void 0(3E e2) {
        block1: {
            if (3E.c.player == null || 3E.c.world == null) {
                return;
            }
            if (!((Boolean)3F.c("Notify", "Modules").6()).booleanValue() || !3F.c("Notify").f()) break block1;
            8p_0.0(e2.b() + 2.c + "a enabled");
        }
    }

    public void c(String string, TrayIcon.MessageType messageType) {
        block0: {
            boolean bl;
            3S s = (3S)3F.c(3S.class);
            if (s == null || !s.f() || !(bl = ((Boolean)3F.c("Notify", "SystemTray").6()).booleanValue())) break block0;
            s.c(this.b(), string, messageType);
        }
    }

    public 3E(String string, String string2, int n2, 3D d2, String ... stringArray) {
        this.c = new ArrayList();
        this.c = string;
        this.1 = string2;
        ((87)((8h_0)((Object)this.c)).6()).c(n2);
        this.c = d2;
        Collections.addAll(this.c, stringArray);
        EventDispatcher.Companion.register(this);
    }

    public void c() {
    }

    public ArrayList<String> 1() {
        return this.c;
    }

    public 3D e() {
        return this.c;
    }

    public void 0(boolean bl) {
        ((8h_0)((Object)this.0)).2(bl);
    }

    public void c(int n2) {
        ((8h_0)((Object)this.c)).2(new 87(n2));
    }

    public void c(String string) {
        this.c = string;
    }

    public String 8() {
        return this.1;
    }

    public static void c(3E e2) {
        block1: {
            if (3E.c.player == null || 3E.c.world == null) {
                return;
            }
            if (!((Boolean)3F.c("Notify", "Modules").6()).booleanValue() || !3F.c("Notify").f()) break block1;
            8p_0.0(e2.b() + 2.c + "c disabled");
        }
    }

    public void 0(String string) {
        this.0 = string;
    }

    public int 6() {
        return ((87)((8h_0)((Object)this.c)).6()).c();
    }

    public 3E(String string, 3D d2, String ... stringArray) {
        this.c = new ArrayList();
        this.c = string;
        this.c = d2;
        Collections.addAll(this.c, stringArray);
        EventDispatcher.Companion.register(this);
    }

    public void 7() {
    }

    public void 1(boolean bl) {
        this.c = bl;
    }

    public void c(3D d2) {
        this.c = d2;
    }

    public void c(ArrayList<String> arrayList) {
        this.c = arrayList;
    }

    public void 1(String string) {
        this.1 = string;
    }

    public boolean f() {
        return this.c;
    }

    public int g() {
        return this.c;
    }

    public String 0() {
        return this.0;
    }
}

