package pcd.lab02.check_act;

public class WorkerB extends Thread {

    private final BoundedCounter counter;
    private int ntimes;

    public WorkerB(BoundedCounter c, int ntimes) {
        counter = c;
        this.ntimes = ntimes;
    }

    public void run() {
        try {
            for (int i = 0; i < ntimes; i++) {
                synchronized (counter) {//azione atomica, cioè eseguo due cose insieme come unica cosa e poi lascio.
                    if (counter.getValue() < 1) {
                        counter.inc();
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
