public class CentralizedQueueSystem {
    private static CentralizedQueueSystem instance;
    private int currentQueueNumber;

    private CentralizedQueueSystem() {
        this.currentQueueNumber = 0;
    }

    public static CentralizedQueueSystem getInstance() {
        if (instance == null) {
            synchronized (CentralizedQueueSystem.class) {
                if (instance == null) {
                    instance = new CentralizedQueueSystem();
                }
            }
        }
        return instance;
    }

    public int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    public void resetQueueNumber(int newNumber) {
        this.currentQueueNumber = newNumber;
    }

    public void increaseQueueNumber() {
        this.currentQueueNumber++;
    }
}