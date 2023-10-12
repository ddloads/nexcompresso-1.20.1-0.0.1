package com.ddloads.nexcompresso.datagen;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.ddloads.nexcompresso.util.ModTags.Items.HAMMERS;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, NexCompresso.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(HAMMERS)
                .addOptional(new ResourceLocation(NexCompresso.MOD_ID, "stone_hammer"))
                .addOptional(new ResourceLocation(NexCompresso.MOD_ID, "iron_hammer"))
                .addOptional(new ResourceLocation(NexCompresso.MOD_ID, "diamond_hammer"))
                .addOptional(new ResourceLocation(NexCompresso.MOD_ID, "sky_stone_hammer"));

    }
}
