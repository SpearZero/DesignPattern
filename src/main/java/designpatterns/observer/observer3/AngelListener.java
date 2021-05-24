package designpatterns.observer.observer3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AngelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("안 돼. 분명 나중에 후회할 거야");
    }
}
