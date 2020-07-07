package com.github.ravensdot.proceduralmobs.util;

import com.github.ravensdot.proceduralmobs.init.ModEntityTypes;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {

    public static void init()
    {
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
