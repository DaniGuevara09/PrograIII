public class Runn {
    public static void main(String[] args) {
        long timeBegin = System.currentTimeMillis();

        //MyThread m1 = new MyThread(1, 3000);
        //MyThread m2 = new MyThread(1, 3000);
        //MyThread m3 = new MyThread(1, 10000);

        // Thread t1 = new Thread(m1);
        // Thread t2 = new Thread(m2);
        // Thread t3 = new Thread(m3);

        //t1.start();
        //t2.start();
        //t3.start();

        /*
        try {
            //t1.join();
            //t2.join();
            //t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        */

        MyThread rangeFriends = new MyThread(1, 10000);
        rangeFriends.findFriendsWithThreads(1); // Usa 4 hilos

        // Imprime los números amigos encontrados
        rangeFriends.printFriends();

        long timeEnd = System.currentTimeMillis() - timeBegin;
        System.out.println("Tiempo de ejecución: " + timeEnd / 1000.0 + " segundos");

        // 0.005
        // 34.407

        // 0.003
        // 0.018
        // 0.022
    }
}
