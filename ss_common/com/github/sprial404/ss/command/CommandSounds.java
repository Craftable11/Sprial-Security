package com.github.sprial404.ss.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatMessageComponent;

import com.github.sprial404.ss.configuration.ConfigurationHandler;
import com.github.sprial404.ss.configuration.ConfigurationSettings;
import com.github.sprial404.ss.lib.Commands;

/**
 * Sprial-Security
 * 
 * CommandSounds
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CommandSounds {

    public static void processCommand(ICommandSender commandSender, String[] args) {

        String subCommand;

        if (args.length > 0) {
            subCommand = args[0];

            if (subCommand.toLowerCase().equals(Commands.COMMAND_ALL)) {
                processAllCommand(commandSender);
            }
            else if (subCommand.toLowerCase().equals(Commands.COMMAND_SELF)) {
                processSelfCommand(commandSender);
            }
            else if (subCommand.toLowerCase().equals(Commands.COMMAND_OFF)) {
                processOffCommand(commandSender);
            }
            else
                throw new WrongUsageException(Commands.COMMAND_SOUNDS_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Commands.COMMAND_SOUNDS_USAGE, new Object[0]);
    }

    private static void processAllCommand(ICommandSender commandSender) {

        ConfigurationSettings.ENABLE_SOUNDS = Commands.ALL;
        ConfigurationHandler.set(ConfigurationHandler.CATEGORY_AUDIO, ConfigurationSettings.ENABLE_SOUNDS_CONFIGNAME, Commands.ALL);
        commandSender.sendChatToPlayer(ChatMessageComponent.func_111077_e(Commands.COMMAND_SOUNDS_SET_TO_ALL));
    }

    private static void processSelfCommand(ICommandSender commandSender) {

        ConfigurationSettings.ENABLE_SOUNDS = Commands.SELF;
        ConfigurationHandler.set(ConfigurationHandler.CATEGORY_AUDIO, ConfigurationSettings.ENABLE_SOUNDS_CONFIGNAME, Commands.SELF);
        commandSender.sendChatToPlayer(ChatMessageComponent.func_111077_e(Commands.COMMAND_SOUNDS_SET_TO_SELF));
    }

    private static void processOffCommand(ICommandSender commandSender) {

        ConfigurationSettings.ENABLE_SOUNDS = Commands.OFF;
        ConfigurationHandler.set(ConfigurationHandler.CATEGORY_AUDIO, ConfigurationSettings.ENABLE_SOUNDS_CONFIGNAME, Commands.OFF);
        commandSender.sendChatToPlayer(ChatMessageComponent.func_111077_e(Commands.COMMAND_SOUNDS_TURNED_OFF));
    }
}
