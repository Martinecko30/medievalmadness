package io.github.martinecko30.blocks;

import io.github.martinecko30.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    SILVER(Lazy.of(ModBlocks.SILVER_ORE), 6, 20, 30);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int maxHeight;
    private final int minHeight;


    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public static OreType get(Block block) {
        for(OreType ore : values()) {
            if(block == ore.block) {
                return ore;
            }
        }
        return  null;
    }
}
