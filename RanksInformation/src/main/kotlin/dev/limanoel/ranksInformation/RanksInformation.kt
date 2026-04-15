package dev.limanoel.ranksInformation


import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.plugin.java.JavaPlugin

class RanksInformation : JavaPlugin() {

    override fun onEnable() {


        logger.info("")
        logger.info("")
        logger.info("")
        logger.info("-----------------------------------------------------------")
        logger.info("")
        server.consoleSender.sendMessage(
            net.kyori.adventure.text.Component.text("                         - Ranks Information Plugin erfolgreich gestartet! - ")
                .color(net.kyori.adventure.text.format.NamedTextColor.DARK_PURPLE).decorate(TextDecoration.BOLD)
        )
        logger.info("")
        logger.info("-----------------------------------------------------------")
        logger.info("")
        logger.info("")
        logger.info("")


        getCommand("bewerben")?.setExecutor { sender: CommandSender, _, _, _ ->

            if (sender !is Player) {
                sender.sendMessage("§l§4Dieser Command kann nur von Spielern ausgeführt werden!")
                return@setExecutor true
            }

            if (!sender.hasPermission("ranksinformation.bewerben")) {

                sender.sendMessage(
                    net.kyori.adventure.text.Component.text("You dont have the Permission to perform this Command!")
                        .color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD)
                )

                return@setExecutor false

            }

            val player = sender

            val book = ItemStack(Material.WRITTEN_BOOK)
            val meta = book.itemMeta as BookMeta

            meta.title(Component.text("Mein Buch").color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD))
            meta.author(Component.text("BlockverseMC.net").decorate(TextDecoration.BOLD).color(NamedTextColor.DARK_BLUE))


            val page2 = Component.text()
                .append(
                    Component.text("Supporter:\n")
                        .color(NamedTextColor.AQUA)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 13 Jahre alt\n")
                )
                .append(
                    Component.text("• Du kannst halb gut Deutsch sprechen, sowie Schreiben\n")
                )
                .append(
                    Component.text("• Du bist Freundlich\n")
                )
                .append(
                    Component.text("• Du bist in keinem anderen Team Vertreten\n")
                )
                .build()


            val page3 = Component.text()
                .append(
                    Component.text("Moderator:\n")
                        .color(NamedTextColor.GOLD)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 16 Jahre alt\n")
                )
                .append(
                    Component.text("• Du kannst sehr gut Deutsch sprechen, sowie Schreiben\n")
                )
                .append(
                    Component.text("• Du bist Freundlichn\n")
                )
                .append(
                    Component.text("• Du bist Teamfähig\n")
                )
                .append(
                    Component.text("• Du nutzt deine Rechte nicht aus!\n")
                )
                .append(
                    Component.text("• Du bist in keinem anderen Team Vertreten\n")
                )
                .build()

            val page4 = Component.text()
                .append(
                    Component.text("Builder:\n")
                        .color(NamedTextColor.DARK_BLUE)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 13 Jahre alt\n")
                )
                .append(
                    Component.text("• Du kennst dich mit Worldedit/Minecraft Befehlen\n")
                )
                .append(
                    Component.text("• Du bist Zuverlässig\n")
                )
                .append(
                    Component.text("• Du bist in keinem anderen Team Vertreten\n")
                )
                .build()

            val page5 = Component.text()
                .append(
                    Component.text("Developer:\n")
                        .color(NamedTextColor.DARK_AQUA)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 17 Jahre alt\n")
                )
                .append(
                    Component.text("• Du bist Freundlich\n")
                )
                .append(
                    Component.text("• Du bist Zuverlässig\n")
                )
                .append(
                    Component.text("• Du kannst gut Coden\n")
                )
                .append(
                    Component.text("• Du bist Zuverlässig\n")
                )
                .append(
                    Component.text("• Du bist in keinem anderen Team Vertreten\n")
                )
                .build()
            val page6 = Component.text()
                .append(
                    Component.text("Content:\n")
                        .color(NamedTextColor.LIGHT_PURPLE)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 15 Jahre alt\n")
                )
                .append(
                    Component.text("• Du bist sehr gut in Deutscher Schreibweise\n")
                )
                .append(
                    Component.text("• Du bist Freundlich\n")
                )
                .append(
                    Component.text("• Du bist ehrlich\n")
                )
                .append(
                    Component.text("• Du bist Zuverlässig\n")
                )
                .append(
                    Component.text("• Du bist (wenn möglich) in keinem anderen Team Vertreten\n")
                )
                .build()
            val page7 = Component.text()
                .append(
                    Component.text("Jr. Creator:\n")
                        .color(NamedTextColor.LIGHT_PURPLE)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 16 Jahre alt\n")
                )
                .append(
                    Component.text("• Du hast 50 Follower\n")
                )
                .append(
                    Component.text("• Du hast eine gute Reichweite\n")
                )
                .append(
                    Component.text("Creator:\n")
                        .color(NamedTextColor.LIGHT_PURPLE)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 16 Jahre alt\n")
                )
                .append(
                    Component.text("• Du hast 100 Follower\n")
                )
                .append(
                    Component.text("• Du hast eine Reichweite von 100 - 150 Aufrufen\n")
                )
                .build()

            val page8 = Component.text()
                .append(
                    Component.text("Partnerschaft:\n")
                        .color(NamedTextColor.RED)
                        .decorate(TextDecoration.BOLD)
                )
                .append(
                    Component.text("• Du bist mindestens 18 Jahre alt\n")
                )
                .append(
                    Component.text("• Dein Projekt verstößt nicht gegen unser Regelwerk\n")
                )
                .append(
                    Component.text("\n")
                )
                .append(
                    Component.text("\n")
                )
                .append(
                    Component.text("Für alle Ränge sind Aufstiegschancen möglich! Ausgenommen Partnerschaften!\n")
                        .color(NamedTextColor.DARK_RED)
                        .decorate(TextDecoration.BOLD)
                )
                .build()


            val page1 = Component.text()
                .append(
                    Component.text("Hier findest Alle Informationen über unsere Team-Ränge\n")
                        .color(NamedTextColor.DARK_GRAY)
                        .decorate(TextDecoration.BOLD)
                )
                .append(Component.text("\n"))
                .append(
                    Component.text("➡ Zu Unserem Discord für die Bewerbung!\n")
                        .color(NamedTextColor.BLUE)
                        .clickEvent(ClickEvent.openUrl("https://discord.gg/mVc4U824GF"))
                )
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(
                    Component.text("- BlockverseMC.net - \n")
                        .color(NamedTextColor.DARK_BLUE)
                        .decorate(TextDecoration.BOLD)
                )

                .build()


            val page9 = Component.text()
                .append(
                    Component.text("Interesse Geweckt?\n")
                        .color(NamedTextColor.DARK_GRAY)
                        .decorate(TextDecoration.BOLD)
                )
                .append(Component.text("\n"))
                .append(
                    Component.text("Dann bewirb dich jetzt auf unserem Discord!\n")
                        .color(NamedTextColor.BLUE))
                .append(Component.text("\n"))
                .append(
                    Component.text("➡ Zu Unserem Discord!\n")
                        .color(NamedTextColor.BLUE)
                        .clickEvent(ClickEvent.openUrl("XXXXXXXXXXX"))
                )
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(Component.text("\n"))
                .append(
                    Component.text("- BlockverseMC.net - \n")
                        .color(NamedTextColor.DARK_BLUE)
                        .decorate(TextDecoration.BOLD)
                )


                .build()

            meta.addPages(page1, page2, page3, page4, page5, page6, page7, page8, page9)

            book.itemMeta = meta

            // Buch öffnen
            player.openBook(book)

            true
        }
    }
}