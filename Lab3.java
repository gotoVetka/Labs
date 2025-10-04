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
    protected float carWeight;
    protected float mileage;

    public Auto(){

    }

    public Auto(String mark, boolean isDiesel, int power, float carWeight, float mileage){
        this.mark = mark;
        this.isDiesel = isDiesel;
        this.power = power;
        this.carWeight = carWeight;
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

    public float getcarWeight(){
        return carWeight;
    }

    public float getMileage(){
        return mileage;
    }

    public void setMark(String newMark){
        this.mark = newMark;
    }
    
    public void setDiesel(boolean newStatus){
        this.isDiesel = newStatus;
    }

    public void setPower(int newPower){
        this.power = newPower;
    }

    public void setCarWeight(float newCarWeight){
        this.carWeight = newCarWeight;
    }

    public void setMileage(float newMileage){
        this.mileage = newMileage;
    }

    public void getGeneralInfo(){
        System.out.println("General Car Info:");
        System.out.println("Mark: " + mark);
        System.out.println("IsDiesel: " + isDiesel);
        System.out.println("Power: " + power);
        System.out.println("Car Weight: " + carWeight);
        System.out.println("Mileage: " + mileage);
    }
}

public class LightCar extends Auto{

    protected float per100km;
    protected float acceleration;

    public LightCar(String mark, boolean isDiesel, int power, float carWeight, float mileage, float per100km, float acceleration){
        super(mark, isDiesel, power, carWeight, mileage);
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

    public void setPer(float newPer){
        this.per100km = newPer;
    }

    public void setAcceleration(float newAcceleration){
        this.acceleration = newAcceleration;
    }

    public void getLightCarInfo(){
        this.getGeneralInfo();
        System.out.println("Light Car Info: ");
        System.out.println("Per 100 km: " + per100km);
        System.out.println("Acceleration: " + acceleration);
    }
}

public class HeavyCar extends Auto{

    float maxCargoWeight;
    public HeavyCar(String mark, boolean isDiesel, int power, float carWeight, float mileage, float maxCargoWeight){
        super(mark, isDiesel, power, carWeight, mileage);
        this.maxCargoWeight = maxCargoWeight;
    }
    public HeavyCar(){

    }
    public float getMaxWeight() {
        return maxCargoWeight;
    }

    public void getHeavyCarInfo(){
        this.getGeneralInfo();
        System.out.println("Heavy Car Info: " + maxCargoWeight);
    }
}
