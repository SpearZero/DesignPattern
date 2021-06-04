package designpatterns.iterator;

import java.util.Iterator;

public class DinerMenu implements Menu{
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat",
                true, 2.99);
        addItem("Soup of the day", "Soup of the day, with a side of potato salad",
                false, 3.29);
        addItem("Hotdog", "A hot dog, with sauerkraut, relish, onions, topped with cheese",
                false, 3.05);
        addItem("Steamed Veggies and Brown Rice", "A medly of steamed vegetables over brown rice",
                true, 3.99);
        addItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdought bread",
                true, 3.89);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {

        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
