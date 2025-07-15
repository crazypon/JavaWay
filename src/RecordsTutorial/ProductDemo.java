package RecordsTutorial;

public class ProductDemo {
    public static void main(String[] args) {
        Product iphone = new Product("Iphone 15 pro", 800, "phone");
        System.out.println(iphone.name() + " costs " + iphone.price());

        Product airpods = new Product("Air Pods", 222);
        System.out.println("Type: " + airpods.type());
    }
}
