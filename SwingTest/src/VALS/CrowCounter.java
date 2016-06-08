package VALS;

/**
 * Created on 31.01.2016
 */
public class CrowCounter {

    private static CrowCounter instance;
    private static int crows = 0;

    public int getCrows() {
        return crows;
    }

    public static void setCrows(int crows) {
        CrowCounter.crows = crows;
    }

    private CrowCounter() {
    }



    public static CrowCounter getInstance() {
        synchronized (CrowCounter.class) {
            if (instance == null) {
                instance = new CrowCounter();
            }
            return instance;
        }
    }


    public void setCrows(int i) {
    }
}
