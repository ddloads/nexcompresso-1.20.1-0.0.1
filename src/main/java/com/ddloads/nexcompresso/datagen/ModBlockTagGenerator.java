package com.ddloads.nexcompresso.datagen;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.block.ModBlocks;
import com.ddloads.nexcompresso.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NexCompresso.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ModTags.Blocks.MINEABLE_WITH_HAMMERS)
                .add(ModBlocks.COMPRESSED_COBBLESTONE.get(),
                        ModBlocks.COMPRESSED_GRAVEL.get(),
                        ModBlocks.COMPRESSED_DIRT.get(),
                        ModBlocks.COMPRESSED_SAND.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPRESSED_COBBLESTONE.get(),
                        ModBlocks.COMPRESSED_GRAVEL.get(),
                        ModBlocks.COMPRESSED_DIRT.get(),
                        ModBlocks.COMPRESSED_SAND.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPRESSED_COBBLESTONE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.COMPRESSED_DIRT.get(),
                        ModBlocks.COMPRESSED_GRAVEL.get(),
                        ModBlocks.COMPRESSED_SAND.get());
    }
}
