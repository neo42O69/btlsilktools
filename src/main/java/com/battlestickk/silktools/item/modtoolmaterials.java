package com.battlestickk.silktools.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public class modtoolmaterials
{
    public static final ToolMaterial IRON_SILK = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            125, 6f, 0f, 14, ItemTags.IRON_TOOL_MATERIALS);
    /*
    registers the iron_silk tool material with the same stats as iron but with half durability and
    netherite harvestability(for example obsidian will drop when mined by this unlike with the iron pickaxe)
    also it has no attack damage unlike iron tools because fuck you haha
    Who even uses tools beside sword and axe for fighting
     */
    public static final ToolMaterial IRON_SIEVE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL,
            64, 1f, 0f, 14, ItemTags.IRON_TOOL_MATERIALS);
}