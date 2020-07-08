package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.zombie;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelZombieLegs extends AbstractModelParts {

    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;
    private final PartSpawnLocation bodySpawnLocation;
    private final PartType partType = PartType.LEGS;

    public ModelZombieLegs(float offX, float offY, float offZ, ModelRenderer leftLeg, ModelRenderer rightLeg)
    {
        super(offX, offY, offZ, leftLeg, rightLeg);

        //TODO: set location positions
        bodySpawnLocation = new PartSpawnLocation(1.9f, 12.0f, 0.0f, PartType.BODY);

        this.rightLeg = rightLeg;
        this.rightLeg.setRotationPoint(-1.9F - offX, 12.0F + offY, 0.0f + offZ);
        this.setRotationAngle(rightLeg, -0.4363F, 0.0F, 0.0873F);
        this.rightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        this.leftLeg = leftLeg;
        this.leftLeg.setRotationPoint(1.9F + offX, 12.0F + offY, 0.0f + offZ);
        this.setRotationAngle(leftLeg, 0.3491F, 0.0F, 0.0F);
        this.leftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
    }

    @Override
    public ModelRenderer[] getModelRenderers()
    {
        return new ModelRenderer[]{leftLeg, rightLeg};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightLeg.rotationPointZ = 0.1F;
        this.leftLeg.rotationPointZ = 0.1F;
        this.rightLeg.rotationPointY = 12.0F;
        this.leftLeg.rotationPointY = 12.0F;

        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.rightLeg.rotateAngleY = 0.0F;
        this.leftLeg.rotateAngleY = 0.0F;
        return new ModelRenderer[]{leftLeg, rightLeg};
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocation() {
        return new PartSpawnLocation[]{bodySpawnLocation};
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
