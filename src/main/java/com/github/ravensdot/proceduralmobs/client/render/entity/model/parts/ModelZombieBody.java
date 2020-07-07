package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelZombieBody extends AbstractModelParts {

    private final ModelRenderer body;

    public ModelZombieBody(ModelRenderer body) {
        super();
        this.body = body;
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureOffset(16,16).addBox(-4.0f, 0.0f, -2.0f, 8.0f, 12.0f, 4.0F, 0.0F, false);
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{this.body};
    }

    @Override
    public ModelRenderer[] updateAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float HeadPitch) {
        this.body.rotateAngleX = 0.0F;
        this.body.rotationPointY = 0.0f;
        return new ModelRenderer[]{this.body};
    }


}
