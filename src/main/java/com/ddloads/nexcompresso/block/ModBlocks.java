package com.ddloads.nexcompresso.block;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.item.ModItems;
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


    //Basic Blocks

    public static final RegistryObject<Block> SKY_STONE_BLOCK = registerBlock("sky_stone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> CRUDE_SIEVE = registerBlock("crude_sieve",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
    public static final RegistryObject<Block> COMPRESSED_COBBLESTONE = registerBlock("compressed_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> COMPRESSED_DIRT = registerBlock("compressed_dirt",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));


    //Blocks that act like sand and fall when placed
    public static final RegistryObject<Block> COMPRESSED_GRAVEL = registerBlock("compressed_gravel",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL)));
    public static final RegistryObject<Block> COMPRESSED_SAND = registerBlock("compressed_sand",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> DUST = registerBlock("dust",
            () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    public static class CompressedFallingBlock extends FallingBlock {
        public CompressedFallingBlock(Properties properties) {
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
