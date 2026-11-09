package net.therenegadedog.timeandspace.Datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.data.PackOutput;
import net.therenegadedog.timeandspace.TimeAndSpace;
import net.therenegadedog.timeandspace.block.ModBlocks;
import net.therenegadedog.timeandspace.item.ModItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TimeAndSpace.MOD_ID);


    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //ITEMS
        itemModels.generateFlatItem(ModItems.ZEITON_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.UNREFINED_ZEITON_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);

        //BLOCKS
        blockModels.createTrivialCube(ModBlocks.ZEITON_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.ZEITON_ORE.get());
        blockModels.createTrivialCube(ModBlocks.ZEITON_DEEPSLATE_ORE.get());

    }
}
