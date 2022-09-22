package solutions;

import java.util.PriorityQueue;

public class L1046_LastStoneWeight {
  public static void main(String[] args) {
    //
  }

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for(int s : stones)
            pq.offer(s);

        while(pq.size() > 1)
        {
            int a = pq.poll(), b = pq.poll();
            if(a!=b)
                pq.offer(a-b);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
