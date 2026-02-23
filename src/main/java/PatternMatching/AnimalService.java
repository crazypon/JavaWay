package PatternMatching;

public class AnimalService {
    public String retrieveName(Animal animal) {
        return switch(animal) {
            /*
            You may be wondering where is the default case? we don't need it since our interface is sealed, and
            it permits only to Cat and Dog, that are all possible cases
             */
            case null -> "";
            case Cat cat -> cat.name();
            case Dog dog -> dog.name();
        };
    }

    public String retrieveNameV2(Animal animal) {
        return switch(animal) {
            case null -> "";
            case Cat(String name, String color) -> name;
            case Dog (String name, String color) -> name;
        };
    }

    public String retrieveNameUsingGuardedPattern(Animal animal) {
        return switch(animal) {
            case Cat(String name, String color) when name==null -> "";
            case Cat(String name, String color) -> name;
            case Dog (String name, String color) -> name;
        };
    }
}
