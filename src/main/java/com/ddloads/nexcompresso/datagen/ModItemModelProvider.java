package com.ddloads.nexcompresso.datagen;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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

        simpleItem(ModItems.SKYBERRY);

        handheldItem(ModItems.SKY_STONE_HAMMER);
        hammerItem(ModItems.STONE_HAMMER);

        simpleItem(ModItems.PINE_CONE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(NexCompresso.MOD_ID,"item/" + item.getId().getPath()));
    }private ItemModelBuilder hammerItem(RegistryObject<PickaxeItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NexCompresso.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(NexCompresso.MOD_ID,"item/" + item.getId().getPath()));
    }
}
