package net.therenegadedog.timeandspace;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
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

    }
}
