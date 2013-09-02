package com.github.sprial404.ss.command;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Sprial-Security
 * 
 * CommandHandler
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CommandHandler {

    public static void initCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandSS());
    }
}
