package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.zombie;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.ModelArm;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelZombieArms extends ModelArm {
    /**
     * Constructor, initializes parts and positions.
     *
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param rightArm Right arm renderer
     * @param leftArm Left arm renderer
     */
    public ModelZombieArms(float offX, float offY, float offZ, ModelRenderer rightArm, ModelRenderer leftArm) {
        super(offX, offY, offZ, rightArm, leftArm);

        setRotationAngle(this.rightArm, -1.3963F, -0.0873F, 0.0F);
        this.rightArm.setTextureOffset(40,16).addBox(-3.0f, -2.0f, 2.0f, 4.0f, 12.0f, 4.0f, 0.0f, false);

        setRotationAngle(this.leftArm, -1.309F, 0.0873F, 0.0F);
        this.leftArm.setTextureOffset(40,16).addBox(-1.0f, -2.0f, -2.0f, 4.0f, 12.0f, 4.0f, 0.0f, true);
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.updateAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        boolean flag = entityIn.isAggressive();
        float f = MathHelper.sin(limbSwingAmount * (float)Math.PI);
        float f1 = MathHelper.sin((1.0F - (1.0F - limbSwingAmount) * (1.0F - limbSwingAmount)) * (float)Math.PI);
        this.rightArm.rotateAngleZ = 0.0F;
        this.leftArm.rotateAngleZ = 0.0F;
        this.rightArm.rotateAngleY = -(0.1F - f * 0.6F);
        this.leftArm.rotateAngleY = 0.1F - f * 0.6F;
        float f2 = -(float)Math.PI / (flag ? 1.5F : 2.25F);
        this.rightArm.rotateAngleX = f2;
        this.leftArm.rotateAngleX = f2;
        this.rightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.leftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
        this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        return new ModelRenderer[]{this.rightArm, this.leftArm};
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
