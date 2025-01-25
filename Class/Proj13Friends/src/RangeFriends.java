import java.util.HashMap;

public class RangeFriends {
    private int rangeBegin;
    private int rangeEnd;
    private HashMap<Integer, Integer> friends;

    public RangeFriends(int rangeBegin, int rangeEnd) {
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
        this.friends = new HashMap<>();
    }

    public int getRangeBegin() {
        return rangeBegin;
    }

    public void setRangeBegin(int rangeBegin) {
        this.rangeBegin = rangeBegin;
    }

    public HashMap<Integer, Integer> getFriends() {
        return friends;
    }

    public void setFriends(int a, int b) {
        friends.put(a, b);
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public int sum (int n){
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public void friends(){
        for (int i = rangeBegin; i < rangeEnd; i++) {
            for (int j = 1; j < i; j++) {
                if (sum(i) == j && sum(j) == i) {
                    setFriends(j, i);
                }
            }
        }
    }
}
