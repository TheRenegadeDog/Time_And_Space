package net.therenegadedog.timeandspace.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.therenegadedog.timeandspace.TimeAndSpace;

public class ModItems{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TimeAndSpace.MOD_ID);

    public static final DeferredItem<Item> ZEITON_CRYSTAL = ITEMS.registerSimpleItem("zeiton_crystal",
            properties -> properties);
    public static final DeferredItem<Item> UNREFINED_ZEITON_CRYSTAL = ITEMS.registerSimpleItem("unrefined_zeiton_crystal",
            properties -> properties);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
