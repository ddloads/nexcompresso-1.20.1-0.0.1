package com.ddloads.nexcompresso.datagen;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NexCompresso.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockwithitem(ModBlocks.COMPRESSED_COBBLESTONE);
        blockwithitem(ModBlocks.COMPRESSED_DIRT);
        blockwithitem(ModBlocks.COMPRESSED_SAND);
        blockwithitem(ModBlocks.COMPRESSED_GRAVEL);
        blockwithitem(ModBlocks.SKY_STONE_BLOCK);
        blockwithitem(ModBlocks.DUST);
        blockwithitem(ModBlocks.CRUDE_SIEVE);

    }
    private void blockwithitem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
