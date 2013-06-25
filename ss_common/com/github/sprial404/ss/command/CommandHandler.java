package com.github.sprial404.ss.command;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandHandler {

    public static void initCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandSS());
    }
}
