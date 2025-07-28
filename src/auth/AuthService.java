package auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthService {
    private final List<Credencial> banco = new ArrayList<>();

    /** Cadastra e devolve o objeto salvo */
    public Credencial registrar(String usuario, String senha) {
        Credencial cred = new Credencial(usuario, senha);
        banco.add(cred);
        return cred;
    }

    /** Faz login: true se usuário existir e senha bater */
    public boolean login(String usuario, String senhaDigitada) {
        Optional<Credencial> encontrado = banco.stream()
                .filter(c -> c.getUsuario().equals(usuario))
                .findFirst();
        return encontrado.isPresent() && encontrado.get().validarSenha(senhaDigitada);
    }
    public List<Credencial> getUsuarios() {
        return banco;
    }
}
