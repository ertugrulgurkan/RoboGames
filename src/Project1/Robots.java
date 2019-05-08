package Project1;
public class Robots {
String name;
 Modules[] robotinventory=new Modules[4];
int robotnumber;
Modules head;
Modules arms;
Modules legs;
Modules torso;

public double getweight(){
	double totalweight;
	totalweight=head.weight+torso.weight+arms.weight+legs.weight;
	return totalweight;

}

public double calculetespeed(){			
	double speed;
	speed = (250* legs.force)/ getweight();
	return speed;
}

public double getChessScore(){
	double chessscore;
	chessscore=head.intellegence*(head.durability/100);
	return chessscore;
}
public double getRunscore(){
	double runscore;
	runscore=calculetespeed()*(legs.durability/100);
	return runscore;
}
public double getSumoscore(){
	double sumoscore;
	sumoscore=(torso.force*(torso.durability/100)*0.3)+ (legs.force*(legs.durability/100)*0.7);
	return sumoscore;
}
public double getPingPongScore(){
	double PingPongscore;
	PingPongscore=(arms.skill*(arms.durability/100)*0.6)+(head.intellegence * (head.durability/100)*0.2)+ (calculetespeed()*(legs.durability/100)*0.2);
	return PingPongscore;
}

}
