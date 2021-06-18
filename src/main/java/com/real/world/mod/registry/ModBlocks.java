package com.real.world.mod.registry;

import com.real.world.mod.Mod;
import com.real.world.mod.fix_texture.Cylinder;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    
    public static final Block BAUXITE = new Block(FabricBlockSettings
        .of(Material.METAL)
        .breakByTool(FabricToolTags.PICKAXES, 2)
        .requiresTool()
        .strength(3.0f, 15.0f)
        .sounds(BlockSoundGroup.METAL));

    public static final Block CYLINDER = new Cylinder(FabricBlockSettings
        .of(Material.STONE)
        .breakByTool(FabricToolTags.PICKAXES, 2)
        .requiresTool()
        .strength(4.0f, 25.0f)
        .sounds(BlockSoundGroup.STONE));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Mod.Mod_ID, "bauxite"), BAUXITE);
        Registry.register(Registry.BLOCK, new Identifier(Mod.Mod_ID, "cylinder"), CYLINDER);
    }
}
