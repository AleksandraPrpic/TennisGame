public class TennisGame 
{	
	private int player1Points;
	private int player2Points;
	private boolean gameEnded;
	
	public TennisGame() 
	{
		this.player1Points = 0;
		this.player2Points = 0;
		this.gameEnded = false;
	}

	public void player1Scored() throws TennisGameException 
	{
		checkGameEnded();
		
		if (gameEnded) 
			throw new TennisGameException("Player 1 can't score, game has ended.");
		
		player1Points++;
	}

	public void player2Scored() throws TennisGameException 
	{
		checkGameEnded();
		
		if (gameEnded) 
			throw new TennisGameException("Player 2 can't score, game has ended.");
		
		player2Points++;
	}
	
	private void checkGameEnded()
	{ 
		if ((player1Points >= 4 && (player1Points - player2Points) >=2) || (player2Points >= 4 && (player2Points - player1Points) >= 2)) {
			gameEnded = true;
		}
	}

	private String getScore(int points) 
	{
		if (points == 0) {
			return "0";
		}
		else if (points == 1) {
			return "15";
		}
		else if (points == 2) {
			return "30";
		}
		else if (points == 3) {
			return "40";
		}
		return "";
	}
	
	public String getScore() 
	{
		
		checkGameEnded();
		
		// Scores format: "player1Score - player2Score"
		// "0 - 0"
		// "15 - 15"
		// "30 - 30"
		// "deuce"
		// "15 - 0", "0 - 15"
		// "30 - 0", "0 - 30"
		// "40 - 0", "0 - 40"
		// "30 - 15", "15 - 30"
		// "40 - 15", "15 - 40"
		// "advantage player1"
		// "advantage player2"
		// "game player1"
		// "game player2"
		
		String player1 = getScore(player1Points);
		String player2 = getScore(player2Points);
		if (player1.equals("40") && player2.equals("40")) {
			return "deuce";
		}
		else if (player1Points == 4 && player2Points == 3) {
			return "advantage player1";
		} 
		else if (player1Points == 3 && player2Points == 4) {
			return "advantage player2";
		} 
		else if (gameEnded) {
			if (player1Points > player2Points) return "game player1";
			else return "game player2";
		}
		return player1 + " - " + player2;
	}
}
