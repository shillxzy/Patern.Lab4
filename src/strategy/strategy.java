package strategy;

interface Delivery
{
    void deliver();
}

class StandardDelivery implements Delivery
{
    public void deliver()
    {
        System.out.println("Виконується стандартна доставка товару. Час доставки: 5-7 днів.");
    }
}

class ExpressDelivery implements Delivery
{
    public void deliver()
    {
        System.out.println("Виконується експрес доставка товару. Час доставки: 1-2 дні.");
    }
}

class Package
{
    private Delivery deliveryStrategy;

    public Package(Delivery deliveryStrategy)
    {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void setDeliveryStrategy(Delivery deliveryStrategy)
    {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void deliverPackage()
    {
        deliveryStrategy.deliver();
    }
}