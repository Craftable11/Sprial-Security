package com.github.sprial404.ss.core.proxy;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;

import com.github.sprial404.ss.client.audio.SoundHandler;
import com.github.sprial404.ss.core.handlers.KeyBindingHandler;
import com.github.sprial404.ss.core.util.KeyBindingUtil;
import com.github.sprial404.ss.network.PacketTypeHandler;
import com.github.sprial404.ss.network.packet.PacketRequestEvent;
import com.github.sprial404.ss.tileentiy.TileSS;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.network.PacketDispatcher;

/**
 * Sprial-Security
 * 
 * ClientProxy
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerKeyBindingHandler() {
        KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
    }

    @Override
    public void registerRenderTickHandler() {
        
    }

    @Override
    public void registerDrawBlockHighlightHandler() {
        
    }

    @Override
    public void setKeyBinding(String name, int value) {

        KeyBindingUtil.addKeyBinding(name, value);
        KeyBindingUtil.addIsRepeating(false);
    }

    @Override
    public void registerSoundHandler() {

        MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }

    @Override
    public void initRenderingAndTextures() {
        
    }

    @Override
    public void registerTileEntities() {
        super.registerTileEntities();
    }

    @Override
    public void sendRequestEventPacket(byte eventType, int originX, int originY, int originZ, byte sideHit, byte rangeX, byte rangeY, byte rangeZ, String data) {
        PacketDispatcher.sendPacketToServer(PacketTypeHandler.populatePacket(new PacketRequestEvent(eventType, originX, originY, originZ, sideHit, rangeX, rangeY, rangeZ, data)));
    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

        if (tileEntity != null) {
            if (tileEntity instanceof TileSS) {
                ((TileSS) tileEntity).setOrientation(orientation);
                ((TileSS) tileEntity).setState(state);
                ((TileSS) tileEntity).setCustomName(customName);
            }
        }
    }

    @Override
    public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData, int stackSize, int color) {

        World world = FMLClientHandler.instance().getClient().theWorld;
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        this.handleTileEntityPacket(x, y, z, orientation, state, customName);

        if (tileEntity != null) {
            
        }
    }
}
