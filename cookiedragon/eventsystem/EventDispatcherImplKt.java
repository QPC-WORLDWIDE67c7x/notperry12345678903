/*
 * Decompiled with CFR 0.151.
 */
package cookiedragon.eventsystem;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 16}, bv={1, 0, 3}, k=2, d1={"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u00a8\u0006\u0003"}, d2={"isStatic", "", "Ljava/lang/reflect/Method;", "EventSystem"})
public final class EventDispatcherImplKt {
    private static final boolean isStatic(@NotNull Method $this$isStatic) {
        return Modifier.isStatic($this$isStatic.getModifiers());
    }

    public static final /* synthetic */ boolean access$isStatic(Method $this$access_u24isStatic) {
        return EventDispatcherImplKt.isStatic($this$access_u24isStatic);
    }
}

