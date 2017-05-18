import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class PlayerTest {
	
	Player bob;

	@Before
	public void setUp() {
		bob = new Player("bob");
		deleteAllBobRecords();
		insertBobScores();
	}
	
	@Test
	public void averageScoreNormalCase() {
		assertThat(bob.getMyAverageScore(), equalTo(200));
	}
	
	public void deleteAllBobRecords() {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "test1", "123456");
			Statement stmt = conn.createStatement();
			String deleteCurrentBobScores = "delete from Scores where name='" + "bob" + "'";
			stmt.executeQuery(deleteCurrentBobScores);
		} catch(Exception e) {
			//Exception handling
		}
	}
	
	public void insertBobScores() {
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "test1", "123456");
			Statement stmt = conn.createStatement();
			String insertBobScore150 = "insert into Scores values('1', 'bob', 150)";
			String insertBobScore200 = "insert into Scores values('2', 'bob', 200)";
			String insertBobScore250 = "insert into Scores values('3', 'bob', 250)";
			stmt.executeQuery(insertBobScore150);
			stmt.executeQuery(insertBobScore200);
			stmt.executeQuery(insertBobScore250);
		} catch (Exception e) {
			//Exception handling
		}
	}

}
