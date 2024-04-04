import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Практическое задание № 1.12, РИБО-03-22, Тувыкин Михаил Денисович, Вариант №4");
        System.out.println("Перейти к заполнению полей? (1 - Да, 2 - Вывести путь к файлу): ");

        String filePath = "C:\\Plant.bin";

        int flag = -1;
        Scanner scanner = new Scanner(System.in);
        while (flag < 1 || flag > 2) {
            if (scanner.hasNextInt()) {
                flag = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
            }
        }

        while (flag != 2) {
            String fio = "";
            while (fio.isBlank()) {
                System.out.println("Введите Название растения: ");
                fio = scanner.nextLine();
            }
            int dlin = 0;
            while (dlin <= 0.00001 || dlin >= 1000000) {
                System.out.println("Введите Длину растения: ");
                if (scanner.hasNextInt()) {
                    dlin = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                }
            }
            int lepest = 0;
            while (lepest <= 0.00001 || lepest >= 1000000) {
                System.out.println("Введите Кол-во лепестков растения: ");
                if (scanner.hasNextInt()) {
                    lepest = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                }
            }
            String cvet = "";
            while (cvet.isBlank()) {
                System.out.println("Введите Цвет растения: ");
                cvet = scanner.nextLine();
            }

            boolean gorsh;
            System.out.println("Растение в горшке?(true/false): ");
            while (!scanner.hasNextBoolean()) {
                System.out.println("Растение в горшке?(true/false): ");
                scanner.nextLine();
            }
            gorsh = scanner.nextBoolean();
            Plant plant = new Plant(fio, lepest, dlin, cvet, gorsh);

            PlantSerializer serializer = new PlantSerializer(plant, filePath);
            Thread th = new Thread(serializer);
            th.start();

            flag = -1;
            while (flag < 1 || flag > 2) {
                System.out.println("Перейти к заполнению полей заново? (1 - Да, 2 - Создать файл и вывести путь к нему): ");
                if (scanner.hasNextInt()) {
                    flag = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    scanner.nextLine();
                }
            }
        }
        System.out.println("Путь к файлу: " + filePath);
    }
}
