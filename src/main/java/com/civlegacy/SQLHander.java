package com.civlegacy;

import com.civlegacy.commands.TeleportCommand;
import org.bukkit.command.CommandSender;
import vg.civcraft.mc.civmodcore.ACivMod;
import vg.civcraft.mc.civmodcore.dao.ManagedDatasource;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLHander extends ManagedDatasource {

    public SQLHander(ACivMod plugin, String user, String pass, String host, int port, String database, int poolSize,
                  long connectionTimeout, long idleTimeout, long maxLifetime) {
        super(plugin, user, pass, host, port, database, poolSize, connectionTimeout, idleTimeout, maxLifetime);
        prepareMigrations();
        updateDatabase();
    }


    private void prepareMigrations() {
        registerMigration(0, false, "CREATE TABLE IF NOT EXISTS ottusernames (name VARCHAR(20) UNIQUE NOT NULL");
    }

    String username = TeleportCommand.usr;

    public void saveUsernames(TeleportCommand sender) {
        try (Connection conn = getConnection();
             PreparedStatement prep = conn
                     .prepareStatement("replace into ottusernames (name) values(?);");) {
            prep.setString(1, username);
            prep.execute();
        } catch (SQLException ex) {
            OneTimeTeleportMain.getInstance().warning("Failed to save username.");
        }
    }
}

