package net.therenegadedog.timeandspace.creativetab;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.therenegadedog.timeandspace.TimeAndSpace;
import net.therenegadedog.timeandspace.block.ModBlocks;
import net.therenegadedog.timeandspace.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TimeAndSpace.MOD_ID);

    public static final Supplier<CreativeModeTab> SPACE_ORES_TAB = CREATIVE_MODE_TABS.register("space_ores_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.timeandspace.space_ores"))
                    .icon(() -> new ItemStack(ModItems.ZEITON_CRYSTAL.get()))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.UNREFINED_ZEITON_CRYSTAL);
                        output.accept(ModItems.ZEITON_CRYSTAL);
                    }))
                    .build());

    public static final Supplier<CreativeModeTab> SPACE_BLOCKS = CREATIVE_MODE_TABS.register("space_blocks_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.timeandspace.space_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.ZEITON_BLOCK.get()))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ZEITON_BLOCK);
                        output.accept(ModBlocks.ZEITON_ORE);
                        output.accept(ModBlocks.ZEITON_DEEPSLATE_ORE);
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
