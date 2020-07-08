package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.spider;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelSpiderLegs extends AbstractModelParts {

    private final ModelRenderer legLeft0;
    private final ModelRenderer legLeft1;
    private final ModelRenderer legLeft2;
    private final ModelRenderer legLeft3;
    private final ModelRenderer legRight0;
    private final ModelRenderer legRight1;
    private final ModelRenderer legRight2;
    private final ModelRenderer legRight3;
    private final PartSpawnLocation bodySpawnLocation;
    private final PartType partType = PartType.LEGS;

    /**
     * Constructor, initializes parts and positions.
     *
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param parts One or more model renderer parts
     */
    public ModelSpiderLegs(float offX, float offY, float offZ, ModelRenderer[] parts) {
        super(offX, offY, offZ, parts);

        bodySpawnLocation = new PartSpawnLocation(4.0f, 15.0f, 1.0f, PartType.BODY);

        legLeft0 = parts[0];
        legLeft1 = parts[1];
        legLeft2 = parts[2];
        legLeft3 = parts[3];
        legRight0 = parts[4];
        legRight1 = parts[5];
        legRight2 = parts[6];
        legRight3 = parts[7];

        legLeft0.setRotationPoint(-4.0F - offX, 15.0f + offY, 2.0f + offZ);
        setRotationAngle(legLeft0, 0.0F, 0.7854F, -0.7854F);
        legLeft0.setTextureOffset(82, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        legRight0.setRotationPoint(4.0F + offX, 15.0f + offY, 2.0f + offZ);
        setRotationAngle(legRight0, 0.0F, -0.7854F, 0.7854F);
        legRight0.setTextureOffset(82, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        legLeft1.setRotationPoint(-4.0F - offX, 15.0f + offY, 1.0f + offZ);
        setRotationAngle(legLeft1, 0.0F, 0.2618F, -0.6109F);
        legLeft1.setTextureOffset(82, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        legRight1.setRotationPoint(4.0F + offX, 15.0f + offY, 1.0f + offZ);
        setRotationAngle(legRight1, 0.0F, -0.2618F, 0.6109F);
        legRight1.setTextureOffset(82, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        legLeft2.setRotationPoint(-4.0F - offX, 15.0f + offY, 0.0f + offZ);
        setRotationAngle(legLeft2, 0.0F, -0.2618F, -0.6109F);
        legLeft2.setTextureOffset(82, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        legRight2.setRotationPoint(4.0F + offX, 15.0f + offY, 1.0f + offZ);
        setRotationAngle(legRight2, 0.0F, 0.2618F, 0.6109F);
        legRight2.setTextureOffset(82, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        legLeft3.setRotationPoint(-4.0F - offX, 15.0f + offY, 0.0f + offZ);
        setRotationAngle(legLeft3, 0.0F, -0.7854F, -0.7854F);
        legLeft3.setTextureOffset(82, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);

        legRight3.setRotationPoint(4.0F + offX, 15.0f + offY, 0.0f + offZ);
        setRotationAngle(legRight3, 0.0F, 0.7854F, 0.7854F);
        legRight3.setTextureOffset(82, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{legLeft0, legLeft1, legLeft2, legLeft3, legRight0, legRight1, legRight2, legRight3};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.legLeft0.rotateAngleZ = (-(float)Math.PI / 4F);
        this.legRight0.rotateAngleZ = ((float)Math.PI / 4F);
        this.legLeft1.rotateAngleZ = -0.58119464F;
        this.legRight1.rotateAngleZ = 0.58119464F;
        this.legLeft2.rotateAngleZ = -0.58119464F;
        this.legRight2.rotateAngleZ = 0.58119464F;
        this.legLeft3.rotateAngleZ = (-(float)Math.PI / 4F);
        this.legRight3.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = ((float)Math.PI / 8F);
        this.legLeft0.rotateAngleY = ((float)Math.PI / 4F);
        this.legRight0.rotateAngleY = (-(float)Math.PI / 4F);
        this.legLeft1.rotateAngleY = ((float)Math.PI / 8F);
        this.legRight1.rotateAngleY = (-(float)Math.PI / 8F);
        this.legLeft2.rotateAngleY = (-(float)Math.PI / 8F);
        this.legRight2.rotateAngleY = ((float)Math.PI / 8F);
        this.legLeft3.rotateAngleY = (-(float)Math.PI / 4F);
        this.legRight3.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        this.legLeft0.rotateAngleY += f3;
        this.legRight0.rotateAngleY += -f3;
        this.legLeft1.rotateAngleY += f4;
        this.legRight1.rotateAngleY += -f4;
        this.legLeft2.rotateAngleY += f5;
        this.legRight2.rotateAngleY += -f5;
        this.legLeft3.rotateAngleY += f6;
        this.legRight3.rotateAngleY += -f6;
        this.legLeft0.rotateAngleZ += f7;
        this.legRight0.rotateAngleZ += -f7;
        this.legLeft1.rotateAngleZ += f8;
        this.legRight1.rotateAngleZ += -f8;
        this.legLeft2.rotateAngleZ += f9;
        this.legRight2.rotateAngleZ += -f9;
        this.legLeft3.rotateAngleZ += f10;
        this.legRight3.rotateAngleZ += -f10;

        return new ModelRenderer[]{legLeft0, legRight1, legLeft2, legLeft3, legRight0, legRight1, legRight2, legRight3};
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocations() {
        return new PartSpawnLocation[]{bodySpawnLocation};
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
