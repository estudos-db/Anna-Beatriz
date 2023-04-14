import java.util.ArrayList;
import java.util.List;



public class LimiteDeCompras {
    public static void main(String[] args) {
        int limite = 100;
        List<Integer> compras = new ArrayList<>();
        compras.add(5);
        compras.add(40);
        compras.add(50);
        //Totaliza 95 e o limite do usuário é 100, então o limite não foi excedido

        boolean limiteExcedido = LimiteDeCompras.seLimiteForExcedido(limite, compras);
        if (limiteExcedido) {
            System.out.println("Limite de compras foi excedido.");
        } else {
            System.out.println("Seu limite de compras não foi excedido.");
        }
    }
    public static boolean seLimiteForExcedido(double limit, List<Integer> compras) {
        int total = 0;
        for (double compra : compras) {
            total += compra;
        }
        return total > limit;
    }
}
