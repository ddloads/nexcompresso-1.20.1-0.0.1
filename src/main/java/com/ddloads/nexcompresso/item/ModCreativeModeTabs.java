package com.ddloads.nexcompresso.item;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NexCompresso.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NEXCOMPRESSO_TAB = CREATIVE_MODE_TABS.register("nexcompresso_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STONE_HAMMER.get()))
                    .title(Component.translatable("creativetab.nexcompresso_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //Ingredients
                        pOutput.accept(ModItems.SKY_STONE.get());

                        //Tools
                        pOutput.accept(ModItems.STONE_HAMMER.get());
                        pOutput.accept(ModItems.IRON_HAMMER.get());
                        pOutput.accept(ModItems.DIAMOND_HAMMER.get());
                        pOutput.accept(ModItems.SKY_STONE_HAMMER.get());

                        //Food
                        pOutput.accept(ModItems.SKYBERRY.get());

                        //Fuel
                        pOutput.accept(ModItems.PINE_CONE.get());

                        //Blocks
                        pOutput.accept(ModBlocks.COMPRESSED_COBBLESTONE.get());
                        pOutput.accept(ModBlocks.COMPRESSED_SAND.get());
                        pOutput.accept(ModBlocks.COMPRESSED_GRAVEL.get());
                        pOutput.accept(ModBlocks.COMPRESSED_DIRT.get());
                        pOutput.accept(ModBlocks.SKY_STONE_BLOCK.get());
                        pOutput.accept(ModBlocks.DUST.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
