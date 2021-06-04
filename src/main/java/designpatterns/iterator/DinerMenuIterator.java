package designpatterns.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class DinerMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] list;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = list[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if (position >= list.length || list[position] == null) {
            return false;
        }

        return true;
    }

    @Override
    public void remove() {
        if(position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done at least one next()");
        }

        if(list[position-1] != null) {
            for (int i = position - 1; i < (list.length -1); i++) {
                list[i] = list[i+1];
            }
            list[list.length - 1] = null;
        }
    }

}
