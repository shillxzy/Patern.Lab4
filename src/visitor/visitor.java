package visitor;

interface Visitor
{
    void visit(Standard standard);
    void visit(Express express);
}

interface Delivery
{
    void accept(Visitor visitor);
}

class Standard implements Delivery
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    public void standardDeliveryMethod()
    {
        System.out.println("Виконання стандартної доставки...");
    }
}

// Конкретний елемент 2 - Експрес доставка
class Express implements Delivery
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    public void expressDeliveryMethod()
    {
        System.out.println("Виконання експрес-доставки...");
    }
}


class Cost implements Visitor
{
    public void visit(Standard standardDelivery)
    {
        System.out.println("Вартість стандартної доставки: 100 грн.");
    }


    public void visit(Express expressDelivery)
    {
        System.out.println("Вартість експрес-доставки: 200 грн.");
    }
}

class Timer implements Visitor
{
    public void visit(Standard standardDelivery)
    {
        System.out.println("Час стандартної доставки: 3 дні.");
    }

    public void visit(Express expressDelivery)
    {
        System.out.println("Час експрес-доставки: 1 день.");
    }
}

