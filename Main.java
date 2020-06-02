import core.ManagerControllerImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerControllerImpl managerController = new ManagerControllerImpl();
        String line = scanner.nextLine();

        while (!line.equals("Report")) {
            String[] data = line.split(" ");
            String type = data[1];
            String name = data[2];
            if (data[0].equals("AddCard")) {
                System.out.println(managerController.addPlayer(type, name));
            } else if (line.contains("AddCard")) {
                System.out.println(managerController.addCard(type, name));
            } else if (data[0].equals("AddPlayerCard")) {
                System.out.println(managerController.addPlayerCard(type, name));
            } else if (line.contains("Fight")) {
                System.out.println(managerController.fight(type, name));
            }

            line = scanner.nextLine();
        }


        System.out.println("Hello World!");
    }
}
