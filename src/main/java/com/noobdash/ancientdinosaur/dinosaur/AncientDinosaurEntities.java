package com.noobdash.ancientdinosaur.dinosaur;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.noobdash.ancientdinosaur.AncientDinosaur;
import com.noobdash.ancientdinosaur.dinosaur.entity.TyrannosaurusEntity;
import com.noobdash.ancientdinosaur.dinosaur.entity.VelociraptorEntity;
import com.noobdash.ancientdinosaur.dinosaur.entity.PteranodonEntity;

/**
 * 恐竜エンティティタイプ登録
 */
public class AncientDinosaurEntities {
    
    public static final EntityType<TyrannosaurusEntity> TYRANNOSAURUS = 
        EntityType.Builder.create(TyrannosaurusEntity::new, SpawnGroup.CREATURE)
            .setDimensions(1.2f, 2.5f)
            .maxTrackingRange(10)
            .build();

    public static final EntityType<VelociraptorEntity> VELOCIRAPTOR = 
        EntityType.Builder.create(VelociraptorEntity::new, SpawnGroup.CREATURE)
            .setDimensions(0.8f, 1.5f)
            .maxTrackingRange(10)
            .build();

    public static final EntityType<PteranodonEntity> PTERANODON = 
        EntityType.Builder.create(PteranodonEntity::new, SpawnGroup.CREATURE)
            .setDimensions(1.0f, 0.8f)
            .maxTrackingRange(12)
            .build();

    /**
     * 全エンティティを登録
     */
    public static void registerEntities() {
        Registry.register(Registries.ENTITY_TYPE, 
            new Identifier(AncientDinosaur.MOD_ID, "tyrannosaurus"), TYRANNOSAURUS);
        
        Registry.register(Registries.ENTITY_TYPE, 
            new Identifier(AncientDinosaur.MOD_ID, "velociraptor"), VELOCIRAPTOR);
        
        Registry.register(Registries.ENTITY_TYPE, 
            new Identifier(AncientDinosaur.MOD_ID, "pteranodon"), PTERANODON);

        AncientDinosaur.LOGGER.info("恐竜エンティティが登録されました: 3体");
    }
}
