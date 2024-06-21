package net.kaupenjoe.mccourse.item;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BLACK_OPAL_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_items_tab"))
                    .icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLACK_OPAL);
                        pOutput.accept(ModItems.RAW_BLACK_OPAL);

                    }).build());

    public static final Supplier<CreativeModeTab> BLACK_OPAL_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("black_opal_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.black_opal_blocks_tab"))
                    .icon(() -> new ItemStack(ModItems.RAW_BLACK_OPAL.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "black_opal_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Blocks.ANDESITE);
                        pOutput.accept(Blocks.DEEPSLATE_DIAMOND_ORE);

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
