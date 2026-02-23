package CollectionsFramework.Basics;

import java.util.*;

public class MapTutorial {
    /*
    LinkedHashMap is just like a Map but it is ordered, use when solving LRU problems
    TreeMap - in this implementation every element is sorted
     */
    public static void main(String[] args) {
        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("Ilnur", 100);
        scoreMap.put("Alex", 35);
        scoreMap.put("Dave", 56);

        System.out.println(scoreMap.get("Ilnur"));
        System.out.println(scoreMap.getOrDefault("Amogus", 0));
        System.out.println(scoreMap.containsKey("Alex"));

        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // this three lines of code can be replaced by computeIfAbsent()
//        if(adjList.get(1) == null) {
//            adjList.put(1, new ArrayList<>());
//        }
//        adjList.get(1).add(2);

        adjList.computeIfAbsent(1, k -> new ArrayList<>()).add(2);

        /*
        Since in Maps we cannot iterate over elements in there, to do that we can convert
        it into a set
         */

        Set<Map.Entry<String, Integer>> myMaps = scoreMap.entrySet();
        myMaps.forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));

        // or we can just get set of keys
        Set<String> names = scoreMap.keySet();
        names.forEach(x -> System.out.println(scoreMap.get(x)));

        System.out.println();

        NavigableMap<String, Integer> tmap = new TreeMap<>(scoreMap);
        System.out.println(tmap.pollFirstEntry());
        System.out.println(tmap.ceilingKey("Chandler"));

    }
}
