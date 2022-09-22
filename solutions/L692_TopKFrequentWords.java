package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class L692_TopKFrequentWords {

  public static void main(String[] args) {

      String[] words  = {"elk", "i", "love", "joe", "rogan", "elk", "lsd", "medidate", "exercise", "elk", "i", "joe", "rogan"};
      int k = 3;
      List<String> topK = topKFrequent(words, k);
      for (String s : topK) System.out.println(s);
  }

    public static List<String> topKFrequent(String[] words, int k) {

        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        // RE : important use of comparator
        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>((a,b) -> Objects.equals(a.getValue(), b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> m : map.entrySet())
        {
            pq.offer(m);
            if(pq.size() > k)
                pq.poll();
        }

        // RE : important step -> specifying index so that returned in the opposite order -> last element polled alwasys at top and
        // rest pushed to the side
        while(!pq.isEmpty())
            res.add(0, pq.poll().getKey());

        return res;
    }
}
