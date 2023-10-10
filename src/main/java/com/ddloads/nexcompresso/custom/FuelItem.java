package com.ddloads.nexcompresso.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FuelItem extends Item {
    private int burntime = 0;

    public FuelItem(Properties pProperties, int burntime){
        super(pProperties);
        this.burntime = burntime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burntime;
    }
}
