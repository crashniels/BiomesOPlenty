/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.util.inventory;

import biomesoplenty.api.item.BOPItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroupBOP 
{
    public static final ItemGroup ItemGroupBOP = FabricItemGroupBuilder.build(
		new Identifier(biomesoplenty.core.BiomesOPlenty.MOD_ID, "biomesoplenty"),
		() -> new ItemStack(BOPItems.bop_icon));
}
