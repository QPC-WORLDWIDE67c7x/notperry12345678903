/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import cookiedragon.eventsystem.Subscriber;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import me.darki.konas.1A;
import me.darki.konas.3D;
import me.darki.konas.3E;
import me.darki.konas.3F;
import me.darki.konas.4g_0;
import me.darki.konas.4y_0;
import me.darki.konas.4z_0;
import me.darki.konas.8E;
import me.darki.konas.8h_0;
import me.darki.konas.9m;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 4A
extends 3E {
    public 8h_0<Boolean> 1 = new 8h_0("Totem", true).c(315, 1000);
    public 8h_0<Boolean> 2 = new 8h_0("Gapple", true);
    public 8h_0<Boolean> 3 = new 8h_0("Crystal", true);
    public 8h_0<Float> 4 = new 8h_0("Delay", Float.valueOf(0.0f), Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(0.05f));
    public 8h_0<Boolean> 5 = new 8h_0("HotbarTotem", false);
    public 8h_0<Float> 6 = new 8h_0("TotemHealth", Float.valueOf(5.0f), Float.valueOf(36.0f), Float.valueOf(0.0f), Float.valueOf(0.5f));
    public 8h_0<Boolean> 7 = new 8h_0("RightClickGap", true).c(this::5);
    public 8h_0<4y_0> 8 = new 8h_0("CrystalCheck", 4y_0.0);
    public 8h_0<Float> 9 = new 8h_0("CrystalRange", Float.valueOf(10.0f), Float.valueOf(15.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).c(this::1);
    public 8h_0<Boolean> a = new 8h_0("FallCheck", true);
    public 8h_0<Float> b = new 8h_0("FallDist", Float.valueOf(15.0f), Float.valueOf(50.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)).c(this::0);
    public 8h_0<Boolean> d = new 8h_0("TotemOnElytra", true);
    public 8h_0<Boolean> e = new 8h_0("ExtraSafe", false);
    public 8h_0<Boolean> f = new 8h_0("ClearAfter", true);
    public 8h_0<Boolean> g = new 8h_0("Hard", false);
    public 8h_0<Boolean> h = new 8h_0("NotFromHotbar", true);
    public 8h_0<4z_0> i = new 8h_0("DefaultItem", 4z_0.c);
    public Queue<Integer> c;
    public 9m c = new 9m();

    public boolean 1(Item item) {
        return item == Items.DIAMOND_SWORD || item == Items.IRON_SWORD || item == Items.GOLDEN_SWORD || item == Items.STONE_SWORD || item == Items.WOODEN_SWORD;
    }

    public static boolean 1(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    public float c(BlockPos blockPos) {
        List list = ((Minecraft)4A.c).world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(blockPos)).stream().filter(4A::1).collect(Collectors.toList());
        float f2 = 0.0f;
        for (Entity entity : list) {
            f2 += 8E.c(entity.posX, entity.posY, entity.posZ, (Entity)((Minecraft)4A.c).player);
        }
        return f2;
    }

    public boolean c(Entity entity) {
        return entity instanceof EntityEnderCrystal && ((Minecraft)4A.c).player.getDistance(entity) <= ((Float)this.9.6()).floatValue();
    }

    public void 0(Item item) {
        if (((Minecraft)4A.c).player.getHeldItemOffhand().getItem() == item) {
            return;
        }
        int n2 = this.c(item);
        if (((Boolean)this.5.6()).booleanValue() && item == Items.TOTEM_OF_UNDYING) {
            for (int i2 = 0; i2 < 9; ++i2) {
                ItemStack itemStack = (ItemStack)4A.c.player.inventory.mainInventory.get(i2);
                if (itemStack.getItem() != Items.TOTEM_OF_UNDYING) continue;
                if (4A.c.player.inventory.currentItem != i2) {
                    4A.c.player.inventory.currentItem = i2;
                }
                return;
            }
        }
        if (n2 != -1) {
            if (((Float)this.4.6()).floatValue() > 0.0f) {
                if (this.c.c(((Float)this.4.6()).floatValue() * 100.0f)) {
                    ((Minecraft)4A.c).playerController.windowClick(4A.c.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4A.c).player);
                    this.c.c();
                } else {
                    this.c.add(n2 < 9 ? n2 + 36 : n2);
                }
                this.c.add(45);
                this.c.add(n2 < 9 ? n2 + 36 : n2);
            } else {
                this.c.c();
                ((Minecraft)4A.c).playerController.windowClick(4A.c.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4A.c).player);
                PlayerControllerMP playerControllerMP = ((Minecraft)4A.c).playerController;
                int n3 = 4A.c.player.inventoryContainer.windowId;
                int n4 = 45;
                int n5 = 0;
                ClickType clickType = ClickType.PICKUP;
                EntityPlayerSP entityPlayerSP = ((Minecraft)4A.c).player;
                playerControllerMP.windowClick(n3, n4, n5, clickType, (EntityPlayer)entityPlayerSP);
                try {
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                ((Minecraft)4A.c).playerController.windowClick(4A.c.player.inventoryContainer.windowId, n2 < 9 ? n2 + 36 : n2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4A.c).player);
            }
        }
    }

    public boolean 1() {
        return this.8.6() != 4y_0.c;
    }

    public 4A() {
        super("Offhand", 3D.c, "OffhandCrystal", "AutoTotem", "OffhandGapple", "AutoOffhand", "SmartOffhand");
    }

    public static Float 0(Entity entity) {
        return Float.valueOf(((Minecraft)4A.c).player.getDistance(entity));
    }

    @Subscriber
    public void c(1A a2) {
        block25: {
            block26: {
                if (((Minecraft)4A.c).player == null || ((Minecraft)4A.c).world == null) {
                    return;
                }
                if (((Minecraft)4A.c).currentScreen instanceof GuiContainer || ((Minecraft)4A.c).currentScreen instanceof GuiInventory) break block25;
                if (this.c.isEmpty()) break block26;
                if (!this.c.c(((Float)this.4.6()).floatValue() * 100.0f)) {
                    return;
                }
                int n2 = this.c.poll();
                9m m2 = this.c;
                m2.c();
                PlayerControllerMP playerControllerMP = ((Minecraft)4A.c).playerController;
                int n3 = 4A.c.player.inventoryContainer.windowId;
                int n4 = n2;
                int n5 = 0;
                ClickType clickType = ClickType.PICKUP;
                EntityPlayerSP entityPlayerSP = ((Minecraft)4A.c).player;
                playerControllerMP.windowClick(n3, n4, n5, clickType, (EntityPlayer)entityPlayerSP);
                try {
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                break block25;
            }
            if (!4A.c.player.inventory.getItemStack().isEmpty()) {
                for (int i2 = 44; i2 >= 9; --i2) {
                    if (!4A.c.player.inventoryContainer.getSlot(i2).getStack().isEmpty()) continue;
                    ((Minecraft)4A.c).playerController.windowClick(0, i2, 0, ClickType.PICKUP, (EntityPlayer)((Minecraft)4A.c).player);
                    return;
                }
            }
            if (((Boolean)this.1.6()).booleanValue()) {
                if (((Minecraft)4A.c).player.getHealth() + ((Minecraft)4A.c).player.getAbsorptionAmount() <= ((Float)this.6.6()).floatValue() || (Boolean)this.d.6() != false && ((Minecraft)4A.c).player.isElytraFlying() || ((Boolean)this.a.6()).booleanValue() && 4A.c.player.fallDistance >= ((Float)this.b.6()).floatValue() && !((Minecraft)4A.c).player.isElytraFlying()) {
                    this.0(Items.TOTEM_OF_UNDYING);
                    return;
                }
                if (this.8.6() == 4y_0.1) {
                    EntityEnderCrystal entityEnderCrystal = 4A.c.world.loadedEntityList.stream().filter(this::c).min(Comparator.comparing(4A::0)).orElse(null);
                    if (entityEnderCrystal != null) {
                        this.0(Items.TOTEM_OF_UNDYING);
                        return;
                    }
                } else if (this.8.6() == 4y_0.0) {
                    float f2 = 0.0f;
                    List list = 4A.c.world.loadedEntityList.stream().filter(4A::3).filter(this::2).collect(Collectors.toList());
                    for (Entity entity : list) {
                        f2 += 8E.c((EntityEnderCrystal)entity, (Entity)((Minecraft)4A.c).player);
                    }
                    if (((Minecraft)4A.c).player.getHealth() + ((Minecraft)4A.c).player.getAbsorptionAmount() - f2 <= ((Float)this.6.6()).floatValue()) {
                        this.0(Items.TOTEM_OF_UNDYING);
                        return;
                    }
                }
                if (((Boolean)this.e.6()).booleanValue() && this.c()) {
                    this.0(Items.TOTEM_OF_UNDYING);
                    return;
                }
            }
            if (((Boolean)this.2.6()).booleanValue() && this.1(((Minecraft)4A.c).player.getHeldItemMainhand().getItem())) {
                if (((Boolean)this.7.6()).booleanValue() && !4A.c.gameSettings.keyBindUseItem.isKeyDown()) {
                    if (((Boolean)this.f.6()).booleanValue()) {
                        this.0(((4z_0)this.i.6()).c);
                    }
                    return;
                }
                this.0(Items.GOLDEN_APPLE);
                return;
            }
            if (((Boolean)this.3.6()).booleanValue()) {
                if (3F.c(4g_0.class).f()) {
                    this.0(Items.END_CRYSTAL);
                    return;
                }
                if (((Boolean)this.f.6()).booleanValue()) {
                    this.0(((4z_0)this.i.6()).c);
                    return;
                }
            }
            if (!((Boolean)this.g.6()).booleanValue()) break block25;
            this.0(((4z_0)this.i.6()).c);
        }
    }

    public int c(Item item) {
        int n2;
        int n3 = -1;
        int n4 = n2 = (Boolean)this.h.6() != false ? 9 : 0;
        while (n2 < 36) {
            ItemStack itemStack = 4A.c.player.inventory.getStackInSlot(n2);
            if (itemStack != null && itemStack.getItem() == item) {
                n3 = n2;
                break;
            }
            ++n2;
        }
        return n3;
    }

    public static boolean 3(Entity entity) {
        return entity instanceof EntityEnderCrystal;
    }

    public boolean 0() {
        return (Boolean)this.a.6();
    }

    public boolean c() {
        float f2 = 0.0f;
        ArrayList<Float> arrayList = new ArrayList<Float>();
        arrayList.add(Float.valueOf(this.c(((Minecraft)4A.c).player.getPosition().add(1, 0, 0))));
        arrayList.add(Float.valueOf(this.c(((Minecraft)4A.c).player.getPosition().add(-1, 0, 0))));
        arrayList.add(Float.valueOf(this.c(((Minecraft)4A.c).player.getPosition().add(0, 0, 1))));
        arrayList.add(Float.valueOf(this.c(((Minecraft)4A.c).player.getPosition().add(0, 0, -1))));
        arrayList.add(Float.valueOf(this.c(((Minecraft)4A.c).player.getPosition())));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            float f3 = ((Float)iterator.next()).floatValue();
            f2 += f3;
            if (!(((Minecraft)4A.c).player.getHealth() + ((Minecraft)4A.c).player.getAbsorptionAmount() - f3 <= ((Float)this.6.6()).floatValue())) continue;
            return true;
        }
        return ((Minecraft)4A.c).player.getHealth() + ((Minecraft)4A.c).player.getAbsorptionAmount() - f2 <= ((Float)this.6.6()).floatValue();
    }

    public boolean 2(Entity entity) {
        return ((Minecraft)4A.c).player.getDistance(entity) <= ((Float)this.9.6()).floatValue();
    }

    @Override
    public boolean 5() {
        return (Boolean)this.2.6();
    }
}

