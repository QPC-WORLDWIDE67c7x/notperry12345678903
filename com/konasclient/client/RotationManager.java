/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.8;
import com.konasclient.client.a;
import com.konasclient.loader.Loader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RotationManager {
    @Nullable
    public static Map<String, byte[]> resourceCache;
    @NotNull
    public static List<String> mixinCache;
    @Nullable
    public static byte[] refmap;
    public static RotationManager INSTANCE;

    @JvmStatic
    public static void resourceCache$annotations() {
    }

    @Nullable
    public static Map getResourceCache() {
        return resourceCache;
    }

    public static void setResourceCache(@Nullable Map map) {
        Map map2;
        resourceCache = map2;
    }

    @NotNull
    public List getMixinCache() {
        return mixinCache;
    }

    /*
     * WARNING - void declaration
     */
    public void setMixinCache(@NotNull List list) {
        void <set-?>;
        mixinCache = <set-?>;
    }

    @Nullable
    public byte[] getRefmap() {
        return refmap;
    }

    /*
     * WARNING - void declaration
     */
    public void setRefmap(@Nullable byte[] byArray) {
        void <set-?>;
        refmap = <set-?>;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void load() {
        8.0.c();
        8.0.0();
        a.c.c().start();
        a.c.c().join();
        Field field = LaunchClassLoader.class.getDeclaredField("resourceCache");
        boolean bl = false;
        boolean bl2 = false;
        Object it = field;
        boolean bl3 = false;
        ((AccessibleObject)it).setAccessible(true);
        Object object = ((Field)it).get(Launch.classLoader);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.ByteArray>");
        }
        resourceCache = TypeIntrinsics.asMutableMap((Object)object);
        a.c.c().c();
        byte[] array = a.c.c().c();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(array);
        ArrayList<String> list = new ArrayList<String>();
        it = new ZipInputStream(inputStream);
        boolean bl4 = false;
        Throwable throwable = null;
        try {
            Ref.ObjectRef objectRef;
            ZipInputStream zipStream = (ZipInputStream)it;
            boolean bl5 = false;
            objectRef();
            Ref.ObjectRef zipEntry = objectRef;
            while (true) {
                String name;
                ZipEntry zipEntry2 = zipStream.getNextEntry();
                boolean bl6 = false;
                boolean bl7 = false;
                ZipEntry it2 = zipEntry2;
                boolean bl8 = false;
                zipEntry.element = it2;
                if (zipEntry2 == null) break;
                ZipEntry zipEntry3 = (ZipEntry)zipEntry.element;
                if (zipEntry3 == null) {
                    Intrinsics.throwNpe();
                }
                if (StringsKt.endsWith$default((String)(name = zipEntry3.getName()), (String)".class", (boolean)false, (int)2, null)) {
                    name = StringsKt.replace$default((String)(name = StringsKt.removeSuffix((String)name, (CharSequence)".class")), (char)'/', (char)'.', (boolean)false, (int)4, null);
                    byte[] bytes = ByteStreamsKt.readBytes((InputStream)zipStream);
                    if (StringsKt.startsWith$default((String)name, (String)"me.darki.konas.mixin.mixins", (boolean)false, (int)2, null)) {
                        mixinCache.add(name);
                    } else {
                        list.add(name);
                    }
                    Map<String, byte[]> map = resourceCache;
                    if (map == null) {
                        Intrinsics.throwNpe();
                    }
                    map.put(name, bytes);
                    continue;
                }
                if (!Intrinsics.areEqual((Object)name, (Object)"mixins.konas.refmap.json")) continue;
                refmap = ByteStreamsKt.readBytes((InputStream)zipStream);
            }
            Throwable throwable2 = Unit.INSTANCE;
        }
        catch (Throwable throwable3) {
            throwable = throwable3;
            throw throwable3;
        }
        finally {
            CloseableKt.closeFinally((Closeable)it, (Throwable)throwable);
        }
        for (String name : list) {
            Launch.classLoader.findClass(name);
            Map<String, byte[]> map = resourceCache;
            if (map == null) {
                Intrinsics.throwNpe();
            }
            map.remove(name);
        }
        list.clear();
        Loader.INSTANCE.load();
    }

    static {
        RotationManager rotationManager;
        INSTANCE = rotationManager = new RotationManager();
        boolean bl = false;
        mixinCache = new ArrayList();
    }
}

