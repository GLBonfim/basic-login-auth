package app;

import auth.AuthService;
import auth.SenhaInvalidaException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AuthService auth = new AuthService();
        try (Scanner sc = new Scanner(System.in)) {

            // -------- Cadastro (laço até sucesso) ----------
            boolean cadastrado = false;
            while (!cadastrado) {
                System.out.println("=== CADASTRO ===");
                System.out.print("Usuário: ");
                String userCad = sc.next();
                System.out.print("Senha  : ");
                String passCad = sc.next();

                try {
                    auth.registrar(userCad, passCad);
                    System.out.println("✔ Registrado com sucesso!\n");
                    cadastrado = true;           // sai do while → segue p/ login
                } catch (SenhaInvalidaException e) {
                    System.out.println("✖ " + e.getMessage());
                    System.out.println("Tente novamente.\n");
                    // NÃO dá return; continua no loop
                }
            }

            // -------- Login -----------
            boolean logado = false;
            while (!logado) {
                System.out.println("=== LOGIN ===");
                System.out.print("Usuário: ");
                String userIn = sc.next();
                System.out.print("Senha  : ");
                String passIn = sc.next();

                if (auth.login(userIn, passIn)) {
                    System.out.println("✅ Login bem-sucedido! Seja bem-vindo, " + userIn +"!");
                    logado = true;
                } else {
                    System.out.println("❌ Usuário ou senha incorretos. Tente de novo.\n");
                }
            }
        }
    }
}
