package net.therenegadedog.timeandspace;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.therenegadedog.timeandspace.Datagen.ModBlockLoot;
import net.therenegadedog.timeandspace.Datagen.ModBlockLootTableProvider;
import net.therenegadedog.timeandspace.Datagen.ModBlockTagProvider;
import net.therenegadedog.timeandspace.Datagen.ModModelProvider;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = TimeAndSpace.MOD_ID)
public class TimeAndSpaceDataGenerators {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getReloadableLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModBlockTagProvider(packOutput, lookupProvider));

        RegistrySetBuilder builder = new RegistrySetBuilder()
                .add(Registries.LOOT_TABLE, new LootTableProvider(
                        Set.of(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(
                                        ModBlockLootTableProvider::new,
                                        LootContextParamSets.BLOCK
                                )
                        )
                ));

        generator.addProvider(true, DatapackBuiltinEntriesProvider.forReloadableLayer(
                event.getGenerator().getPackOutput(),
                "Time and Space Block Loot Provider",
                event.getWorldLookupProvider(),
                event.getReloadableLookupProvider(),
                builder, Set.of(TimeAndSpace.MOD_ID)));
    }
}
