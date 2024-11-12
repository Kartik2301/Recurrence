package ZJava.LockFreeConcurrencyControl;

public class RaceCondition {
    private int count;

    public RaceCondition() {
        this.count = 0;;
    }

    public void increment() {
        count++;
    }

    public int getCounter() {
        return count;
    }
}
