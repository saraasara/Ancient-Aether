package net.builderdog.ancient_aether.effect;

import net.builderdog.ancient_aether.AncientAether;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AncientAether.MODID);

    public static final RegistryObject<MobEffect> NATURE_BOOST = EFFECTS.register("nature_boost", NatureBoostEffect::new);
}