import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

public class Lab6{
  public static void main(String[] args) {
    CReader reader = new CReader("input.txt");
    CWriter writer = new CWriter("output.txt");
    CParser parser = new CParser("^\\d+\\|\\w+\\|\\w+\\|\\d+$");
    ArrayList<String> strings = reader.readLines();
    strings.forEach(System.out::println);
    ArrayList<Computer> computers = parser.parseComputers(strings);
    computers.forEach(System.out::println);
    writer.writeToFile(computers);
  }
}

public class Computer{
  private int cpu_frequency;
  private String ram;
  private String gpu;
  private int production;

  public Computer(int cpu_frequency, String ram, String gpu, int production) {
    this.cpu_frequency = cpu_frequency;
    this.ram = !ram.isBlank() ? ram : "null";
    this.gpu = !gpu.isBlank() ? gpu : "null" ;
    this.production = production;
    System.out.println("new Computer: " + this.toString());
  }

  public int getCpu_frequency() {
    return cpu_frequency;
  }

  public void setCpu_frequency(int cpu_frequency) {
    this.cpu_frequency = cpu_frequency;
  }

  public String getRam() {
    return ram;
  }

  public void setRam(String ram) {
    if(!ram.isBlank()){
      this.ram = ram;
    }
  }

  public String getGpu() {
    return gpu;
  }

  public void setGpu(String gpu) {
    if(!gpu.isBlank()){
      this.gpu = gpu;
    }
  }

  public int getProduction() {
    return production;
  }

  @Override
  public String toString(){
    StringJoiner str = new StringJoiner("|");
    return str.add(Integer.toString(cpu_frequency)).
            add(ram).
            add(gpu).
            add(Integer.toString(production)).toString();
  }
}

//package CReader
public class CReader {
  private static String filename;

  public CReader(String inputFile){
    filename = inputFile;
  }

  public ArrayList<String> readLines(){
    System.out.println("Reading file " + filename);
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
      System.err.println("Error in readning file: " + exception.getMessage());
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

  public void writeToFile(ArrayList<Computer> objList){
    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(output), StandardCharsets.UTF_8)) {
      for (Computer obj : objList) {
        //System.out.println(obj.toftring());
        bw.write(obj.toString());
        bw.newLine();
      }
      System.out.println("Succefully writed into " + output);
    } catch (IOException e) {
      System.err.println("Error in writing to file: " + e.getMessage());
    }
  }
}

//package CParser
public class CParser{
  private static String stringPatternRegex;
  public CParser(String regex){
    stringPatternRegex = regex;
  }

  public ArrayList<Computer> parseComputers(ArrayList<String> strings){
    System.out.println("Parsing strings");
    Pattern pattern = Pattern.compile(stringPatternRegex);
    String[] params;
    ArrayList<Computer> computers = new ArrayList<>();
    strings.removeIf(string -> !pattern.matcher(string).matches());
    for( String line : strings ){
      params = line.split("\\|");
      computers.add(new Computer(Integer.parseInt(params[0]), params[1], params[2], Integer.parseInt(params[3])));
    }
    return computers;
  }
}

//package CComparotor
public enum CComparator implements Comparator<Computer> {
  BY_CPU{
    @Override
    public int compare(Computer c1, Computer c2){
      return Integer.compare(c1.getCpu_frequency(), c2.getCpu_frequency());
    }
  },
  BY_RAM{
    @Override
    public int compare(Computer c1, Computer c2){
      return c1.getRam().compareTo(c2.getRam());
    }
  },
  BY_GPU{
    @Override
    public int compare(Computer c1, Computer c2){
      return c1.getGpu().compareTo(c2.getGpu());
    }
  },
  BY_PRODUCTION{
    @Override
    public int compare(Computer c1, Computer c2){
      return Integer.compare(c1.getProduction(), c2.getProduction());
    }
  }
}