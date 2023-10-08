package com.ddloads.nexcompresso.block;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NexCompresso.MOD_ID);

    public static final RegistryObject<Block> COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE), UniformInt.of(0, 1)));
    public static final RegistryObject<Block> COMPRESSED_GRAVEL = registerBlock("compressed_gravel",
            () -> new CompressedFallingBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL), UniformInt.of(0, 1)));
    public static final RegistryObject<Block> COMPRESSED_DIRT = registerBlock("compressed_dirt",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIRT), UniformInt.of(0, 1)));
    public static final RegistryObject<Block> COMPRESSED_SAND = registerBlock("compressed_sand",
            () -> new CompressedFallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND), UniformInt.of(0, 1)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    public static class CompressedFallingBlock extends FallingBlock {
        public CompressedFallingBlock(Properties properties, UniformInt uniformInt) {
            super(properties);
        }
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
     return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
