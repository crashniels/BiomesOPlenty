/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.init;

import biomesoplenty.common.entity.item.BoatEntityBOP;
import biomesoplenty.common.item.BoatItemBOP;
import biomesoplenty.common.item.MusicDiscItemBOP;
import biomesoplenty.common.util.inventory.ItemGroupBOP;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static biomesoplenty.api.item.BOPItems.*;

public class ModItems
{

    public static void registerItems()
	{
        mud_ball = registerItem(new Item(new Item.Settings().group(ItemGroupBOP.ItemGroupBOP)), "mud_ball");
        mud_brick = registerItem(new Item(new Item.Settings().group(ItemGroupBOP.ItemGroupBOP)), "mud_brick");
        
        //music_disc_wanderer = registerItem(new MusicDiscItemBOP("music_disc.wanderer"), "music_disc_wanderer");

        /*
        fir_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.FIR), "fir_boat");
        redwood_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.REDWOOD), "redwood_boat");
        cherry_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.CHERRY), "cherry_boat");
        mahogany_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.MAHOGANY), "mahogany_boat");
        jacaranda_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.JACARANDA), "jacaranda_boat");
        palm_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.PALM), "palm_boat");
        willow_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.WILLOW), "willow_boat");
        dead_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.DEAD), "dead_boat");
        magic_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.MAGIC), "magic_boat");
        umbran_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.UMBRAN), "umbran_boat");
        hellbark_boat = registerItem(new BoatItemBOP(BoatEntityBOP.BoatModel.HELLBARK), "hellbark_boat");
        */

        bop_icon = registerItem(new Item(new Item.Settings()), "bop_icon");
	}

    public static Item registerItem(Item item, String name)
    {
        return Registry.register(Registry.ITEM, new Identifier("biomesoplenty", name), item);
    }
}
