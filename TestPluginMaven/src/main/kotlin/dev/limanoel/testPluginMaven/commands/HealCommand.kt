package dev.limanoel.testPluginMaven.commands

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class HealCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<String>
    ): Boolean {

        if (!sender.hasPermission("testplugin.heal")) {

            sender.sendMessage(
                net.kyori.adventure.text.Component.text("You dont have the Permission to perform this Command!")
                    .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
            )

        }

        if (sender !is Player) {
            sender.sendPlainMessage("Nur Spieler können das ausführen")
            return false
        }

        sender.health = 20.0
        sender.sendMessage(
            net.kyori.adventure.text.Component.text("Deine Leben wurden aufgefüllt").color(NamedTextColor.GREEN)
                .decorate(TextDecoration.BOLD)
        )
        return false

    }
}


