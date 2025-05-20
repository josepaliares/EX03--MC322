package lab03.notifications;

public class EMail implements Notificavel {
    private final String enderecoEmail;

    public EMail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    @Override
    public void exibirNotificacao(String mensagem) {
        System.out.println("Enviando email para: " + enderecoEmail);
        System.out.println("Mensagem: " + mensagem);
    }
    
}
