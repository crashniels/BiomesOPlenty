/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.item;

import biomesoplenty.common.util.inventory.ItemGroupBOP;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class MusicDiscItemBOP extends MusicDiscItem
{
	//Provide a resource location and the correct registry to retrieve a SoundEvent supplier
    public static SoundEvent soundProvider(String soundName) {
        return new SoundEvent(new Identifier(BiomesOPlenty.MOD_ID, soundName));
    };
	
    public MusicDiscItemBOP(String record)
    {
        super(0, soundProvider(record), new Item.Settings().group(ItemGroupBOP.ItemGroupBOP).rarity(Rarity.RARE).maxCount(1));
    }
}
