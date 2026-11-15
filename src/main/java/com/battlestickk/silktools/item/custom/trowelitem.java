package com.battlestickk.silktools.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class trowelitem extends Item
{

    public trowelitem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) //this code runs when you interact with a block with the trowel
    {
        // variables for simplicity
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        Block clickedBlock = level.getBlockState(pos).getBlock();

        if(clickedBlock == Blocks.DIRT_PATH && context.getClickedFace() == Direction.UP) // runs this if you clicked the upper part of a dirt path
        {
            if (player instanceof ServerPlayer)//runs this if you are serverside
            {
                level.setBlockAndUpdate(context.getClickedPos(), Blocks.DIRT.defaultBlockState());//changes the dirt path to dirt
                context.getItemInHand().hurtAndBreak(1, context.getPlayer(), context.getHand()); //damages the trowel once
                level.playSound(null, pos, (SoundEvent) SoundEvents.SHOVEL_FLATTEN.value(), SoundSource.BLOCKS); //plays sound
            }
            return InteractionResult.SUCCESS; //plays success animation (if you put it in the serverside check the animation won't play)
        }
        else
        {
            return InteractionResult.PASS;//if you didn't click the top of a dirt path it plays no animation
        }
    }
}
