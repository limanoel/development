package dev.limanoel.testPluginMaven.commands

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class KickCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<String>
    ): Boolean {


        if (!sender.hasPermission("testplugin.kick")) {

            sender.sendMessage(
                net.kyori.adventure.text.Component.text("You dont have the Permission to perform this Command!")
                    .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
            )

        }

        if(args.size != 1) {

            sender.sendMessage(
                net.kyori.adventure.text.Component.text("Invalid Ussage! Use /kick <player>")
                    .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)


            )

            return false
        }

            val player = Bukkit.getPlayer(args[0])
            if (player == null) {

                sender.sendMessage(
                    net.kyori.adventure.text.Component.text("The Specified Player is not Online!")
                        .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
                )

                return false
            }


            player.kick()

            sender.sendMessage(
            net.kyori.adventure.text.Component.text("You kicked ${player.name}!")
                .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
             )


            return false
        }




    }
