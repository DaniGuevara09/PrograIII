import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyThread {
    private final int rangeBegin;
    private final int rangeEnd;
    private final Map<Integer, Integer> friends;

    public MyThread(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
        this.friends = new ConcurrentHashMap<>();
    }

    private int sumOfDivisors(int n) {
        int sum = 1; // 1 siempre es divisor
        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) { // Si no es un divisor cuadrado
                    sum += n / i;
                }
            }
        }
        return sum;
    }

    public class RangeTask implements Runnable {
        private final int start;
        private final int end;
        private final Map<Integer, Integer> divisorSums;

        public RangeTask(int start, int end, Map<Integer, Integer> divisorSums) {
            this.start = start;
            this.end = end;
            this.divisorSums = divisorSums;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                int sum = divisorSums.getOrDefault(i, sumOfDivisors(i));
                divisorSums.putIfAbsent(i, sum);

                if (sum > i && sum <= rangeEnd) { // Evita duplicados
                    int reverseSum = divisorSums.getOrDefault(sum, sumOfDivisors(sum));
                    divisorSums.putIfAbsent(sum, reverseSum);

                    if (reverseSum == i) {
                        friends.put(i, sum);
                    }
                }
            }
        }
    }

    public void findFriendsWithThreads(int threadCount) {
        int rangeSize = (rangeEnd - rangeBegin) / threadCount;
        Thread[] threads = new Thread[threadCount];
        Map<Integer, Integer> divisorSums = new ConcurrentHashMap<>();

        for (int i = 0; i < threadCount; i++) {
            int start = rangeBegin + i * rangeSize;
            int end = (i == threadCount - 1) ? rangeEnd : start + rangeSize;

            threads[i] = new Thread(new RangeTask(start, end, divisorSums));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printFriends() {
        friends.forEach((a, b) ->
                System.out.println("Amigos: " + a + " y " + b)
        );
    }
}
