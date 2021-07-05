package biomesoplenty.mixin.item;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;

@Mixin(AxeItem.class)
public interface AxeItemAccessor {
    //Taken from PR #1125
    //Content Registry v1 stuff
	@Accessor(value = "STRIPPED_BLOCKS")
	static Map<Block, Block> getStrippedBlocks() {
		throw new AssertionError();  
    }
}
