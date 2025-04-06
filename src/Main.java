package observer;

class Main
{

    private static void line()
    {
        System.out.println("--------------------------------------");
    }

    public static void main (String[] args)
    {
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
    }

}
