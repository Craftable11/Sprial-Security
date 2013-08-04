package com.github.sprial404.ss.network.packet;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;

import com.github.sprial404.ss.network.PacketTypeHandler;

import cpw.mods.fml.common.network.Player;

/**
 * Sprial-Security
 * 
 * PacketSS
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PacketSS {

    public PacketTypeHandler packetType;
    public boolean isChunkDataPacket;

    public PacketSS(PacketTypeHandler packetType, boolean isChunkDataPacket) {
        this.packetType = packetType;
        this.isChunkDataPacket = isChunkDataPacket;
    }

    public byte[] populate() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        try {
            dos.writeByte(packetType.ordinal());
            this.writeData(dos);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        return bos.toByteArray();
    }

    public void readPopulate(DataInputStream data) {
        try {
            this.readData(data);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public void readData(DataInputStream data) throws IOException {

    }

    public void writeData(DataOutputStream dos) throws IOException {

    }

    public void execute(INetworkManager network, Player player) {

    }

    public void setKey(int key) {

    }
}
