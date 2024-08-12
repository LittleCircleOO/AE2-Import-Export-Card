package com.ultramega.ae2insertexportcard.registry;

import appeng.api.upgrades.Upgrades;
import com.ultramega.ae2insertexportcard.AE2InsertExportCard;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item INSERT_CARD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(AE2InsertExportCard.MOD_ID, "insert_card"), Upgrades.createUpgradeCardItem(new Item.Properties().stacksTo(1)));
    public static final Item EXPORT_CARD = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(AE2InsertExportCard.MOD_ID, "insert_card"), Upgrades.createUpgradeCardItem(new Item.Properties().stacksTo(1)));
}
