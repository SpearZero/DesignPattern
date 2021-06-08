package designpatterns.state.gumballstatewinner;

public class GumballMachine {
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;

    private State state;

    private int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        state = soldOutState;

        this.count = numberGumballs;

        state = numberGumballs > 0 ? noQuarterState : soldOutState;
    }


    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
        }
    }

    int getCount() {
        return count;
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; its new count is:" + this.count);
        state.refill();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldSate() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: ");
        result.append(count);
        result.append(" gumball");

        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is ");
        result.append(state);
        result.append("\n");
        return result.toString();
    }

}
