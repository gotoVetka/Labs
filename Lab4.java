import java.util.*;
import java.util.regex.*;

public class Lab4{
	public static void main(String[] args){
		Race races_array [] = new Race[10];

		for(int index = 0; index < races_array.length; index++){
            races_array[index] = new Race(index+1, "11.09.2001", 10, true);
            races_array[index].printRecord();
        }

		int allParticipantsCount=0, withPrizeCount=0;

		for(Race example : races_array){
			allParticipantsCount+=example.getParticipantsCount();
			if(example.withPrize)withPrizeCount++;
		}
		System.out.println("\nAll participants count:" + allParticipantsCount + "\nRaces with prize: " + withPrizeCount);
	}
}

// package Race
public class Race{

    protected int raceIndex;
	protected String date;
	protected int participants_count;
	protected boolean withPrize;
	
	Race(){
        this.raceIndex = 0;
		this.date = "";
		this.participants_count = 0;
		this.withPrize = false;
	}
	Race(int raceIndex, String date, int participants_count, boolean withPrize){

		Matcher matcher = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.(\\d{4})$").matcher(date);
		this.raceIndex = raceIndex >= 0 ? raceIndex : -1;
		this.participants_count = participants_count >= 0 ? participants_count : -1;
		this.date = matcher.find() ? date : "Invalid date format";
		this.withPrize = withPrize;

	}
	public int getParticipantsCount(){
		return this.participants_count;
	}
	public boolean withPrize(){
		return this.withPrize;
	}
	public void printRecord(){
		System.out.println("\nRace:\nRace Index: " +  this.raceIndex + "\nDate: " + date + "\nParticipants count: " + participants_count + "\nWith Prize: " + withPrize);
	}
} 