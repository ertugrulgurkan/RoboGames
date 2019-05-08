package Project1;
import java.util.Random;

public class RoboGames {
Robots [][] Competingteams = new Robots [6][9]; ///6*9luk iki boyutlu dizi
Robots [] Temp= new Robots[9];
String type;
int prize;
Random r = new Random();
//double chance = 0.950 + (1.050 - 0.950) * r.nextDouble();
//double chance = 0.950 + (1.050 - 0.950) * r.nextDouble();
public RoboGames(int prize) {
	this.prize=prize;	
}
public RoboGames(){
	
}

public void Register(Robots r,int whichteam,int whichplayer ,int gameindex){
	if (Competingteams[whichteam][whichplayer]==null){
			Competingteams[whichteam][whichplayer]=r;		
		}
   else {
	   System.out.println("Wrong Command");
	} 			
}

public double calculateChessScore(int whichteam){
	 double Teamscore=0;
	 //double chance = 0.950 + (1.050 - 0.950) * r.nextDouble();
		int k=0;
		int counter=0;
			for (int j = 0; j < 9; j++) {
				if (Competingteams[whichteam][j]!=null) {
					Temp[k]=Competingteams[whichteam][j];
					k++;
					counter++;
				} 
			}
			if (counter==9) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4)+(Temp[2].getChessScore()/8)+(Temp[3].getChessScore()/12)+(Temp[4].getChessScore()/16)+(Temp[5].getChessScore()/20)+(Temp[6].getChessScore()/24)+(Temp[7].getChessScore()/28)+(Temp[8].getChessScore()/32);
			if (counter==8) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4)+(Temp[2].getChessScore()/8)+(Temp[3].getChessScore()/12)+(Temp[4].getChessScore()/16)+(Temp[5].getChessScore()/20)+(Temp[6].getChessScore()/24)+(Temp[7].getChessScore()/28);
			if (counter==7) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4)+(Temp[2].getChessScore()/8)+(Temp[3].getChessScore()/12)+(Temp[4].getChessScore()/16)+(Temp[5].getChessScore()/20)+(Temp[6].getChessScore()/24);
			if (counter==6) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4)+(Temp[2].getChessScore()/8)+(Temp[3].getChessScore()/12)+(Temp[4].getChessScore()/16)+(Temp[5].getChessScore()/20);
			if (counter==5) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4)+(Temp[2].getChessScore()/8)+(Temp[3].getChessScore()/12)+(Temp[4].getChessScore()/16);
			if (counter==4) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4)+(Temp[2].getChessScore()/8)+(Temp[3].getChessScore()/12);
			if (counter==3) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4)+(Temp[2].getChessScore()/8);
			if (counter==2) 
				Teamscore = (Temp[0].getChessScore())+(Temp[1].getChessScore()/4);	
			if (counter==1) 
				Teamscore = Temp[0].getChessScore();
			return Teamscore;
}

public double calculateSumoScore(int whichteam){
	 double Teamscore=0;
		int k=0;
		int counter=0;
			for (int j = 0; j < 9; j++) {
				if (Competingteams[whichteam][j]!=null) {
					Temp[k]=Competingteams[whichteam][j];
					k++;
					counter++;
				} 
			}
			if (counter==9) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4)+(Temp[2].getSumoscore()/8)+(Temp[3].getSumoscore()/12)+(Temp[4].getSumoscore()/16)+(Temp[5].getSumoscore()/20)+(Temp[6].getSumoscore()/24)+(Temp[7].getSumoscore()/28)+(Temp[8].getSumoscore()/32);
			if (counter==8) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4)+(Temp[2].getSumoscore()/8)+(Temp[3].getSumoscore()/12)+(Temp[4].getSumoscore()/16)+(Temp[5].getSumoscore()/20)+(Temp[6].getSumoscore()/24)+(Temp[7].getSumoscore()/28);
			if (counter==7) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4)+(Temp[2].getSumoscore()/8)+(Temp[3].getSumoscore()/12)+(Temp[4].getSumoscore()/16)+(Temp[5].getSumoscore()/20)+(Temp[6].getSumoscore()/24);
			if (counter==6) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4)+(Temp[2].getSumoscore()/8)+(Temp[3].getSumoscore()/12)+(Temp[4].getSumoscore()/16)+(Temp[5].getSumoscore()/20);
			if (counter==5) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4)+(Temp[2].getSumoscore()/8)+(Temp[3].getSumoscore()/12)+(Temp[4].getSumoscore()/16);
			if (counter==4) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4)+(Temp[2].getSumoscore()/8)+(Temp[3].getSumoscore()/12);
			if (counter==3) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4)+(Temp[2].getSumoscore()/8);
			if (counter==2) 
				Teamscore = (Temp[0].getSumoscore())+(Temp[1].getSumoscore()/4);	
			if (counter==1) 
				Teamscore = Temp[0].getSumoscore();
			return Teamscore;
}

public double calculateRunScore(int whichteam){
	double Teamscore=0;
	Robots [] Temp= new Robots[9];
	int k=0;
	int counter=0;
		for (int j = 0; j < 9; j++) {
			if (Competingteams[whichteam][j]!=null) {
				Temp[k]=Competingteams[whichteam][j];
				k++;
				counter++;
			}
		}
		if (counter==9) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4)+(Temp[2].getRunscore()/8)+(Temp[3].getRunscore()/12)+(Temp[4].getRunscore()/16)+(Temp[5].getRunscore()/20)+(Temp[6].getRunscore()/24)+(Temp[7].getRunscore()/28)+(Temp[8].getRunscore()/32);
		if (counter==8) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4)+(Temp[2].getRunscore()/8)+(Temp[3].getRunscore()/12)+(Temp[4].getRunscore()/16)+(Temp[5].getRunscore()/20)+(Temp[6].getRunscore()/24)+(Temp[7].getRunscore()/28);
		if (counter==7) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4)+(Temp[2].getRunscore()/8)+(Temp[3].getRunscore()/12)+(Temp[4].getRunscore()/16)+(Temp[5].getRunscore()/20)+(Temp[6].getRunscore()/24);
		if (counter==6) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4)+(Temp[2].getRunscore()/8)+(Temp[3].getRunscore()/12)+(Temp[4].getRunscore()/16)+(Temp[5].getRunscore()/20);
		if (counter==5) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4)+(Temp[2].getRunscore()/8)+(Temp[3].getRunscore()/12)+(Temp[4].getRunscore()/16);
		if (counter==4) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4)+(Temp[2].getRunscore()/8)+(Temp[3].getRunscore()/12);
		if (counter==3) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4)+(Temp[2].getRunscore()/8);
		if (counter==2) 
			Teamscore = (Temp[0].getRunscore())+(Temp[1].getRunscore()/4);	
		if (counter==1) 
			Teamscore = Temp[0].getRunscore();
	return  Teamscore;
}

public double calculatePingPongScore(int whichteam){
	double Teamscore=0;
	Robots [] Temp= new Robots[9];
	int k=0;
	int counter=0;
		for (int j = 0; j < 9; j++) {
			if (Competingteams[whichteam][j]!=null) {
				Temp[k]=Competingteams[whichteam][j];
				k++;
				counter++;
			}
		}
		if (counter==9) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4)+(Temp[0].getPingPongScore()/8)+(Temp[0].getPingPongScore()/12)+(Temp[0].getPingPongScore()/16)+(Temp[0].getPingPongScore()/20)+(Temp[0].getPingPongScore()/24)+(Temp[0].getPingPongScore()/28)+(Temp[0].getPingPongScore()/32);
		if (counter==8) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4)+(Temp[0].getPingPongScore()/8)+(Temp[0].getPingPongScore()/12)+(Temp[0].getPingPongScore()/16)+(Temp[0].getPingPongScore()/20)+(Temp[0].getPingPongScore()/24)+(Temp[0].getPingPongScore()/28);
		if (counter==7) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4)+(Temp[0].getPingPongScore()/8)+(Temp[0].getPingPongScore()/12)+(Temp[0].getPingPongScore()/16)+(Temp[0].getPingPongScore()/20)+(Temp[0].getPingPongScore()/24);
		if (counter==6) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4)+(Temp[0].getPingPongScore()/8)+(Temp[0].getPingPongScore()/12)+(Temp[0].getPingPongScore()/16)+(Temp[0].getPingPongScore()/20);
		if (counter==5) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4)+(Temp[0].getPingPongScore()/8)+(Temp[0].getPingPongScore()/12)+(Temp[0].getPingPongScore()/16);
		if (counter==4) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4)+(Temp[0].getPingPongScore()/8)+(Temp[0].getPingPongScore()/12);
		if (counter==3) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4)+(Temp[0].getPingPongScore()/8);
		if (counter==2) 
			Teamscore = (Temp[0].getPingPongScore())+(Temp[0].getPingPongScore()/4);	
		if (counter==1) 
			Teamscore = Temp[0].getPingPongScore();
return Teamscore;
}

public int FindChessWinner(){
	int winnerTeamIndex=-1;
	double ChessWinner=0.0;
	boolean isThereWinner=false;
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 9; j++) {	
		if (ChessWinner<calculateChessScore(i)) {
			ChessWinner=calculateChessScore(i);
		}
		if (calculateChessScore(i)!=0.0 && Competingteams[i][j]!=null) {
			System.out.println("t"+(i+1)+" - r"+(j+1)+":  "+Competingteams[i][j].head.name+" "+Competingteams[i][j].torso.name+" "+Competingteams[i][j].arms.name+" "+Competingteams[i][j].legs.name+" ");
		}
		}
	}
	for (int i = 0; i < 6; i++) {
		if (ChessWinner==calculateChessScore(i) && ChessWinner!=0.0) {
			System.out.println("Winner: Team "+(i+1)+" " +ChessWinner);	
			winnerTeamIndex=i;
			isThereWinner=true;
			break;
		}
	}
	if (!isThereWinner) {
		System.out.println("Winner: No winner. Prize transferred to the next week.");
	}
	return winnerTeamIndex;

}

public int FindSumoWinner(){
	int winnerTeamIndex=-1;
	double Sumowinner=0.0;
	boolean isThereWinner=false;
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 9; j++) {	
		if (Sumowinner<calculateSumoScore(i)) {
			Sumowinner=calculateSumoScore(i);
		}
		if (calculateSumoScore(i)!=0.0&& Competingteams[i][j]!=null) {
			System.out.println("t"+(i+1)+" - r"+(j+1)+":  "+Competingteams[i][j].head.name+" "+Competingteams[i][j].torso.name+" "+Competingteams[i][j].arms.name+" "+Competingteams[i][j].legs.name+" ");
		}
		}
	}
	for (int i = 0; i < 6; i++) {
		if (Sumowinner==calculateSumoScore(i)&& Sumowinner!=0.0) {
			System.out.println("Winner: Team "+(i+1)+" " +Sumowinner);
			isThereWinner=true;
			winnerTeamIndex=i;
			break;
		}
	}
	if (!isThereWinner) {
		System.out.println("Winner: No winner. Prize transferred to the next week.");
	}
return winnerTeamIndex;
}

public int FindRunWinner(){
	int winnerTeamIndex=-1;
	double Runwinner=0.0;
	boolean isThereWinner=false;
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 9; j++) {	
		if (Runwinner<calculateRunScore(i)) {
			Runwinner=calculateRunScore(i);
		}
		if (calculateRunScore(i)!=0.0&& Competingteams[i][j]!=null) {
			System.out.println("t"+(i+1)+" - r"+(j+1)+":  "+Competingteams[i][j].head.name+" "+Competingteams[i][j].torso.name+" "+Competingteams[i][j].arms.name+" "+Competingteams[i][j].legs.name+" ");
		}
		}
	}
	for (int i = 0; i < 6; i++) {
		if (Runwinner==calculateRunScore(i)&& Runwinner!=0.0) {
			System.out.println("Winner: Team "+(i+1)+" " +Runwinner);
			isThereWinner=true;
			winnerTeamIndex=i;
			break;
		}
	}
	if (!isThereWinner) {
		System.out.println("Winner: No winner. Prize transferred to the next week.");
}
	return winnerTeamIndex;

}

public int FindPingPongWinner(){
	int winnerTeamIndex=-1;
	double PingpongWinner=0.0;
	boolean isThereWinner=false;
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 9; j++) {	
		if (PingpongWinner<calculatePingPongScore(i)) {
			PingpongWinner=calculatePingPongScore(i);
		}
		if (calculatePingPongScore(i)!=0.0&& Competingteams[i][j]!=null) {
			System.out.println("t"+(i+1)+" - r"+(j+1)+":  "+Competingteams[i][j].head.name+" "+Competingteams[i][j].torso.name+" "+Competingteams[i][j].arms.name+" "+Competingteams[i][j].legs.name+" ");
		}
		}
	}
	for (int i = 0; i < 6; i++) {
		if (PingpongWinner==calculatePingPongScore(i)&& PingpongWinner!=0.0) {
			System.out.println("Winner: Team "+(i+1)+" " +PingpongWinner);
			isThereWinner=true;
			winnerTeamIndex=i;
			break;
			}

	}
	if (!isThereWinner) {
		System.out.println("Winner: No winner. Prize transferred to the next week.");
	}
	return winnerTeamIndex;
}

public int numberofteams(){
	int numofteams=0;
	boolean counter0=false,counter1=false,counter2=false,counter3=false,counter4=false,counter5=false;
	for (int i = 0; i < 9; i++) {
		if (Competingteams[0][i]!=null) 
			counter0=true;	
	}
	if (counter0) {
		numofteams++;
	}
	for (int i = 0; i < 9; i++) {
		if (Competingteams[1][i]!=null) 
			counter1=true;	
	}
	if (counter1) {
		numofteams++;
	}
	for (int i = 0; i < 9; i++) {
		if (Competingteams[2][i]!=null) 
			counter2=true;	
	}
	if (counter2) {
		numofteams++;
	}
	for (int i = 0; i < 9; i++) {
		if (Competingteams[3][i]!=null) 
			counter3=true;	
	}
	if (counter3) {
		numofteams++;
	}
	for (int i = 0; i < 9; i++) {
		if (Competingteams[4][i]!=null) 
			counter4=true;	
	}
	if (counter4) {
		numofteams++;
	}
	for (int i = 0; i < 9; i++) {
		if (Competingteams[5][i]!=null) 
			counter5=true;	
	}
	if (counter5) {
		numofteams++;
	}
	return numofteams;
	
}
}




	
	

	



