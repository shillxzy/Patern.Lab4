package state;

interface Delivery
{
    void deliverPackage();
}

class PreparingState implements Delivery
{
    public void deliverPackage()
    {
        System.out.println("Пакунок готується до доставки...");
    }
}

class InDeliveryState implements Delivery
{
    public void deliverPackage()
    {
        System.out.println("Пакунок в процесі доставки...");
    }
}

class DeliveredState implements Delivery
{
    public void deliverPackage()
    {
        System.out.println("Пакунок доставлений.");
    }
}

class Package
{
    private Delivery state;

    public Package(Delivery state)
    {
        this.state = state;
    }

    public void setState(Delivery state)
    {
        this.state = state;
    }

    public void deliverPackage()
    {
        state.deliverPackage();
    }
}
