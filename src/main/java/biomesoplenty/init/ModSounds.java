/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.init;

import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static biomesoplenty.api.sound.BOPSounds.*;

public class ModSounds
{
    public static void registerSounds()
    {
        music_disc_wanderer = registerSound("music_disc.wanderer");
    }

    private static SoundEvent registerSound(String soundName)
    {
        Identifier location = new Identifier(BiomesOPlenty.MOD_ID, soundName);
        SoundEvent event = new SoundEvent(location);
        return Registry.register(Registry.SOUND_EVENT, location, event);
    }
}
