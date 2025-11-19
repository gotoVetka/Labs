import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

public class Lab5{
    public static void main(String[] args) {
        String input = "input.txt";
        String output = "output.txt";
        CReader reader = new CReader(input);
        CWriter writer = new CWriter(output);
        CParser parser = new CParser("^[A-Za-z]+\\|\\d+\\|\\d+\\|\\d+$");
        ArrayList<String> strings = reader.readLines();
        ArrayList<Teapot> teapots = parser.parseTeapots(strings);
        teapots.sort(CComparator.BY_BRAND);
        writer.writeToFile(output, teapots);
    }
}

//package Teapot
public class Teapot{
    private String brand;
    private int power;
    private int avgWorkTime;
    private int usingCost;
    
    public Teapot(String brand, int power, int avgWorkTime, int usingCost) {
        this.brand = brand != null ? brand : "Null";
        this.power = power > 0 ? power : -1;
        this.avgWorkTime = avgWorkTime > 0 ? avgWorkTime : -1;
        this.usingCost = usingCost > 0 ? usingCost : -1;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAvgWorkTime() {
        return avgWorkTime;
    }

    public void setAvgWorkTime(int avgWorkTime) {
        this.avgWorkTime = avgWorkTime;
    }

    public int getUsingCost() {
        return usingCost;
    }

    public void setUsingCost(int usingCost) {
        this.usingCost = usingCost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + power;
        result = prime * result + avgWorkTime;
        result = prime * result + usingCost;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null || getClass() == obj.getClass()) return false;
        Teapot other = (Teapot) obj;
        return this.hashCode() == other.hashCode();  
    }
    
    @Override
    public String toString() {
        return brand + "|" + power + "|" + avgWorkTime + "|" + 
                + usingCost;
    }
    

}

//package CReader
public class CReader {
  private static String filename;

  public CReader(String inputFile){
    filename = inputFile;
  }

  public ArrayList<String> readLines(){
    ArrayList<String> strings = new ArrayList<>();
    if(filename.isBlank()){
      return strings;
    }
    try(BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)){
      String line;
      while ((line = reader.readLine()) != null) {
        strings.add(line);
      }
    } catch (IOException exception){
      System.err.println("Ошибка при записи файла: " + exception.getMessage());
    }
    return strings;
  }
}


//package CWriter
public class CWriter {
  private static String output;

  public CWriter(String filename){
    output = filename;
  }

  public void writeToFile(String filename, ArrayList<Teapot> objList){
    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(output), StandardCharsets.UTF_8)) {
      for (Teapot obj : objList) {
        bw.write(obj.toString());
        bw.newLine();
      }
      System.out.println("Результат записан в " + output);
    } catch (IOException e) {
       System.err.println("Ошибка при записи файла: " + e.getMessage());
    }
  }
}

//package CParser
public class CParser{
  private static String stringPatternRegex;

  public CParser(String regex){

    stringPatternRegex = regex;
  }

  public ArrayList<Teapot> parseTeapots(ArrayList<String> strings){
    Pattern pattern = Pattern.compile(stringPatternRegex);
    ArrayList<Teapot> teapots = new ArrayList<>();
    strings.removeIf(string -> !pattern.matcher(string).matches());
    for(String line : strings){
      String[] params = line.split("\\|");
      teapots.add(new Teapot(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3])));
    }
    return teapots;
  }
}

//package CComparotor
public enum CComparator implements Comparator<Teapot> {
  BY_BRAND{
    @Override
    public int compare(Teapot t1, Teapot t2){
      return t1.getBrand().compareTo(t2.getBrand());
    }
  },
  BY_AVG_TIME{
    @Override
    public int compare(Teapot t1, Teapot t2){
      return Integer.compare(t1.getAvgWorkTime(), t2.getAvgWorkTime());
    }
  },
  BY_POWER{
    @Override
    public int compare(Teapot t1, Teapot t2){
      return Integer.compare(t1.getPower(), t2.getPower());
    }
  },
  BY_USING_COST{
    @Override
    public int compare(Teapot t1, Teapot t2){
      return Integer.compare(t1.getUsingCost(), t2.getUsingCost());
    }
  }
}