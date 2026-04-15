package dev.limanoel.duelPlugin

import org.bukkit.plugin.java.JavaPlugin
import net.milkbowl.vault.economy.Economy
import org.bukkit.plugin.RegisteredServiceProvider

class DuelPlugin : JavaPlugin() {

    override fun onEnable() {
        setupEconomy()

        duelManager = DuelManager()

        getCommand("duel")?.setExecutor(DuelCommand(duelManager))
        getCommand("dueladmin")?.setExecutor(DuelAdminCommand())

        server.pluginManager.registerEvents(DuelKitListener(duelManager), this)
        server.pluginManager.registerEvents(DuelListener(duelManager), this)
    }

    private fun setupEconomy() {
        val rsp = server.servicesManager.getRegistration(Economy::class.java)
        if (rsp != null) economy = rsp.provider

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
