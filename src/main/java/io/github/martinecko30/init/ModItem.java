package io.github.martinecko30.init;

import io.github.martinecko30.MedievalMadness;
import io.github.martinecko30.items.CustomItemTiers;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItem
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MedievalMadness.MODID);



    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item( new Item.Properties().group(MedievalMadness.MODGROUP)));

    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item( new Item.Properties().group(MedievalMadness.MODGROUP)));

    public static final RegistryObject<Item> IRON_AND_COAL = ITEMS.register("iron_and_coal",
            () -> new Item( new Item.Properties().group(MedievalMadness.MODGROUP)));

    public static final  RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
            () -> new SwordItem(CustomItemTiers.METAL,3,2.4F, new Item.Properties().maxStackSize(1).group(MedievalMadness.MODGROUP) ));

    public static final  RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword",
            () -> new SwordItem(CustomItemTiers.SILVER,3,2.4F, new Item.Properties().maxStackSize(1).group(MedievalMadness.MODGROUP) ));

    public static final  RegistryObject<Item> WEED_SEEDS = ITEMS.register("weed_seeds",
            () -> new BlockItem(ModBlocks.WEED_SEEDS.get(),
                    new Item.Properties()
                            .group(MedievalMadness.MODGROUP)
                            .maxStackSize(64)
                            .food(new Food.Builder().hunger(-1).saturation(0).setAlwaysEdible().build())));

    public static final  RegistryObject<Item> WEED = ITEMS.register("weed",
            () -> new Item( new Item.Properties().group(MedievalMadness.MODGROUP)));

    public static final  RegistryObject<Item> DRIED_WEED = ITEMS.register("dried_weed",
            () -> new Item( new Item.Properties().group(MedievalMadness.MODGROUP).food(new Food.Builder().hunger(1).saturation(0).setAlwaysEdible().build())));

}