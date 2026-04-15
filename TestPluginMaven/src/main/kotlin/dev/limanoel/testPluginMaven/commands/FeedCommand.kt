package dev.limanoel.testPluginMaven.commands

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class FeedCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<String>
    ): Boolean {


        if (!sender.hasPermission("testplugin.feed")) {

            sender.sendMessage(
                net.kyori.adventure.text.Component.text("You dont have the Permission to perform this Command!")
                    .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
            )

        }

        if(args.size != 2) {



            sender.sendMessage(
                net.kyori.adventure.text.Component.text("Invalid Ussage! Use /feed <player> <amount>")
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

        val amount = args[1].toIntOrNull()
        if (amount == null) {

            sender.sendMessage(
                net.kyori.adventure.text.Component.text("The Specified Number is not a Number!")
                    .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
            )

            return false
        }

        if(player == sender){

            player.foodLevel = (amount + player.foodLevel).coerceIn(0, 20)

            sender.sendMessage(
                net.kyori.adventure.text.Component.text("You got feeded by ${sender.name}!")
                    .color(NamedTextColor.GREEN).decorate(TextDecoration.BOLD)
            )

            return false

        } else {

            player.foodLevel = (amount + player.foodLevel).coerceIn(0, 20)

            sender.sendMessage(
                net.kyori.adventure.text.Component.text("You feeded ${player.name}!")
                    .color(NamedTextColor.GREEN).decorate(TextDecoration.BOLD)
            )

            player.sendMessage(
                net.kyori.adventure.text.Component.text("You got feeded by ${sender.name}!")
                    .color(NamedTextColor.GREEN).decorate(TextDecoration.BOLD)
            )
                return  false
        }




        return false
    }





}
