package com.github.sprial404.ss.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.github.sprial404.ss.core.trackers.PlayerTracker;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Sprial-Security
 * 
 * CommonProxy
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CommonProxy implements IGuiHandler {

    public void registerTrackers() {
        GameRegistry.registerPlayerTracker(new PlayerTracker());
    }

    public void registerKeyBindingHandler() {

    }

    public void registerRenderTickHandler() {

    }

    public void registerDrawBlockHighlightHandler() {

    }

    public void setKeyBinding(String name, int value) {

    }

    public void registerSoundHandler() {

    }

    public void initRenderingAndTextures() {

    }

    public void registerTileEntities() {
        // Register Server Tile Entities Here
    }

    public void sendRequestEventPacket(byte eventType, int originX,
            int originY, int originZ, byte sideHit, byte rangeX, byte rangeY,
            byte rangeZ, String data) {

    }

    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName) {

    }

    public void handleTileWithItemPacket(int x, int y, int z,
            ForgeDirection orientation, byte state, String customName,
            int itemID, int metaData, int stackSize, int color) {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        return null;
    }
}
