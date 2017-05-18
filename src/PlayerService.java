import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class PlayerService {
	
	public ArrayList<Integer> getPlayerScores(Player p) throws Exception {
		String playerName = p.getName();
		ArrayList<Integer> playerScores = new ArrayList<Integer>();
		ResultSet rs = getPlayerScoresFromDB(playerName);
		while(rs.next()) {
			playerScores.add(rs.getInt("score"));
		}	
		return playerScores;
	}
	
	public ResultSet getPlayerScoresFromDB(String name) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "test1", "123456");
			stmt = conn.createStatement();
			String query = "select score from scores where name='" + name + "'";
			return stmt.executeQuery(query);	
		} catch(Exception e) {
			//Exception handling
			return null;
		}
	}
	
}
