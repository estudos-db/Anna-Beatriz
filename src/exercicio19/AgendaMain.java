package exercicio19;

public class AgendaMain {
    public static void main(String[] args) {

        Endereco endereco = new Endereco("Rua do Limão", 123, "Fulaninha City", "São Fulano", "Bairro do Limoeiro");
        Contato contato1 = new Contato("Fulano", "de Tal", "(83) 91234-5678", "fulano@hotmail.com", endereco);
        Agenda agenda = new Agenda();

        //adicionando um contato inicial p/ agenda
        agenda.adicionarContato(contato1);

        agenda.listarContatosDisponiveis();
        System.out.println("Agenda só possui um contato disponível.");

        // outro contato p/ agenda
        Endereco endereco2 = new Endereco("Rua Ciclaninha da Silva", 456, "Ciclaninha City", "São Ciclano", "Bairro Silva de Souza");
        Contato contato2 = new Contato("Ciclano", "Ciclaninho", "(21) 94002-8922", "ciclano@gmail.com", endereco2);

        agenda.adicionarContato(contato2);

        //agenda atualizada
        agenda.listarContatosDisponiveis();
        System.out.println("Agenda agora possui dois contatos disponíveis.");

        agenda.excluirContato(contato2);

        // adicionando um contato e atualizando algumas informações dele
        Endereco endereco3 = new Endereco("Rua Tal", 789, "Beltraninho City", "São Beltrano", "Bairro do Beltranão");
        Contato contatoAntigoDoBeltrano = new Contato("Beltrano", "de Beltraninho", "(11) 91111-2222", "beltrano@gmail.com", endereco3);


        agenda.adicionarContato(contatoAntigoDoBeltrano);
        agenda.listarContatosDisponiveis();
        Contato contatoNovoDoBeltrano = new Contato("João", "de Beltraninha", "(11) 91111-3333", "joão@hotmail.com", endereco3);
        agenda.atualizarContato(contatoAntigoDoBeltrano, contatoNovoDoBeltrano);
        System.out.println("O contato de Beltrano foi atualizado e será listado a seguir na agenda com suas atualizações.");
        agenda.listarContatosDisponiveis();
    }
}
