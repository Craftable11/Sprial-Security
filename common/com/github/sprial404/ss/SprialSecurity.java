package com.github.sprial404.ss;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;

import com.github.sprial404.ss.block.ModBlocks;
import com.github.sprial404.ss.command.CommandHandler;
import com.github.sprial404.ss.configuration.ConfigurationHandler;
import com.github.sprial404.ss.core.handlers.VersionCheckTickHandler;
import com.github.sprial404.ss.core.proxy.CommonProxy;
import com.github.sprial404.ss.core.util.LogHelper;
import com.github.sprial404.ss.core.util.VersionHelper;
import com.github.sprial404.ss.creativetab.CreativeTabSS;
import com.github.sprial404.ss.item.ModItems;
import com.github.sprial404.ss.lib.Reference;
import com.github.sprial404.ss.lib.Strings;
import com.github.sprial404.ss.network.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * Sprial-Security
 * 
 * SprialSecurity
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, certificateFingerprint = Reference.FINGERPRINT)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class SprialSecurity {

    @Instance(Reference.MOD_ID)
    public static SprialSecurity instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs tabsSS = new CreativeTabSS(
            CreativeTabs.getNextID(), Reference.MOD_ID);

    @EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event) {
     // Report (log) to the user that the version of Equivalent Exchange 3
        // they are using has been changed/tampered with
        if (Reference.FINGERPRINT.equals("@FINGERPRINT@")) {
            LogHelper.warning(Strings.NO_FINGERPRINT_MESSAGE);
        }
        else {
            LogHelper.severe(Strings.INVALID_FINGERPRINT_MESSAGE);
        }
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        // Initialize the custom commands
        CommandHandler.initCommands(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Initialize the log helper
        LogHelper.init();

        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory()
                .getAbsolutePath()
                + File.separator
                + Reference.CHANNEL_NAME
                + File.separator + Reference.MOD_ID + ".cfg"));

        // Conduct the version check and log the result
        VersionHelper.execute();

        // Initialize the Version Check Tick Handler (Client only)
        TickRegistry.registerTickHandler(new VersionCheckTickHandler(),
                Side.CLIENT);

        // Initialize the Player Movement Tick Handler (Client only)
        // TickRegistry.registerTickHandler(new PlayerMovementTickHandler(),
        // Side.CLIENT);

        // Register the Trackers (Server and Client)
        proxy.registerTrackers();

        // Initialize the Render Tick Handler (Client only)
        proxy.registerRenderTickHandler();

        // Register the KeyBinding Handler (Client only)
        // proxy.registerKeyBindingHandler();

        // Register the Sound Handler (Client only)
        proxy.registerSoundHandler();

        // Initalize mod blocks
        ModBlocks.init();

        // Initialize mod items
        ModItems.init();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        // Register the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);

        // Initialize mod tile entities
        proxy.registerTileEntities();

        // Initialize custom rendering and pre-load textures (Client only)
        proxy.initRenderingAndTextures();
    }

    @EventHandler
    public void modsLoaded(FMLPostInitializationEvent event) {

    }
}
