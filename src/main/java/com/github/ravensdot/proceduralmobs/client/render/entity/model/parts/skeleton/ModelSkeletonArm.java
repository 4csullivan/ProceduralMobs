package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.skeleton;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class ModelSkeletonArm extends AbstractModelParts {

    private final ModelRenderer leftArm, rightArm;
    private final PartSpawnLocation spawnLocation;
    private final PartType partType = PartType.ARMS;

    public ModelSkeletonArm(float offX, float offY, float offZ, ModelRenderer leftArm, ModelRenderer rightArm)
    {
        super(offX, offY, offZ, leftArm, rightArm);

        //TODO: set location postions
        spawnLocation = new PartSpawnLocation(0.0f, 0.0f + offY, 0.0f + offZ, PartType.BODY);

        this.leftArm = leftArm;
        this.rightArm = rightArm;

        this.rightArm.setTextureOffset(64,82).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, false);
        this.rightArm.setRotationPoint(-offX, spawnLocation.getLocY(), spawnLocation.getLocZ());

        this.leftArm.setTextureOffset(64,82).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, true);
        this.leftArm.setRotationPoint(offX, spawnLocation.getLocY(), spawnLocation.getLocZ());
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{leftArm, rightArm};
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

        ItemStack itemStack = entityIn.getHeldItemMainhand();
        if (entityIn.isAggressive() && (itemStack.isEmpty() || !(itemStack.getItem() instanceof BowItem))) {
            float f = MathHelper.sin(limbSwingAmount * (float) Math.PI);
            float f1 = MathHelper.sin(1.0f - ((1.0f - limbSwingAmount) * (1.0f - limbSwingAmount)) * (float) Math.PI);
            this.rightArm.rotateAngleZ = 0.0F;
            this.leftArm.rotateAngleZ = 0.0F;
            this.rightArm.rotateAngleY = -(0.1F - f * 0.6F);
            this.leftArm.rotateAngleY = 0.1F - f * 0.6F;
            this.rightArm.rotateAngleX = (-(float) Math.PI / 2F);
            this.leftArm.rotateAngleX = (-(float) Math.PI / 2F);
            this.rightArm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.leftArm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
            this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
            this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        }
        return new ModelRenderer[]{leftArm, rightArm};
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocations() {
        return new PartSpawnLocation[]{spawnLocation};
    }
}
