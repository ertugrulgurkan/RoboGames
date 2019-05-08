package Project1;

public class Modules {
	double weight,force;
	double price;
	double intellegence;
	double skill;
	double durability;
	double quality;
	String type,name;
	public Modules(String name,String typ,double qual,double price_value,double weight_value,double force_value, double int_value,double skill_value,int durability)
	{
		price=price_value; weight=weight_value; force=force_value;intellegence=int_value; skill=skill_value;
		type=typ;	
		quality=qual;
		this.name=name;
		this.durability=durability;
	}

	
}
