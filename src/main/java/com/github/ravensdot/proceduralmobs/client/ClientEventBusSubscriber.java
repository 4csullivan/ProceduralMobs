package com.github.ravensdot.proceduralmobs.client;

import com.github.ravensdot.proceduralmobs.ProceduralMobs;
import com.github.ravensdot.proceduralmobs.client.render.entity.ProceduralEntityRenderer;
import com.github.ravensdot.proceduralmobs.init.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ProceduralMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PROCEDURAL_ENTITY0.get(), ProceduralEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PROCEDURAL_ENTITY1.get(), ProceduralEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PROCEDURAL_ENTITY2.get(), ProceduralEntityRenderer::new);
    }
}
