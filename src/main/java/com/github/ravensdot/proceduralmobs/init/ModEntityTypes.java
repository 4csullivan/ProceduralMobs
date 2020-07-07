package com.github.ravensdot.proceduralmobs.init;

import com.github.ravensdot.proceduralmobs.ProceduralMobs;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ProceduralMobs.MOD_ID);
    public static final RegistryObject<EntityType<ProceduralEntity>> PROCEDURAL_ENTITY0 = ENTITY_TYPES
            .register("procedural_entity0",
                () -> EntityType.Builder
                    .create(ProceduralEntity::new, EntityClassification.MONSTER)
                    .size(0.6f, 1.95f)
                    .build("procedural_entity0"));
    public static final RegistryObject<EntityType<ProceduralEntity>> PROCEDURAL_ENTITY1 = ENTITY_TYPES
            .register("procedural_entity1",
                    () -> EntityType.Builder
                            .create(ProceduralEntity::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f)
                            .build("procedural_entity1"));
    public static final RegistryObject<EntityType<ProceduralEntity>> PROCEDURAL_ENTITY2 = ENTITY_TYPES
            .register("procedural_entity2",
                    () -> EntityType.Builder
                            .create(ProceduralEntity::new, EntityClassification.MONSTER)
                            .size(0.6f, 1.95f)
                            .build("procedural_entity2"));
}
