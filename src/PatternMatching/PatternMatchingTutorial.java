package PatternMatching;

public class PatternMatchingTutorial {

    public void patterMatchingUsingInstanceOf(Object o) {
        // this syntax below is called pattern matching, we are able to store the object in variable
        // if instance of returns true, so o = i;
        if(o instanceof Integer  i) {
            System.out.println("Interger: " + i);
        }
        if(o instanceof String j) {
            System.out.println("String: " + j);
        }
        System.out.println("Not String or Integer");
    }

    public void patternMatchingUsingSwitch(Object o) {
        switch(o) {
            case String s -> System.out.println("String: " + s);
            case Integer i -> System.out.println("Integer: " + i);
            case null, default -> System.out.println("Not String or Integer");
        }

    }
}
