package machine;

import java.util.Scanner;

public class CoffeeMachine {
    MachineState status = MachineState.CHOOSE_ACTION;
    int cash = 550;
    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;

    enum MachineState {
        CHOOSE_ACTION, CHOOSE_COFFEE, FILL_WATER, FILL_MILK, FILL_BEANS, FILL_CUPS
    }

    public static void main(String[] args) {
        var coffeeMachine = new CoffeeMachine();
        var scan = new Scanner(System.in);
        boolean again = true;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        while (again) {
            again = coffeeMachine.takeAction(scan.next());
        }
    }

    boolean takeAction(String action) {
        switch (status) {
            case CHOOSE_ACTION:
                return chooseAction(action);
            case CHOOSE_COFFEE:
                return chooseCoffee(action);
            case FILL_WATER:
                water += Integer.parseInt(action);
                status = MachineState.FILL_MILK;
                System.out.println("Add ml of milk:");
                return true;
            case FILL_MILK:
                milk += Integer.parseInt(action);
                status = MachineState.FILL_BEANS;
                System.out.println("Add grams of beans:");
                return true;
            case FILL_BEANS:
                beans += Integer.parseInt(action);
                status = MachineState.FILL_CUPS;
                System.out.println("Add how many cups:");
                return true;
            case FILL_CUPS:
                cups += Integer.parseInt(action);
                status = MachineState.CHOOSE_ACTION;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                return true;
            default:
                return true;
        }
    }

    boolean chooseAction(String action) {
        switch (action) {
            case "buy":
                status = MachineState.CHOOSE_COFFEE;
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                return true;
            case "fill":
                status = MachineState.FILL_WATER;
                System.out.println("Add ml of water:");
                return true;
            case "take":
                System.out.println("I gave you $" + cash);
                cash = 0;
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                return true;
            case "remaining":
                System.out.println("The coffee machine has:");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(beans + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(cash + " of money");
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                return true;
            case "exit":
                return false;
            default:
                return true;

        }
    }

    boolean chooseCoffee(String coffeeType) {
        if (coffeeType.equals("back")) {
            status = MachineState.CHOOSE_ACTION;
            return true;
        }
        if ((coffeeType.equals("1") && (water < 250 || beans < 16)) ||
                (coffeeType.equals("2") && (water < 350 || milk < 75 || beans < 20)) ||
                (coffeeType.equals("3") && (water < 200 || milk < 100 || beans < 12))) {
            System.out.println("Sorry, not enough supplies");
            status = MachineState.CHOOSE_ACTION;
            return true;
        } else {
            cups -= 1;
            switch (coffeeType) {
                case "1":
                    cash += 4;
                    water -= 250;
                    beans -= 16;
                    break;
                case "2":
                    cash += 7;
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    break;
                case "3":
                    cash += 6;
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
            }
            System.out.println("Making you a coffee");
            status = MachineState.CHOOSE_ACTION;
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
        return true;
    }
}

