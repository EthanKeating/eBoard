package me.eths.eboard.Effects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.eths.eboard.Util.LunarBoard;

public class UpdateBoard extends Effect {
	private Expression<Player> players;
	
	private Expression<String> lines;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
		this.players = (Expression<Player>)expressions[0];
		this.lines = (Expression)expressions[1];
		return true;
	}
	
	public String toString(Event event, boolean debug) {
		return "";
	}
	
	protected void execute(Event event) {
		if (this.players == null)
			return;
		List<String> scoreboard = new ArrayList<String>();
		for (String line : lines.getArray(event)) {
			scoreboard.add(line);
		}
		for (Player p : players.getArray(event)) {
			LunarBoard.updateBoard(p, scoreboard);
		}
	}
}
