package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelArm extends AbstractModelParts {

    public PartSpawnLocation bodySpawnLocation;
    public ModelRenderer rightArm, leftArm;
    public final PartType partType = PartType.ARMS;

    /**
     * Constructor, initializes parts and positions.
     *
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param rightArm Right arm renderer
     * @param leftArm Left arm renderer
     */
    public ModelArm(float offX, float offY, float offZ, ModelRenderer rightArm, ModelRenderer leftArm) {
        super(offX, offY, offZ, rightArm, leftArm);

        bodySpawnLocation = new PartSpawnLocation(0.0f, 0.0f + offY, 0.0f + offZ, PartType.NONE);

        this.rightArm = rightArm;
        this.rightArm.setRotationPoint(-offX, this.bodySpawnLocation.getLocY(), this.bodySpawnLocation.getLocZ());

        this.leftArm = leftArm;
        this.leftArm.setRotationPoint(offX, this.bodySpawnLocation.getLocY(), this.bodySpawnLocation.getLocZ());
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{this.rightArm, this.leftArm};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightArm.rotationPointZ = 0.0F;
        this.rightArm.rotationPointX = -5.0F;
        this.leftArm.rotationPointZ = 0.0F;
        this.leftArm.rotationPointX = 5.0F;

        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / 1.0f;
        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / 1.0f;
        this.rightArm.rotateAngleZ = 0.0F;
        this.leftArm.rotateAngleZ = 0.0F;

        this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        return new ModelRenderer[]{this.rightArm, this.leftArm};
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocations() {
        return new PartSpawnLocation[]{this.bodySpawnLocation};
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
