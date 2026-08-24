package com.noobdash.ancientdinosaur.dinosaur.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import com.noobdash.ancientdinosaur.dinosaur.DinosaurType;

/**
 * ティラノサウルスエンティティ
 */
public class TyrannosaurusEntity extends BaseDinosaurEntity {
    public TyrannosaurusEntity(EntityType<? extends TyrannosaurusEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initLiving() {
        super.initLiving();
        this.initializeDinosaurStats(DinosaurType.TYRANNOSAURUS);
    }
}
