public class App {
    public static void main(String[] args) throws Exception {
        Pedido pedido = new Pedido();
        pedido.addItem("Chiclete", 12.3);
        pedido.addItem("Pepinos em Conserva", 14.50);
        pedido.addItem("Bolo de Banana", 18.90);
        pedido.addItem("Pasta de Dentes", 8.20);
        pedido.addItem("Vassoura", 34.50);
        System.out.println(pedido);
        System.out.println(pedido.total());
        pedido.setStatus(Pedido.Status.PAGO);
    }
}
