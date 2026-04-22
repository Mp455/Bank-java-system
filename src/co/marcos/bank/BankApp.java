package co.marcos.bank;

import co.marcos.bank.model.Account;
import co.marcos.bank.service.Bank;

import java.util.List;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("0001");

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("c - Criar conta");
            System.out.println("e - Sair");

            String op = scanner.nextLine();

            switch (op) {
                case "c":
                    System.out.print("Digite seu nome: ");
                    String name = scanner.nextLine();

                    Account account = bank.createAccount(name);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println(account);

                    operateAccount(account, scanner);
                    break;

                case "e":
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        System.out.println("\n=== CONTAS CRIADAS ===");
        List<Account> accounts = bank.getAccounts();
        for (Account acc : accounts) {
            System.out.println(acc);
        }

        System.out.println("Total no banco: R$ " + bank.getTotalBalance());
        scanner.close();
    }

    static void operateAccount(Account account, Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== CONTA ===");
            System.out.println("d - Depositar");
            System.out.println("s - Sacar");
            System.out.println("e - Voltar");

            String op = scanner.nextLine();

            switch (op) {
                case "d":
                    System.out.print("Valor do depósito: ");
                    double deposit = readDouble(scanner);

                    if (account.deposit(deposit)) {
                        System.out.println("Depósito realizado!");
                    } else {
                        System.out.println("Valor inválido.");
                    }
                    break;

                case "s":
                    System.out.print("Valor do saque: ");
                    double withdraw = readDouble(scanner);

                    if (account.withDraw(withdraw)) {
                        System.out.println("Saque realizado!");
                    } else {
                        System.out.println("Saldo insuficiente ou valor inválido.");
                    }
                    break;

                case "e":
                    running = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    static double readDouble(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }
}