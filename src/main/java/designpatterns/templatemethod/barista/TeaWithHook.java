package designpatterns.templatemethod.barista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaWithHook extends CaffeineBeverageWithHook {

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }

    @Override
    boolean customerWantsCondiments() {
        String answer = getInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }

        return false;
    }

    private String getInput() {
        String answer = null;

        System.out.println("Would you like lemon with your tea? (y/n)");

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
