package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.math.MathHelper;

public class ModelZombieLegs extends AbstractModelParts {

    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;

    public ModelZombieLegs(ModelRenderer leftLeg, ModelRenderer rightLeg)
    {
        super();
        this.rightLeg = rightLeg;
        this.rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.setRotationAngle(rightLeg, -0.4363F, 0.0F, 0.0873F);
        this.rightLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        this.leftLeg = leftLeg;
        this.leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.setRotationAngle(leftLeg, 0.3491F, 0.0F, 0.0F);
        this.leftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
    }

    @Override
    public ModelRenderer[] getModelRenderers()
    {
        return new ModelRenderer[]{leftLeg, rightLeg};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float HeadPitch) {
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

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
