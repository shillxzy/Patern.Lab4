package chainofresponsibility;

class Delivery
{
    private String type;

    public Delivery(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
}

abstract class Handler
{
    private Handler next;

    public Handler setNext(Handler next)
    {
        this.next = next;
        return next;
    }

    public void handle(Delivery request)
    {
        if (next != null)
        {
            next.handle(request);
        } else {
            System.out.println("Немає обробника для цього типу доставки: " + request.getType());
        }
    }
}

class Standard extends Handler
{

    public void handle(Delivery request)
    {
        if (request.getType().equalsIgnoreCase("standard"))
        {
            System.out.println("Опрацьовано стандартну доставку за 5-10 днів");
        } else {
            super.handle(request);
        }
    }
}

class Express extends Handler
{

    public void handle(Delivery request)
    {
        if (request.getType().equalsIgnoreCase("express"))
        {
            System.out.println("Опрацьовано ЕКСПРЕС доставку за 1-3 дні");
        } else {
            super.handle(request);
        }
    }
}


/*
        Handler standard = new Standard();
        Handler express = new Express();

        standard.setNext(express);

        Delivery req1 = new Delivery("standard");
        Delivery req2 = new Delivery("express");
        Delivery req3 = new Delivery("very fast");

        System.out.println("--- Запит 1 ---");
        standard.handle(req1);

        System.out.println("\n--- Запит 2 ---");
        standard.handle(req2);

        System.out.println("\n--- Запит 3 ---");
        standard.handle(req3);
 */

