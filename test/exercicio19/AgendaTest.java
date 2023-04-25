package exercicio19;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgendaTest {
    private static Agenda agenda;
    private static Contato contato1;
    private static Contato contato2;

    @BeforeEach
    public void setUp() {
        agenda = new Agenda();
        contato1 = new Contato("João", "Silva", "(81) 91111-1111", "joaosilva@gmail.com", new Endereco("Rua Tal", 123, "Cidade Assim", "Estado Assado", "Bairro Tal"));
        contato2 = new Contato("Maria", "Santos", "(110 92222-2222", "mariadossantos@gmail.com", new Endereco("Rua Tal", 456, "Cidade de Deus", "Estado Fulano", "Bairro Sicrano"));
    }

    @Test
    @DisplayName("Deve adicionar um contato na agenda.")
    public void adicionarContatoTest() {
        agenda.adicionarContato(contato1);
        assertTrue(agenda.getContatos().contains(contato1));
        assertEquals(1, agenda.getContatos().size());
    }

    @Test
    @DisplayName("Deve excluir um contato da agenda.")
    public void excluirContatoTest() {
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        agenda.excluirContato(contato1);
        assertFalse(agenda.getContatos().contains(contato1));
        assertEquals(1, agenda.getContatos().size());
    }

    @Test
    @DisplayName("Deve atualizar um contato na agenda.")
    public void atualizarContatoTest() {
        agenda.adicionarContato(contato1);
        agenda.atualizarContato(contato1, contato2);
        assertFalse(agenda.getContatos().contains(contato1));
        assertTrue(agenda.getContatos().contains(contato2));
        assertEquals(1, agenda.getContatos().size());
    }

    @Test
    @DisplayName("Deve verificar se a lista da agenda contém os contatos adicionados anteriormente")
    public void listarContatosDisponiveisTest() {
        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        List<Contato> contatos = agenda.getContatos();
        assertEquals(2, contatos.size());
        assertTrue(contatos.contains(contato1));
        assertTrue(contatos.contains(contato2));
    }
}
