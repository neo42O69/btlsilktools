package com.battlestickk.silktools.item;

import com.battlestickk.silktools.btlsilktools;
import com.battlestickk.silktools.item.custom.trowelitem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class moditems {

    public static final Item CHISEL = registerItem("chisel",
            properties -> new Item(properties.pickaxe(modtoolmaterials.IRON_SILK, 0, 0)));//registers the chisel with the iron_silk(see modtoolmaterials) material, 0 damage and 0 attack speed (same as bare hands)
    public static final Item SIEVE = registerItem("sieve",
            properties -> new Item(properties.tool(modtoolmaterials.IRON_SIEVE, BlockTags.MINEABLE_WITH_SHOVEL, 0, 0, 0)));//registers the sieve that has the properties of bare hands with durability (with a datapack i'll make it get flint easily). it's not a shovel for the same reason why the trowel isn't
    public static final Item TROWEL = registerItem("trowel", properties -> new trowelitem(properties.tool(modtoolmaterials.IRON_SILK, BlockTags.MINEABLE_WITH_SHOVEL, 0, 0, 0))); //registers a custom trowel item (trowel items turn paths into dirt) that can mine dirts like a shovel. has iron_silk material

    private static Item registerItem(String name, Function<Item.Properties, Item> function)
    {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(btlsilktools.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(btlsilktools.MOD_ID, name))))); //registers the items
    }

    public static void registerModItems()
    {
        btlsilktools.LOGGER.info("Registering items for BTL Silk Tools");

        //puts the items in creative tabs
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register
        (
                output ->
                {
                    //everything here goes to the vanilla tools & utilities creative tab
                    output.insertAfter(Items.BRUSH, CHISEL); // the chisel is inserted after (to the right of) the vanilla brush
                    output.insertAfter(CHISEL, TROWEL); // the trowel is inserted after the chisel
                    output.insertAfter(TROWEL, SIEVE); // the sieve is inserted after the trowel
                }
        );
    }
}
