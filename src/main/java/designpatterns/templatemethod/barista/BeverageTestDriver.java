package designpatterns.templatemethod.barista;

public class BeverageTestDriver {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();

        TeaWithHook teaHook = new TeaWithHook();
        CoffeWithHook coffeHook = new CoffeWithHook();

        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffeHook.prepareRecipe();
    }
}
