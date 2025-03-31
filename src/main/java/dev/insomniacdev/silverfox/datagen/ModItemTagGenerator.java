package dev.insomniacdev.silverfox.datagen;

import dev.insomniacdev.silverfox.Silverfox;
import dev.insomniacdev.silverfox.registry.ModItems;
import dev.insomniacdev.silverfox.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Silverfox.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        /* Block Items */

        this.copy(ModTags.Blocks.SILVER_ORES, ModTags.Items.SILVER_ORES);
        this.copy(ModTags.Blocks.SILVER_STORAGE_BLOCKS, ModTags.Items.SILVER_STORAGE_BLOCKS);
        this.copy(ModTags.Blocks.RAW_SILVER_STORAGE_BLOCKS, ModTags.Items.RAW_SILVER_STORAGE_BLOCKS);

        this.copy(ModTags.Blocks.ORES, ModTags.Items.ORES);
        this.copy(ModTags.Blocks.STORAGE_BLOCKS, ModTags.Items.STORAGE_BLOCKS);

        /* Items */

        this.tag(ModTags.Items.SILVER_INGOTS).add(ModItems.SILVER_INGOT.get());
        this.tag(ModTags.Items.RAW_SILVER).add(ModItems.RAW_SILVER.get());
        this.tag(ModTags.Items.SILVER_NUGGETS).add(ModItems.SILVER_NUGGET.get());

        this.tag(ModTags.Items.INGOTS).addTag(ModTags.Items.SILVER_INGOTS);
        this.tag(ModTags.Items.RAW_MATERIALS).addTag(ModTags.Items.RAW_SILVER);
        this.tag(ModTags.Items.NUGGETS).addTag(ModTags.Items.SILVER_NUGGETS);
    }
}
