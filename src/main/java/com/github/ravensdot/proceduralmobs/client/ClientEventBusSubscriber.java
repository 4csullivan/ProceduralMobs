package com.github.ravensdot.proceduralmobs.client;

import com.github.ravensdot.proceduralmobs.ProceduralMobs;
import com.github.ravensdot.proceduralmobs.client.render.entity.ProceduralEntityRenderer;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import com.github.ravensdot.proceduralmobs.init.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ProceduralMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
    {
        for (RegistryObject<EntityType<ProceduralEntity>> entity : ModEntityTypes.ENTITY_LIST) {
            RenderingRegistry.registerEntityRenderingHandler(entity.get(), ProceduralEntityRenderer::new);
        }
    }
}
