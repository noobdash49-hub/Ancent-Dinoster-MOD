package com.noobdash.ancientdinosaur.dinosaur.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurType;

/**
 * ラプトルエンティティ
 */
public class VelociraptorEntity extends BaseDinosaurEntity {
    public VelociraptorEntity(EntityType<? extends VelociraptorEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initLiving() {
        super.initLiving();
        this.initializeDinosaurStats(DinosaurType.VELOCIRAPTOR);
    }
}
