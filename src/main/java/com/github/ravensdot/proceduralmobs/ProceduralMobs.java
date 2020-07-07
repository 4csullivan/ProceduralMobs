package com.github.ravensdot.proceduralmobs;

import com.github.ravensdot.proceduralmobs.util.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

@Mod("proceduralmobs")
public class ProceduralMobs
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "proceduralmobs";

    public static int PROCEDURAL_SEED;

    public ProceduralMobs()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        Random rand = new Random();
        PROCEDURAL_SEED = rand.nextInt(1000000000);

        MinecraftForge.EVENT_BUS.register(this);
        RegistryHandler.init();
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }
}
