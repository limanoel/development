package dev.limanoel.testPluginMaven

import dev.limanoel.testPluginMaven.commands.FeedCommand
import dev.limanoel.testPluginMaven.commands.HealCommand
import dev.limanoel.testPluginMaven.commands.KickCommand
import dev.limanoel.testPluginMaven.listeners.Events
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class TestPluginMaven : JavaPlugin() {

    override fun onEnable() {
        println("Plugin Funktioniert")

        Bukkit.getPluginManager().registerEvents(Events(), this)
        getCommand("heal")!!.setExecutor(HealCommand())
        getCommand("kick")!!.setExecutor(KickCommand())
        getCommand("feed")!!.setExecutor(FeedCommand())

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
