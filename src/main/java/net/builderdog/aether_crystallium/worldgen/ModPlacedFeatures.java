package net.builderdog.aether_crystallium.worldgen;

import com.aetherteam.aether.world.placementmodifier.DungeonBlacklistFilter;
import net.builderdog.aether_crystallium.AetherCrystallium;
import net.builderdog.aether_crystallium.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> HIGHLANDS_PINE_KEY = createKey("highlands_pine_placed");

    public static final ResourceKey<PlacedFeature> SUNROOT_KEY = createKey("sunroot_tree_placed");
    public static final ResourceKey<PlacedFeature> AETHER_QUARTZ_ORE_PLACED = createKey("aether_quartz_ore_placed");
    public static final ResourceKey<PlacedFeature> QUICKSTONE_ORE_PLACED = createKey("quickstone_ore_placed");
    public static final ResourceKey<PlacedFeature> MOONLIT_TULIP_PATCH_KEY = createKey("moonlit_tulip_patch");
    public static final ResourceKey<PlacedFeature> ENCHANTED_BLOSSOM_PATCH_KEY = createKey("enchanted_blossom_patch");
    public static final ResourceKey<PlacedFeature> SMALL_AETHER_CACTUS_PATCH_KEY = createKey("small_aether_cactus_patch");
    public static final ResourceKey<PlacedFeature> AETHER_CACTUS_PATCH_KEY = createKey("aether_cactus_patch");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, HIGHLANDS_PINE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HIGHLANDS_PINE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f,2), ModBlocks.HIGHLANDS_PINE_SAPLING.get()));

        register(context, SUNROOT_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUNROOT_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f,2), ModBlocks.SUNROOT_SAPLING.get()));

        register(context, AETHER_QUARTZ_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.AETHER_QUARTZ_ORE_KEY),
                ModPlacedFeatureBuilder.commonOrePlacement(16, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        register(context, QUICKSTONE_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.QUICKSTONE_ORE_KEY),
                ModPlacedFeatureBuilder.commonOrePlacement(32, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));

        register(context, MOONLIT_TULIP_PATCH_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOONLIT_TULIP_PATCH_KEY), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, ENCHANTED_BLOSSOM_PATCH_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENCHANTED_BLOSSOM_PATCH_KEY), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, SMALL_AETHER_CACTUS_PATCH_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_AETHER_CACTUS_PATCH_KEY), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

        register(context, AETHER_CACTUS_PATCH_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AETHER_CACTUS_PLACEMENT),
                CountPlacement.of(2),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome(),
                new DungeonBlacklistFilter());
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AetherCrystallium.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
