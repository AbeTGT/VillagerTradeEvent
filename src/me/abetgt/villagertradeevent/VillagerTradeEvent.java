package me.abetgt.villagertradeevent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerTradeEvent extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new VillagerTradeListener(), this);
        getServer().getPluginManager().registerEvents(this, this);
        Metrics metrics = new Metrics(this, 16056);
    }
}
