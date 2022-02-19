package io.github.martinecko30.items;

import io.github.martinecko30.init.ModItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

public enum CustomItemTiers implements IItemTier {
    METAL(3,1761, 10.0F, 4.0F,17, new LazyValue<>(() -> {return Ingredient.fromItems(ModItem.STEEL_INGOT.get());})),
    SILVER(3, 1423, 11.0F, 3.8F, 17, new LazyValue<>(() -> {return Ingredient.fromItems(ModItem.SILVER_INGOT.get());}));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;

    CustomItemTiers(int level, int uses, float speed, float damage, int enchantmentValue, LazyValue<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getMaxUses() {
        return this.uses;
    }

    @Override
    public float getEfficiency() {
        return this.speed;
    }

    @Override
    public float getAttackDamage() {
        return this.damage;
    }

    @Override
    public int getHarvestLevel() {
        return this.level;
    }

    @Override
    public int getEnchantability() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairIngredient.getValue();
    }
}