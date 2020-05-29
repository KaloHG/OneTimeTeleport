package com.civlegacy;

import com.civlegacy.commands.TeleportCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import vg.civcraft.mc.civmodcore.ACivMod;

public class OneTimeTeleportMain extends ACivMod {
    private static OneTimeTeleportMain instance;

    public static OneTimeTeleportMain getInstance() {
        return instance;
    }
    private SQLHander dao;
    private ConfigManager configMan;

    public ConfigManager getConfigMan() {
        return configMan;
    }

    public SQLHander getDB() {
        return dao;
    }

    @Override
    protected String getPluginName() {
        return "OneTimeTeleport";
    }

    @Override
    public void onEnable() {
        instance = this;
        this.getCommand("ott").setExecutor(new TeleportCommand());
        super.onEnable();
        configMan = new ConfigManager(this);
        dao = configMan.getDAO();
    }

}
