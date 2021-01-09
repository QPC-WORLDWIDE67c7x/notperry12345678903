/*
 * Decompiled with CFR 0.151.
 */
package cookiedragon.eventsystem;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(value=RetentionPolicy.RUNTIME)
@Metadata(mv={1, 1, 16}, bv={1, 0, 3}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lcookiedragon/eventsystem/Subscriber;", "", "priority", "", "()I", "EventSystem"})
public @interface Subscriber {
    public int priority() default 0;
}

