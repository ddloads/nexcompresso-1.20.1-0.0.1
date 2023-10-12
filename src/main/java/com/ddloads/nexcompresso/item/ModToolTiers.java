package com.ddloads.nexcompresso.item;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SKY_STONE_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1800, 7.5f, 5f, 20,
                    ModTags.Blocks.NEEDS_SKY_STONE_TOOL, () -> Ingredient.of(ModItems.SKY_STONE.get())),
            new ResourceLocation(NexCompresso.MOD_ID, "sky_stone"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));

}
