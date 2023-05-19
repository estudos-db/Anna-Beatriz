package exerciciosCodeWars;
/*Given two integers a and b, which can be positive or negative, find the sum of all the integers
between and including them and return it. If the two numbers are equal return a or b.

Note: a and b are not ordered! Examples (a, b) --> output (explanation)

(1, 0) --> 1 (1 + 0 = 1)
(1, 2) --> 3 (1 + 2 = 3)
(0, 1) --> 1 (0 + 1 = 1)
(1, 1) --> 1 (1 since both are same)
(-1, 0) --> -1 (-1 + 0 = -1)
(-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)
Your function should only return a number, not the explanation about how you get that number
*/
public class Sum {

    //lembrar q se A e B forem iguais, deve retornar esse mesmo numero q eh repetido
    public static int somarInteiros(int a, int b) {
        if (a == b) {
            return a;
        } else if (a < b) {
            int soma = 0;
            for (int i = a; i <= b; i++) {
                soma += i;
            }
            return soma;
        } else {
            int soma = 0;
            for (int i = b; i <= a; i++) {
                soma += i;
            }
            return soma;
        }
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int resultado = somarInteiros(a, b);
        System.out.println("Resultado: " + resultado);
    }
}
