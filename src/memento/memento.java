package memento;

class Delivery
{
    private String type;

    public void setType(String type)
    {
        this.type = type;
        System.out.println("Тип доставки встановлено: " + type);
    }

    public String getType()
    {
        return type;
    }

    public DeliverySnapshot createSnapshot()
    {
        return new DeliverySnapshot(this, type);  // Створюємо знімок стану доставки
    }

    public void restore(DeliverySnapshot snapshot) {
        this.type = snapshot.getSavedType();  // Відновлюємо знімок
        System.out.println("Відновлено тип доставки: " + type);
    }
}

class DeliverySnapshot
{
    private final Delivery delivery;
    private final String savedType;

    public DeliverySnapshot(Delivery delivery, String savedType)
    {
        this.delivery = delivery;
        this.savedType = savedType;
    }

    public String getSavedType()
    {
        return savedType;
    }
}


class Command
{
    private DeliverySnapshot backup;

    public void makeBackup(Delivery delivery)
    {
        backup = delivery.createSnapshot();
    }

    public void undo(Delivery delivery)
    {
        if (backup != null)
        {
            delivery.restore(backup);
        } else
        {
            System.out.println("Немає збереженого знімку для відкату.");
        }
    }
}


/*
 Delivery delivery = new Delivery();
        Command command = new Command();

        delivery.setType("standard");
        command.makeBackup(delivery);

        delivery.setType("express");

        command.undo(delivery);
        command.undo(delivery);
 */

