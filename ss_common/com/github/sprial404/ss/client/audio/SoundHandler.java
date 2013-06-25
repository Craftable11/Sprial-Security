package com.github.sprial404.ss.client.audio;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

import com.github.sprial404.ss.core.util.LogHelper;
import com.github.sprial404.ss.lib.Sounds;

public class SoundHandler {

    @ForgeSubscribe
    public void onSoundLoad(SoundLoadEvent event) {
        // For each custom sound file we have defined in Sounds
        for (String soundFile : Sounds.soundFiles) {
            // Try to add the custom sound file to pool of sounds
            try {
                event.manager.soundPoolSounds.addSound(soundFile, this.getClass().getResource("/" + soundFile));
            } catch (Exception e) {
                LogHelper.warning("Failed loading sound file: " + soundFile);
            }
        }
    }
}
