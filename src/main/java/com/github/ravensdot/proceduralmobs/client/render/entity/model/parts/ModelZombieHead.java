package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelZombieHead extends AbstractModelParts
{
    private ModelRenderer head;
    private PartSpawnLocation bodySpawnLocation;
    private PartTypes partType = PartTypes.HEAD;

    /**
     * Constructor, initializes parts and positions.
     *
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param head Head model renderer
     */
    public ModelZombieHead(float offX, float offY, float offZ, ModelRenderer head) {
        super(offX, offY, offZ, head);

        //TODO: set location postions
        bodySpawnLocation = new PartSpawnLocation(0.0f, 0.0f, 0.0f, PartTypes.BODY);

        this.head = head;
        this.head.setTextureOffset(0,0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, false);
        this.head.setRotationPoint(0.0f + offX, 0.0f + offY, 0.0f + offZ);
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
    public PartTypes getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocation() {
        return new PartSpawnLocation[]{bodySpawnLocation};
    }
}
