import java.io.*; 
import java.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
        System.out.println("=== ЧТЕНИЕ ИЗ ФАЙЛА ==="); 
         
        // Список для хранения чисел 
        List<Integer> numbers = new ArrayList<>(); 
         
        // ----- ЧТЕНИЕ ИЗ ФАЙЛА ----- 
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) { 
            String line; 
            while ((line = reader.readLine()) != null) { 
                int num = Integer.parseInt(line.trim()); 
                numbers.add(num); 
                System.out.println("Прочитано: " + num); 
            } 
        } catch (FileNotFoundException e) { 
            System.out.println("ОШИБКА: Файл input.txt не найден!"); 
            return; 
        } catch (IOException e) { 
            System.out.println("ОШИБКА при чтении: " + e.getMessage()); 
            return; 
        } 
         
        System.out.println("Всего чисел: " + numbers.size()); 
         
        // ----- ОБРАБОТКА ДАННЫХ ----- 
        int sum = 0; 
        for (int num : numbers) { 
            sum += num; 
        } 
        System.out.println("Сумма чисел: " + sum); 
         
        // ----- ЗАПИСЬ В ФАЙЛ ----- 
        System.out.println("\n=== ЗАПИСЬ В ФАЙЛ ==="); 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) { 
            writer.write("Результат обработки:"); 
            writer.newLine(); 
            writer.write("Всего чисел: " + numbers.size()); 
            writer.newLine(); 
            writer.write("Сумма чисел: " + sum); 
            writer.newLine(); 
             
            double average = numbers.isEmpty() ? 0 : (double) sum / numbers.size(); 
            writer.write("Среднее: " + average); 
             
            System.out.println("Результат записан в output.txt"); 
        } catch (IOException e) { 
            System.out.println("ОШИБКА при записи: " + e.getMessage()); 
        } 
    } 
} 