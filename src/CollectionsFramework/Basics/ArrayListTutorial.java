package CollectionsFramework.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTutorial {
    /*
    ArrayList is just as simple array in java, but it grows dynamically, meaning we don't need to
    specify the size when we are creating it. It will grow according to the number of the values we

    ArrayList vs LinkedList
    ArrayList we can get elements at O(1), but it is bad for insertions and deletions, since
    every element should be in a sequence with no gaps, once we delete it will have to fill the gap
    by moving every element by 1 position.

    LinkedList - here we can get an element with O(n)(because we have to traverse in order to reach
    the element). However, insertion and deletion operations are fast here O(1). Also LinkedList
    in java implements Queue, so we can use as Queue or Dequeue as well
     */
    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        System.out.println(aList);

        // converting ArrayList to array
        Integer[] arr = aList.toArray(new Integer[0]);


        // set returns the previous value
        System.out.println("Setting: " + aList.set(1, 5));

        List<Integer> aList2 = new ArrayList<>(aList);

        aList.addAll(aList2);
        System.out.println("Addng all value from one bufferList to another: " + aList);

        System.out.println("Constructor Demo: " + aList2);

        System.out.println("Getting index of a certain element(first occurrence): " + aList2.indexOf(5));
        System.out.println("Getting the last occurrence of an element: " + aList.lastIndexOf(5));

        System.out.println();

        // Sublist - be careful we don't get a copy, we get a reference to the elements
        List<Integer> aList3 = aList.subList(1, 3);
        aList3.set(0, 777);
        System.out.println("SubList demo: ");
        System.out.println("SubList: " + aList3);
        System.out.println("The aList: " + aList);

        /*
        ListIterator what is it?
        The same thing as iterator, but has additional methods hasPrevious() and previous(), which
        allows to move in both directions. This is used by LinkedList which is actually a bidirectional
        LinkedList
         */
        List<Integer> myLL = new LinkedList<>();
        myLL.add(1);
        myLL.add(2);
        myLL.add(3);

        System.out.println("ListIterator demo:");
        // getting ListIterator
        ListIterator<Integer> iterator = myLL.listIterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.previous());
    }
}
