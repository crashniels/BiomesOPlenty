/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.core;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.client.BOPClassicPack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockRenderView;
import net.minecraft.resource.metadata.PackResourceMetadata;

import java.awt.*;
import java.util.Calendar;

public class ClientProxy
{
    public ClientProxy()
    {

    }

    @Environment(EnvType.CLIENT)
    public static void init()
    {
        //addClassicPack();

        //Grass Coloring
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
            world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getColor(0.5D, 1.0D),
            BOPBlocks.sprout, BOPBlocks.clover, BOPBlocks.huge_clover_petal, BOPBlocks.watergrass, BOPBlocks.potted_sprout, BOPBlocks.potted_clover);
        
        //Foliage Coloring
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
	        world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefaultColor(),
	        BOPBlocks.bush, BOPBlocks.flowering_oak_leaves, BOPBlocks.mahogany_leaves, BOPBlocks.palm_leaves,
	        BOPBlocks.willow_leaves, BOPBlocks.willow_vine);

        //Rainbow Birch Leaf Coloring
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) ->
            world != null && pos != null ? getRainbowBirchColor(world, pos) : FoliageColors.getDefaultColor(),
            BOPBlocks.rainbow_birch_leaves);
    
        // Need to fix
        /*
            ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            BlockState BlockState = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(BlockState, null, null, tintIndex); }, 
        	BOPBlocks.sprout, BOPBlocks.bush, BOPBlocks.clover, BOPBlocks.huge_clover_petal, BOPBlocks.flowering_oak_leaves,
            BOPBlocks.mahogany_leaves, BOPBlocks.palm_leaves, BOPBlocks.willow_leaves, BOPBlocks.willow_vine);
        */
    }

    /*
    public static void addClassicPack()
    {
        if (MinecraftClient.getInstance() == null) { return; }
        MinecraftClient.getInstance().getResourcePackDir().list((consumer, iFactory) -> consumer.accept(ResourcePackInfo.create(new Identifier(BiomesOPlenty.MOD_ID, "classic_textures").toString(), false, () -> new BOPClassicPack(ModList.get().getModFileById(BiomesOPlenty.MOD_ID).getFile()), iFactory, ResourcePackInfo.Priority.TOP, iTextComponent -> iTextComponent)));
    }
    */

    public static int getRainbowBirchColor(BlockRenderView world, BlockPos pos)
    {
        Color foliage = Color.getHSBColor((((float)pos.getX() + MathHelper.sin(((float)pos.getZ() + (float)pos.getX()) / 35) * 35) % 150) / 150, 0.6F, 1.0F);

        return foliage.getRGB();
    }
}
