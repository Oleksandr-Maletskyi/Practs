package Assignment2;

public class UnsafeInventory implements Inventory {
    private int items;

    public UnsafeInventory(int initialItems) {
        this.items = initialItems;
    }

    @Override
    public boolean reserve(int amount) {
        if (items >= amount) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            items -= amount;
            return true;
        }
        return false;
    }

    @Override
    public int available() {
        return items;
    }
}



