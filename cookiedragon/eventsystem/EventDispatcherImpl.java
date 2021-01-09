/*
 * Decompiled with CFR 0.151.
 */
package cookiedragon.eventsystem;

import cookiedragon.eventsystem.EventDispatcher;
import cookiedragon.eventsystem.EventDispatcherImplKt;
import cookiedragon.eventsystem.Subscriber;
import cookiedragon.eventsystem.SubscribingMethod;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 16}, bv={1, 0, 3}, k=1, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\u000e\u001a\u0002H\fH\u0016\u00a2\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u001c\u0010\u0015\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0014\u0010\u0019\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lcookiedragon/eventsystem/EventDispatcherImpl;", "Lcookiedragon/eventsystem/EventDispatcher;", "()V", "lookup", "Ljava/lang/invoke/MethodHandles$Lookup;", "kotlin.jvm.PlatformType", "subscriptions", "", "Ljava/lang/Class;", "", "Lcookiedragon/eventsystem/SubscribingMethod;", "dispatch", "T", "", "event", "(Ljava/lang/Object;)Ljava/lang/Object;", "register", "", "subscriber", "clazz", "instance", "setActive", "active", "", "subscribe", "unsubscribe", "EventSystem"})
public final class EventDispatcherImpl
implements EventDispatcher {
    private static final MethodHandles.Lookup lookup;
    private static final Map<Class<?>, Set<SubscribingMethod<?>>> subscriptions;
    public static final EventDispatcherImpl INSTANCE;

    @Override
    @NotNull
    public <T> T dispatch(@NotNull T event) {
        Comparator comparator;
        Intrinsics.checkParameterIsNotNull(event, (String)"event");
        boolean bl = false;
        Comparator comparator2 = comparator = (Comparator)new Comparator<T>(){

            public final int compare(T a2, T b2) {
                boolean bl = false;
                SubscribingMethod it = (SubscribingMethod)b2;
                boolean bl2 = false;
                Comparable comparable = Integer.valueOf(it.getPriority());
                it = (SubscribingMethod)a2;
                Comparable comparable2 = comparable;
                bl2 = false;
                Integer n2 = it.getPriority();
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)n2);
            }
        };
        PriorityQueue invokeQueue = new PriorityQueue(comparator2);
        Class<?> clazz = event.getClass();
        Set classes = SetsKt.mutableSetOf((Object[])new Class[]{clazz});
        while (Intrinsics.areEqual(clazz, Object.class) ^ true) {
            Intrinsics.checkExpressionValueIsNotNull(clazz.getSuperclass(), (String)"clazz.superclass");
            classes.add(clazz);
        }
        Iterable $this$forEach$iv = classes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Set<SubscribingMethod<?>> set;
            Class it = (Class)element$iv;
            boolean bl2 = false;
            if (subscriptions.get(it) == null) continue;
            boolean bl3 = false;
            boolean bl4 = false;
            Set<SubscribingMethod<?>> methods = set;
            boolean bl5 = false;
            for (SubscribingMethod<?> method : methods) {
                if (!method.getActive()) continue;
                invokeQueue.add(method);
            }
        }
        while (true) {
            $this$forEach$iv = invokeQueue;
            boolean bl6 = false;
            if (!(!$this$forEach$iv.isEmpty())) break;
            SubscribingMethod method = (SubscribingMethod)invokeQueue.remove();
            method.invoke(event);
        }
        return event;
    }

    @Override
    public void register(@NotNull Class<?> subscriber) {
        Intrinsics.checkParameterIsNotNull(subscriber, (String)"subscriber");
        this.register(subscriber, null);
    }

    @Override
    public void register(@NotNull Object subscriber) {
        Intrinsics.checkParameterIsNotNull((Object)subscriber, (String)"subscriber");
        this.register(subscriber.getClass(), subscriber);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void register(Class<?> clazz, Object instance) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(Subscriber.class)) continue;
            if (instance == null) {
                v0 = method;
                Intrinsics.checkExpressionValueIsNotNull((Object)v0, (String)"method");
                if (!EventDispatcherImplKt.access$isStatic(v0)) continue;
            }
            if (instance != null) {
                v1 = method;
                Intrinsics.checkExpressionValueIsNotNull((Object)v1, (String)"method");
                if (EventDispatcherImplKt.access$isStatic(v1)) continue;
            }
            annotation = method.getAnnotation(Subscriber.class);
            v2 = method;
            Intrinsics.checkExpressionValueIsNotNull((Object)v2, (String)"method");
            if (Intrinsics.areEqual(v2.getReturnType(), Void.TYPE) ^ true) {
                new IllegalArgumentException("Subscriber " + clazz + '.' + method.getName() + " cannot return type").printStackTrace();
                continue;
            }
            if (method.getParameterCount() != 1) {
                new IllegalArgumentException("Expected only 1 parameter for " + clazz + '.' + method.getName()).printStackTrace();
                continue;
            }
            method.setAccessible(true);
            if (method.getParameterTypes()[0] == null) {
                Intrinsics.throwNpe();
            }
            methodHandle = EventDispatcherImpl.lookup.unreflect(method);
            $this$getOrPut$iv = EventDispatcherImpl.subscriptions;
            $i$f$getOrPut = false;
            value$iv = $this$getOrPut$iv.get(eventType);
            if (value$iv == null) {
                $i$a$-getOrPut-EventDispatcherImpl$register$1 = false;
                var14_16 = false;
                answer$iv = new HashSet<SubscribingMethod<?>>();
                $this$getOrPut$iv.put(eventType, answer$iv);
                v3 = answer$iv;
            } else {
                v3 = value$iv;
            }
            v4 = EventDispatcherImplKt.access$isStatic(method);
            v5 = methodHandle;
            Intrinsics.checkExpressionValueIsNotNull((Object)v5, (String)"methodHandle");
            v3.add(new SubscribingMethod<T>(clazz, instance, v4, method, v5, annotation.priority(), false, 64, null));
            v6 = EventDispatcherImpl.subscriptions;
            v7 = eventType;
            v8 /* !! */  = EventDispatcherImpl.subscriptions.get(eventType);
            if (v8 /* !! */  == null) ** GOTO lbl-1000
            var17_19 = v8 /* !! */ ;
            var16_18 = v7;
            var15_17 = v6;
            var10_11 = false;
            var18_20 = new Comparator<T>(){

                public final int compare(T a2, T b2) {
                    boolean bl = false;
                    SubscribingMethod it = (SubscribingMethod)b2;
                    boolean bl2 = false;
                    Comparable comparable = Integer.valueOf(it.getPriority());
                    it = (SubscribingMethod)a2;
                    Comparable comparable2 = comparable;
                    bl2 = false;
                    Integer n2 = it.getPriority();
                    return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)n2);
                }
            };
            v6 = var15_17;
            v7 = var16_18;
            v8 /* !! */  = CollectionsKt.sortedWith((Iterable)var17_19, (Comparator)var18_20);
            if (v8 /* !! */  != null) {
                v9 = CollectionsKt.toMutableSet((Iterable)v8 /* !! */ );
            } else lbl-1000:
            // 2 sources

            {
                v9 = null;
            }
            if (v9 == null) {
                Intrinsics.throwNpe();
            }
            v6.put(v7, v9);
        }
    }

    @Override
    public void subscribe(@NotNull Class<?> subscriber) {
        Intrinsics.checkParameterIsNotNull(subscriber, (String)"subscriber");
        this.setActive(subscriber, true);
    }

    @Override
    public void subscribe(@NotNull Object subscriber) {
        Intrinsics.checkParameterIsNotNull((Object)subscriber, (String)"subscriber");
        this.setActive(subscriber, true);
    }

    @Override
    public void unsubscribe(@NotNull Class<?> subscriber) {
        Intrinsics.checkParameterIsNotNull(subscriber, (String)"subscriber");
        this.setActive(subscriber, false);
    }

    @Override
    public void unsubscribe(@NotNull Object subscriber) {
        Intrinsics.checkParameterIsNotNull((Object)subscriber, (String)"subscriber");
        this.setActive(subscriber, false);
    }

    private final void setActive(Object instance, boolean active) {
        for (Set<SubscribingMethod<?>> methods : subscriptions.values()) {
            for (SubscribingMethod<?> method : methods) {
                if (!Intrinsics.areEqual(method.getInstance(), (Object)instance)) continue;
                method.setActive(active);
            }
        }
    }

    private final void setActive(Class<?> subscriber, boolean active) {
        for (Set<SubscribingMethod<?>> methods : subscriptions.values()) {
            for (SubscribingMethod<?> method : methods) {
                if (!Intrinsics.areEqual(method.getClazz(), subscriber)) continue;
                method.setActive(active);
            }
        }
    }

    private EventDispatcherImpl() {
    }

    static {
        EventDispatcherImpl eventDispatcherImpl;
        INSTANCE = eventDispatcherImpl = new EventDispatcherImpl();
        lookup = MethodHandles.lookup();
        subscriptions = new ConcurrentHashMap();
    }
}

