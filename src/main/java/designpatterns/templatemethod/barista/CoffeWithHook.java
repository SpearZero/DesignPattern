package designpatterns.templatemethod.barista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeWithHook extends CaffeineBeverageWithHook {

    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    public boolean customerWantsCondiments() {
        String answer = getUserInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }

        return false;
    }

    private String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n)?");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = br.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
        }

        if (answer == null) {
            return "no";
        }

        return answer;
    }
}
