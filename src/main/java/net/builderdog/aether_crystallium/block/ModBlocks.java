package net.builderdog.aether_crystallium.block;

import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.item.ModItems;
import net.builderdog.aether_crystallium.worldgen.tree.FrostPineTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.Luminance;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AetherCrystallium.MOD_ID);
    public static final RegistryObject<Block> CRYSTAL_GOLD_BLOCK =  registerBlock("crystal_gold_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PURPLE_AETHER_CACTUS_FLOWER =  registerBlock("purple_aether_cactus_flower",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT)
                    .instabreak()));
    public static final RegistryObject<Block> CRYSTAL_GOLD_ORE =  registerBlock("crystal_gold_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_CRYSTAL_GOLD_BLOCK =  registerBlock("raw_crystal_gold_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ENCHANTED_SENTRY_STONE =  registerBlock("enchanted_sentry_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)
                    .strength(0.5f, 6f).lightLevel(s -> 11).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLIGHTED_SENTRY_STONE =  registerBlock("blighted_sentry_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)
                    .strength(0.5f, 6f).lightLevel(s -> 11).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AETHER_CACTUS =  registerBlock("aether_cactus",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS).sound(SoundType.WOOL)
                    .strength(0.5f, 6f)));

    public static final RegistryObject<Block> MOONLIT_TULIP = registerBlock("moonlit_tulip", () -> new FlowerBlock(() -> MobEffects.SLOW_FALLING, 4, Block.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> SMALL_AETHER_CACTUS = registerBlock("small_aether_cactus", () -> new FlowerBlock(() -> MobEffects.SLOW_FALLING, 4, Block.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> QUICKSOIL_BRICKS =  registerBlock("quicksoil_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5F).friction(1.1F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> FROSTPINE_LOG =  registerBlock("frostpine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));
    public static final RegistryObject<Block> FROSTPINE_WOOD =  registerBlock("frostpine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)));
    public static final RegistryObject<Block> STRIPPED_FROSTPINE_LOG =  registerBlock("stripped_frostpine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)));
    public static final RegistryObject<Block> STRIPPED_FROSTPINE_WOOD =  registerBlock("stripped_frostpine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)));
    public static final RegistryObject<Block> FROSTPINE_PLANKS =  registerBlock("frostpine_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2f)) {


                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> FROSTPINE_LEAVES =  registerBlock("frostpine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> FROSTPINE_SAPLING =  registerBlock("frostpine_sapling",
            () -> new SaplingBlock(new FrostPineTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> FROSTPINE_STAIRS =  registerBlock("frostpine_stairs",
            () -> new StairBlock(() -> FROSTPINE_PLANKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(ModBlocks.FROSTPINE_PLANKS.get()))));

    public static final RegistryObject<Block> QUICKSOIL_BRICK_STAIRS =  registerBlock("quicksoil_brick_stairs",
            () -> new StairBlock(() -> QUICKSOIL_BRICKS.get().defaultBlockState(), (BlockBehaviour.Properties.copy(ModBlocks.QUICKSOIL_BRICKS.get()))));

    public static final RegistryObject<Block> FROSTPINE_SLAB = registerBlock("frostpine_slab",
            () -> new SlabBlock(Block.Properties.copy(ModBlocks.FROSTPINE_PLANKS.get()).strength(2.0F, 3.0F)));

    public static final RegistryObject<Block> QUICKSOIL_BRICK_SLAB = registerBlock("quicksoil_brick_slab",
            () -> new SlabBlock(Block.Properties.copy(ModBlocks.QUICKSOIL_BRICKS.get()).strength(2.0F, 3.0F)));

    public static final RegistryObject<FenceBlock> FROSTPINE_FENCE = registerBlock("frostpine_fence", () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<FenceGateBlock> FROSTPINE_FENCE_GATE = registerBlock("frostpine_fence_gate", () -> new FenceGateBlock(Block.Properties.copy(Blocks.OAK_FENCE_GATE), ModWoodTypes.FROSTPINE));
    public static final RegistryObject<DoorBlock> FROSTPINE_DOOR = registerBlock("frostpine_door", () -> new DoorBlock(Block.Properties.copy(Blocks.OAK_DOOR), ModWoodTypes.FROSTPINE_BLOCK_SET));
    public static final RegistryObject<TrapDoorBlock> FROSTPINE_TRAPDOOR = registerBlock("frostpine_trapdoor", () -> new TrapDoorBlock(Block.Properties.copy(Blocks.OAK_TRAPDOOR), ModWoodTypes.FROSTPINE_BLOCK_SET));
    public static final RegistryObject<ButtonBlock> FROSTPINE_BUTTON = registerBlock("frostpine_button", () -> new ButtonBlock(Block.Properties.copy(Blocks.OAK_BUTTON), ModWoodTypes.FROSTPINE_BLOCK_SET, 30, true));
    public static final RegistryObject<PressurePlateBlock> FROSTPINE_PRESSURE_PLATE = registerBlock("frostpine_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.copy(Blocks.OAK_PRESSURE_PLATE), ModWoodTypes.FROSTPINE_BLOCK_SET));

    public static final RegistryObject<WallBlock> QUICKSOIL_BRICK_WALL = registerBlock("quicksoil_brick_wall", () -> new WallBlock(Block.Properties.copy(ModBlocks.QUICKSOIL_BRICKS.get())));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item>  registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
