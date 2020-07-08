package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.zombie;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.AbstractModelParts;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.ModelHead;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartSpawnLocation;
import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.PartType;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelZombieHead extends ModelHead
{

    /**
     * Constructor, initializes parts and positions.
     *
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param head Head model renderer
     */
    public ModelZombieHead(float offX, float offY, float offZ, ModelRenderer head) {
        super(offX, offY, offZ, head);
        this.head.setTextureOffset(0, 0).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, false);
    }
}
