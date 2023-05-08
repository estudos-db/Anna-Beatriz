package exercicio20;

public class MenuMain {
    public static void main(String[] args) {

        Menu menu = new Menu();
        InicializarEstoque.estoqueInitializer();
        menu.iniciaMenu();
    }
}
