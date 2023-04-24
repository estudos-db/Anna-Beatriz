package exercicio19;

public class ContatoMain {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua Primeiro de Março", 123, "Rio de Janeiro", "Rio de Janeiro", "Bairro da Tijuca");
        Contato contato = new Contato("Maria", "Silva", "(21) 99999-9999", "maria@gmail.com", endereco);


        System.out.println("Nome: " + contato.getNome());
        System.out.println("Sobrenome: " + contato.getSobrenome());
        System.out.println("Telefone: " + contato.getTelefone());
        System.out.println("Email: " + contato.getEmail());
        System.out.println("Endereço: " + contato.getEndereco());


        contato.setNome("Maria");
        contato.setSobrenome("Souza");
        contato.setTelefone("(21) 91111-2222");
        contato.setEmail("mariasouza@hotmail.com");
        Endereco novoEndereco = new Endereco("Avenida Portugal", 456, "Rio de Janeiro", "Rio de Janeiro", "Ipanema");
        contato.setEndereco(novoEndereco);

        // verificando as alterações pós setters
        System.out.println("\nDados do contato após as alterações:");
        System.out.println("Nome: " + contato.getNome());
        System.out.println("Sobrenome: " + contato.getSobrenome());
        System.out.println("Telefone: " + contato.getTelefone());
        System.out.println("Email: " + contato.getEmail());
        System.out.println("Endereço: " + contato.getEndereco());
    }
}
