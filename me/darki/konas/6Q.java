/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import me.darki.konas.0T;
import me.darki.konas.1N;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.5x_0;
import me.darki.konas.6i_0;
import me.darki.konas.8N;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 6Q
extends 3E {
    public static 8h_0<Boolean> 1 = new 8h_0("ElytraPrio", false);
    public static 8h_0<Boolean> 2 = new 8h_0("Smart", false).c(1::6);
    public static 8h_0<Integer> 3 = new 8h_0("Delay", 0, 10, 0, 1);
    public static 8h_0<Boolean> 4 = new 8h_0("Strict", false);
    public static 8h_0<Boolean> 5 = new 8h_0("ArmorSaver", false);
    public static 8h_0<Boolean> 6 = new 8h_0("PauseWhenSafe", false);
    public static 8h_0<Float> 7 = new 8h_0("Depletion", Float.valueOf(0.75f), Float.valueOf(0.95f), Float.valueOf(0.5f), Float.valueOf(0.05f)).c(5::6);
    public static 8h_0<Boolean> 8 = new 8h_0("AllowMend", false);
    public 9m c = new 9m();
    public boolean 1;
    public 9m 0 = new 9m();

    public static boolean 2(8N n2) {
        return ((ItemArmor)n2.c.getItem()).armorType.equals((Object)EntityEquipmentSlot.LEGS);
    }

    @Subscriber
    public void c(1N n2) {
        block21: {
            boolean bl;
            Object object;
            if (n2.c() == TickEvent.Phase.END) {
                return;
            }
            if (((Minecraft)6Q.c).world == null || ((Minecraft)6Q.c).player == null) {
                return;
            }
            if (!this.0.c(350.0)) {
                return;
            }
            if (6Q.c.player.ticksExisted % ((Integer)3.6() + 1) != 0) {
                return;
            }
            if (((Boolean)4.6()).booleanValue() && (6Q.c.player.motionX != 0.0 || 6Q.c.player.motionZ != 0.0)) {
                return;
            }
            if (((Boolean)6.6()).booleanValue() && (object = 6Q.c.world.loadedEntityList.stream().filter(6Q::c).collect(Collectors.toList())).isEmpty()) {
                return;
            }
            if (5x_0.2 && 3F.c("AutoMend").f()) {
                return;
            }
            if (((Boolean)8.6()).booleanValue() && !this.c.c(500.0)) {
                for (int i2 = 0; i2 < 6Q.c.player.inventory.armorInventory.size(); ++i2) {
                    ItemStack itemStack = (ItemStack)6Q.c.player.inventory.armorInventory.get(i2);
                    if (itemStack.getEnchantmentTagList() != null) {
                        boolean bl2 = false;
                        for (Map.Entry entry : EnchantmentHelper.getEnchantments((ItemStack)itemStack).entrySet()) {
                            if (!((Enchantment)entry.getKey()).getName().contains("mending")) continue;
                            bl2 = true;
                            break;
                        }
                        if (!bl2) continue;
                    }
                    if (itemStack.isEmpty()) continue;
                    long l2 = 6Q.c.player.inventory.mainInventory.stream().filter(6Q::c).map(6Q::0).count();
                    if (l2 <= 0L) {
                        return;
                    }
                    if (itemStack.getItemDamage() == 0) continue;
                    this.0(8 - i2);
                    return;
                }
                return;
            }
            if (((Minecraft)6Q.c).currentScreen instanceof GuiContainer) {
                return;
            }
            object = new AtomicBoolean(false);
            if (this.1) {
                this.1 = false;
                return;
            }
            boolean bl3 = (Boolean)1.6();
            if (((Boolean)2.6()).booleanValue() && !3F.c(6i_0.class).f()) {
                bl3 = false;
            }
            HashSet<8N> hashSet = new HashSet<8N>();
            for (int i3 = 0; i3 < 36; ++i3) {
                8N n3 = new 8N(i3, 6Q.c.player.inventory.getStackInSlot(i3));
                if (!(n3.c.getItem() instanceof ItemArmor) && !(n3.c.getItem() instanceof ItemElytra)) continue;
                hashSet.add(n3);
            }
            List list = hashSet.stream().filter(6Q::8).filter(6Q::0).sorted(Comparator.comparingInt(6Q::d)).sorted(Comparator.comparingInt(6Q::4)).collect(Collectors.toList());
            boolean bl4 = list.isEmpty();
            if (bl4) {
                list = hashSet.stream().filter(6Q::a).sorted(Comparator.comparingInt(6Q::9)).sorted(Comparator.comparingInt(6Q::e)).collect(Collectors.toList());
            }
            List list2 = hashSet.stream().filter(6Q::6).sorted(Comparator.comparingInt(6Q::c)).collect(Collectors.toList());
            Item item = 6Q.c.player.inventory.getStackInSlot(39).getItem();
            Item item2 = 6Q.c.player.inventory.getStackInSlot(38).getItem();
            Item item3 = 6Q.c.player.inventory.getStackInSlot(37).getItem();
            Item item4 = 6Q.c.player.inventory.getStackInSlot(36).getItem();
            boolean bl5 = item.equals(Items.AIR) || !bl4 && (Boolean)5.6() != false && 6Q.c.player.inventory.getStackInSlot(39).getItem().getDurabilityForDisplay(6Q.c.player.inventory.getStackInSlot(39)) >= (double)((Float)7.6()).floatValue();
            boolean bl6 = item2.equals(Items.AIR) || !bl4 && (Boolean)5.6() != false && 6Q.c.player.inventory.getStackInSlot(38).getItem().getDurabilityForDisplay(6Q.c.player.inventory.getStackInSlot(38)) >= (double)((Float)7.6()).floatValue();
            boolean bl7 = item3.equals(Items.AIR) || !bl4 && (Boolean)5.6() != false && 6Q.c.player.inventory.getStackInSlot(37).getItem().getDurabilityForDisplay(6Q.c.player.inventory.getStackInSlot(37)) >= (double)((Float)7.6()).floatValue();
            boolean bl8 = bl = item4.equals(Items.AIR) || !bl4 && (Boolean)5.6() != false && 6Q.c.player.inventory.getStackInSlot(36).getItem().getDurabilityForDisplay(6Q.c.player.inventory.getStackInSlot(36)) >= (double)((Float)7.6()).floatValue();
            if (bl5 && !((AtomicBoolean)object).get()) {
                list.stream().filter(6Q::7).filter(6Q::f).findFirst().ifPresent(arg_0 -> this.1((AtomicBoolean)object, arg_0));
            }
            if (bl3 && !(item2 instanceof ItemElytra) && list2.size() > 0 && !((AtomicBoolean)object).get()) {
                list2.stream().findFirst().ifPresent(arg_0 -> this.c((AtomicBoolean)object, arg_0));
            }
            if (bl6 || !bl3 && item2.equals(Items.ELYTRA) && !((AtomicBoolean)object).get()) {
                list.stream().filter(6Q::g).filter(6Q::5).findFirst().ifPresent(arg_0 -> this.0((AtomicBoolean)object, arg_0));
            }
            if (bl7 && !((AtomicBoolean)object).get()) {
                list.stream().filter(6Q::3).filter(6Q::2).findFirst().ifPresent(arg_0 -> this.3((AtomicBoolean)object, arg_0));
            }
            if (!bl || ((AtomicBoolean)object).get()) break block21;
            list.stream().filter(6Q::1).filter(6Q::b).findFirst().ifPresent(arg_0 -> this.2((AtomicBoolean)object, arg_0));
        }
    }

    public void 0(AtomicBoolean atomicBoolean, 8N n2) {
        this.0(n2.c, 6);
        atomicBoolean.set(true);
    }

    public static boolean g(8N n2) {
        return n2.c.getItem() instanceof ItemArmor;
    }

    public static boolean 1(8N n2) {
        return n2.c.getItem() instanceof ItemArmor;
    }

    public void c(AtomicBoolean atomicBoolean, 8N n2) {
        this.0(n2.c, 6);
        atomicBoolean.set(true);
    }

    public static Integer 0(ItemStack itemStack) {
        return 6Q.c.player.inventory.getSlotFor(itemStack);
    }

    public static boolean c(ItemStack itemStack) {
        return itemStack.isEmpty() || itemStack.getItem() == Items.AIR;
    }

    @Subscriber
    public void c(PlayerInteractEvent.RightClickItem rightClickItem) {
        if (rightClickItem.getEntityPlayer() != ((Minecraft)6Q.c).player) {
            return;
        }
        if (rightClickItem.getItemStack().getItem() != Items.EXPERIENCE_BOTTLE) {
            return;
        }
        this.c.c();
    }

    public static boolean b(8N n2) {
        return ((ItemArmor)n2.c.getItem()).armorType.equals((Object)EntityEquipmentSlot.FEET);
    }

    public static boolean 5(8N n2) {
        return ((ItemArmor)n2.c.getItem()).armorType.equals((Object)EntityEquipmentSlot.CHEST);
    }

    public static boolean 7(8N n2) {
        return n2.c.getItem() instanceof ItemArmor;
    }

    public void 2(AtomicBoolean atomicBoolean, 8N n2) {
        this.0(n2.c, 8);
        atomicBoolean.set(true);
    }

    public static int e(8N n2) {
        return ((ItemArmor)n2.c.getItem()).damageReduceAmount;
    }

    public static int c(8N n2) {
        return n2.c;
    }

    public static boolean c(Entity entity) {
        return entity instanceof EntityPlayer && !entity.equals((Object)((Minecraft)6Q.c).player) && ((Minecraft)6Q.c).player.getDistance(entity) <= 6.0f || entity instanceof EntityEnderCrystal && ((Minecraft)6Q.c).player.getDistance(entity) <= 12.0f;
    }

    public void 3(AtomicBoolean atomicBoolean, 8N n2) {
        this.0(n2.c, 7);
        atomicBoolean.set(true);
    }

    public static boolean 6(8N n2) {
        return n2.c.getItem() instanceof ItemElytra;
    }

    public static boolean 8(8N n2) {
        return n2.c.getItem() instanceof ItemArmor;
    }

    public 6Q() {
        super("AutoArmor", "Automatically equips armor", 3D.1, new String[0]);
    }

    public static boolean f(8N n2) {
        return ((ItemArmor)n2.c.getItem()).armorType.equals((Object)EntityEquipmentSlot.HEAD);
    }

    public static int d(8N n2) {
        return n2.c;
    }

    public static boolean 0(8N n2) {
        return (Boolean)5.6() == false || n2.c.getItem().getDurabilityForDisplay(n2.c) < (double)((Float)7.6()).floatValue();
    }

    public void 1(AtomicBoolean atomicBoolean, 8N n2) {
        this.0(n2.c, 5);
        atomicBoolean.set(true);
    }

    public void 0(int n2, int n3) {
        ((Minecraft)6Q.c).playerController.windowClick(6Q.c.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)6Q.c).player);
        ((Minecraft)6Q.c).playerController.windowClick(6Q.c.player.inventoryContainer.windowId, n3, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)6Q.c).player);
        ((Minecraft)6Q.c).playerController.windowClick(6Q.c.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)6Q.c).player);
        this.1 = true;
    }

    public static int 9(8N n2) {
        return n2.c;
    }

    public static boolean 3(8N n2) {
        return n2.c.getItem() instanceof ItemArmor;
    }

    public static boolean a(8N n2) {
        return n2.c.getItem() instanceof ItemArmor;
    }

    @Subscriber
    public void c(0T t) {
        block0: {
            if (!(t.c() instanceof CPacketClickWindow)) break block0;
            this.0.c();
        }
    }

    public void 0(int n2) {
        ((Minecraft)6Q.c).playerController.windowClick(6Q.c.player.inventoryContainer.windowId, n2, 0, ClickType.QUICK_MOVE, (EntityPlayer)((Minecraft)6Q.c).player);
    }

    public static int 4(8N n2) {
        return ((ItemArmor)n2.c.getItem()).damageReduceAmount;
    }
}

