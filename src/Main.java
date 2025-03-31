package mediator;

class Main
{

    private static void line()
    {
        System.out.println("--------------------------------------");
    }

    public static void main (String[] args)
    {
        ConcreteDelivery mediator = new ConcreteDelivery();

        StandardDelivery standard = new StandardDelivery(mediator);
        ExpressDelivery express = new ExpressDelivery(mediator);

        mediator.setStandardDelivery(standard);
        mediator.setExpressDelivery(express);

        standard.send("Пакунок готовий до відправки.");

        System.out.println();

        express.send("Пакунок буде відправлено терміново.");

    }

}
