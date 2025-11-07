import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Lab5{
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        List<Teapot> list = new ArrayList<>();

        // Чтение txt (brand, power, avgWorkTime, usingCost)
        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputPath), StandardCharsets.UTF_8)) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;
                // Разделие по запятой, допускаем простую txt без кавычек
                String[] parts = line.split(",", -1);
                if (parts.length < 3) {
                    System.err.println("Пропущено поле в строке " + lineNo + ": " + line);
                    continue;
                }
                try {
                    String brand = parts[0].trim();
                    int power = Integer.parseInt(parts[1].trim());
                    int avgWorkTime = Integer.parseInt(parts[2].trim());
                    int usingCost = Integer.parseInt(parts[3].trim());
                    list.add(new Teapot(brand, power, avgWorkTime, usingCost));
                } catch (NumberFormatException ex) {
                    System.err.println("Ошибка парсинга в строке " + lineNo + ": " + line);
                }
            }
        } catch (IOException exception) {
            System.err.println("Ошибка при чтении файла: " + exception.getMessage());
            return;
        }

        // Сортировка (Comparable реализован в Teapot)
        Collections.sort(list);

        // Запись в удобочитаемом формате
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputPath), StandardCharsets.UTF_8)) {
            for (Teapot teapot : list) {
                bw.write(teapot.toString());
                bw.newLine();
            }
            System.out.println("Результат записан в " + outputPath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
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
    public int compareTo(Teapot other) {
        if (other == null) return 1;
        // Сортировка по возрастанию текстового поля name (лексикографически, с учетом локали JVM)
        return this.brand.compareTo(other.brand);
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
        return "Teapot [brand=" + brand + ", power=" + power + ", avgWorkTime=" + avgWorkTime + ", usingCost="
                + usingCost + "]";
    }
    

}