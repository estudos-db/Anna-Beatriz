package exercicio19;

import java.util.ArrayList;

public class Agenda {
    private final ArrayList<Contato> contatos;
    public Agenda() {
        contatos = new ArrayList<>();
    }
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }
    public ArrayList<Contato> getContatos() {
        return contatos;
    }
    public void excluirContato(Contato contato) {
        contatos.remove(contato);
    }
    public void atualizarContato(Contato contatoAntigoDoBeltrano, Contato contatoNovoDoBeltrano) {
        int index = contatos.indexOf(contatoAntigoDoBeltrano);
        contatos.set(index, contatoNovoDoBeltrano);
    }
    public void listarContatosDisponiveis() {
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }
}
