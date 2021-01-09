/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import com.konasclient.loader.Loader;
import cookiedragon.eventsystem.EventDispatcher;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import me.darki.konas.20;
import me.darki.konas.21;
import me.darki.konas.23;
import me.darki.konas.24;
import me.darki.konas.25;
import me.darki.konas.26;
import me.darki.konas.2F;
import me.darki.konas.2c_0;
import me.darki.konas.2e_0;
import me.darki.konas.2n_0;
import me.darki.konas.3;
import me.darki.konas.38;
import me.darki.konas.3F;
import me.darki.konas.3f_0;
import me.darki.konas.8A;
import me.darki.konas.8B;
import me.darki.konas.8M;
import me.darki.konas.8P;
import me.darki.konas.8T;
import me.darki.konas.9d;
import me.darki.konas.9n;
import me.darki.konas.9q;
import me.darki.konas.T;
import me.darki.konas.U;
import me.darki.konas.c;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import sun.misc.Unsafe;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Renamed from me.darki.konas.8k
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8k_0 {
    public static 8k_0 c = new 8k_0();
    public 2n_0 c;
    public 38 c;
    public 2e_0 c;
    public 26 c;
    public 9n c;
    public 8T c;
    public 2F c;
    public 8P c;
    public 9q c;
    public 8M c;
    public c c;

    /*
     * Unable to fully structure code
     */
    public void 0() {
        block52: {
            block51: {
                3F.c();
                3.0();
                this.c = new 2F();
                this.c.0();
                v0 = Unsafe.class;
                v1 = "theUnsafe";
                v2 = v0.getDeclaredField(v1);
                v3 = var1_1 = v2;
                v4 = true;
                v3.setAccessible(v4);
                v5 = var1_1;
                v6 = null;
                v7 = v5.get(v6);
                v8 = (Unsafe)v7;
                v9 = Loader.INSTANCE;
                v10 = v9.getAddress();
                v11 = v8.getByte(v10);
                var2_4 = v11;
                if (var2_4 != 111) break block51;
                v12 = MinecraftForge.EVENT_BUS;
                v13 = 2c_0.c;
                v12.register((Object)v13);
                v14 = EventDispatcher.Companion;
                v15 = 23.c;
                v14.register(v15);
                v16 = EventDispatcher.Companion;
                v17 = 21.c;
                v16.register(v17);
                v18 = EventDispatcher.Companion;
                v19 = 23.c;
                v18.subscribe(v19);
                v20 = EventDispatcher.Companion;
                v21 = 21.c;
                v20.subscribe(v21);
                v22 = EventDispatcher.Companion;
                v23 = 8A.c;
                v22.register(v23);
                v24 = EventDispatcher.Companion;
                v25 = 8A.c;
                v24.subscribe(v25);
                v26 = EventDispatcher.Companion;
                v27 = 20.c;
                v26.register(v27);
                v28 = EventDispatcher.Companion;
                v29 = 20.c;
                v28.subscribe(v29);
                v30 = EventDispatcher.Companion;
                v31 = 24.c;
                v30.register(v31);
                v32 = EventDispatcher.Companion;
                v33 = 24.c;
                v32.subscribe(v33);
                v34 = EventDispatcher.Companion;
                v35 = 25.c;
                v34.register(v35);
                v36 = EventDispatcher.Companion;
                v37 = 25.c;
                try {
                    v36.subscribe(v37);
                }
                catch (Exception var1_2) {
                    // empty catch block
                }
            }
            this.c = new 2n_0();
            this.c.0();
            this.c = new 38();
            this.c.c();
            3f_0.c();
            this.c = new 26();
            EventDispatcher.Companion.register(this.c);
            EventDispatcher.Companion.subscribe(this.c);
            this.c = new 9n();
            EventDispatcher.Companion.register(this.c);
            EventDispatcher.Companion.subscribe(this.c);
            this.c = new 8P();
            EventDispatcher.Companion.register(this.c);
            EventDispatcher.Companion.subscribe(this.c);
            this.c = new 8M();
            EventDispatcher.Companion.register(this.c);
            EventDispatcher.Companion.subscribe(this.c);
            this.c = new 9q();
            this.c = new 8T();
            8B.c = new 8B();
            this.c = new 2e_0(Minecraft.getMinecraft().currentScreen);
            this.c.0();
            T.c(T.0(), true);
            Runtime.getRuntime().addShutdownHook(new U());
            v38 = "os.arch";
            v39 = System.getProperty(v38);
            v40 = "aarch64";
            v41 = v39.equals(v40);
            if (v41) ** GOTO lbl142
            v42 = this;
            v43 = v44;
            v45 = v44;
            v43();
            try {
                v42.c = v45;
                break block52;
lbl142:
                // 1 sources

                this.c = null;
            }
            catch (Exception var1_3) {
                this.c = null;
            }
        }
    }

    public void c() {
        3F.c.start();
        if (!T.c.exists()) {
            T.c.mkdir();
        }
        if (!T.1.exists()) {
            T.1.mkdir();
        }
        if (T.c.listFiles() != null) {
            List list = Arrays.stream(T.c.listFiles()).filter(8k_0::c).collect(Collectors.toList());
            for (File file : list) {
                T.c(file, new File(T.1, file.getName()));
            }
        }
        T.c(T.4, T.0);
        T.c(T.5, T.2);
        T.c(new File(Minecraft.getMinecraft().gameDir, "Fonts"), 9d.c);
        if (new File(Minecraft.getMinecraft().gameDir, "Fonts").exists()) {
            T.c(new File(Minecraft.getMinecraft().gameDir, "Fonts"), 9d.c);
        } else {
            9d.c.mkdir();
        }
    }

    public static boolean c(File file) {
        return file.getName().endsWith(".json") && !file.getName().equalsIgnoreCase("config.json") && !file.getName().equalsIgnoreCase("accounts.json");
    }
}

