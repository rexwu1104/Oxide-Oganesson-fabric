package com.real.world.mod.registry;

import com.real.world.mod.Mod;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final BlockItem BAUXITE_ITEM = new BlockItem(ModBlocks.BAUXITE, new Item.Settings().group(Mod.ITEM_GROUP));
    public static final BlockItem CYLINDER_ITEM = new BlockItem(ModBlocks.CYLINDER, new Item.Settings().group(Mod.ITEM_GROUP));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Mod.Mod_ID, "bauxite"), BAUXITE_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Mod.Mod_ID, "cylinder"), CYLINDER_ITEM);
    }
}
