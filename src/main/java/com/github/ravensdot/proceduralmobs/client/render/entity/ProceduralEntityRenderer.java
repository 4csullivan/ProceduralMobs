package com.github.ravensdot.proceduralmobs.client.render.entity;

import com.github.ravensdot.proceduralmobs.ProceduralMobs;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.ProceduralEntityModel;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ProceduralEntityRenderer extends MobRenderer<ProceduralEntity, ProceduralEntityModel<ProceduralEntity>> {
    protected static final ResourceLocation ENEMY_TEXTURE = new ResourceLocation(ProceduralMobs.MOD_ID,"textures/entity/procedural_enemy.png");

    public ProceduralEntityRenderer(EntityRendererManager rendererManagerIn)
    {
        super (rendererManagerIn, new ProceduralEntityModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ProceduralEntity entity) {
        return ENEMY_TEXTURE;
    }
}
