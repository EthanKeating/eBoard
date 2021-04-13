package me.eths.eboard.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

public class LunarBoard {

	private static Map<UUID, FastBoard> boards = new HashMap<>();
	
	public static void createBoard(Player player) {
		
		FastBoard board = new FastBoard(player);
		
		boards.put(player.getUniqueId(), board);
	}
	
	public static void deleteBoard(Player player) {
		FastBoard board = boards.remove(player.getUniqueId());

        if (board != null) {
            board.delete();
        }
	}
	
	public static FastBoard getBoard(Player player) { 
		return boards.get(player.getUniqueId());
	}
    
	public static boolean boardExists(Player player) {
		FastBoard exists = getBoard(player);
		if (exists != null) {
			return false;
			}
		return true;
	}
    
	public static void updateBoardTitle(Player player, String title) {
		FastBoard board = getBoard(player);
		board.updateTitle(title);
	}
	
	public static void updateBoard(Player player, List<String> lines) {
		FastBoard board = getBoard(player);
		board.updateLines(lines);
	}	
	
	public static void updateBoardLine(Player player, String line, Integer id) {
		FastBoard board = getBoard(player);
		board.updateLine(id, line);
	}
	
	public static void deleteBoardLine(Player player, Integer id) {
		FastBoard board = getBoard(player);
		board.removeLine(id);
	}
	
	public static void deleteAllLines(Player player) {
		FastBoard board = getBoard(player);
		board.updateLines("");
		board.updateTitle("");
		board.removeLine(0);
	}
	
}
