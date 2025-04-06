package iterator;

class DeliveryOrder
{
    private String type;

    public DeliveryOrder(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
}

interface DeliveryIterator
{
    boolean hasNext();
    DeliveryOrder next();
}

class DeliveryQueue
{
    private DeliveryOrder[] orders;
    private int size = 0;

    public DeliveryQueue(int capacity)
    {
        orders = new DeliveryOrder[capacity];
    }

    public void addOrder(DeliveryOrder order)
    {
        if (size < orders.length)
        {
            orders[size++] = order;
        } else
        {
            System.out.println("Черга заповнена");
        }
    }

    public DeliveryIterator iterator()
    {
        return new DeliveryQueueIterator();
    }

    private class DeliveryQueueIterator implements DeliveryIterator
    {
        private int index = 0;

        public boolean hasNext()
        {
            return index < size;
        }

        public DeliveryOrder next()
        {
            return orders[index++];
        }
    }
}

/*
DeliveryQueue queue = new DeliveryQueue(5);

        queue.addOrder(new DeliveryOrder("standard"));
        queue.addOrder(new DeliveryOrder("express"));
        queue.addOrder(new DeliveryOrder("standard"));
        queue.addOrder(new DeliveryOrder("drone"));

        DeliveryIterator iterator = queue.iterator();

        System.out.println("--- Починаємо обробку замовлень ---");

        while (iterator.hasNext()) {
            DeliveryOrder order = iterator.next();
            switch (order.getType()) {
                case "standard":
                    System.out.println("Стандартна доставка: доставлено через 5 днів");
                    break;
                case "express":
                    System.out.println("Експрес доставка: доставлено через 1 день");
                    break;
                default:
                    System.out.println("Невідомий тип доставки: " + order.getType());
                    break;
            }
        }
 */

