package com.ddloads.nexcompresso.datagen;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NexCompresso.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //ingredients
        simpleItem(ModItems.SKY_STONE);

        //Food Item
        simpleItem(ModItems.SKYBERRY);

        //Tool Item
        hammerItem(ModItems.STONE_HAMMER);
        hammerItem(ModItems.IRON_HAMMER);
        hammerItem(ModItems.DIAMOND_HAMMER);
        hammerItem(ModItems.SKY_STONE_HAMMER);

        //Fuel Item
        simpleItem(ModItems.PINE_CONE);
    }

    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NexCompresso.MOD_ID, "item/" + item.getId().getPath()));
    }private void hammerItem(RegistryObject<PickaxeItem> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NexCompresso.MOD_ID, "item/" + item.getId().getPath()));
    }
}
