package Project1;

public class Teams {
	public Modules[] inventory=new Modules[20];
	public Robots[] robot= new Robots[9];
	public double credit=1500;
	public int type;
	public int robotcounter;
	public void addRobot(Robots robots) {
		robot[robotcounter] = robots;
		robotcounter++;
		 }
	
	public int findEmptySpace(){
		int i = 0;
		for (int s = 0; s < 21; s++) {
			if (inventory[s].name.equals(" ")) {
				i=s;
				break;
			}
		}
		return i;
	}

}
