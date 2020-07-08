package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelHead extends AbstractModelParts {

    public PartSpawnLocation bodySpawnLocation;
    public ModelRenderer head;
    public final PartType partType = PartType.HEAD;

    /**
     * Constructor, initializes parts and positions.
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param head Head model renderer
     */
    public ModelHead(float offX, float offY, float offZ, ModelRenderer ... head)
    {
        super(offX, offY, offZ, head);
        bodySpawnLocation = new PartSpawnLocation(0.0f, 0.0f + offY, 0.0f + offZ, PartType.BODY);

        this.head = head[0];
        this.head.setRotationPoint(0.0f, 0.0f + offY, 0.0f + offZ);
    }


    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{this.head};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        return new ModelRenderer[]{this.head};
    }

    @Override
    public PartType getPartType() {
        return null;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocations() {
        return new PartSpawnLocation[]{bodySpawnLocation};
    }
}
