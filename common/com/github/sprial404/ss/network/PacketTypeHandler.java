package com.github.sprial404.ss.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.github.sprial404.ss.lib.Reference;
import com.github.sprial404.ss.network.packet.PacketItemUpdate;
import com.github.sprial404.ss.network.packet.PacketKeyPressed;
import com.github.sprial404.ss.network.packet.PacketRequestEvent;
import com.github.sprial404.ss.network.packet.PacketSS;
import com.github.sprial404.ss.network.packet.PacketSoundEvent;
import com.github.sprial404.ss.network.packet.PacketSpawnParticle;
import com.github.sprial404.ss.network.packet.PacketTileUpdate;
import com.github.sprial404.ss.network.packet.PacketTileWithItemUpdate;

/**
 * Sprial-Security
 * 
 * PacketTypeHandler
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum PacketTypeHandler {

    KEY(PacketKeyPressed.class), TILE(PacketTileUpdate.class), REQUEST_EVENT(
            PacketRequestEvent.class), SPAWN_PARTICLE(PacketSpawnParticle.class), SOUND_EVENT(
            PacketSoundEvent.class), ITEM_UPDATE(PacketItemUpdate.class), TILE_WITH_ITEM(
            PacketTileWithItemUpdate.class);

    private Class<? extends PacketSS> clazz;

    private PacketTypeHandler(Class<? extends PacketSS> clazz) {
        this.clazz = clazz;
    }

    public static PacketSS buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        PacketSS packet = null;

        try {
            packet = values()[selector].clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static PacketSS buildPacket(PacketTypeHandler type) {

        PacketSS packet = null;

        try {
            packet = values()[type.ordinal()].clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(PacketSS packetEE) {

        byte[] data = packetEE.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = Reference.CHANNEL_NAME;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = packetEE.isChunkDataPacket;

        return packet250;
    }
}
