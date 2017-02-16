package study._004method_constructor_references;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}