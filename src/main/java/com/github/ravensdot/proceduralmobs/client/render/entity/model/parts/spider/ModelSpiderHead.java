package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.spider;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.ModelHead;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelSpiderHead extends ModelHead {

    public ModelSpiderHead(float offX, float offY, float offZ, ModelRenderer head)
    {
        super(offX, offY, offZ, head);
        this.head.setTextureOffset(96, 4).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, false);
    }
}
