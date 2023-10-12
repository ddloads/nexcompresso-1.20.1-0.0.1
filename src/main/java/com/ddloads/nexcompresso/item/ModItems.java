package com.ddloads.nexcompresso.item;

import com.ddloads.nexcompresso.NexCompresso;
import com.ddloads.nexcompresso.custom.FuelItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import static com.ddloads.nexcompresso.item.ModToolTiers.SKY_STONE_TIER;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NexCompresso.MOD_ID);

    //Ingredients
    public static final RegistryObject<Item> SKY_STONE = ITEMS.register("sky_stone",
            () -> new Item(new Item.Properties()));


    //Tool Items
    public static final RegistryObject<PickaxeItem> STONE_HAMMER = (ITEMS.register("stone_hammer",
            () -> new PickaxeItem(
                    Tiers.STONE,
                    4,
                    1,
                    new Item.Properties()
            )));
    public static final RegistryObject<PickaxeItem> IRON_HAMMER = (ITEMS.register("iron_hammer",
            () -> new PickaxeItem(
                    Tiers.IRON,
                    5,
                    1,
                    new Item.Properties()
            )));
    public static final RegistryObject<PickaxeItem> DIAMOND_HAMMER = (ITEMS.register("diamond_hammer",
            () -> new PickaxeItem(
                    Tiers.DIAMOND,
                    6,
                    0.9F,
                    new Item.Properties()
            )));
    public static final RegistryObject<PickaxeItem> SKY_STONE_HAMMER = (ITEMS.register("sky_stone_hammer",
            () -> new PickaxeItem(
                    SKY_STONE_TIER,
                    7,
                    1,
                    new Item.Properties()
            )));


    //Fuel Items
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));


    //Food Items
    public static final RegistryObject<Item> SKYBERRY = ITEMS.register("sky_berry",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationMod(0.2F).fast().build())
            ));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
