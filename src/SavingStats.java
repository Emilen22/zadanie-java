import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

class SumNumbers {
    public static final String EXIT = "exit";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName = "stats.txt";
        File file = new File(fileName);

        boolean fileExists = file.exists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
                var fileWriter = new FileWriter(fileName);
                var writer = new BufferedWriter(fileWriter);
                writer.write("list.add(num)");
                writer.newLine();
                
            } catch (IOException e) {
                System.out.println("Nie udało się utworzyć pliku");
            }
        }

        if (fileExists)
            System.out.println("Plik " + fileName + " istnieje lub został utworzony");

        List<Double> numbers = new ArrayList<>();
        fillList(numbers);
    }

    static void fillList(List<Double> list) {
        System.out.println("Podaj wynik kolejnego gracza (lub wpisz \"exit\"): ");

        String input = sc.nextLine();
        if (input.equals(SumNumbers.EXIT))
            return;

        try {
            Double num = Double.valueOf(input);
            list.add(num);
        } catch (NumberFormatException e) {
            System.err.println("Błąd Zapisu");
        }

        fillList(list);
    }
}

