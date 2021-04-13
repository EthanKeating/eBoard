package me.eths.eboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import me.eths.eboard.Effects.DeleteBoard;
import me.eths.eboard.Effects.DeleteBoardLine;
import me.eths.eboard.Effects.UpdateBoard;
import me.eths.eboard.Effects.UpdateBoardLine;
import me.eths.eboard.Effects.UpdateBoardTitle;
import me.eths.eboard.Util.LunarBoard;

public class Main extends JavaPlugin implements Listener {

	SkriptAddon skriptAddon;

	static Main main;
	  
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
		if (Bukkit.getPluginManager().getPlugin("Skript") != null) {
			main = this;
			this.skriptAddon = Skript.registerAddon(this);
			Skript.registerEffect(UpdateBoard.class, new String[] { "(update|set) eboard (of|for) %players% to %strings%" });
			Skript.registerEffect(DeleteBoard.class, new String[] { "(delete|remove|clear|wipe) eboard (of|for) %players%" });
			Skript.registerEffect(UpdateBoardTitle.class, new String[] { "(update|set) eboard title (of|for) %players% to %string%" });
			Skript.registerEffect(UpdateBoardLine.class, new String[] { "(update|set) eboard line %integer% (of|for) %players% to %string%" });
			Skript.registerEffect(DeleteBoardLine.class, new String[] { "(delete|remove|clear|wipe) eboard line %integer% (of|for) %players%" });
		} else {
			Bukkit.getLogger().warning("[eBoard] Please install Skript to use eBoard"); }
		Bukkit.getLogger().info("[eBoard] eBoard has been enabled!");
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
        LunarBoard.createBoard(player);
    }
	
	@EventHandler
	public void PlayerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
        LunarBoard.deleteBoard(player);
    }
	
}
