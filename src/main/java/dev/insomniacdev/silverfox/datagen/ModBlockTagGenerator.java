package dev.insomniacdev.silverfox.datagen;

import dev.insomniacdev.silverfox.Silverfox;
import dev.insomniacdev.silverfox.registry.ModBlocks;
import dev.insomniacdev.silverfox.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Silverfox.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        /* FORGE TAGS */

        this.tag(ModTags.Blocks.SILVER_ORES)
                .add(ModBlocks.SILVER_ORE.get(),
                        ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                        ModBlocks.MOON_SILVER_ORE.get());

        this.tag(ModTags.Blocks.SILVER_STORAGE_BLOCKS).add(ModBlocks.SILVER_STORAGE_BLOCK.get());
        this.tag(ModTags.Blocks.RAW_SILVER_STORAGE_BLOCKS).add(ModBlocks.RAW_SILVER_STORAGE_BLOCK.get());

        this.tag(ModTags.Blocks.ORES).addTag(ModTags.Blocks.SILVER_ORES);
        this.tag(ModTags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.SILVER_STORAGE_BLOCKS);
        this.tag(ModTags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.RAW_SILVER_STORAGE_BLOCKS);

        /* VANILLA TAGS */

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SILVER_STORAGE_BLOCK.get(),
                        ModBlocks.RAW_SILVER_STORAGE_BLOCK.get())
                .addTag(ModTags.Blocks.SILVER_ORES);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILVER_ORE.get(),
                        ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                        ModBlocks.MOON_SILVER_ORE.get());



    }

}
