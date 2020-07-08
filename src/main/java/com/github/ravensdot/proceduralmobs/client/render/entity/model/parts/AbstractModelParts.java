package com.github.ravensdot.proceduralmobs.client.render.entity.model.parts;

import com.github.ravensdot.proceduralmobs.client.render.entity.model.ProceduralEntityModel;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.client.renderer.model.ModelRenderer;

/**
 * Abstract class that holds required getters and updaters.
 *
 * @author ravensdot
 */
public abstract class AbstractModelParts {

    /**
     * Constructor, initializes parts and positions.
     * @param offX X position offset
     * @param offY Y position offset
     * @param offZ Z position offset
     * @param part One or more model renderer parts
     */
    public AbstractModelParts(float offX, float offY, float offZ, ModelRenderer ... part) { }

    /**
     * gets model renderers from model parts inside the class.
     *
     * @return array of model renderers
     */
    public abstract ModelRenderer[] getModelRenderers();

    /**
     * Updates the angles as defined in parent model class.
     *
     * @param entityIn Parent entity
     * @param limbSwing Parent limb swing
     * @param limbSwingAmount Parent limb swing amount
     * @param ageInTicks Parent age in ticks
     * @param netHeadYaw Parent head yaw
     * @param headPitch Parent head pitch
     * @return array of updated model renderers
     */
    public abstract ModelRenderer[] updateAngles(ProceduralEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch);

    /**
     * Gets current part type
     * TODO: deprecate
     *
     * @return PartType
     */
    public abstract PartType getPartType();

    /**
     * Getter for every PartSpawnLocation in part
     * @return PartSpawnLocation array
     */
    public abstract PartSpawnLocation[] getPartSpawnLocations();
}
