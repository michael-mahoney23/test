import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.CoreMatchers.*;

public class GameTest {
	private Game g;
	
	@Before
	public void setUp() {
	    g = new Game();
	  }
	
	public void rollMany(int pins, int n) {
		for(int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}
	
	public void rollStrike() {
		g.roll(10);
	  }
	
	public void rollSpare() {
		g.roll(5);
		g.roll(5);
	}

	@Test
	public void allGutterGameScoresZero() {
		rollMany(0, 20);
		assertThat(g.score(), equalTo(0));
	}
	
	@Test
	public void allOnesScoresTwenty() {
		rollMany(1, 20);
		assertThat(g.score(), equalTo(20));
	}
	
	@Test
	public void testOneSpare() throws Exception {
	    rollSpare();
	    g.roll(3);
	    rollMany(17, 0);
	    assertThat(g.score(), equalTo(16));
	}
	
	@Test
	public void testOneStrike() throws Exception {
	    rollStrike();
	    g.roll(3);
	    g.roll(4);
	    rollMany(16, 0);
	    assertThat(g.score(), is(equalTo(24)));
	}
	
	@Test
	public void testPerfectGame() throws Exception {
	    rollMany(10, 12);
	    assertThat(g.score(), is(equalTo(300)));
	}
	
}
