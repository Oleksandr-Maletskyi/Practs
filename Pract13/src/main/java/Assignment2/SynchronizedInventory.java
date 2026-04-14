package Assignment2;

class SynchronizedInventory implements Inventory {
    private int items;

    public SynchronizedInventory(int initialItems) {
        this.items = initialItems;
    }

    @Override
    public synchronized boolean reserve(int amount) {
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
    public synchronized int available() {
        return items;
    }
}
