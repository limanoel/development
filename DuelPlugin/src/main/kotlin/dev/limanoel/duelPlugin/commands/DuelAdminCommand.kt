package dev.limanoel.duelPlugin.commands

import org.bukkit.command.*
import org.bukkit.entity.Player

class DuelAdminCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) return true
        if (!sender.hasPermission("duel.admin")) return true

        if (args.isEmpty()) return true

        when (args[0].lowercase()) {

            "setspawn1" -> {
                sender.world.spawnLocation = sender.location
                sender.sendMessage("§aSpawn1 gesetzt")
            }

            "setspawn2" -> {
                sender.world.spawnLocation = sender.location
                sender.sendMessage("§aSpawn2 gesetzt")
            }
        }

        return true
    }
}