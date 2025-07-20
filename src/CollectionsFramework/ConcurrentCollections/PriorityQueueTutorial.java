package CollectionsFramework.ConcurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/*
PriorityBlockingQueue is same as PriorityQueue but concurrent one. When getting the element it will return the either
or smallest element (depends on how you write the Comparable method) in the collection at the moment
 */

class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age.compareTo(person.age);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class FirstPriorityWorker implements Runnable{
    BlockingQueue<Person> queue;

    public FirstPriorityWorker(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put(new Person("Jack", 30));
            queue.put(new Person("Emily", 18));
            queue.put(new Person("Steve", 19));
            queue.put(new Person("Said", 42));
            queue.put(new Person("Daniel", 32));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SecondPriorityWorker implements Runnable{
    BlockingQueue<Person> queue;

    public SecondPriorityWorker(BlockingQueue<Person> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class PriorityQueueTutorial {
    public static void main(String[] args) {
        BlockingQueue<Person> peopleDB = new PriorityBlockingQueue<>();

        FirstPriorityWorker firstWorker = new FirstPriorityWorker(peopleDB);
        SecondPriorityWorker secondWorker = new SecondPriorityWorker(peopleDB);

        Thread t1 = new Thread(firstWorker);
        Thread t2 = new Thread(secondWorker);

        t1.start();
        t2.start();
    }
}
