package dev.insomniacdev.silverfox.tags;

import dev.insomniacdev.silverfox.Silverfox;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SILVER_ORES = forgeTag("ores/silver");
        public static final TagKey<Block> SILVER_STORAGE_BLOCKS = forgeTag("storage_blocks/silver");
        public static final TagKey<Block> RAW_SILVER_STORAGE_BLOCKS = forgeTag("storage_blocks/raw_silver");

        public static final TagKey<Block> ORES = forgeTag("ores");
        public static final TagKey<Block> STORAGE_BLOCKS = forgeTag("storage_blocks");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Silverfox.MODID, name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }



    public static class Items {
        public static final TagKey<Item> SILVER_ORES = forgeTag("ores/silver");
        public static final TagKey<Item> SILVER_INGOTS = forgeTag("ingots/silver");
        public static final TagKey<Item> RAW_SILVER = forgeTag("raw_materials/silver");
        public static final TagKey<Item> SILVER_NUGGETS = forgeTag("nuggets/silver");
        public static final TagKey<Item> SILVER_STORAGE_BLOCKS = forgeTag("storage_blocks/silver");
        public static final TagKey<Item> RAW_SILVER_STORAGE_BLOCKS = forgeTag("storage_blocks/raw_silver");

        public static final TagKey<Item> ORES = forgeTag("ores");
        public static final TagKey<Item> INGOTS = forgeTag("ingots");
        public static final TagKey<Item> RAW_MATERIALS = forgeTag("raw_materials");
        public static final TagKey<Item> NUGGETS = forgeTag("nuggets");
        public static final TagKey<Item> STORAGE_BLOCKS = forgeTag("storage_blocks");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Silverfox.MODID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
