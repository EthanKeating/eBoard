package me.eths.eboard.Effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.eths.eboard.Util.LunarBoard;

public class UpdateBoardLine extends Effect {
	private Expression<Player> players;
	
	private Expression<String> line;
	
	private Expression<Integer> id;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean init(Expression<?>[] expressions, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parser) {
		this.players = (Expression<Player>)expressions[1];
		this.id = (Expression)expressions[0];
		this.line = (Expression)expressions[2];
		return true;
	}
	
	public String toString(Event event, boolean debug) {
		return "";
	}
	
	protected void execute(Event event) {
		if (this.players == null)
			return;
		for (Player p : players.getArray(event)) {
			LunarBoard.updateBoardLine(p, line.getSingle(event), (int)id.getSingle(event));
		}
	}
}
