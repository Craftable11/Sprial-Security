package com.github.sprial404.ss.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatMessageComponent;

import com.github.sprial404.ss.core.util.VersionHelper;
import com.github.sprial404.ss.lib.Commands;

/**
 * Sprial-Security
 * 
 * CommandVersion
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CommandVersion {

    public static void processCommand(ICommandSender commandSender, String[] args) {

        String subCommand;

        if (args.length > 0) {
            subCommand = args[0];

            if (subCommand.toLowerCase().equals(Commands.COMMAND_VERSION)) {
                processVersionCommand(commandSender);
            }
            else if (subCommand.toLowerCase().equals(Commands.COMMAND_CHANGELOG)) {
                processChangelogCommand(commandSender);
            }
            else
                throw new WrongUsageException(Commands.COMMAND_VERSION_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Commands.COMMAND_VERSION_USAGE, new Object[0]);
    }

    private static void processVersionCommand(ICommandSender commandSender) {

        commandSender.sendChatToPlayer(ChatMessageComponent.func_111077_e(VersionHelper.getResultMessage()));
    }

    private static void processChangelogCommand(ICommandSender commandSender) {

    }
}
