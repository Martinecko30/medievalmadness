package io.github.martinecko30.init;

import io.github.martinecko30.MedievalMadness;
import io.github.martinecko30.custom.WeedPlantBlock;
import io.github.martinecko30.trees.WillowTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MedievalMadness.MODID);

    public static final RegistryObject<Block> STEEL_BLOCK = createBlock("steel_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .sound(SoundType.METAL)
                    .speedFactor(1.0F)
                    .hardnessAndResistance(10.0F)));

    public static final RegistryObject<Block> SILVER_ORE = createBlock("silver_ore",
            ()-> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(2.0F)));

    //TREE
    public static final RegistryObject<Block> WILLOW_LOG = createBlock("willow_log",
            ()-> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILLOW_LEAVES = createBlock("willow_leaves",
            ()-> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES)
                    .sound(SoundType.PLANT)
                    .notSolid()
                    .tickRandomly()));

    public static final RegistryObject<Block> WILLOW_SAPLING = createBlock("willow_sapling",
            ()-> new SaplingBlock(new WillowTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));



    public static final RegistryObject<Block> WEED_SEEDS = BLOCKS.register("weed_seeds",
            () -> new WeedPlantBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));



    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItem.ITEMS.register(name, ()  -> new BlockItem(block.get(), new Item.Properties().group(MedievalMadness.MODGROUP)));
        return block;
    }

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlock(name, toReturn);
        return toReturn;
    }
}
