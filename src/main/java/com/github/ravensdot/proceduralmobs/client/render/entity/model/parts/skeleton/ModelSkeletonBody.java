package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.skeleton;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelSkeletonBody extends AbstractModelParts {

    private final ModelRenderer body;
    private final PartSpawnLocation headSpawnLocation;
    private final PartSpawnLocation armsSpawnLocation;
    private final PartSpawnLocation legsSpawnLocation;
    private final PartType partType = PartType.BODY;

    public ModelSkeletonBody(float offX, float offY, float offZ, ModelRenderer body)
    {
        super(offX, offY, offZ, body);

        //TODO: set location postions
        headSpawnLocation = new PartSpawnLocation(0.0f, offY - 12.0f, 0.0f + offZ, PartType.HEAD);
        armsSpawnLocation = new PartSpawnLocation(5.0f, offY - 10.0f, 0.0f + offZ, PartType.ARMS);
        legsSpawnLocation = new PartSpawnLocation(0.0f, offY - 0.0f, 0.0f + offZ, PartType.LEGS);

        this.body = body;
        this.body.setTextureOffset(80,82).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0F, 0.0F, false);
        this.body.setRotationPoint(0.0f, offY - 12.0f, offZ - 0.0f);
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{body};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float HeadPitch) {
        return new ModelRenderer[]{this.body};
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocations() {
        return new PartSpawnLocation[]{headSpawnLocation, armsSpawnLocation, legsSpawnLocation};
    }
}
