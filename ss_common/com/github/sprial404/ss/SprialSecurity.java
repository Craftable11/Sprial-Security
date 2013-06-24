package com.github.sprial404.ss;

import net.minecraft.creativetab.CreativeTabs;

import com.github.sprial404.ss.creativetab.CreativeTabSS;
import com.github.sprial404.ss.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.FingerprintWarning;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name= Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, certificateFingerprint = Reference.FINGERPRINT)
// @NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false)
public class SprialSecurity {

    @Instance(Reference.MOD_ID)
    public static SprialSecurity instance;
    
    public static CreativeTabs tabsSS = new CreativeTabSS(CreativeTabs.getNextID(), Reference.MOD_ID);
    
    @FingerprintWarning
    public void invalidFingerprint(FMLFingerprintViolationEvent event) {
        
    }
    
    @ServerStarting
    public void serverStarting(FMLServerStartingEvent event) {
        
    }
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
        
    }
    
    @PostInit
    public void modsLoaded(FMLPostInitializationEvent event) {
        
    }
}
