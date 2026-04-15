package dev.limanoel.stopMessage

import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import net.kyori.adventure.title.Title
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import java.time.Duration

class StopMessage : JavaPlugin() {

    override fun onLoad() {
        logger.info("")
        logger.info("-----------------------------------------------------------")
        logger.info("")
        server.consoleSender.sendMessage(
            Component.text("                         - Stop Command Plugin erfolgreich gestartet! - ")
                .color(NamedTextColor.GREEN)
                .decorate(TextDecoration.BOLD)
        )
        logger.info("")
        logger.info("-----------------------------------------------------------")
        logger.info("")
        logger.info("A Plugin by Limanoel")
    }

    override fun onEnable() {
        getCommand("stopserver")?.setExecutor(this)
    }

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {

        if (!sender.hasPermission("stopmessageplugin.stopserver")) {
            sender.sendMessage("§1§lLimanoelPlugins > > > §4 You dont have the permission to perform this command!")
            return true
        }

        if (!command.name.equals("stopserver", true)) return false

        val totalTime = 60

        val times = Title.Times.times(
            Duration.ofMillis(300),
            Duration.ofSeconds(2),
            Duration.ofMillis(300)
        )

        val bossBar = BossBar.bossBar(
            Component.text("Server stoppt in 60 Sekunden!")
                .color(NamedTextColor.RED)
                .decorate(TextDecoration.BOLD),
            1.0f,
            BossBar.Color.RED,
            BossBar.Overlay.PROGRESS
        )

        Bukkit.getOnlinePlayers().forEach { player ->
            player.showBossBar(bossBar)
        }

        fun sendTitle(title: String, subtitle: String? = null) {
            Bukkit.getOnlinePlayers().forEach { player ->
                player.showTitle(
                    Title.title(
                        Component.text(title)
                            .color(NamedTextColor.RED)
                            .decorate(TextDecoration.BOLD),
                        subtitle?.let {
                            Component.text(it)
                                .color(NamedTextColor.BLUE)
                        } ?: Component.empty(),
                        times
                    )
                )

                player.playSound(player.location, Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f)
            }
        }

        sendTitle("Server stoppt in 60 Sekunden!", "Sichert eure Items!")

        for (i in totalTime downTo 1) {
            Bukkit.getScheduler().runTaskLater(this, Runnable {

                val progress = i.toFloat() / totalTime.toFloat()
                bossBar.progress(progress)

                bossBar.name(
                    Component.text("Server stoppt in $i Sekunden!")
                        .color(NamedTextColor.RED)
                        .decorate(TextDecoration.BOLD)
                )

                if (i == 30 || i <= 10) {
                    sendTitle("Server stoppt in $i Sekunden!", "Sichert eure Items!")
                }

                if (i <= 10) {
                    Bukkit.getOnlinePlayers().forEach {
                        it.playSound(it.location, Sound.BLOCK_NOTE_BLOCK_BASS, 1f, 0.8f)
                    }
                }

            }, 20L * (totalTime - i))
        }

        Bukkit.getScheduler().runTaskLater(this, Runnable {

            Bukkit.getOnlinePlayers().forEach { player ->
                player.hideBossBar(bossBar)

                player.kick(
                    Component.text("Dieser Server des Minecraft Server Networks Networks wird heruntergefahren\n")
                        .color(NamedTextColor.RED)
                        .decorate(TextDecoration.BOLD)
                        .append(Component.empty())
                        .append(
                            Component.text("Wir sind bald wieder erreichbar")
                                .color(NamedTextColor.BLUE)
                                .decorate(TextDecoration.BOLD)
                        )
                )
            }

            server.shutdown()

        }, 20L * totalTime)

        sender.sendMessage("§1§LimanoelPLugins > > > §a§lServer-Stop-Countdown wurde gestartet!")
        return true
    }
}