package io.github.martinecko30;

import io.github.martinecko30.init.ModBlocks;
import io.github.martinecko30.init.ModItem;
import io.github.martinecko30.world.ModWorldEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(MedievalMadness.MODID)
public class MedievalMadness {

    public static final String MODID = "medievalmadness";
    public static final String NAME = "Medieval Madness";
    public static final String VERSION = "1.0";

    private static final Logger LOGGER = LogManager.getLogger();

   public static final ItemGroup MODGROUP = new ItemGroup("medievalmadness") {
       @Override
       public ItemStack createIcon() {
           return new ItemStack(ModBlocks.STEEL_BLOCK.get());
       }
   };

    public MedievalMadness()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItem.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
    }

    private void setup(FMLCommonSetupEvent e)
    {

    }
    private void clientSetup(FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            //RenderTypeLookup.setRenderLayer(ModBlocks.WEED.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.WILLOW_SAPLING.get(), RenderType.getCutout());
        });
    }
}
