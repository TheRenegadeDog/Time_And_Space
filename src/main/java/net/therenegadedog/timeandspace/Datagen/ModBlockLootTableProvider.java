package net.therenegadedog.timeandspace.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.UniformGenerator;
import net.therenegadedog.timeandspace.block.ModBlocks;
import net.therenegadedog.timeandspace.item.ModItems;

import java.util.List;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(LootTableSubProvider.Context output) {
        super(
                output,
                Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(
                                ModBlockLoot::new,
                                LootContextParamSets.BLOCK
                        )
                )
        );
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ZEITON_BLOCK.get());

        add(ModBlocks.ZEITON_ORE.get(), block -> createOreDrop(block, ModItems.UNREFINED_ZEITON_CRYSTAL.get()));
        add(ModBlocks.ZEITON_DEEPSLATE_ORE.get(), block -> createMultipleOreDrops(block, ModItems.UNREFINED_ZEITON_CRYSTAL.get(),1,3));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item,int minDrops, int maxDrops) {
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }
}
