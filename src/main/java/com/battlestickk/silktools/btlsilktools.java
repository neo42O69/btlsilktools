package com.battlestickk.silktools;

import com.battlestickk.silktools.item.moditems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class btlsilktools implements ModInitializer
{
    public static final String MOD_ID = "btlsilktools"; //tells mod id yeah
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID); //makes logger output stuff in the name of the mod i guess?

    @Override
    public void onInitialize()
    {
        moditems.registerModItems();
    }//registers items (see moditems)
}
