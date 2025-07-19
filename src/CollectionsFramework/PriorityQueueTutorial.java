package CollectionsFramework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTutorial {
    /*
    This is heap-like data structure, it guarantees that elements can be removed in priority order
    Iterating over PriorityQueue is a bad idea
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(94);
        pq.offer(5);
        pq.offer(110);
        pq.offer(2);

        // ascending order top 2 elements
        List<Integer> top2 = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty()) {
            if(index == 2) break;
            top2.add(pq.poll());
            index++;
        }

        /*
        In order PriorityQueue to work with StudentMarks object we should make it Comparable,
        otherwise our PriorityQueue doesn't know based on what property to sort the data

        Comparable is called to be natural ordering
        Comparator is called total ordering, if there is a choice between Comparable or comparator
        JRE will choose Comparator. Comparator is functional interface, you can pass lambda or
        method reference to constructor
         */
        PriorityQueue<StudentMarks> topStudents = new PriorityQueue<>(
                Comparator.comparingInt(StudentMarks::getPhysics)
        );
        topStudents.offer(new StudentMarks(58, 72));
        topStudents.offer(new StudentMarks(94, 100));
        topStudents.offer(new StudentMarks(73, 59));
        topStudents.offer(new StudentMarks(86, 90));
        topStudents.offer(new StudentMarks(33, 97));

        while(!topStudents.isEmpty()) {
            System.out.println(topStudents.poll().getPhysics());
        }

        System.out.println(top2);
    }
}
