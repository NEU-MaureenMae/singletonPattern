public class HelpDeskStation {
    private CentralizedQueueSystem queueSystem;
    private String stationName;

    public HelpDeskStation(CentralizedQueueSystem queueSystem, String stationName) {
        this.queueSystem = queueSystem;
        this.stationName = stationName;
    }

    public String getStationName() {
        return stationName;
    }

    public void displayCurrentNumber() {
        int currentNumber = queueSystem.getCurrentQueueNumber();
        System.out.println("-- CURRENT QUEUE NUMBER " + ": " + currentNumber + " --");
    }

    public void resetQueueNumber(int newNumber) {
        queueSystem.resetQueueNumber(newNumber);
        System.out.println("Queue number reset by " + stationName + " to: " + newNumber);
    }

    public void serveNextCustomer() {
        queueSystem.increaseQueueNumber();
        System.out.println("Next customer served at " + stationName + ".\n-- CURRENT QUEUE NUMBER IS NOW: " + queueSystem.getCurrentQueueNumber()+ " --");
    }
}