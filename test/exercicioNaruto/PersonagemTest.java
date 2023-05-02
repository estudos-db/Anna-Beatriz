package exercicioNaruto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PersonagemTest {

    @Test
    @DisplayName("Deve aprender um novo jutsu")
    public void testAprenderJutsu() {
        Personagem personagem = new Personagem("Naruto", 16, "Konoha", 20);

        assertEquals("O ninja Naruto aprendeu o jutsu Rasengan.", personagem.aprenderJutsu("Rasengan"));
        assertEquals("O ninja Naruto já aprendeu o jutsu Rasengan.", personagem.aprenderJutsu("Rasengan"));
        assertEquals("O ninja Naruto aprendeu o jutsu Chidori.", personagem.aprenderJutsu("Chidori"));
    }

    @Test
    @DisplayName("Deve aumentar chakra")
    public void testAumentarChakra() {
        Personagem personagem = new Personagem("Sakura", 16, "Konoha", 30);

        assertEquals("O total de chakra do ninja Sakura agora é 50.", personagem.aumentarChakra(20));
        assertEquals("O total de chakra do ninja Sakura agora é 55.", personagem.aumentarChakra(5));
        assertEquals("O aumento do chakra não pode ser nulo ou negativo.", personagem.aumentarChakra(-10));
    }

    @Test
    @DisplayName("Deve impor um novo chakra")
    public void testSetChakra() {
        Personagem personagem = new Personagem("Sasuke", 16, "Konoha", 50);

        assertEquals(50, personagem.getChakra());
        personagem.setChakra(35);
        assertEquals(35, personagem.getChakra());
        try {
            personagem.setChakra(100);
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Um ninja iniciante não consegue ter essa quantidade de chakra", e.getMessage());
            assertEquals(35, personagem.getChakra());
        }
    }

    @Test
    @DisplayName("Deve exibir as informações de um ninja")
    public void testExibirInfo() {
        Personagem personagem = new Personagem("Kakashi", 27, "Konoha", 40);
        personagem.aprenderJutsu("Chidori");

        String info = "Personagem:\nNome: Kakashi\nIdade: 27\nAldeia: Konoha\nChakra total: 40\nLista de jutsus: [Chidori]";

        assertEquals(info, personagem.exibirInfo());
    }
}
