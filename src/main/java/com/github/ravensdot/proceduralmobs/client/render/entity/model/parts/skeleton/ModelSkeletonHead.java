package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.skeleton;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.parts.ModelHead;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelSkeletonHead extends ModelHead {
    /**
     * Constructor, initializes parts and positions.
     *
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param head Head model renderer
     */
    public ModelSkeletonHead(float offX, float offY, float offZ, ModelRenderer... head) {
        super(offX, offY, offZ, head);
        this.head.setTextureOffset(64,66).addBox(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, false);
    }
}
