
public class Score {
	private int score;
	
	public Score(int def){
		score = def;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public void addScore(int add, int multiplier){
		score += add * multiplier;
	}
	
	public int getScore(){
		return score;
	}
}
