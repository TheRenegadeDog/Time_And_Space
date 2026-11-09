package net.therenegadedog.timeandspace.Datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.therenegadedog.timeandspace.TimeAndSpace;
import net.therenegadedog.timeandspace.block.ModBlocks;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TimeAndSpace.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ZEITON_BLOCK.getKey())
                .add(ModBlocks.ZEITON_ORE.getKey())
                .add(ModBlocks.ZEITON_DEEPSLATE_ORE.getKey());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ZEITON_ORE.getKey())
                .add(ModBlocks.ZEITON_DEEPSLATE_ORE.getKey());
    }
}
