package exercicio19;

public class EnderecoMain {
    public static void main(String[] args) {

        Endereco endereco = new Endereco("Rua Oscar Freire", 123, "São Paulo", "São Paulo", "Pinheiros");
        System.out.println("Endereço inicial:");
        System.out.println("Rua: " + endereco.getRua());
        System.out.println("Número: " + endereco.getNumero());
        System.out.println("Cidade: " + endereco.getCidade());
        System.out.println("Estado: " + endereco.getEstado());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println();


        endereco.setRua("Rua do Mucugê");
        endereco.setNumero(456);
        endereco.setCidade("Porto Seguro");
        endereco.setEstado("Bahia");
        endereco.setBairro("Arraial d'Ajuda");

        // endereço pós alterações
        System.out.println("\nValores após as alterações:");
        System.out.println("Rua: " + endereco.getRua());
        System.out.println("Número: " + endereco.getNumero());
        System.out.println("Cidade: " + endereco.getCidade());
        System.out.println("Estado: " + endereco.getEstado());
        System.out.println("Bairro: " + endereco.getBairro());
    }
}
