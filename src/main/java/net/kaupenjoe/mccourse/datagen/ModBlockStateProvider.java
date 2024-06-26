package net.kaupenjoe.mccourse.datagen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);
        blockWithItem(ModBlocks.RAW_BLACK_OPAL_BLOCK);

        blockWithItem(ModBlocks.BLACK_OPAL_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE );
        blockWithItem(ModBlocks.BLACK_OPAL_END_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.BLACK_OPAL_STAIRS.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.BLACK_OPAL_SLAB.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));


        blockItem(ModBlocks.BLACK_OPAL_STAIRS);
        blockItem(ModBlocks.BLACK_OPAL_SLAB);
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + deferredBlock.getId().getPath()));
    }
}
