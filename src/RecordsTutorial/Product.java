package RecordsTutorial;

record Product(String name, Integer price, String type) {
    // by default all arguments constructor is available, but you can create your custom one
    Product(String name, Integer price) {
        this(name, price, "GENERAL");
    }
}
