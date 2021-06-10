package designpatterns.proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MatchMakingTestDrive {
    private Map<String, Person> datingDb = new HashMap<>();

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    private MatchMakingTestDrive() {
        initializeDatabase();
    }

    private void drive() {
        Person joe = getPersonFromDatabase("Joe javabean");
        Person ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getGeekRating());

        Person nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("bowling, Go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setGeekRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getGeekRating());
    }

    private Person getOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader()
                , person.getClass().getInterfaces()
                , new OwnerInvocationHandler(person));
    }

    private Person getNonOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader()
                ,person.getClass().getInterfaces()
                , new NonOwnerInvocationHandler(person));
    }

    private Person getPersonFromDatabase(String name) {
        return datingDb.get(name);
    }

    private void initializeDatabase() {
        Person joe = new PersonImpl();
        joe.setName("Joe javabean");
        joe.setInterests("cars, computers, music");
        joe.setGeekRating(7);
        datingDb.put(joe.getName(), joe);

        Person kelly = new PersonImpl();
        kelly.setName("kelly klosure");
        kelly.setInterests("ebay, movies ,music");
        kelly.setGeekRating(6);
        datingDb.put(kelly.getName(), kelly);
    }
}
