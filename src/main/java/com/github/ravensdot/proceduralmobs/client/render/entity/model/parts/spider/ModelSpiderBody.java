package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.spider;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelSpiderBody extends AbstractModelParts {

    private final ModelRenderer neck;
    private final ModelRenderer body;
    private final PartSpawnLocation headSpawn;
    private final PartSpawnLocation legSpawn;
    private final PartType partType = PartType.BODY;

    public ModelSpiderBody(float offX, float offY, float offZ, ModelRenderer neck, ModelRenderer body) {
        super(offX, offY, offZ, neck, body);

        //TODO: set location postions
        headSpawn = new PartSpawnLocation(0.0f,offY - 6.0f, 0.0f + offZ, PartType.HEAD);
        legSpawn = new PartSpawnLocation(0.0f, offY - 3.0f, 0.0f + offZ, PartType.LEGS);

        this.neck = neck;
        this.neck.setTextureOffset(64,0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F);
        this.neck.setRotationPoint(0.0F, offY - 3.0F, offZ + 0.0F);
        this.body = body;
        this.body.setTextureOffset(64,12).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F);
        this.body.setRotationPoint(0.0F, offY - 3.0F, offZ + 9.0F);
    }

    @Override
    public ModelRenderer[] getModelRenderers() {
        return new ModelRenderer[]{neck, body};
    }

    @Override
    public ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        return new ModelRenderer[]{neck,body};
    }

    @Override
    public PartType getPartType() {
        return partType;
    }

    @Override
    public PartSpawnLocation[] getPartSpawnLocations() {
        return new PartSpawnLocation[]{headSpawn, legSpawn};
    }
}
