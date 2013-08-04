package com.github.sprial404.ss.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.github.sprial404.ss.network.packet.PacketSS;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * Sprial-Security
 * 
 * PacketHandler
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PacketHandler implements IPacketHandler {

    /***
     * Handles Packet250CustomPayload packets that are registered to an Sprial
     * Security network channel
     * 
     * @param manager
     *            The NetworkManager associated with the current platform
     *            (client/server)
     * @param packet
     *            The Packet250CustomPayload that was received
     * @param player
     *            The Player associated with the packet
     */
    @Override
    public void onPacketData(INetworkManager manager,
            Packet250CustomPayload packet, Player player) {
        // Build a PacketSS object from the data contained within the
        // Packet250CustomPayload packet
        PacketSS packetSS = PacketTypeHandler.buildPacket(packet.data);

        // Execute the appropriate actions based on the PacketSS type
        packetSS.execute(manager, player);
    }

}
