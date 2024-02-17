package net.builderdog.ancient_aether.world.feature;

import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.world.configuration.CoastConfiguration;
import net.builderdog.ancient_aether.world.configuration.CrystalIslandConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, AncientAether.MOD_ID);

    public static RegistryObject<Feature<CoastConfiguration>> COAST = FEATURES.register("coast", () -> new CoastFeature(CoastConfiguration.CODEC));
    public static RegistryObject<Feature<CloudbedFeature.Config>> CLOUDBED = FEATURES.register("cloudbed", () -> new CloudbedFeature(CloudbedFeature.Config.CODEC));
    public static RegistryObject<Feature<CrystalIslandConfiguration>> CONFIGURABLE_CRYSTAL_ISLAND = FEATURES.register("configurable_crystal_island", () -> new ConfigurableCrystalIslandFeature(CrystalIslandConfiguration.CODEC));
}