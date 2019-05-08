package Project1;
import java.util.Random;

import enigma.core.Enigma;

import enigma.console.Console;

public class TakeCommand {
	public Teams[] teams =new Teams[6];
	public int[] robotcounter = new int[6];
	public int [][] calculateTeamscore=new int [6][9]; 
    public Console cn;
    public String thecommand;  //to take input from the user
    public int week=1;	      //week counter value
    Random rand = new Random();
    RoboGames chess= new RoboGames();
    RoboGames run= new RoboGames();
    RoboGames sumo= new RoboGames();
    RoboGames pingpong= new RoboGames();
	int t1robotindex=1;	int t2robotindex=1;	int t3robotindex=1;	int t4robotindex=1;	int t5robotindex=1;

    public TakeCommand() 
    {
        thecommand = "      ";
        cn = Enigma.getConsole("Robot Games",110,30, true);   //to run enigma console
        
    }
    
    public void AssingInventory()
    {
    	for (int i = 0; i < teams.length; i++) {
			teams[i]=new Teams();
				for (int j = 0; j < 20; j++) 
					teams[i].inventory[j]= new Modules(" ", " ", 0, 0, 0, 0, 0, 0,0);
				
    			for (int k = 0; k < 9; k++) {
					teams[i].robot[k]= new Robots();
			 		teams[i].robot[k].name=" ";


    			 	}
				} 
    	chess.prize=200;
    	run.prize=200;
    	sumo.prize=250;
    	pingpong.prize=250;
    }
    
    public void decreaseDurability()
{
        for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 20; j++) {
				if (!teams[i].inventory[j].name.equals(" ")) {
					teams[i].inventory[j].durability=teams[i].inventory[j].durability-2;
				}
			}
		}
        for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				if (!teams[i].robot[j].name.equals(" ")) {
					teams[i].robot[j].arms.durability=teams[i].robot[j].arms.durability-2;
					teams[i].robot[j].head.durability=teams[i].robot[j].head.durability-2;
					teams[i].robot[j].legs.durability=teams[i].robot[j].legs.durability-2;
					teams[i].robot[j].torso.durability=teams[i].robot[j].torso.durability-2;
				}
			}
		}
    }
    
    public void Screen()   //a function To show the required table
    {
    	System.out.println();
    	System.out.println("Week:"+week+"  Robot/Credit: T1:"+robotcounter[0]+"/"+teams[0].credit+"  T2:"+robotcounter[1]+"/"+teams[1].credit+"  T3:"+robotcounter[2]+"/"+teams[2].credit);
    	System.out.println("				      T4:"+robotcounter[2]+"/"+teams[3].credit+"  T5:"+robotcounter[4]+"/"+teams[4].credit+"  T6:"+robotcounter[5]+"/"+teams[5].credit);
    	System.out.println();
    	System.out.println("--- Team1: Modules ---");
    	System.out.println();
    	for (int i = 0; i <teams[0].inventory.length; i++) {
    		if(teams[0].inventory[i].equals(" "))
    		{
    			System.out.print("m"+(i+1)+".  ");		
    		}
    		else
    		{
    			if (teams[0].inventory[i].durability!=0) {
    				System.out.print("m"+(i+1)+"."+teams[0].inventory[i].name+"-"+teams[0].inventory[i].durability+" ");
				}
    			else
				System.out.print("m"+(i+1)+"."+teams[0].inventory[i].name+" ");
    		}				
    		if (i==4)
    			System.out.println();
    		if (i==9) 
    			System.out.println();
    		if (i==14)
    			System.out.println();			
    	}
    	System.out.println();        
    	System.out.println("-----------------------");
    	System.out.printf("Please Enter a command:");
        thecommand = cn.readLine();
        if (thecommand.length()>3) {
	        if(thecommand.substring(0, 2).equals("by"))
	            buyCommand(thecommand.substring(3),0);
	        else if(thecommand.substring(0, 4).equals("sl m"))
	            sellCommand(thecommand,0);
	        else if(thecommand.startsWith("++ r"))
	        	buildRobot(thecommand,0);
	        else if(thecommand.startsWith("-- r"))
	        	divideRobot(thecommand,0);
	        else if(thecommand.startsWith("sl r"))
	        	sellRobot(thecommand,0);
	        else if(thecommand.startsWith("ch r"))
	        	changeModule(thecommand,0);
	        else if(thecommand.startsWith("ls "))
				listRobots(thecommand);
	        else if(thecommand.startsWith("rg "))
	        	register(thecommand,0);
	        else if(thecommand.startsWith("play"))
	        	play();
	        else
	        	System.out.println("Wrong command!");
	        }
        
    else
    	System.out.println("Wrong command!");
    	}    

	public void buyCommand(String command,int teamindex) //buy command function
	{
		
	    if (teams[teamindex].credit<0&&teamindex==0)//if team1 credit lower than zero {
			System.out.println("You don't have enough money to buy this module");
		
		
	    if (teams[teamindex].findEmptySpace()>20&&teamindex==0) {
			System.out.println("You don't have enough space on your inventory!");
		}
	    	//all modules to use for creating robots
	    if (!(command.substring(2).equals("1")||command.substring(2).equals("2")||command.substring(2).equals("3")||command.substring(2).equals("4")||command.substring(2).equals("5")||command.substring(2).equals("6"))&&teamindex==0)
	    {
	    	System.out.println("Wrong command");
		}
	    else	
	    {
	    	int quality=Integer.parseInt(command.substring(2));

	    	if (command.startsWith("hd")) {
	    		if (teams[teamindex].credit-100*quality>0) {
	    	    	Modules head = new Modules(command,"Head",quality,100*quality, (20 + (quality * 1)), 0, (100+(quality*160)), 0,100);
	    	    	head.name= command;
	    	    	teams[teamindex].credit=teams[teamindex].credit-head.price;	
		    		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=head;
				}
	    		else{
	    			if (teamindex==0) 
		    			System.out.println("You don't have money to bu this module");						
	    			else
	    				Screen();		
	    		}
	
			}
	    	else if (command.startsWith("tr")) {
	    		if (teams[teamindex].credit-150*quality>0) {
	    	    	Modules torso = new Modules(command,"Torso",quality,150*quality, (100 + (quality * 10)), (100+(quality*80)),0, 0,100);
	    	    	torso.name= command;
	    	    	teams[teamindex].credit=teams[teamindex].credit-torso.price;	
		    		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=torso;
				}
	    		else{
	    			if (teamindex==0) 
		    			System.out.println("You don't have money to bu this module");						
	    			else
	    				Screen();		
	    		}
			}
	    	else if (command.startsWith("ar")) {
	    		if (teams[teamindex].credit-40*quality>0) {
	    	    	Modules arms = new Modules(command,"Arms",quality,40*quality, (40+(1*2)), 0, 0, (100+(quality * 200)),100);
	    	    	arms.name= command;
	    	    	teams[teamindex].credit=teams[teamindex].credit-arms.price;	
		    		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=arms;	
				}
	    		else{
	    			if (teamindex==0) 
		    			System.out.println("You don't have money to bu this module");						
	    			else
	    				Screen();		
	    		}
			}
	    	else if (command.startsWith("lg")) {
	    		if (teams[teamindex].credit-50*quality>0) {
	    	    	Modules legs = new Modules(command,"Legs",quality,50*quality, (80+(quality*4)), (100 + (quality * 80)), 0, 0,100);
	    	    	legs.name= command;
	    	    	teams[teamindex].credit=teams[teamindex].credit-legs.price;	
		    		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=legs;	
				}
	    		else{
	    			if (teamindex==0) 
		    			System.out.println("You don't have money to bu this module");						
	    			else
	    				Screen();		
	    		}
			}
    		else{
    			if (teamindex==0) 
	    			System.out.println("You don't have money to bu this module");						
    			else
    				Screen();		
    		}
	    }
	    }

	public void sellCommand(String command,int teamindex)
{
		int mnumber=Integer.parseInt(command.substring(4)); 
		if(mnumber<21&&mnumber>0&&!(teams[teamindex].inventory[mnumber-1].name.equals(" ")))
		{
			//PriceOfUsedModule = 0.5 * PriceOfNewModule * Durability/100
			teams[teamindex].credit=teams[teamindex].credit+(0.5*teams[teamindex].inventory[mnumber-1].price * (teams[teamindex].inventory[mnumber-1].durability/100));
			//to delete from the inventory
			teams[teamindex].inventory[mnumber-1]= new Modules(" ", " ", 0, 0, 0, 0, 0, 0,0);
			
	    }
		else
			System.out.println("Wrong Command");
  }
	
	public void buildRobot(String command,int teamindex)
{
		

		int rnumber=Integer.parseInt(command.substring(4,5)); 
		String Modul[]=command.split(" ");
		int robonumber=rnumber-1;
		int headcounter=0; int armscounter=0; int torsocounter=0; int legscounter=0;
		boolean hdflag=true,trflag=true,lgflag=true,arflag=true;
		if (!teams[teamindex].robot[robonumber].name.equals(" ")) {
			System.out.println("This robot already exists");
			Screen();
		}
		else{
			
		
		
			
		for (int i = 3; i < Modul.length; i++) {
			if (Modul[i].startsWith("hd"))
				headcounter++;
			if (Modul[i].startsWith("tr"))
				torsocounter++;
			if (Modul[i].startsWith("ar"))
				armscounter++;
			if (Modul[i].startsWith("lg"))
				legscounter++;	
			if (Modul[i].startsWith("m")) {
				int inv=Integer.parseInt(Modul[i].substring(1,2));
				if (inv>0&&inv<21&&!(teams[teamindex].inventory[inv-1].equals(" ")))
				{
					if (teams[teamindex].inventory[inv-1].type.equals("Head"))
						headcounter++;
					if (teams[teamindex].inventory[inv-1].type.equals("Torso"))
						torsocounter++;
					if (teams[teamindex].inventory[inv-1].type.equals("Legs"))
						legscounter++;
					if (teams[teamindex].inventory[inv-1].type.equals("Arms"))
						armscounter++;
				}
			}
		}
			if (headcounter==1 && torsocounter==1 && armscounter==1 && legscounter==1 && robonumber<9&&robonumber>=0&&Modul.length==7)
			{		
				double totalcost=0;

					for (int i = 3; i < Modul.length; i++) {
						if (Modul[i].startsWith("hd")){
							int quality=Integer.parseInt(Modul[i].substring(2));							
								totalcost=totalcost+(100*quality);	}						
						if (Modul[i].startsWith("tr")) {
							int quality=Integer.parseInt(Modul[i].substring(2));							
				    	    	totalcost=totalcost+(150*quality);	}					
						if (Modul[i].startsWith("ar")) {
							int quality=Integer.parseInt(Modul[i].substring(2));							
				    	    	totalcost=totalcost+(40*quality);	}					
						if (Modul[i].startsWith("lg")) {
							int quality=Integer.parseInt(Modul[i].substring(2));							
				    	    	totalcost=totalcost+(50*quality);	}			
					}
					if (totalcost<teams[0].credit){ 
							teams[teamindex].credit=teams[teamindex].credit-totalcost;
							for (int i = 3; i < Modul.length; i++) {
						if (Modul[i].startsWith("hd")&&hdflag==true) {
							int quality=Integer.parseInt(Modul[i].substring(2));							
								Modules heads = new Modules(Modul[i],"Head",quality,100*quality, (20 + (quality * 1)), 0, (100+(quality*160)), 0,100);
								teams[teamindex].robot[robonumber].head=heads;
								teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
								hdflag=false;
							
						}
						if (Modul[i].startsWith("tr")&&trflag==true) {
							int quality=Integer.parseInt(Modul[i].substring(2));							
					    	    	Modules torso = new Modules(Modul[i],"Torso",quality,150*quality, (100 + (quality * 10)), (100+(quality*80)),0, 0,100);
					    	    	totalcost=totalcost+torso.price;	
									teams[teamindex].robot[robonumber].torso=torso;
									teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
									trflag=false;

								
					    	}
						if (Modul[i].startsWith("ar")&&arflag==true) {
							int quality=Integer.parseInt(Modul[i].substring(2));							
				    	    	Modules arms = new Modules(Modul[i],"Arms",quality,40*quality, (40+(1*2)), 0, 0, (100+(quality * 200)),100);
				    	    	totalcost=totalcost+arms.price;	
								teams[teamindex].robot[robonumber].arms=arms;	
								teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
								arflag=false;

							
						}
						if (Modul[i].startsWith("lg")&&lgflag==true) {
							int quality=Integer.parseInt(Modul[i].substring(2));							
			    	    	Modules legs = new Modules(Modul[i],"Legs",quality,50*quality, (80+(quality*4)), (100 + (quality * 80)), 0, 0,100);
			    	    	totalcost=totalcost+legs.price;	
							teams[teamindex].robot[robonumber].legs=legs;	
							teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
							lgflag=false;

							
						}
						if (Modul[i].startsWith("m")) {
							int inv=Integer.parseInt(Modul[i].substring(1,2));
							if (inv>0&&inv<21&&!(teams[0].inventory[inv-1].equals(" "))) {
								if (teams[teamindex].inventory[inv-1].type.equals("Head")) {
									teams[teamindex].robot[robonumber].head=teams[teamindex].inventory[inv-1];	
									teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
									teams[teamindex].inventory[inv-1]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,0);
								}
								if (teams[teamindex].inventory[inv-1].type.equals("Torso")) {
									teams[teamindex].robot[robonumber].torso=teams[teamindex].inventory[inv-1];	
									teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
									teams[teamindex].inventory[inv-1]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,0);
								}
								if (teams[teamindex].inventory[inv-1].type.equals("Legs")) {
									teams[teamindex].robot[robonumber].legs=teams[teamindex].inventory[inv-1];	
									teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
									teams[teamindex].inventory[inv-1]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,0);
								}
								if (teams[teamindex].inventory[inv-1].type.equals("Arms")) {
									teams[teamindex].robot[robonumber].arms=teams[teamindex].inventory[inv-1];	
									teams[teamindex].robot[robonumber].name="r"+Integer.toString(rnumber);
									teams[teamindex].inventory[inv-1]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,0);
						     	}
				     	  	}
				    		}
						}
						
							robotcounter[teamindex]++;

					}
					else{
						System.out.println("You don't have enough money to build this robot");
					}
			}				

				else{
					System.out.println("Wrong Command, Please type again");

				}
			}
	}
	
	public void divideRobot(String command,int teamindex)
{
		int numofrobot = Integer.parseInt(command.substring(4,5));
		if (teams[0].robot[numofrobot-1].name.equals(" ")) {
			System.out.println("There is no robot by that name");
		}
		else{
    	for (int i = 0; i < 4; i++) {
    		if (i==0) 
        		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=teams[teamindex].robot[numofrobot-1].head;			
    		if (i==1) 
        		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=teams[teamindex].robot[numofrobot-1].torso;			
    		if (i==2) 
        		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=teams[teamindex].robot[numofrobot-1].arms;			
    		if (i==3) 
        		teams[teamindex].inventory[teams[teamindex].findEmptySpace()]=teams[teamindex].robot[numofrobot-1].legs;		
		}
			teams[teamindex].robot[numofrobot-1].name=" ";   	
			robotcounter[teamindex]--;
	}
	}
	
	public void sellRobot(String command,int teamindex)
{
		
		int numofrobot = Integer.parseInt(command.substring(4,5));
		if (!(teams[teamindex].robot[numofrobot-1].name.equals(" "))) {
			teams[teamindex].credit=teams[teamindex].credit+(0.5*teams[teamindex].robot[numofrobot-1].head.price * (teams[teamindex].robot[numofrobot-1].head.durability/100));
			teams[teamindex].credit=teams[teamindex].credit+(0.5*teams[teamindex].robot[numofrobot-1].arms.price * (teams[teamindex].robot[numofrobot-1].arms.durability/100));
			teams[teamindex].credit=teams[teamindex].credit+(0.5*teams[teamindex].robot[numofrobot-1].torso.price * (teams[teamindex].robot[numofrobot-1].torso.durability/100));
			teams[teamindex].credit=teams[teamindex].credit+(0.5*teams[teamindex].robot[numofrobot-1].legs.price * (teams[teamindex].robot[numofrobot-1].legs.durability/100));
			robotcounter[teamindex]--;
			teams[teamindex].robot[numofrobot-1]=new Robots();
			teams[teamindex].robot[numofrobot-1].name=" ";
		}
		else{
			System.out.println("There is no robot by that name");
		}
	}
			
	public void changeModule(String command,int teamindex)
{
		int numofrobot = Integer.parseInt(command.substring(4,5));
		int numofinventory = Integer.parseInt(command.substring(7));
		
		if (teams[teamindex].inventory[numofinventory-1].name.equals(" ") || (numofinventory<0 && numofinventory>21)) {
			System.out.println("The inventory number is invalid");
		}
		if (teams[teamindex].robot[numofrobot-1].equals(" ")) {
			System.out.println("There is no robot by that name");
		}
		else
		{
			if (teams[teamindex].inventory[numofinventory-1].type.equals("Head")) {
		    	int counter=0;  //
		    	for (int i = 0; i <teams[teamindex].inventory.length; i++) {
					if (teams[teamindex].inventory[i].name.equals(" ")){
						counter=i;
						break;
					}					
				}
		    	teams[teamindex].inventory[counter]=teams[teamindex].inventory[numofinventory-1];
		    	teams[teamindex].inventory[numofinventory-1]=teams[teamindex].robot[numofrobot-1].head;
		    	teams[teamindex].robot[numofrobot-1].head=teams[teamindex].inventory[counter];
		    	teams[teamindex].inventory[counter]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,100);		    	
			}
			if (teams[teamindex].inventory[numofinventory-1].type.equals("Torso")) {
		    	int counter=0;  //
		    	for (int i = 0; i <teams[teamindex].inventory.length; i++) {
					if (teams[teamindex].inventory[i].name.equals(" ")){
						counter=i;
						break;
					}					
				}
		    	teams[teamindex].inventory[counter]=teams[teamindex].inventory[numofinventory-1];
		    	teams[teamindex].inventory[numofinventory-1]=teams[teamindex].robot[numofrobot-1].torso;
		    	teams[teamindex].robot[numofrobot-1].torso=teams[teamindex].inventory[counter];
		    	teams[teamindex].inventory[counter]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,100);		    	
			}
			if (teams[teamindex].inventory[numofinventory-1].type.equals("Legs")) {
		    	int counter=0;  //
		    	for (int i = 0; i <teams[teamindex].inventory.length; i++) {
					if (teams[teamindex].inventory[i].name.equals(" ")){
						counter=i;
						break;
					}					
				}
		    	teams[teamindex].inventory[counter]=teams[teamindex].inventory[numofinventory-1];
		    	teams[teamindex].inventory[numofinventory-1]=teams[teamindex].robot[numofrobot-1].legs;
		    	teams[teamindex].robot[numofrobot-1].legs=teams[teamindex].inventory[counter];
		    	teams[teamindex].inventory[counter]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,100);		    	
			}
			if (teams[teamindex].inventory[numofinventory-1].type.equals("Arms")) {
		    	int counter=0;  //
		    	for (int i = 0; i <teams[teamindex].inventory.length; i++) {
					if (teams[teamindex].inventory[i].name.equals(" ")){
						counter=i;
						break;
					}					
				}
		    	teams[teamindex].inventory[counter]=teams[teamindex].inventory[numofinventory-1];
		    	teams[teamindex].inventory[numofinventory-1]=teams[teamindex].robot[numofrobot-1].arms;
		    	teams[teamindex].robot[numofrobot-1].arms=teams[teamindex].inventory[counter];
		    	teams[teamindex].inventory[counter]=new Modules(" ", " ", 0, 0, 0, 0, 0, 0,100);		    	
			}
		}
		
	}
			
	public void listRobots(String command)
 {
		int numofteam = Integer.parseInt(command.substring(3,4));
		System.out.println();
		System.out.println("-----Team "+ numofteam+ " Robots-----");
		for (int i = 0; i < teams[numofteam-1].robot.length; i++) {
		if (!(teams[numofteam-1].robot[i].name.equals(" "))) {
			System.out.println(teams[numofteam-1].robot[i].name+" "
				+teams[numofteam-1].robot[i].head.name+"-"+teams[numofteam-1].robot[i].head.durability+"   "
				+teams[numofteam-1].robot[i].torso.name+"-"+teams[numofteam-1].robot[i].torso.durability+"   "
			    +teams[numofteam-1].robot[i].arms.name+"-"+teams[numofteam-1].robot[i].arms.durability+"   "
				+teams[numofteam-1].robot[i].legs.name+"-"+teams[numofteam-1].robot[i].legs.durability+""
						+ "    (Ch: "+teams[numofteam-1].robot[i].getChessScore()+"  Rn: "+teams[numofteam-1].robot[i].getRunscore()+"  Sm: "+teams[numofteam-1].robot[i].getSumoscore()+"  Pp: "+teams[numofteam-1].robot[i].getPingPongScore()+")");

		}	
		else
			continue;
		}		
	}
	
	public void register(String command,int teamindex)
	{

		Robots robot = null;
		int roboindex = Integer.parseInt(command.substring(4,5))-1;
		int gameindex = Integer.parseInt(command.substring(9,10))-1;
		String register[]=command.split(" ");
		boolean flag=true;
		for (int i = 0; i < teams[teamindex].robot.length; i++) {
			if (register[1].equals(teams[teamindex].robot[i].name) && (teams[teamindex].robot[i].arms.durability>60 && teams[teamindex].robot[i].head.durability>60&&teams[teamindex].robot[i].head.durability>60 && teams[teamindex].robot[i].torso.durability>60)) {
				flag=true;
				robot=teams[teamindex].robot[i];
				teams[teamindex].robot[i].arms.durability=teams[teamindex].robot[i].arms.durability-2;
				teams[teamindex].robot[i].head.durability=teams[teamindex].robot[i].head.durability-2;
				teams[teamindex].robot[i].torso.durability=teams[teamindex].robot[i].torso.durability-2;
				teams[teamindex].robot[i].legs.durability=teams[teamindex].robot[i].legs.durability-2;
				break;
				}
				else {
					flag=false;
				}	
		}
			
		if (flag&&register[3].startsWith("c")) {
			chess.Register(robot, teamindex, roboindex,gameindex);
			System.out.println(chess.calculateChessScore(1));	
		}
		else if (flag&&register[3].startsWith("r")) {
			run.Register(robot, teamindex, roboindex,gameindex);
		}
		else if (flag&&register[3].startsWith("s")) {
			sumo.Register(robot, teamindex, roboindex,gameindex);
		}
		else if (flag&&register[3].startsWith("p")) {
			pingpong.Register(robot, teamindex, roboindex,gameindex);
		}
		else{
			if (teamindex==0) {
				System.out.println("There is no robot with this name or One module is not enough durability to play a game");		
			}
		}

	}

	public void play() 
{		
		AI();
		System.out.println("---Games (Results)---");
		week++;
		boolean ChessIsTransferred=false;
		boolean RunIsTransferred=false;
		boolean SumoIsTransferred=false;
		boolean PingPongIsTransferred=false;

		int chesswinner=-1;
		int sumowinner=-1;
		int runwinner=-1;
		int pingpongwinner=-1;
		chesswinner=(Integer)chess.FindChessWinner();
		System.out.println("---RoboChess:"+chess.prize);	
		runwinner=run.FindRunWinner();
		System.out.println("---RoboRun:"+run.prize);		
		sumowinner=sumo.FindSumoWinner();
		System.out.println("---RoboSumo: "+sumo.prize);		
		pingpongwinner=pingpong.FindPingPongWinner();
		System.out.println("---RoboPingPong: "+pingpong.prize);

		if (chesswinner==-1) {
			ChessIsTransferred=true;
		}
		if (ChessIsTransferred) {			
			chess.prize=chess.prize+200;
		}
		else{
		chess.prize=chess.prize+chess.numberofteams()*25;
		teams[chesswinner].credit=teams[chesswinner].credit+chess.prize;
		}
		////
		if (sumowinner==-1) {
			SumoIsTransferred=true;
		}
		if (SumoIsTransferred) {			
			sumo.prize=sumo.prize+200;
		}
		else{
		sumo.prize=sumo.prize+sumo.numberofteams()*25;
		teams[sumowinner].credit=teams[sumowinner].credit+sumo.prize;
		}
		///
		if (runwinner==-1) {
			RunIsTransferred=true;
		}
		if (RunIsTransferred) {			
			run.prize=run.prize+250;
		}
		else{
		run.prize=run.prize+run.numberofteams()*25;
		teams[runwinner].credit=teams[runwinner].credit+run.prize;
		}
		//
		if (pingpongwinner==-1) {
			PingPongIsTransferred=true;
		}
		if (PingPongIsTransferred) {			
			pingpong.prize=pingpong.prize+250;
		}
		else{
		pingpong.prize=pingpong.prize+pingpong.numberofteams()*25;
		teams[pingpongwinner].credit=teams[pingpongwinner].credit+pingpong.prize;
		}
		decreaseDurability();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				chess.Competingteams[i][j]=null;
				pingpong.Competingteams[i][j]=null;
				sumo.Competingteams[i][j]=null;
				run.Competingteams[i][j]=null;

			}
		}
	}
	
	public void AI()
	{
			int randomgame1 = rand.nextInt(4)+1;
			int randomregister1 = rand.nextInt(robotcounter[1]+1)+0;


			if (teams[1].credit>2040&&t1robotindex<10) {
				buildRobot("++ r"+Integer.toString(t1robotindex)+" = tr6 ar6 hd6 lg6",1);
				
				t1robotindex++;
			}
			else if (teams[1].credit>1000&&teams[1].credit<2040&&t1robotindex<10) {
				buildRobot("++ r"+Integer.toString(t1robotindex)+" = tr3 ar3 hd3 lg3",1);
				t1robotindex++;
			}
			else if (teams[1].credit>300&&teams[1].credit<1000&&t1robotindex<10) {
				buildRobot("++ r"+Integer.toString(t1robotindex)+" = tr1 ar2 hd1 lg1",1);
				t1robotindex++;
			}
			for (int i = 0; i < 9; i++) {
				if (!teams[1].robot[i].name.equals(" "))
				{
					if (teams[1].robot[i].arms.durability<=60||teams[1].robot[i].head.durability<=60||teams[1].robot[i].torso.durability<=60||teams[1].robot[i].legs.durability<=60&&robotcounter[1]>=1) {
						sellRobot("sl "+teams[1].robot[i].name, 1);
					}
				}
			}
			if (randomgame1==1) {
				register("rg r"+Integer.toString(randomregister1)+" > c1", 1);
			}
			if (randomgame1==2) {
				register("rg r"+Integer.toString(randomregister1)+" > s1", 1);
			}
			if (randomgame1==3) {
				register("rg r"+Integer.toString(randomregister1)+" > p1", 1);
			}
			if (randomgame1==4) {
				register("rg r"+Integer.toString(randomregister1)+" > r1", 1);
			}
			
			///////////////////////////////////////////////
			int randomgame2 = rand.nextInt(4)+1;
			int randomregister2 = rand.nextInt(robotcounter[1]+1)+0;


			if (teams[2].credit>2040&&t2robotindex<10) {
				buildRobot("++ r"+Integer.toString(t2robotindex)+" = tr6 ar6 hd5 lg6",2);
				
				t2robotindex++;
			}
			else if (teams[2].credit>1000&&teams[2].credit<2040&&t2robotindex<10) {
				buildRobot("++ r"+Integer.toString(t2robotindex)+" = tr2 ar3 hd3 lg3",2);
				t2robotindex++;
			}
			else if (teams[2].credit>300&&teams[2].credit<1000&&t2robotindex<10) {
				buildRobot("++ r"+Integer.toString(t2robotindex)+" = tr1 ar2 hd1 lg1",2);
				t2robotindex++;
			}
			for (int i = 0; i < 9; i++) {
				if (!teams[2].robot[i].name.equals(" "))
				{
					if (teams[2].robot[i].arms.durability<=60||teams[2].robot[i].head.durability<=60||teams[2].robot[i].torso.durability<=60||teams[2].robot[i].legs.durability<=60&&robotcounter[2]>=1) {
						sellRobot("sl "+teams[2].robot[i].name, 2);
					}
				}
			}
			if (randomgame2==1) {
				register("rg r"+Integer.toString(randomregister2)+" > c1", 2);
			}
			if (randomgame2==2) {
				register("rg r"+Integer.toString(randomregister2)+" > s1", 2);
			}
			if (randomgame2==3) {
				register("rg r"+Integer.toString(randomregister2)+" > p1", 2);
			}
			if (randomgame2==4) {
				register("rg r"+Integer.toString(randomregister2)+" > r1", 2);
			}
			////////////////////
			int randomgame3 = rand.nextInt(4)+1;
			int randomregister3 = rand.nextInt(robotcounter[1]+1)+0;


			if (teams[3].credit>2040&&t3robotindex<10) {
				buildRobot("++ r"+Integer.toString(t3robotindex)+" = tr6 ar5 hd6 lg6",3);
				
				t3robotindex++;
			}
			else if (teams[3].credit>1000&&teams[3].credit<2040&&t3robotindex<10) {
				buildRobot("++ r"+Integer.toString(t3robotindex)+" = tr3 ar3 hd3 lg2",3);
				t3robotindex++;
			}
			else if (teams[3].credit>300&&teams[3].credit<1000&&t3robotindex<10) {
				buildRobot("++ r"+Integer.toString(t3robotindex)+" = tr1 ar2 hd1 lg1",3);
				t3robotindex++;
			}
			for (int i = 0; i < 9; i++) {
				if (!teams[3].robot[i].name.equals(" "))
				{
					if (teams[3].robot[i].arms.durability<=60||teams[3].robot[i].head.durability<=60||teams[3].robot[i].torso.durability<=60||teams[3].robot[i].legs.durability<=60&&robotcounter[3]>=1) {
						sellRobot("sl "+teams[3].robot[i].name, 3);
					}
				}
			}
			if (randomgame3==1) {
				register("rg r"+Integer.toString(randomregister3)+" > c1", 3);
			}
			if (randomgame3==2) {
				register("rg r"+Integer.toString(randomregister3)+" > s1", 3);
			}
			if (randomgame3==3) {
				register("rg r"+Integer.toString(randomregister3)+" > p1", 3);
			}
			if (randomgame3==4) {
				register("rg r"+Integer.toString(randomregister3)+" > r1", 3);
			}
			
			//////
			int randomgame4 = rand.nextInt(4)+1;
			int randomregister4 = rand.nextInt(robotcounter[1]+1)+0;


			if (teams[4].credit>2040&&t4robotindex<10) {
				buildRobot("++ r"+Integer.toString(t4robotindex)+" = tr6 ar6 hd6 lg5",4);
				
				t4robotindex++;
			}
			else if (teams[4].credit>1000&&teams[4].credit<2040&&t4robotindex<10) {
				buildRobot("++ r"+Integer.toString(t4robotindex)+" = tr3 ar2 hd3 lg3",4);
				t4robotindex++;
			}
			else if (teams[4].credit>300&&teams[4].credit<1000&&t4robotindex<10) {
				buildRobot("++ r"+Integer.toString(t4robotindex)+" = tr1 ar2 hd1 lg1",4);
				t4robotindex++;
			}
			for (int i = 0; i < 9; i++) {
				if (!teams[4].robot[i].name.equals(" "))
				{
					if (teams[4].robot[i].arms.durability<=60||teams[4].robot[i].head.durability<=60||teams[4].robot[i].torso.durability<=60||teams[4].robot[i].legs.durability<=60&&robotcounter[4]>=1) {
						sellRobot("sl "+teams[4].robot[i].name, 4);
					}
				}
			}
			if (randomgame4==1) {
				register("rg r"+Integer.toString(randomregister4)+" > c1", 4);
			}
			if (randomgame4==2) {
				register("rg r"+Integer.toString(randomregister4)+" > s1", 4);
			}
			if (randomgame4==3) {
				register("rg r"+Integer.toString(randomregister4)+" > p1", 4);
			}
			if (randomgame4==4) {
				register("rg r"+Integer.toString(randomregister4)+" > r1", 4);
			}
			
			/////
			int randomgame5 = rand.nextInt(4)+1;
			int randomregister5 = rand.nextInt(robotcounter[1]+1)+0;


			if (teams[5].credit>2040&&t4robotindex<10) {
				buildRobot("++ r"+Integer.toString(t5robotindex)+" = tr6 ar5 hd6 lg6",5);
				
				t5robotindex++;
			}
			else if (teams[5].credit>1000&&teams[5].credit<2040&&t5robotindex<10) {
				buildRobot("++ r"+Integer.toString(t5robotindex)+" = tr3 ar3 hd2 lg3",5);
				t5robotindex++;
			}
			else if (teams[5].credit>300&&teams[5].credit<1000&&t5robotindex<10) {
				buildRobot("++ r"+Integer.toString(t5robotindex)+" = tr1 ar2 hd1 lg1",5);
				t5robotindex++;
			}
			for (int i = 0; i < 9; i++) {
				if (!teams[5].robot[i].name.equals(" "))
				{
					if (teams[5].robot[i].arms.durability<=60||teams[5].robot[i].head.durability<=60||teams[5].robot[i].torso.durability<=60||teams[5].robot[i].legs.durability<=60&&robotcounter[5]>=1) {
						sellRobot("sl "+teams[5].robot[i].name, 5);
					}
				}
			}
			if (randomgame5==1) {
				register("rg r"+Integer.toString(randomregister5)+" > c1", 5);
			}
			if (randomgame5==2) {
				register("rg r"+Integer.toString(randomregister5)+" > s1", 5);
			}
			if (randomgame5==3) {
				register("rg r"+Integer.toString(randomregister5)+" > p1", 5);
			}
			if (randomgame5==4) {
				register("rg r"+Integer.toString(randomregister5)+" > r1", 5);
			}
			
	}
}

  
	


