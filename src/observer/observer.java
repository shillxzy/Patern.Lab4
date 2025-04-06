package observer;
import java.util.ArrayList;
import java.util.List;

interface Observer
{
    void update(String status);
}

class Delivery
{
    private String status;
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public void setStatus(String status)
    {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update(status);
        }
    }

    public String getStatus()
    {
        return status;
    }
}

class Customer implements Observer
{
    private String name;

    public Customer(String name)
    {
        this.name = name;
    }


    public void update(String status)
    {
        System.out.println("Клієнт " + name + " отримав оновлення: " + status);
    }
}

class Courier implements Observer
{
    private String name;

    public Courier(String name)
    {
        this.name = name;
    }


    public void update(String status)
    {
        System.out.println("Кур'єр " + name + " отримав оновлення: " + status);
    }
}

/*

Customer customer = new Customer("Клієнт");
        Courier courier = new Courier("Кур'єр");

        Delivery delivery = new Delivery();
        delivery.addObserver(customer);
        delivery.addObserver(courier);

        System.out.println("--- Оновлення статусу доставки ---");
        delivery.setStatus("Замовлення прийняте");

        System.out.println("\n--- Оновлення статусу доставки ---");
        delivery.setStatus("Відправлено");

        System.out.println("\n--- Оновлення статусу доставки ---");
        delivery.setStatus("Доставлено");
 */
