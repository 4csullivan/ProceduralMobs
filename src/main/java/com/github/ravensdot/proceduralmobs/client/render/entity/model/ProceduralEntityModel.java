package com.github.ravensdot.proceduralmobs.client.render.entity.model;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.*;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.skeleton.ModelSkeletonArm;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.skeleton.ModelSkeletonBody;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.skeleton.ModelSkeletonHead;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.spider.ModelSpiderBody;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.spider.ModelSpiderHead;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.zombie.ModelZombieArms;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.zombie.ModelZombieHead;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.zombie.ModelZombieLegs;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

import java.util.*;

public class ProceduralEntityModel<T extends Entity> extends SegmentedModel<T> {

    public static final int TEXTURE_WIDTH = 256;
    public static final int TEXTURE_HEIGHT = 256;
    private final ImmutableList<ModelRenderer> partList;
    //private Map<Enum<PartTypes>, AbstractModelParts> modelParts = new HashMap<>();
    private final List<AbstractModelParts> modelParts = new ArrayList<>();
    private final Random random;

    public ProceduralEntityModel()
    {
        this.textureWidth = TEXTURE_WIDTH;
        this.textureHeight = TEXTURE_HEIGHT;

        random = new Random();

        ModelZombieLegs zombieLegs = new ModelZombieLegs(0.0f, 0.0f, 0.0f, new ModelRenderer(this), new ModelRenderer(this));
        modelParts.add(zombieLegs);
        PartSpawnLocation[] locations = zombieLegs.getPartSpawnLocations();
        buildParts(locations);

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

    private void buildParts(PartSpawnLocation[] locations)
    {
        AbstractModelParts part = null;
        PartSpawnLocation[] newLocations = null;
        for (PartSpawnLocation psl : locations) {
            switch (psl.getType()) {
                case ARMS:
                    if (random.nextBoolean()) {
                        modelParts.add(new ModelSkeletonArm(psl.getLocX(), psl.getLocY(), psl.getLocZ(), new ModelRenderer(this), new ModelRenderer(this)));
                    } else {
                        modelParts.add(new ModelZombieArms(psl.getLocX(),psl.getLocY(), psl.getLocZ(), new ModelRenderer(this), new ModelRenderer(this)));
                    }
                    break;
                case BODY:
                    part = new ModelSpiderBody(psl.getLocX(), psl.getLocY(), psl.getLocZ(), new ModelRenderer(this), new ModelRenderer(this));
                    modelParts.add(part);
                    newLocations = part.getPartSpawnLocations();
                    buildParts(newLocations);
                    break;
                case HEAD:
                    int chance = random.nextInt(100);
                    if (chance <= 33) {
                        if (random.nextBoolean()) {
                            modelParts.add(new ModelZombieHead(psl.getLocX(), psl.getLocY(), psl.getLocZ(), new ModelRenderer(this)));
                        } else {
                            modelParts.add(new ModelSkeletonHead(psl.getLocX(), psl.getLocY(), psl.getLocZ(), new ModelRenderer(this)));
                        }
                    } else if (chance <= 66) {
                        ModelSkeletonBody skeletonBody = new ModelSkeletonBody(psl.getLocX(), psl.getLocY(), psl.getLocZ(), new ModelRenderer(this));
                        modelParts.add(skeletonBody);
                        PartSpawnLocation[] skeletonLocs = skeletonBody.getPartSpawnLocations();
                        buildParts(skeletonLocs);
                    } else {
                        part = new ModelSpiderBody(psl.getLocX(), psl.getLocY(), psl.getLocZ(), new ModelRenderer(this), new ModelRenderer(this));
                        modelParts.add(part);
                        newLocations = part.getPartSpawnLocations();
                        buildParts(newLocations);

                    }
                    break;
                case LEGS:
                    boolean containsLeg = false;
                    for (AbstractModelParts p : modelParts) {
                        if (p instanceof ModelZombieLegs) {
                            containsLeg = true;
                        }
                    }
                    if (!containsLeg)
                        modelParts.add(new ModelZombieLegs(psl.getLocX(), psl.getLocY(), psl.getLocZ(), new ModelRenderer(this), new ModelRenderer(this)));

                    break;
            }
        }
    }
}
