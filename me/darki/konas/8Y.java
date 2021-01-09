/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.Iterator;
import java.util.PriorityQueue;
import me.darki.konas.8W;
import me.darki.konas.8X;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class 8Y {
    public PriorityQueue<8X> c = new PriorityQueue(8Y::c);

    public void 1() {
        this.c.clear();
    }

    public boolean c(8W w, float f2) {
        return this.c.add(new 8X(this, w, f2));
    }

    public PriorityQueue<8X> 0() {
        return this.c;
    }

    public 8W c() {
        return 8X.0(this.c.poll());
    }

    public static int c(8X x, 8X x2) {
        return Float.compare(8X.c(x), 8X.c(x2));
    }

    public 8W[] 2() {
        8W[] wArray = new 8W[this.c.size()];
        Iterator<8X> iterator = this.c.iterator();
        for (int i2 = 0; i2 < this.c.size() && iterator.hasNext(); ++i2) {
            wArray[i2] = 8X.0(iterator.next());
        }
        return wArray;
    }
}

