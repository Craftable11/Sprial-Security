package com.github.sprial404.ss.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

import com.github.sprial404.ss.lib.Commands;

/**
 * Sprial-Security
 * 
 * CommandSS
 * 
 * @author Sprial404
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CommandSS extends CommandBase {

    @Override
    public String getCommandName() {
        return Commands.COMMAND_SS;
    }
    
    @Override
    public boolean canCommandSenderUseCommand(ICommandSender commandSender) {
        return true;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List addTabCompletionOptions(ICommandSender commandSender,
            String[] args) {
        switch (args.length) {
            case 1: {
                return getListOfStringsMatchingLastWord(args, new String[] { Commands.COMMAND_PARTICLES, Commands.COMMAND_SOUNDS, Commands.COMMAND_VERSION });
            }
            case 2: {
                if (args[0].equalsIgnoreCase(Commands.COMMAND_PARTICLES))
                    return getListOfStringsMatchingLastWord(args, new String[] { Commands.ON, Commands.OFF });
                else if (args[0].equalsIgnoreCase(Commands.COMMAND_SOUNDS))
                    return getListOfStringsMatchingLastWord(args, new String[] { Commands.ALL, Commands.COMMAND_SELF, Commands.COMMAND_OFF });
                else if (args[0].equalsIgnoreCase(Commands.COMMAND_VERSION))
                    return getListOfStringsMatchingLastWord(args, new String[] { Commands.COMMAND_CHANGELOG });
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public void processCommand(ICommandSender commandSender, String[] args) {
        if (args.length > 0) {
            String commandName = args[0];
            System.arraycopy(args, 1, args, 0, args.length - 1);
            
            if (commandName.equalsIgnoreCase(Commands.COMMAND_PARTICLES))
                CommandParticles.processCommand(commandSender, args);
            else if (commandName.equalsIgnoreCase(Commands.COMMAND_SOUNDS))
                CommandSounds.processCommand(commandSender, args);
            else if (commandName.equalsIgnoreCase(Commands.COMMAND_VERSION))
                CommandVersion.processCommand(commandSender, args);
            else
                throw new WrongUsageException(Commands.COMMAND_SS_USAGE, new Object[0]);
        }
        else
            throw new WrongUsageException(Commands.COMMAND_SS_USAGE, new Object[0]);
    }

}
