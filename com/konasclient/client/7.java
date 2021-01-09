/*
 * Decompiled with CFR 0.151.
 */
package com.konasclient.client;

import com.konasclient.client.5;
import com.konasclient.client.8;
import com.konasclient.client.h;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 7
implements 8 {
    public static String[] c;
    public static 7 c;

    @Override
    public void c() {
        Object v0;
        Object object;
        boolean bl;
        Object object2;
        block7: {
            object2 = ManagementFactory.getRuntimeMXBean().getInputArguments();
            bl = false;
            Iterator iterator = object2.iterator();
            while (iterator.hasNext()) {
                object = iterator.next();
                String string = (String)object;
                boolean bl2 = false;
                if (!ArraysKt.contains((Object[])c, (Object)string)) continue;
                v0 = object;
                break block7;
            }
            v0 = null;
        }
        String string = v0;
        if (string != null) {
            object2 = string;
            bl = false;
            boolean bl3 = false;
            object = object2;
            boolean bl4 = false;
            7 var6_9 = this;
            boolean bl5 = false;
            Unsafe unsafe = h.c();
            long l2 = 0L;
            long l3 = 0L;
            try {
                unsafe.putAddress(l2, l3);
            }
            catch (Exception throwable) {
                // empty catch block
            }
            Runtime.getRuntime().exit(0);
            throwable = new Error();
            boolean bl6 = false;
            boolean bl7 = false;
            Throwable throwable = throwable;
            boolean bl8 = false;
            throwable.setStackTrace(new StackTraceElement[0]);
            throw throwable;
        }
    }

    @Override
    public void 0() {
        try {
        }
        catch (Throwable throwable) {
            boolean bl;
            Method[] methodArray;
            block28: {
                String string = "sun.instrument.InstrumentationImpl";
                boolean bl2 = false;
                ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                Class<?> clazz = Class.forName(string, bl2, classLoader);
                Class<?> clazz2 = clazz;
                Method[] methodArray2 = clazz2.getDeclaredMethods();
                methodArray = methodArray2;
                bl = false;
                if (!(methodArray.length == 0)) break block28;
                try {
                    return;
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
            }
            throwable.printStackTrace();
            methodArray = this;
            bl = false;
            Unsafe unsafe = h.c();
            long l2 = 0L;
            long l3 = 0L;
            try {
                unsafe.putAddress(l2, l3);
            }
            catch (Exception throwable3) {
                // empty catch block
            }
            Runtime.getRuntime().exit(0);
            throwable3 = new Error();
            boolean bl3 = false;
            boolean bl4 = false;
            Throwable throwable4 = throwable3;
            boolean bl5 = false;
            throwable4.setStackTrace(new StackTraceElement[0]);
            throw throwable3;
        }
        String string = "sun/instrument/InstrumentationImpl";
        byte[] byArray = 5.c(string);
        byte[] byArray2 = byArray;
        Unsafe unsafe = h.c();
        String string2 = "sun.instrument.InstrumentationImpl";
        byte[] byArray3 = byArray2;
        int n2 = 0;
        int n3 = byArray2.length;
        ClassLoader classLoader = null;
        ProtectionDomain protectionDomain = null;
        unsafe.defineClass(string2, byArray3, n2, n3, classLoader, protectionDomain);
    }

    @Override
    @NotNull
    public Void c() {
        int n2 = 0;
        Unsafe unsafe = h.c();
        long l2 = 0L;
        long l3 = 0L;
        try {
            unsafe.putAddress(l2, l3);
        }
        catch (Exception exception) {
            // empty catch block
        }
        Runtime.getRuntime().exit(0);
        Error error = new Error();
        boolean bl = false;
        boolean bl2 = false;
        Error error2 = error;
        boolean bl3 = false;
        error2.setStackTrace(new StackTraceElement[0]);
        throw (Throwable)error;
    }

    static {
        7 var0;
        c = var0 = new 7();
        c = new String[]{"-javaagent", "-Xdebug", "-agentlib", "-Xrunjdwp", "-Xnoagent", "-DproxySet", "-DproxyHost", "-DproxyPort", "-Djavax.net.ssl.trustStore", "-Djavax.net.ssl.trustStorePassword", "-Dlegacy.debugClassLoading=true", "-Dlegacy.debugClassLoadingSave=true"};
    }
}

