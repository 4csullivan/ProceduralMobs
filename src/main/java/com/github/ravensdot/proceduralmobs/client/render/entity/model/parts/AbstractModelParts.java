package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.ProceduralEntityModel;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public abstract class AbstractModelParts {
    public abstract ModelRenderer[] getModelRenderers();
    public abstract ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float HeadPitch);
}
