package com.github.ravensdot.proceduralmobs.client.render.entity.model;

import com.github.ravensdot.proceduralmobs.ProceduralMobs;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.*;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import com.github.ravensdot.proceduralmobs.init.ModEntityTypes;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;

public class ProceduralEntityModel<T extends Entity> extends SegmentedModel<T> {

    public static final int TEXTURE_WIDTH = 256;
    public static final int TEXTURE_HEIGHT = 256;
    private final ImmutableList<ModelRenderer> partList;
    //private Map<Enum<PartTypes>, AbstractModelParts> modelParts = new HashMap<>();
    private final List<AbstractModelParts> modelParts = new ArrayList<>();

    public ProceduralEntityModel()
    {
        this.textureWidth = TEXTURE_WIDTH;
        this.textureHeight = TEXTURE_HEIGHT;
        //modelParts.put(PartTypes.ZOMBIE_LEGS, new ModelZombieLegs(new ModelRenderer(this), new ModelRenderer(this)));
        //ModelZombieLegs legs = (ModelZombieLegs)modelParts.get(PartTypes.ZOMBIE_LEGS);
        Random random = new Random();
        if (random.nextBoolean()) {
            modelParts.add(new ModelZombieLegs(0.0f, 0.0f, 0.0f, new ModelRenderer(this), new ModelRenderer(this)));
        } else {
            modelParts.add(new ModelSpiderBody(0.0f, 0.0f, 0.0f, new ModelRenderer(this), new ModelRenderer(this)));
        }
        if (random.nextBoolean())
            modelParts.add(new ModelSpiderHead(0.0f, -10.0f, 0.0f, new ModelRenderer(this)));
        else
            modelParts.add(new ModelZombieHead(0.0f, 0.0f, 0.0f, new ModelRenderer(this)));

        if (random.nextBoolean()) {
            modelParts.add(new ModelSkeletonArm(0.0f, 0.0f, 0.0f, new ModelRenderer(this), new ModelRenderer(this)));
        }

        if (random.nextBoolean()) {
            modelParts.add(new ModelZombieBody(0.0f, 0.0f, 0.0f, new ModelRenderer(this)));
        } else {
            modelParts.add(new ModelSkeletonBody(0.0f, 0.0f, 0.0f, new ModelRenderer(this)));
        }

        ImmutableList.Builder<ModelRenderer> builder = ImmutableList.builder();
        for (AbstractModelParts part : modelParts) {
            builder.addAll(Arrays.asList(part.getModelRenderers()));
        }
        partList = builder.build();
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {

        return this.partList;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        for (AbstractModelParts part : modelParts) {
            part.updateAngles((ProceduralEntity) entityIn,limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        }
    }
}
