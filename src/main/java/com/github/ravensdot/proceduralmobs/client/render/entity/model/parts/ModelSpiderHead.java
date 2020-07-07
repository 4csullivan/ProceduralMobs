package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelSpiderHead extends AbstractModelParts {
    private final ModelRenderer head;

    public ModelSpiderHead(ModelRenderer head, float offX, float offY, float offZ)
    {
        super();
        this.head = head;
        head.setRotationPoint(0.0f + offX, 0.0f + offY, 0.0f + offZ);
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
}
