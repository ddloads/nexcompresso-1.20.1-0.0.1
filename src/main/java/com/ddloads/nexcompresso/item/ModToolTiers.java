package com.ddloads.nexcompresso.item;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SKY_STONE = TierSortingRegistry.registerTier(
            new ForgeTier(2, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_SKY_STONE_TOOL, () -> Ingredient.of(ModItems.SKY_STONE.get())),
            new ResourceLocation(NexCompresso.MOD_ID, "sky_stone"), List.of(Tiers.WOOD), List.of());

    public static final ForgeTier HAMMER = new ForgeTier(
            1,
            131,
            4.0F,
            1.0F,
            5,
            ModTags.Blocks.MINEABLE_WITH_HAMMERS,
            () -> Ingredient.of(Items.COBBLESTONE));
}
