import java.util.ArrayList;

public class Player {
	private String name;
	private PlayerService playerService;
	
	public Player(String n) {
		this.name = n;
		this.playerService = new PlayerService();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPlayerService(PlayerService service) {
		this.playerService = service;
	}

	public int getMyAverageScore() {
		int scoreSum = 0;
		int numberOfScores = 0;
		try {
			ArrayList<Integer> scores = playerService.getPlayerScores(this);
			for(Integer i : scores) {
				scoreSum += i;
				numberOfScores++;
			}
		} catch (Exception e){
			//Exception handling
		}
		if(numberOfScores > 0) {
			return scoreSum/numberOfScores;
		} else {
			return -1;
		}
	}
}
