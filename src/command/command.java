package command;

interface Command
{
    void execute();
}

class DeliveryService
{
    public void Standard()
    {
        System.out.println("Стандартна доставка: доставлено через 5 днів");
    }

    public void Express()
    {
        System.out.println("Експрес доставка: доставлено через 1 день");
    }
}

class StandardDelivery implements Command
{
    private DeliveryService service;

    public StandardDelivery(DeliveryService service)
    {
        this.service = service;
    }

    public void execute()
    {
        service.Standard();
    }
}

class ExpressDelivery implements Command
{
    private DeliveryService service;

    public ExpressDelivery(DeliveryService service)
    {
        this.service = service;
    }

    public void execute()
    {
        service.Express();
    }
}

class Invoker
{
    private Command command;

    public void setCommand(Command command)
    {
        this.command = command;
    }

    public void runCommand()
    {
        if (command != null)
        {
            command.execute();
        } else
        {
            System.out.println("Команда не встановлена");
        }
    }
}

/*
DeliveryService service = new DeliveryService();

        Command standard = new StandardDelivery(service);
        Command express = new ExpressDelivery(service);

        Invoker invoker = new Invoker();

        System.out.println("--- Виклик стандартної доставки ---");
        invoker.setCommand(standard);
        invoker.runCommand();

        System.out.println("\n--- Виклик експрес доставки ---");
        invoker.setCommand(express);
        invoker.runCommand();
 */
