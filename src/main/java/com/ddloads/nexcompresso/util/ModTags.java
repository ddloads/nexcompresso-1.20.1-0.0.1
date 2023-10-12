package com.ddloads.nexcompresso.util;

import com.ddloads.nexcompresso.NexCompresso;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MINEABLE_WITH_HAMMERS = tag("mineable_with_hammers");
        public static final TagKey<Block> NEEDS_SKY_STONE_TOOL = tag("needs_sky_stone_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(NexCompresso.MOD_ID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> HAMMERS = tag("hammers");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(NexCompresso.MOD_ID, name));
        }
    }
}
