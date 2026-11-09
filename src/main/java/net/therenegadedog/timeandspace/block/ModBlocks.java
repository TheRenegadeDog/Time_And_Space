package net.therenegadedog.timeandspace.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.therenegadedog.timeandspace.TimeAndSpace;
import net.therenegadedog.timeandspace.item.ModItems;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TimeAndSpace.MOD_ID);

    public static final DeferredBlock<Block> ZEITON_BLOCK = registerBlock("zeiton_block",
            properties -> new Block(properties
                    .lightLevel(state -> 7)
                    .requiresCorrectToolForDrops()
                    .destroyTime(3)
                    .sound(SoundType.AMETHYST_CLUSTER)));
    public static final DeferredBlock<Block> ZEITON_ORE = registerBlock("zeiton_ore",
            properties -> new DropExperienceBlock(UniformInt.of(3,6), properties
                    .lightLevel(state -> 4)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .destroyTime(3)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ZEITON_DEEPSLATE_ORE = registerBlock("zeiton_deepslate_ore",
            properties -> new DropExperienceBlock(UniformInt.of(4,7), properties
                    .lightLevel(state -> 5)
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .destroyTime(4)
                    .sound(SoundType.DEEPSLATE)));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
