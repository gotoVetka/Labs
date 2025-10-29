import java.util.*;

public class Lab4{
	public static void main(String[] args){
		Race[] races_array = new Race[10];
		for(Race race : races_array){
			race.printRecord();	
		}	
	}
}

public class Race{
	String date = "";
	int participants_count = 0;
	boolean withPrize = false;
	
	Race(){
		this.date = "";
		this.participants_count = 0;
		this.withPrize = false;
	}
	Race(String date, int participants_count, boolean withPrize){
		this.date = date;
		this.participants_count = participants_count;
		this.withPrize = false;
	}
	public int returnCount(){
		return this.participants_count;
	}
	public boolean withPrize(){
		return this.withPrize;
	}
	public void printRecord(){
		System.out.println("\nRace:\nDate: " + this.date + "\nParticipants count: " + this.participants_count + "\nWith Prize: " + this.withPrize);
	}
} 
