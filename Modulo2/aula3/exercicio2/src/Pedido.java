public class Pedido {

    public static enum Status {
        INICIADO,
        FECHADO,
        PAGO,
        EM_TRANSITO
    }

    private Status status;
    private Item[] items;
    private double total;
    private int lastItemIndex;

    public Pedido() {
        this.status = Status.INICIADO;
        this.total = 0;
        this.items = new Item[10];
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = null;
        }
    }

    public void addItem(String item, double value) throws Exception {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                Item newItem = new Item(item, value);
                this.items[i] = newItem;
                lastItemIndex = i;
                break;
            }
            if (i == this.items.length - 1) {
                throw new Exception("Pedido lotado!");
            }
        }

    }

    public double total() {
        Item[] finalReq = this.close();
        total = 0;
        for (Item item : finalReq) {
            total += item.value;
        }
        return total;
    }

    public Item[] close() {
        Item[] finalReq = new Item[lastItemIndex + 1];
        for (int i = 0; i < finalReq.length; i++) {
            finalReq[i] = this.items[i];
        }
        this.status = Status.FECHADO;

        return finalReq;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        String string = new String();
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                string += this.items[i].name;
                if (this.items[i + 1] != null)
                    string += ", ";
            } else {
                break;
            }
        }
        if (string.length() > 0)
            return string;
        else
            return "não há produtos no pedido";
    }
}
