package Project1;

public class RobotGamesOrganization {
	public void start(){
		boolean Isgameover=false;
		int winner=-1;
		TakeCommand initialize = new TakeCommand();
		initialize.AssingInventory();
		do
	    {
	        initialize.Screen();
	        for (int i = 0; i <initialize.teams.length; i++) {
				if (initialize.teams[i].credit>=10000&& initialize.robotcounter[i]>=6) {
					winner = i+1;
					Isgameover=true;
					break;
				}
			}
	    } while(!Isgameover);
		System.out.println("****** Game is Over!*****");
		System.out.println("Winner is :Team "+winner);
		System.out.println("****** Game is Over!*****");
		}
}
