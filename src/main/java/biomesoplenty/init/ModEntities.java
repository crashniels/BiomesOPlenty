/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.init;

import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<BoatEntityBOP> boat = EntityType.Builder.<BoatEntityBOP>create(BoatEntityBOP::new, SpawnGroup.MISC).setDimensions(1.375f, 0.5625f).maxTrackingRange(10).build(BiomesOPlenty.MOD_ID + ":boat");

    public static void registerEntities() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(BiomesOPlenty.MOD_ID, "boat"), boat);
    }
}
