package com.superworldsun.superslegend.registries;

import com.superworldsun.superslegend.SupersLegendMain;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SupersLegendMain.MOD_ID);

    public static final RegistryObject<Block> RUPEE_BLOCK = registerBlock("rupee_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BLUE_RUPEE_BLOCK = registerBlock("blue_rupee_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> RED_RUPEE_BLOCK = registerBlock("red_rupee_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SILVER_RUPEE_BLOCK = registerBlock("silver_rupee_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> GOLD_RUPEE_BLOCK = registerBlock("gold_rupee_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    /*public static final RegistryObject<Block> SPIKES_BLOCK = registerBlock("spikes_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> GOSSIP_STONE_BLOCK = registerBlock("gossip_stone_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> GOSSIP_STONE_TOP = registerBlock("gossip_stone_top",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> DUNGEON_DOOR = registerBlock("dungeon_door",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> LOCKED_DUNGEON_DOOR = registerBlock("locked_dungeon_door",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BOSS_DOOR = registerBlock("boss_door",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> LOCKED_BOSS_DOOR = registerBlock("locked_boss_door",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> LOCKED_WOODEN_DOOR = registerBlock("locked_wooden_door",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> WOODEN_BOSS_DOOR = registerBlock("wooden_boss_door",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BUSH_BLOCK = registerBlock("bush_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> CHAIN_LINK_FENCE_BLOCK = registerBlock("chain_link_fence_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> GRAPPLE_BLOCK = registerBlock("grapple_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> DEKU_FLOWER_BLOCK = registerBlock("deku_flower_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> YELLOW_DEKU_FLOWER_BLOCK = registerBlock("yellow_deku_flower_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> POT_BLOCK = registerBlock("pot_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> JAR_BLOCK = registerBlock("jar_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> POSTBOX_BLOCK = registerBlock("postbox_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> POSTBOX_TOP = registerBlock("postbox_top",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> GRATE_BLOCK = registerBlock("grate_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> CRATE_BLOCK = registerBlock("crate_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUSH_STONE = registerBlock("push_stone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SILVER_PUSH_STONE = registerBlock("silver_push_stone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BLACK_PUSH_STONE = registerBlock("black_push_stone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> GRASS_PATCH_BLOCK = registerBlock("grass_patch_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ODD_MUSHROOM = registerBlock("odd_mushroom",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> MAGIC_MUSHROOM = registerBlock("magic_mushroom",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TORCH_TOWER = registerBlock("torch_tower",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TORCH_TOWER_TOP_UNLIT = registerBlock("torch_tower_top_unlit",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TORCH_TOWER_TOP_LIT = registerBlock("torch_tower_top_lit",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));*/

    public static final RegistryObject<Block> MASTER_ORE_BLOCK = registerBlock("master_ore_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_MASTER_ORE_BLOCK = registerBlock("deepslate_master_ore_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    /*public static final RegistryObject<Block> CRACKED_BOMB_WALL = registerBlock("cracked_bomb_wall",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BLUE_FLOOR_SWITCH = registerBlock("blue_floor_switch",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> YELLOW_FLOOR_SWITCH = registerBlock("yellow_floor_switch",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> RED_FLOOR_SWITCH = registerBlock("red_floor_switch",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> RUSTED_FLOOR_SWITCH = registerBlock("rusted_floor_switch",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> OAK_PEG_BLOCK = registerBlock("oak_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SPRUCE_PEG_BLOCK = registerBlock("spruce_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BIRCH_PEG_BLOCK = registerBlock("birch_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> JUNGLE_PEG_BLOCK = registerBlock("jungle_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ACACIA_PEG_BLOCK = registerBlock("acacia_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> DARK_OAK_PEG_BLOCK = registerBlock("dark_oak_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> RUSTED_PEG_BLOCK = registerBlock("rusted_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SPIKED_PEG_BLOCK = registerBlock("spiked_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_OAK = registerBlock("hammered_wooden_peg_oak",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_SPRUCE = registerBlock("hammered_wooden_peg_spruce",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_BIRCH = registerBlock("hammered_wooden_peg_birch",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_JUNGLE = registerBlock("hammered_wooden_peg_jungle",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_ACACIA = registerBlock("hammered_wooden_peg_acacia",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HAMMERED_WOODEN_PEG_DARK_OAK = registerBlock("hammered_wooden_peg_dark_oak",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HAMMERED_RUSTED_PEG_BLOCK = registerBlock("hammered_rusted_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HAMMERED_SPIKED_PEG_BLOCK = registerBlock("hammered_spiked_peg_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> SHADOW_BLOCK = registerBlock("shadow_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> FALSE_SHADOW_BLOCK = registerBlock("false_shadow_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> HIDDEN_SHADOW_BLOCK = registerBlock("hidden_shadow_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SHADOW_MODEL_BLOCK = registerBlock("shadow_model_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TOMBSTONE_BLOCK = registerBlock("tombstone_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> STONE_PATH_BLOCK = registerBlock("stone_path_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> STONE_TILE_BLOCK = registerBlock("stone_tile_block",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> DINS_FLAME = registerBlock("dins_flame",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> FARORES_FLAME = registerBlock("farores_flame",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> NAYRUS_FLAME = registerBlock("nayrus_flame",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> DINS_SACRED_PEDESTAL = registerBlock("dins_sacred_pedestal",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> FARORES_SACRED_PEDESTAL = registerBlock("farores_sacred_pedestal",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> NAYRUS_SACRED_PEDESTAL = registerBlock("nayrus_sacred_pedestal",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> FAN = registerBlock("fan",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SWITCHABLE_FAN = registerBlock("switchable_fan",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> LIGHT_EMITTER = registerBlock("light_emitter",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> LIGHT_PRISM = registerBlock("light_prism",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> ROYAL_TILE = registerBlock("royal_tile",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> BLOCK_OF_TIME = registerBlock("block_of_time",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> OWL_STATUE = registerBlock("owl_statue",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> SUN_SWITCH = registerBlock("sun_switch",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> WARP_PAD = registerBlock("warp_pad",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> WARP_PAD_LIGHT = registerBlock("warp_pad_light",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> WARP_PAD_FOREST = registerBlock("warp_pad_forest",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> WARP_PAD_FIRE = registerBlock("warp_pad_fire",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> WARP_PAD_WATER = registerBlock("warp_pad_water",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> WARP_PAD_SPIRIT = registerBlock("warp_pad_spirit",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> WARP_PAD_SHADOW = registerBlock("warp_pad_shadow",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().destroyTime(2).explosionResistance(2).sound(SoundType.GLASS)));*/


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
