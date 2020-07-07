package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelSkeletonBody extends AbstractModelParts {

    private final ModelRenderer body;
    private final PartSpawnLocation headSpawnLocation;
    private final PartSpawnLocation legsSpawnLocation;
    private final PartTypes partType = PartTypes.BODY;

    public ModelSkeletonBody(float offX, float offY, float offZ, ModelRenderer body)
    {
        super(offX, offY, offZ, body);

        //TODO: set location postions
        headSpawnLocation = new PartSpawnLocation(0.0f, 0.0f, 0.0f, PartTypes.HEAD);
        legsSpawnLocation = new PartSpawnLocation(0.0f, 0.0f, 0.0f, PartTypes.LEGS);

        this.body = body;
        this.body.setRotationPoint(0.0f + offX,0.0f + offY, 0.0f + offZ);
        this.body.setTextureOffset(80,82).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0F, 0.0F, false);
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{body};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float HeadPitch) {
        this.body.rotateAngleX = 0.0f;
        this.body.rotationPointY = 0.0f;
        return new ModelRenderer[]{this.body};
    }

    @Override
    public PartTypes getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocation() {
        return new PartSpawnLocation[]{headSpawnLocation, legsSpawnLocation};
    }
}
