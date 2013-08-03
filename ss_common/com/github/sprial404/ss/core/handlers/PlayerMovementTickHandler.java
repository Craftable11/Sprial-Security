package com.github.sprial404.ss.core.handlers;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;

import com.github.sprial404.ss.core.util.LogHelper;
import com.github.sprial404.ss.lib.Reference;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerMovementTickHandler implements ITickHandler {

    
    
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) { }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        for (TickType tickType : type)
            if (tickType == TickType.PLAYER) {
                EntityPlayer player = null;
                
                if (!(tickData[0] instanceof EntityPlayer))
                    return;
                player = (EntityPlayer) tickData[0];
                
                LogHelper.debug(String.format("%s is at %s, %s, %s in Dimension: %s.", player.username, player.posX, player.posY, player.posZ, player.dimension));
            }

    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.PLAYER);
    }

    @Override
    public String getLabel() {
        return Reference.MOD_NAME + ": " + this.getClass().getSimpleName();
    }

}
