package mediator;

interface Delivery
{
    void notify(Component component);
}

abstract class Component
{
    protected Delivery mediator;

    public Component (Delivery mediator)
    {
        this.mediator = mediator;
    }

    public abstract void send(String message);
}

class ConcreteDelivery implements Delivery
{
    private StandardDelivery standardDelivery;
    private ExpressDelivery expressDelivery;

    public void setStandardDelivery(StandardDelivery standardDelivery)
    {
        this.standardDelivery = standardDelivery;
    }

    public void setExpressDelivery(ExpressDelivery expressDelivery)
    {
        this.expressDelivery = expressDelivery;
    }

    public void notify(Component component)
    {
        if (component == standardDelivery)
        {
            System.out.println("Посередник обробляє подію для стандартної доставки.");
        }
        else if (component == expressDelivery)
        {
            System.out.println("Посередник обробляє подію для експрес-доставки.");
        }
    }
}

class StandardDelivery extends Component
{
    public StandardDelivery(Delivery mediator)
    {
        super(mediator);
    }


    public void send(String message)
    {
        System.out.println("Стандартна доставка надсилає повідомлення: " + message);
        mediator.notify(this);
    }
}

class ExpressDelivery extends Component
{
    public ExpressDelivery(Delivery mediator)
    {
        super(mediator);
    }

    public void send(String message)
    {
        System.out.println("Експрес доставка надсилає повідомлення: " + message);
        mediator.notify(this);
    }
}
