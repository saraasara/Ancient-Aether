package net.builderdog.ancient_aether.block.natural;

import net.builderdog.ancient_aether.block.blockstate.AetherGrassType;
import net.builderdog.ancient_aether.block.blockstate.AncientAetherBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class SkyGrassBlock extends TallGrassBlock {
    public static final IntegerProperty LENGTH = AncientAetherBlockStateProperties.LENGTH;
    public static final EnumProperty<AetherGrassType> TYPE = AncientAetherBlockStateProperties.TYPE;
    public SkyGrassBlock(Properties properties) {
        super(properties);
    }

    public void performBonemeal(ServerLevel serverLevel, @NotNull RandomSource randomSource, @NotNull BlockPos blockPos, BlockState blockState) {
        int i = Math.min(5, blockState.getValue(LENGTH) + Mth.nextInt(serverLevel.random, 1, 3));
        BlockState blockstate = blockState.setValue(LENGTH, i);
        serverLevel.setBlock(blockPos, blockstate, 2);
        if (i == 5) {
            blockstate.randomTick(serverLevel, blockPos, serverLevel.random);
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().below());
        return this.defaultBlockState().setValue(TYPE, blockstate.getValue(TYPE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(LENGTH);
        blockBlockStateBuilder.add(TYPE);
    }
}