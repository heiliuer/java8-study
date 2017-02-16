package study._004method_constructor_references;

public class Person {
    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("firstName:%s,lastName:%s", firstName, lastName);
    }
}