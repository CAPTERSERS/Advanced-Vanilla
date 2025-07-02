package net.captersers.advanced_vanilla.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.captersers.advanced_vanilla.AVMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class AVBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(AVMod.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> BLOCK_OF_ENDERITE = register("block_of_enderite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops()
                    .strength(50.0F, 1200.0F)
                    .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistrySupplier<Block> MEDIUM_WEIGHTED_PRESSURE_PLATE = register("medium_weighted_pressure_plate",
            () -> new WeightedPressurePlateBlock(75, BlockSetType.COPPER, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .forceSolidOn()
                    .requiresCorrectToolForDrops()
                    .noCollission().strength(0.5F)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistrySupplier<Block> VOID_SHARD = register("void_shard",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .requiresCorrectToolForDrops()
                    .strength(30.0F, 1200.0F)
                    .sound(SoundType.NETHER_ORE)));

    public static void init() {
        BLOCKS.register();
    }

    public static RegistrySupplier<Block> register(String name, Supplier<Block> block){
        return BLOCKS.register(AVMod.id(name), block);
    }
}
