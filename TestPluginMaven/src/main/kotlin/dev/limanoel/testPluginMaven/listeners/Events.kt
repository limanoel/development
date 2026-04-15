package dev.limanoel.testPluginMaven.listeners

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.plugin.java.JavaPlugin

class Events : Listener {

    @EventHandler
    fun onRespawng(event: PlayerRespawnEvent){

        event.player.sendMessage(Component.text("You respawned").color(NamedTextColor.DARK_RED).decorate(TextDecoration.BOLD))

    }

}