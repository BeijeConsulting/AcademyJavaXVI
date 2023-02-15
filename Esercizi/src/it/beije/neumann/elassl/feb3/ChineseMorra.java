package it.beije.neumann.elassl.feb3;

public class ChineseMorra {
	String player1;
	String player2;
	ChineseMorra(){
		this("player1","player2");
	}
	ChineseMorra(String player1, String player2){
		this.player1=player1;
		this.player2=player2;
	}
	
	public void getWinner(String choice1, String choice2) {
		if(choice1 == null || choice2 == null) {
			throw new IllegalArgumentException("You both have to choose a move!");
		}
		if(choice1.equals(choice2)) {
			System.out.println("Draw :/");
			return;
		}
		switch(choice1) {
		case("rock"): 
			if(choice2.equals("scissors")) System.out.println(this.player1+" Wins!!");
			else System.out.println(this.player2+" Wins!!");
			break;
		case("paper"):
			if(choice2.equals("rock")) System.out.println(this.player1+" Wins!!");
			else System.out.println(this.player2+" Wins!!");
			break;
		case("scissors"):
			if(choice2.equals("paper")) System.out.println(this.player1+" Wins!!");
			else System.out.println(this.player2+" Wins!!");
			break;
		default:
			throw new IllegalArgumentException("Invalid move!");
		}
		
	}
	public static void main(String[] args) {
		ChineseMorra partita = new ChineseMorra("Maria", "Ivo");
		partita.getWinner("scissors", "paper");
		

	}

}
