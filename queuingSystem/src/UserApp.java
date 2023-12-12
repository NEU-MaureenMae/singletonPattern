import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        CentralizedQueueSystem queueSystem = CentralizedQueueSystem.getInstance();

        HelpDeskStation station1 = new HelpDeskStation(queueSystem, "Station 1");
        HelpDeskStation station2 = new HelpDeskStation(queueSystem, "Station 2");

        Scanner scanner = new Scanner(System.in);
        int stationChoice = -1;

        System.out.println("HELPDESK STATION");
        while (stationChoice != 0) {
            System.out.println("\nSelect a station:");
            System.out.println("1. Station 1");
            System.out.println("2. Station 2");
            System.out.println("0. Exit");

            System.out.print("Enter station: ");
            stationChoice = scanner.nextInt();

            switch (stationChoice) {
                case 1:
                    performStationActions(station1, scanner);
                    break;
                case 2:
                    performStationActions(station2, scanner);
                    break;
                case 0:
                    System.out.println("Exiting Queue Manager...");
                    break;
                default:
                    System.out.println("Invalid station choice. Please select again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void performStationActions(HelpDeskStation station, Scanner scanner) {
        int actionChoice = -1;

        while (actionChoice != 0) {
            System.out.println("\nStation: " + station.getStationName());
            System.out.println("Select an action:");
            System.out.println("1. Serve next customer");
            System.out.println("2. Display current queue number");
            System.out.println("3. Reset queue number");
            System.out.println("0. Go back to station selection");

            System.out.print("Enter action choice: ");
            actionChoice = scanner.nextInt();

            switch (actionChoice) {
                case 1:
                    station.serveNextCustomer();
                    break;
                case 2:
                    station.displayCurrentNumber();
                    break;
                case 3:
                    System.out.print("Enter new queue number: ");
                    int newNumber = scanner.nextInt();
                    station.resetQueueNumber(newNumber);
                    break;
                case 0:
                    System.out.println("Going back to station selection...");
                    break;
                default:
                    System.out.println("Invalid action choice. Please select again.");
                    break;
            }
        }
    }
}
