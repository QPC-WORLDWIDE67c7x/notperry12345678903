/*
 * Decompiled with CFR 0.151.
 */
package cookiedragon.eventsystem;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 1, 16}, bv={1, 0, 3}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002BE\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000fJ\r\u0010 \u001a\u0006\u0012\u0002\b\u00030\u0004H\u00c6\u0003J\u0010\u0010!\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\t\u0010%\u001a\u00020\rH\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J`\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010+\u001a\u00020\rH\u00d6\u0001J\u001d\u0010,\u001a\u00020-\"\b\b\u0001\u0010.*\u00020\u00022\u0006\u0010/\u001a\u0002H.\u00a2\u0006\u0002\u00100J\t\u00101\u001a\u000202H\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011\u00a8\u00063"}, d2={"Lcookiedragon/eventsystem/SubscribingMethod;", "T", "", "clazz", "Ljava/lang/Class;", "instance", "static", "", "method", "Ljava/lang/reflect/Method;", "handle", "Ljava/lang/invoke/MethodHandle;", "priority", "", "active", "(Ljava/lang/Class;Ljava/lang/Object;ZLjava/lang/reflect/Method;Ljava/lang/invoke/MethodHandle;IZ)V", "getActive", "()Z", "setActive", "(Z)V", "getClazz", "()Ljava/lang/Class;", "getHandle", "()Ljava/lang/invoke/MethodHandle;", "getInstance", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMethod", "()Ljava/lang/reflect/Method;", "getPriority", "()I", "getStatic", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Class;Ljava/lang/Object;ZLjava/lang/reflect/Method;Ljava/lang/invoke/MethodHandle;IZ)Lcookiedragon/eventsystem/SubscribingMethod;", "equals", "other", "hashCode", "invoke", "", "E", "event", "(Ljava/lang/Object;)V", "toString", "", "EventSystem"})
public final class SubscribingMethod<T> {
    @NotNull
    private final Class<?> clazz;
    @Nullable
    private final T instance;
    private final boolean static;
    @NotNull
    private final Method method;
    @NotNull
    private final MethodHandle handle;
    private final int priority;
    private boolean active;

    public final <E> void invoke(@NotNull E event) throws Throwable {
        Intrinsics.checkParameterIsNotNull(event, (String)"event");
        if (this.static) {
            this.handle.invoke(event);
        } else {
            this.handle.invoke(this.instance, event);
        }
    }

    @NotNull
    public final Class<?> getClazz() {
        return this.clazz;
    }

    @Nullable
    public final T getInstance() {
        return this.instance;
    }

    public final boolean getStatic() {
        return this.static;
    }

    @NotNull
    public final Method getMethod() {
        return this.method;
    }

    @NotNull
    public final MethodHandle getHandle() {
        return this.handle;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final void setActive(boolean bl) {
        this.active = bl;
    }

    public SubscribingMethod(@NotNull Class<?> clazz, @Nullable T instance, boolean bl, @NotNull Method method, @NotNull MethodHandle handle, int priority, boolean active) {
        Intrinsics.checkParameterIsNotNull(clazz, (String)"clazz");
        Intrinsics.checkParameterIsNotNull((Object)method, (String)"method");
        Intrinsics.checkParameterIsNotNull((Object)handle, (String)"handle");
        this.clazz = clazz;
        this.instance = instance;
        this.static = bl;
        this.method = method;
        this.handle = handle;
        this.priority = priority;
        this.active = active;
    }

    public /* synthetic */ SubscribingMethod(Class clazz, Object object, boolean bl, Method method, MethodHandle methodHandle, int n2, boolean bl2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n3 & 0x40) != 0) {
            bl2 = false;
        }
        this(clazz, object, bl, method, methodHandle, n2, bl2);
    }

    @NotNull
    public final Class<?> component1() {
        return this.clazz;
    }

    @Nullable
    public final T component2() {
        return this.instance;
    }

    public final boolean component3() {
        return this.static;
    }

    @NotNull
    public final Method component4() {
        return this.method;
    }

    @NotNull
    public final MethodHandle component5() {
        return this.handle;
    }

    public final int component6() {
        return this.priority;
    }

    public final boolean component7() {
        return this.active;
    }

    @NotNull
    public final SubscribingMethod<T> copy(@NotNull Class<?> clazz, @Nullable T instance, boolean bl, @NotNull Method method, @NotNull MethodHandle handle, int priority, boolean active) {
        Intrinsics.checkParameterIsNotNull(clazz, (String)"clazz");
        Intrinsics.checkParameterIsNotNull((Object)method, (String)"method");
        Intrinsics.checkParameterIsNotNull((Object)handle, (String)"handle");
        return new SubscribingMethod<T>(clazz, instance, bl, method, handle, priority, active);
    }

    public static /* synthetic */ SubscribingMethod copy$default(SubscribingMethod subscribingMethod, Class clazz, Object object, boolean bl, Method method, MethodHandle methodHandle, int n2, boolean bl2, int n3, Object object2) {
        if ((n3 & 1) != 0) {
            clazz = subscribingMethod.clazz;
        }
        if ((n3 & 2) != 0) {
            object = subscribingMethod.instance;
        }
        if ((n3 & 4) != 0) {
            bl = subscribingMethod.static;
        }
        if ((n3 & 8) != 0) {
            method = subscribingMethod.method;
        }
        if ((n3 & 0x10) != 0) {
            methodHandle = subscribingMethod.handle;
        }
        if ((n3 & 0x20) != 0) {
            n2 = subscribingMethod.priority;
        }
        if ((n3 & 0x40) != 0) {
            bl2 = subscribingMethod.active;
        }
        return subscribingMethod.copy(clazz, object, bl, method, methodHandle, n2, bl2);
    }

    @NotNull
    public String toString() {
        return "SubscribingMethod(clazz=" + this.clazz + ", instance=" + this.instance + ", static=" + this.static + ", method=" + this.method + ", handle=" + this.handle + ", priority=" + this.priority + ", active=" + this.active + ")";
    }

    public int hashCode() {
        Class<?> clazz = this.clazz;
        T t = this.instance;
        int n2 = ((clazz != null ? clazz.hashCode() : 0) * 31 + (t != null ? t.hashCode() : 0)) * 31;
        int n3 = this.static ? 1 : 0;
        if (n3 != 0) {
            n3 = 1;
        }
        Method method = this.method;
        MethodHandle methodHandle = this.handle;
        int n4 = ((((n2 + n3) * 31 + (method != null ? ((Object)method).hashCode() : 0)) * 31 + (methodHandle != null ? methodHandle.hashCode() : 0)) * 31 + this.priority) * 31;
        int n5 = this.active ? 1 : 0;
        if (n5 != 0) {
            n5 = 1;
        }
        return n4 + n5;
    }

    public boolean equals(@Nullable Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof SubscribingMethod)) break block3;
                SubscribingMethod subscribingMethod = (SubscribingMethod)object;
                if (!Intrinsics.areEqual(this.clazz, subscribingMethod.clazz) || !Intrinsics.areEqual(this.instance, subscribingMethod.instance) || this.static != subscribingMethod.static || !Intrinsics.areEqual((Object)this.method, (Object)subscribingMethod.method) || !Intrinsics.areEqual((Object)this.handle, (Object)subscribingMethod.handle) || this.priority != subscribingMethod.priority || this.active != subscribingMethod.active) break block3;
            }
            return true;
        }
        return false;
    }
}

