package dev.limanoel.discordCommand

import dev.limanoel.discordCommand.commands.DiscordCommandCommand
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.plugin.java.JavaPlugin

class DiscordCommand : JavaPlugin() {

    override fun onEnable() {
        logger.info("")
        logger.info("")
        logger.info("")
        logger.info("-----------------------------------------------------------")
        logger.info("")
        server.consoleSender.sendMessage(
            net.kyori.adventure.text.Component.text("                         - Discord Command Plugin erfolgreich gestartet! - ")
                .color(net.kyori.adventure.text.format.NamedTextColor.GREEN).decorate(TextDecoration.BOLD)
        )
        logger.info("")
        logger.info("-----------------------------------------------------------")
        logger.info("")
        logger.info("")
        logger.info("")

        getCommand("discord")!!.setExecutor(DiscordCommandCommand())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
