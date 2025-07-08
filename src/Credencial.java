public class Credencial {
    private final String usuario;
    private final String senhaHash;

    public Credencial(String usuario, String senha) {
        if (senha == null || senha.length() < 8) {
            throw new SenhaInvalidaException(
                    "A senha deve ter ao menos 8 caracteres.");
        }
        this.usuario = usuario;
        this.senhaHash = HashUtil.gerarHash(senha); // senha convertida para hash
    }

    public String getUsuario() { return usuario; }
    public String getSenhaHash()   { return senhaHash; }

    public boolean validarSenha(String tentativa){
        return senhaHash.equals(HashUtil.gerarHash(tentativa));
    }

    @Override
    public String toString() {
        return "Usuário: %s | Senha: %s".formatted(usuario, senhaHash);
    }
}
