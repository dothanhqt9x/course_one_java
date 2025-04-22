package generic.type;

public class Exercise5 {

    public Exercise5() {
        var model = new PersonModel<String>();
        model.addObject("Hello");
        model.addObject("World");
        model.addObject("Java");
        model.addObject("Generic");
        model.addObject("Type");
        model.addObject("Example");
        model.addObject("Test");
        model.addObject("Model");
        model.addObject("Person");
        model.addObject("List");
        model.display();
    }

}

