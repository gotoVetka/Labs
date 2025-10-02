import java.util.*;
public class Lab3 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){

    }
}
public class Auto{
    protected String mark;
    protected boolean isDiesel;
    protected int power;
    protected float weight;
    protected float mileage;

    public Auto(){

    }

    public Auto(String mark, boolean isDiesel, int power, float weight, float mileage){
        this.mark = mark;
        this.isDiesel = isDiesel;
        this.power = power;
        this.weight = weight;
        this.mileage = mileage;
    }

    public String getMark(){
        return mark;
    }

    public boolean isAutoDiesel(){
        return isDiesel;
    }

    public int getPower(){
        return power;
    }

    public float getWeight(){
        return weight;
    }

    public float getMileage(){
        return mileage;
    }

    public void report(){
        System.out.println("Mark: " + mark);
        System.out.println("IsDiesel: " + isDiesel);
        System.out.println("Power: " + power);
        System.out.println("Weight: " + weight);
        System.out.println("Mileage: " + mileage);
    }
}

public class LightCar extends Auto{
    protected float per100km;
    protected float acceleration;

    public LightCar(String mark, boolean isDiesel, float weight, float mileage, float per100km, float acceleration){
        super(mark, isDiesel, weight, mileage);
        this.per100km = per100km;
        this.acceleration = acceleration;
    }

    public LightCar(){
    }

    public float getPer100km(){
        return per100km;
    }

    public float getAcceleration(){
        return acceleration;
    }

    @Override
    public void report(){
        System.out.println("Mark: " + mark);
        System.out.println("IsDiesel: " + isDiesel);
        System.out.println("Power: " + power);
        System.out.println("Weight: " + weight);
        System.out.println("Mileage: " + mileage);
        System.out.println("Per 100 km: " + per100km);
        System.out.println("Acceleration: " + acceleration);
    }
}
public class HeavyCar extends Auto{
    
}
