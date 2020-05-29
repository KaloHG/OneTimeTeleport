package com.civlegacy;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
    private OneTimeTeleportMain plugin;
    private SQLHander dao;

    public ConfigManager(OneTimeTeleportMain plugin) {
        this.plugin = plugin;
        reloadconfig();
        parseconfig();
    }

    public SQLHander getDAO() {
        return dao;
    }

    public void parseconfig() {
        FileConfiguration config = plugin.getConfig();
        //SQL Stuffs.
        ConfigurationSection dbConfig = config.getConfigurationSection("sql");
        String host = dbConfig.getString("hostname");
        int port = dbConfig.getInt("port");
        String dbname = dbConfig.getString("dbname");
        String username = dbConfig.getString("username");
        String password = dbConfig.getString("password");
        dao = new SQLHander(plugin, username, password, host, port, dbname, 5, 1000L, 600000L, 7200000L);
    }

    public void reloadconfig() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
    }
}
