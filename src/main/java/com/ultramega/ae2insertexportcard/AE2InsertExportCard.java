package com.ultramega.ae2insertexportcard;

import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import com.ultramega.ae2insertexportcard.network.NetworkHandler;
import com.ultramega.ae2insertexportcard.registry.ClientEventHandler;
import com.ultramega.ae2insertexportcard.registry.ModItems;
import com.ultramega.ae2insertexportcard.registry.RegistryHandler;
import de.mari_023.ae2wtlib.AE2wtlib;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AE2InsertExportCard.MOD_ID)
public class AE2InsertExportCard {
    public static final String MOD_ID = "ae2insertexportcard";

    public static final NetworkHandler NETWORK_HANDLER = new NetworkHandler();

    public AE2InsertExportCard() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEventHandler::new);

        RegistryHandler.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(FMLCommonSetupEvent event) {
        Upgrades.add(ModItems.INSERT_CARD, AEItems.WIRELESS_TERMINAL, 1);
        Upgrades.add(ModItems.EXPORT_CARD, AEItems.WIRELESS_TERMINAL, 1);
        Upgrades.add(ModItems.INSERT_CARD, AEItems.WIRELESS_CRAFTING_TERMINAL, 1);
        Upgrades.add(ModItems.EXPORT_CARD, AEItems.WIRELESS_CRAFTING_TERMINAL, 1);
        if(ModList.get().isLoaded("ae2wtlib")) {
            Upgrades.add(ModItems.INSERT_CARD, AE2wtlib.UNIVERSAL_TERMINAL, 1);
            Upgrades.add(ModItems.EXPORT_CARD, AE2wtlib.UNIVERSAL_TERMINAL, 1);
        }

        Upgrades.add(AEItems.FUZZY_CARD, ModItems.INSERT_CARD, 1);
        Upgrades.add(AEItems.FUZZY_CARD, ModItems.EXPORT_CARD, 1);
        Upgrades.add(AEItems.INVERTER_CARD, ModItems.INSERT_CARD, 1);
        Upgrades.add(AEItems.CRAFTING_CARD, ModItems.EXPORT_CARD, 1);
        Upgrades.add(AEItems.SPEED_CARD, ModItems.EXPORT_CARD, 1);

        AE2InsertExportCard.NETWORK_HANDLER.register();
    }
}
