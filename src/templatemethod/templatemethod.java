package templatemethod;

abstract class Delivery
{
    public void deliver()
    {
        preparePackage();
        chooseDeliveryMethod();
        packPackage();
        completeDelivery();
    }

    protected void preparePackage()
    {
        System.out.println("Пакунок готується...");
    }
    protected abstract void chooseDeliveryMethod();
    protected abstract void packPackage();
    protected void completeDelivery()
    {
        System.out.println("Доставка завершена.");
    }
}

class Standard extends Delivery
{
    protected void chooseDeliveryMethod()
    {
        System.out.println("Вибір стандартного методу доставки...");
    }
    protected void packPackage()
    {
        System.out.println("Упаковка пакунку стандартними матеріалами.");
    }
}

class Express extends Delivery
{
    protected void chooseDeliveryMethod()
    {
        System.out.println("Вибір експрес-методу доставки...");
    }
    protected void packPackage() { System.out.println("Упаковка пакунку експрес-матеріалами."); }
}
