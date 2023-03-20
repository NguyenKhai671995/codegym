package ss7_abstract_interface.thuc_hanh.Animal;

public class Chicken extends Animal implements Edible {
    @Override
    String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }


}
