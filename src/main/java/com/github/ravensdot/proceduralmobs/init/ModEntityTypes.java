package com.github.ravensdot.proceduralmobs.init;

import com.github.ravensdot.proceduralmobs.ProceduralMobs;
import com.github.ravensdot.proceduralmobs.entity.ProceduralEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModEntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, ProceduralMobs.MOD_ID);
    public static final List<RegistryObject<EntityType<ProceduralEntity>>> ENTITY_LIST = new ArrayList<>();

    public static void init()
    {
        for (int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
             ENTITY_LIST.add(ENTITY_TYPES
                     .register("procedural_entity" + index,
                             () -> EntityType.Builder
                                     .create(ProceduralEntity::new, EntityClassification.MONSTER)
                                     .size(0.6f, 1.95f)
                                     .build("procedural_entity" + index)
                     )
             );
        }
    }
}
