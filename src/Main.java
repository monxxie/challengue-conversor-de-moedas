import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        boolean sair = false;
        while(!sair) {
            menu.executarMenu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    converterMoedas(scanner, "USD", "EUR");
                    break;
                case 2:
                    converterMoedas(scanner, "USD", "JPY");
                    break;
                case 3:
                    converterMoedas(scanner, "USD", "GBP");
                    break;
                case 4:
                    converterMoedas(scanner, "USD", "ARS");
                    break;
                case 5:
                    converterMoedas(scanner, "USD", "BRL");
                    break;
                case 6:
                    converterMoedas(scanner, "USD", "CNY");
                    break;
                case 7:
                    sair = true;
                    System.out.println("Volte Sempre!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void converterMoedas(Scanner scanner, String moeda1, String moeda2) {
        System.out.println("Qual o valor a ser convertido: ");
        double valor = scanner.nextDouble();
        Conversor Conversor = new Conversor();

        try {
            double valorFinal = Conversor.converterMoedas(valor, moeda1, moeda2);
            System.out.println("*********************************************************");
            System.out.println(valor + moeda1 + " equivale a " + valorFinal + moeda2);

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}