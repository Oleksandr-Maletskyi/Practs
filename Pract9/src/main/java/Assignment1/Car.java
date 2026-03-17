package Assignment1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Car {
    public final int model;

    public Car(int model) {
        this.model = model;
    }

    public static class Engine{
        private final int horsepower;

        public Engine(int horsepower) {
            this.horsepower = horsepower;
        }

        @Override
        public String toString() {
            return "Engine with " + horsepower + " hp";
        }
    }

    public Engine spec(int hp) {
        return new Engine(hp);
    }

}

