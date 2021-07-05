package biomesoplenty.init;

import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings
{
    public static final PaintingMotive FIRST_WORLD = new PaintingMotive(32, 32);
    public static final PaintingMotive NETHER_WASP = new PaintingMotive(32, 32);
    public static final PaintingMotive PROMISED_LAND = new PaintingMotive(64, 32);
    public static final PaintingMotive COAST = new PaintingMotive(64, 64);

    public static void registerPaintingMotives()
    {
        registerPaintingMotive(FIRST_WORLD, "first_world");
        registerPaintingMotive(NETHER_WASP, "nether_wasp");
        registerPaintingMotive(PROMISED_LAND, "promised_land");
        registerPaintingMotive(COAST, "coast");
    }

    public static PaintingMotive registerPaintingMotive(PaintingMotive entry, String name)
    {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(BiomesOPlenty.MOD_ID, name), entry);
    }
}
