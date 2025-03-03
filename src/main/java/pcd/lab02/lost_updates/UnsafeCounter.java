package pcd.lab02.lost_updates;

public class UnsafeCounter {
    private int cont;

    public UnsafeCounter(int base) {
        this.cont = base;
    }

    public synchronized void inc() {
        cont++;
    }

    public synchronized int getValue() {
        return cont;
    }
}
