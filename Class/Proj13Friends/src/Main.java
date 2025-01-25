import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        RangeFriends friends = new RangeFriends(1, 100);
        long timeBegin = System.currentTimeMillis();

        //friends.friends();

        //long timeEnd = System.currentTimeMillis() - timeBegin;
        //System.out.println(timeEnd / 1000);
        long timeEnd = System.currentTimeMillis() - timeBegin;
        System.out.println("Tiempo de ejecución: " + timeEnd / 1000.0 + " segundos");

        // 100 - 0.002
        // 3000 - 34
        // 10000 - 1137

        try {
            System.out.println(friends.getFriends());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}