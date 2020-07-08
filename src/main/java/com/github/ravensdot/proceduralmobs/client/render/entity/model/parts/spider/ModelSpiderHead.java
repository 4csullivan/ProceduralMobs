package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.spider;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelSpiderHead extends AbstractModelParts {
    private final ModelRenderer head;
    private final PartSpawnLocation spawnLocation;
    private final PartType partType = PartType.HEAD;

    public ModelSpiderHead(float offX, float offY, float offZ, ModelRenderer head)
    {
        super(offX, offY, offZ, head);

        //TODO: set location postions
        spawnLocation = new PartSpawnLocation(0.0f + offX, 15.0f + offY, -3.0f + offZ, PartType.HEAD);
        this.head = head;
        head.setRotationPoint(spawnLocation.getLocX(), spawnLocation.getLocY(), spawnLocation.getLocZ());
        head.setTextureOffset(96, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{head};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        return new ModelRenderer[]{head};
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocation() {
        return new PartSpawnLocation[]{spawnLocation};
    }
}
