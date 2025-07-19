package CollectionsFramework;

import java.util.*;

public class SetTutorial {
    /*
    HashSet is just like a regular Set unordered, LinkedHashSet is ordered one

    NavigableSet - provides methods for navigation, like closest matches ceiling(), floor(), higher()
     */
    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        // removes all elements from set
//        mySet2.clear()

        Set<Integer> mySet2 = new HashSet<>();
        mySet2.add(2);
        mySet2.add(3);
        mySet2.add(4);
        System.out.print(mySet + " ");
        System.out.println(mySet2);

        System.out.println("after retaining: ");
        // retaining give just an intersection of two sets
        mySet.retainAll(mySet2);
        System.out.println(mySet);

        System.out.println("after removing: ");
        // gives the diffrence of the set
        mySet2.removeAll(mySet);
        System.out.println(mySet2);


        Set<Integer> mySet3 = new LinkedHashSet<>();
        mySet3.add(1);
        mySet3.add(2);
        mySet3.add(3);
        mySet3.forEach(System.out::println);

        NavigableSet<Integer> navSet = new TreeSet<>();
        navSet.add(0);
        navSet.add(9);
        navSet.add(4);
        navSet.add(1);

        System.out.println();
        // this function gives something less than or equal to this element
        System.out.println(navSet.floor(10));
        // something bigger than 0, not equal to it
        System.out.println(navSet.higher(0));
        System.out.println(navSet.lower(4));
        System.out.println(navSet.ceiling(8));
    }
}
