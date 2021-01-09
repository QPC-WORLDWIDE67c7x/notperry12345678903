/*
 * Decompiled with CFR 0.151.
 */
package me.darki.konas;

import java.util.Collection;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.FoodStats;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public class 8G
extends EntityPlayerSP {
    public Minecraft c;
    public boolean c;
    public boolean 0;
    public float c = Minecraft.getMinecraft();
    public float 0;

    public int getTotalArmorValue() {
        return this.c.player.getTotalArmorValue();
    }

    public boolean c(@NotNull World world, @NotNull Block block, @NotNull BlockPos blockPos, float f2) {
        return false;
    }

    public void 0(boolean bl) {
        this.c = bl;
    }

    public void doBlockCollisions() {
    }

    public boolean c() {
        return this.c;
    }

    public void c(float f2) {
        this.0 = f2;
    }

    public boolean canTriggerWalking() {
        return false;
    }

    public boolean hasNoGravity() {
        return true;
    }

    public float 0() {
        return this.c;
    }

    @NotNull
    public Map<Potion, PotionEffect> getActivePotionMap() {
        return this.c.player.getActivePotionMap();
    }

    public boolean 2() {
        return this.0;
    }

    public boolean getIsInvulnerable() {
        return true;
    }

    public boolean canRenderOnFire() {
        return false;
    }

    public boolean isInsideOfMaterial(@NotNull Material material) {
        return this.c.player.isInsideOfMaterial(material);
    }

    public boolean attackEntityFrom(@NotNull DamageSource damageSource, float f2) {
        return false;
    }

    public void c(float f2, float f3, float f4) {
        float f5 = f2 * f2 + f3 * f3 + f4 * f4;
        if (f5 >= 1.0E-4f) {
            if ((f5 = MathHelper.sqrt((float)f5)) < 1.0f) {
                f5 = 1.0f;
            }
            float f6 = MathHelper.sin((float)(this.rotationYaw * ((float)Math.PI / 180)));
            float f7 = MathHelper.cos((float)(this.rotationYaw * ((float)Math.PI / 180)));
            this.motionX = ((f2 *= (f5 /= 2.0f)) * f7 - (f4 *= f5) * f6) * this.c;
            this.motionY = (double)(f3 *= f5) * (double)this.0;
            this.motionZ = (f4 * f7 + f2 * f6) * this.c;
        }
    }

    public void updateFallState(double d2, boolean bl, @NotNull IBlockState iBlockState, @NotNull BlockPos blockPos) {
    }

    public float getAbsorptionAmount() {
        return this.c.player.getAbsorptionAmount();
    }

    public AxisAlignedBB getCollisionBox(Entity entity) {
        return null;
    }

    @NotNull
    public AxisAlignedBB getEntityBoundingBox() {
        return new AxisAlignedBB(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public void 0(float f2) {
        this.c = f2;
    }

    public void readEntityFromNBT(@NotNull NBTTagCompound nBTTagCompound) {
    }

    public void writeEntityToNBT(@NotNull NBTTagCompound nBTTagCompound) {
    }

    @NotNull
    public FoodStats getFoodStats() {
        return this.c.player.getFoodStats();
    }

    public void c(boolean bl) {
        this.0 = bl;
    }

    public boolean canBePushed() {
        return false;
    }

    public boolean canBeAttackedWithItem() {
        return false;
    }

    public boolean isPotionActive(@NotNull Potion potion) {
        return this.c.player.isPotionActive(potion);
    }

    public boolean canBeRidden(@NotNull Entity entity) {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBox() {
        return null;
    }

    @NotNull
    public Collection<PotionEffect> getActivePotionEffects() {
        return this.c.player.getActivePotionEffects();
    }

    public 8G(World world) {
        super(Minecraft.getMinecraft(), world, Minecraft.getMinecraft().getConnection(), Minecraft.getMinecraft().player.getStatFileWriter(), Minecraft.getMinecraft().player.getRecipeBook());
    }

    public void applyEntityCollision(@NotNull Entity entity) {
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    public 8G(boolean bl, boolean bl2, float f2, float f3) {
        super(Minecraft.getMinecraft(), (World)Minecraft.getMinecraft().world, Minecraft.getMinecraft().getConnection(), Minecraft.getMinecraft().player.getStatFileWriter(), Minecraft.getMinecraft().player.getRecipeBook());
        this.c = bl;
        this.0 = bl2;
        this.c = f2;
        this.0 = f3;
        this.noClip = true;
        this.setHealth(this.c.player.getHealth());
        this.posX = this.c.player.posX;
        this.posY = this.c.player.posY;
        this.posZ = this.c.player.posZ;
        this.prevPosX = this.c.player.prevPosX;
        this.prevPosY = this.c.player.prevPosY;
        this.prevPosZ = this.c.player.prevPosZ;
        this.lastTickPosX = this.c.player.lastTickPosX;
        this.lastTickPosY = this.c.player.lastTickPosY;
        this.lastTickPosZ = this.c.player.lastTickPosZ;
        this.rotationYaw = this.c.player.rotationYaw;
        this.rotationPitch = this.c.player.rotationPitch;
        this.rotationYawHead = this.c.player.rotationYawHead;
        this.prevRotationYaw = this.c.player.prevRotationYaw;
        this.prevRotationPitch = this.c.player.prevRotationPitch;
        this.prevRotationYawHead = this.c.player.prevRotationYawHead;
        if (this.c) {
            this.inventory = this.c.player.inventory;
            this.inventoryContainer = this.c.player.inventoryContainer;
            this.setHeldItem(EnumHand.MAIN_HAND, this.c.player.getHeldItemMainhand());
            this.setHeldItem(EnumHand.OFF_HAND, this.c.player.getHeldItemOffhand());
        }
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.c.player.capabilities.writeCapabilitiesToNBT(nBTTagCompound);
        this.capabilities.readCapabilitiesFromNBT(nBTTagCompound);
        this.capabilities.isFlying = true;
        this.attackedAtYaw = this.c.player.attackedAtYaw;
        this.movementInput = new MovementInputFromOptions(this.c.gameSettings);
    }

    public float 1() {
        return this.0;
    }

    public void onLivingUpdate() {
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.movementInput.updatePlayerMoveState();
        float f2 = this.movementInput.jump ? 1.0f : (this.movementInput.sneak ? -1.0f : 0.0f);
        this.c(this.movementInput.moveStrafe, f2, this.movementInput.moveForward);
        if (this.c.gameSettings.keyBindSprint.isKeyDown()) {
            this.motionX *= 2.0;
            this.motionY *= 2.0;
            this.motionZ *= 2.0;
            this.setSprinting(true);
        } else {
            this.setSprinting(false);
        }
        if (this.0) {
            if (Math.abs(this.motionX) <= (double)1.0E-8f) {
                this.posX += this.c.player.posX - this.c.player.prevPosX;
            }
            if (Math.abs(this.motionY) <= (double)1.0E-8f) {
                this.motionY += this.c.player.posY - this.c.player.prevPosY;
            }
            if (Math.abs(this.motionZ) <= (double)1.0E-8f) {
                this.motionZ += this.c.player.posZ - this.c.player.prevPosZ;
            }
        }
        this.setPosition(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
    }

    @NotNull
    public EnumPushReaction getPushReaction() {
        return EnumPushReaction.IGNORE;
    }

    public PotionEffect getActivePotionEffect(@NotNull Potion potion) {
        return this.c.player.getActivePotionEffect(potion);
    }
}

