package net.builderdog.ancient_aether.item;

import com.aetherteam.aether.client.AetherSoundEvents;
import com.aetherteam.aether.item.AetherItems;
import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import com.aetherteam.aether.item.miscellaneous.DungeonKeyItem;
import com.aetherteam.aether.item.miscellaneous.MoaEggItem;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.AncientAetherBlocks;
import net.builderdog.ancient_aether.entity.misc.AncientAetherBoatEntity;
import net.builderdog.ancient_aether.entity.AncientAetherEntities;
import net.builderdog.ancient_aether.entity.moa.AncientAetherMoaTypes;
import net.builderdog.ancient_aether.item.equipment.AncientAetherArmorTiers;
import net.builderdog.ancient_aether.item.equipment.accessories.*;
import net.builderdog.ancient_aether.item.equipment.armor.AncientAetherArmorItem;
import net.builderdog.ancient_aether.item.equipment.tools.arkzenus.ArkzenusPickaxeItem;
import net.builderdog.ancient_aether.item.equipment.tools.valkyrum.*;
import net.builderdog.ancient_aether.item.equipment.weapons.AncientSwordItem;
import net.builderdog.ancient_aether.item.equipment.weapons.GravititeDartShooterItem;
import net.builderdog.ancient_aether.item.miscellaneous.AncientAetherBoatItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AncientAetherItems {
    public static final DeferredRegister<Item> ITEMS =
           DeferredRegister.create(ForgeRegistries.ITEMS, AncientAether.MOD_ID);

    //Tooltips
    public static final Component COMMON = Component.translatable("ancient_aether.tooltip.common").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GRAY));
    public static final Component RARE = Component.translatable("ancient_aether.tooltip.rare").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.AQUA));
    public static final Component EPIC = Component.translatable("ancient_aether.tooltip.epic").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.DARK_PURPLE));
    public static final Component LEGENDARY = Component.translatable("ancient_aether.tooltip.legendary").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.GOLD));
    public static final Component SEASONAL = Component.translatable("ancient_aether.tooltip.seasonal").withStyle(Style.EMPTY.withItalic(true).withColor(ChatFormatting.RED));
    public static final Component WIP = Component.translatable("ancient_aether.tooltip.wip").withStyle(Style.EMPTY.withColor(ChatFormatting.RED));

    //Misc
    public static final RegistryObject<Item> ANCIENT_RUNE = ITEMS.register("ancient_rune", () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ANCIENT_DUNGEON_KEY = ITEMS.register("ancient_dungeon_key", () -> new DungeonKeyItem(new ResourceLocation(AncientAether.MOD_ID, "ancient"), new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryObject<Item> VALKYRUM = ITEMS.register("valkyrum", () -> new Item(new Item.Properties()));

    //Signs
    public static final RegistryObject<Item> HIGHSPROOT_SIGN = ITEMS.register("highsproot_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.HIGHSPROOT_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_SIGN.get()));
    public static final RegistryObject<Item> SAKURA_SIGN = ITEMS.register("sakura_sign", () -> new SignItem(new Item.Properties().stacksTo(16), AncientAetherBlocks.SAKURA_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_SIGN.get()));
    public static final RegistryObject<Item> HIGHSPROOT_HANGING_SIGN = ITEMS.register("highsproot_hanging_sign", () -> new HangingSignItem(AncientAetherBlocks.HIGHSPROOT_HANGING_SIGN.get(), AncientAetherBlocks.HIGHSPROOT_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SAKURA_HANGING_SIGN = ITEMS.register("sakura_hanging_sign", () -> new HangingSignItem(AncientAetherBlocks.SAKURA_HANGING_SIGN.get(), AncientAetherBlocks.SAKURA_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    //Food
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.6f).build())));

    //Boats
    public static final RegistryObject<Item> HIGHSPROOT_BOAT = ITEMS.register("highsproot_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> HIGHSPROOT_CHEST_BOAT = ITEMS.register("highsproot_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1),  AncientAetherBoatEntity.Type.HIGHLANDS_PINE));
    public static final RegistryObject<Item> SAKURA_BOAT = ITEMS.register("sakura_boat", () -> new AncientAetherBoatItem(false, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));
    public static final RegistryObject<Item> SAKURA_CHEST_BOAT = ITEMS.register("sakura_chest_boat", () -> new AncientAetherBoatItem(true, new Item.Properties().stacksTo(1), AncientAetherBoatEntity.Type.SAKURA));

    //Weapons
    public static final RegistryObject<SwordItem> VALKYRUM_SWORD = ITEMS.register("valkyrum_sword", ValkyrumSwordItem::new);
    public static final RegistryObject<SwordItem> VALKYRUM_LANCE = ITEMS.register("valkyrum_lance", ValkyrumLanceItem::new);
    public static final RegistryObject<SwordItem> ANCIENT_SWORD = ITEMS.register("ancient_sword", AncientSwordItem::new);
    public static final RegistryObject<Item> GRAVITITE_DART_SHOOTER = ITEMS.register("gravitite_dart_shooter", () -> new GravititeDartShooterItem(AetherItems.GOLDEN_DART, (new Item.Properties().stacksTo(1))));

    //Tools
    public static final RegistryObject<PickaxeItem> VALKYRUM_PICKAXE = ITEMS.register("valkyrum_pickaxe", ValkyrumPickaxeItem::new);
    public static final RegistryObject<AxeItem> VALKYRUM_AXE = ITEMS.register("valkyrum_axe", ValkyrumAxeItem::new);
    public static final RegistryObject<ShovelItem> VALKYRUM_SHOVEL = ITEMS.register("valkyrum_shovel", ValkyrumShovelItem::new);
    public static final RegistryObject<HoeItem> VALKYRUM_HOE = ITEMS.register("valkyrum_hoe", ValkyrumHoeItem::new);
    public static final RegistryObject<PickaxeItem> ARKZENUS_PICKAXE = ITEMS.register("arkzenus_pickaxe", ArkzenusPickaxeItem::new);

    //Armor
    public static final RegistryObject<Item> VALKYRUM_HELMET = ITEMS.register("valkyrum_helmet", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_CHESTPLATE = ITEMS.register("valkyrum_chestplate", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_LEGGINGS = ITEMS.register("valkyrum_leggings", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_BOOTS = ITEMS.register("valkyrum_boots", () -> new AncientAetherArmorItem(AncientAetherArmorTiers.VALKYRUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> VALKYRUM_GLOVES = ITEMS.register("valkyrum_gloves", () -> new GlovesItem(AncientAetherArmorTiers.VALKYRUM, 1.0, "valkyrum_gloves", AetherSoundEvents.ITEM_ARMOR_EQUIP_VALKYRIE, new Item.Properties().stacksTo(1).durability(1561)));

    //Accessories
    public static final RegistryObject<Item> STRENGTH_STONE = ITEMS.register("strength_stone", () -> new StrengthStoneItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ANCIENT_RING = ITEMS.register("ancient_ring", () -> new AncientRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ANCIENT_PENDANT = ITEMS.register("ancient_pendant", () -> new AncientPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HEALTH_RING = ITEMS.register("health_ring", () -> new HealthRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HEALTH_PENDANT = ITEMS.register("health_pendant", () -> new HealthPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HERMES_RING = ITEMS.register("hermes_ring", () -> new HermesRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HERMES_PENDANT = ITEMS.register("hermes_pendant", () -> new HermesPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARKENIUM_RING = ITEMS.register("arkenium_ring", () -> new ArkeniumRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ARKENIUM_PENDANT = ITEMS.register("arkenium_pendant", () -> new ArkeniumPendantItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VALKYRUM_RING = ITEMS.register("valkyrum_ring", () -> new ValkyrumRingItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> VALKYRUM_PENDANT = ITEMS.register("valkyrum_pendant", () -> new ValkyrumPendantItem(new Item.Properties().stacksTo(1)));

    //Spawn Eggs
    public static final RegistryObject<SpawnEggItem> HIGHLAND_BUFFALO_SPAWN_EGG = ITEMS.register("highland_buffalo_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.HIGHLAND_BUFFALO, 0x4B6F89, 0x96C4D3, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> ROOTHYRN_SPAWN_EGG = ITEMS.register("roothyrn_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.ROOTHYRN, 0x737558, 0x6FA871, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> AERONAUTIC_LEAPER_SPAWN_EGG = ITEMS.register("aeronautic_leaper_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.AERONAUTIC_LEAPER, 0x35343D, 0xB7B2FF, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> ANCIENT_GUARDIAN_SPAWN_EGG = ITEMS.register("ancient_guardian_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.ANCIENT_GUARDIAN, 0xB7B2FF, 0x35343D, new Item.Properties()));
    public static final RegistryObject<SpawnEggItem> ANCIENT_CORE_SPAWN_EGG = ITEMS.register("ancient_core_spawn_egg", () -> new ForgeSpawnEggItem(AncientAetherEntities.ANCIENT_CORE, 0xCC6C80, 0x35343D, new Item.Properties()));
    public static final RegistryObject<Item> SAKURA_MOA_EGG = ITEMS.register("sakura_moa_egg", () -> new MoaEggItem(AncientAetherMoaTypes.SAKURA, 0xD09FA9, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
