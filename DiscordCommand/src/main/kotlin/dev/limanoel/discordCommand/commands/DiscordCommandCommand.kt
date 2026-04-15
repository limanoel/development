package dev.limanoel.discordCommand.commands

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.awt.Component


    class DiscordCommandCommand : CommandExecutor {
        override fun onCommand(
            sender: CommandSender,
            command: Command,
            label: String,
            args: Array<String>
        ): Boolean {


            if (!sender.hasPermission("discordcommand.discord")) {

                sender.sendMessage(
                    net.kyori.adventure.text.Component.text("You dont have the Permission to perform this Command!")
                        .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
                )

            } else {

                sender.sendMessage(
                    net.kyori.adventure.text.Component.text()
                        .append(
                            net.kyori.adventure.text.Component.text("\n"))
                        .append(
                            net.kyori.adventure.text.Component.text("\n"))
                        .append(
                            net.kyori.adventure.text.Component.text("\n"))
                        .append(
                            net.kyori.adventure.text.Component.text("-----------------------------------------------\n"))

                        .append(
                            net.kyori.adventure.text.Component.text("\n"))

                        .append(
                            net.kyori.adventure.text.Component.text("Joine jetzt dem Discord!\n")
                                .color(net.kyori.adventure.text.format.NamedTextColor.BLUE)
                                .decorate(net.kyori.adventure.text.format.TextDecoration.BOLD)
                        )
                        .append(
                            net.kyori.adventure.text.Component.text("Klicke hier\n")
                                .color(net.kyori.adventure.text.format.NamedTextColor.AQUA)
                                .decorate(net.kyori.adventure.text.format.TextDecoration.UNDERLINED)
                                .clickEvent(
                                    net.kyori.adventure.text.event.ClickEvent.openUrl("XXXXXXXXXXXXXXXXXXXXXXXXXXX")
                                )

                                .append(
                                    net.kyori.adventure.text.Component.text("\n"))
                        )
                        .append(
                            net.kyori.adventure.text.Component.text("-----------------------------------------------\n")
                                .append(
                                    net.kyori.adventure.text.Component.text("\n")

                                )
                        )
                )


            }


            return false
        }
    }
