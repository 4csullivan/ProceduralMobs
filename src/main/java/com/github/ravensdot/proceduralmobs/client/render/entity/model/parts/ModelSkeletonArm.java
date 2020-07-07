package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class ModelSkeletonArm extends AbstractModelParts {

    private final ModelRenderer leftArm, rightArm;
    private final PartSpawnLocation spawnLocation;
    private final PartTypes partType = PartTypes.ARMS;

    public ModelSkeletonArm(float offX, float offY, float offZ, ModelRenderer leftArm, ModelRenderer rightArm)
    {
        super(offX, offY, offZ, leftArm, rightArm);

        //TODO: set location postions
        spawnLocation = new PartSpawnLocation(5.0f + offX, 2.0f + offY, 0.0f + offZ, PartTypes.BODY);

        this.leftArm = leftArm;
        this.rightArm = rightArm;

        this.rightArm.setTextureOffset(64,82).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, false);
        this.rightArm.setRotationPoint(-spawnLocation.getLocX(), spawnLocation.getLocY(), spawnLocation.getLocZ());

        this.leftArm.setTextureOffset(64,82).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F, true);
        this.leftArm.setRotationPoint(spawnLocation.getLocX(), spawnLocation.getLocY(), spawnLocation.getLocZ());
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{leftArm, rightArm};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemStack = entityIn.getHeldItemMainhand();
        if (entityIn.isAggressive() && (itemStack.isEmpty() || !(itemStack.getItem() instanceof net.minecraft.item.BowItem))) {
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
    public PartTypes getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocation() {
        return new PartSpawnLocation[]{spawnLocation};
    }
}
