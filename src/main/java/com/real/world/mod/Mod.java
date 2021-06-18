package com.real.world.mod;

import com.real.world.mod.registry.ModBlocks;
import com.real.world.mod.registry.ModItems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.GenerationStep;

class FeatureGen {

    private static final ConfiguredFeature<?, ?> BAUXITE = Feature.ORE
        .configure(new OreFeatureConfig(
            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            ModBlocks.BAUXITE.getDefaultState(),
            5
        ))
        .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
            UniformHeightProvider.create(
            YOffset.fixed(0), 
            YOffset.fixed(70)))))
        .spreadHorizontally()
        .repeat(10);

    private static final RegistryKey<ConfiguredFeature<?, ?>> BAUXITE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Mod.Mod_ID));

    public static void addFeaturesToBiomes() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, BAUXITE_KEY.getValue(), BAUXITE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, BAUXITE_KEY);
    }
}

public class Mod implements ModInitializer {

    public static final String Mod_ID = "oxide-oganesson";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
        new Identifier(Mod_ID, "creative-tabs"),
        () -> new ItemStack(ModItems.CYLINDER_ITEM));

    @Override
    public void onInitialize() {
        FeatureGen.addFeaturesToBiomes();
        ModBlocks.registerBlocks();
        ModItems.registerItems();
    }

}
