package com.civlegacy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

    public static String usr;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            usr = player.getUniqueId().toString();
        }
        sender.sendMessage("Command Ran! Check Database for confirmation!");
        return true;
    }
}
