import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {

            Credencial credencial = null;

            // loop até digitar uma senha válida
            while (credencial == null) {
                System.out.print("Usuário: ");
                String usuario = entrada.nextLine();

                System.out.print("Senha (mín. 8 caracteres): ");
                String senha = entrada.nextLine();

                try {
                    credencial = new Credencial(usuario, senha);
                } catch (SenhaInvalidaException e) {
                    System.out.println("✖ " + e.getMessage());
                    System.out.println("Tente novamente.\n");
                }
            }

            System.out.println("\n✔ Registro concluído com sucesso!");
            System.out.println(credencial);
        }
    }
}
