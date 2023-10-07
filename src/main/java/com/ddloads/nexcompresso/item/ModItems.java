package com.ddloads.nexcompresso.item;

import com.ddloads.nexcompresso.NexCompresso;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, NexCompresso.MOD_ID);

    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new Item(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new Item(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
