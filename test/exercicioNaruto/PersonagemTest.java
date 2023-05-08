package exercicioNaruto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PersonagemTest {
    private Personagem ninja;
    @BeforeEach
    public void setUp(){
        ninja = new Personagem("Naruto", 16, "Konoha", 20);
    }


    @Test
    public void testAprenderJutsuComSucesso() {
        String jutsu = "Rasengan";
        String resultadoEsperado = "O ninja Naruto aprendeu o jutsu " + jutsu + ".";
        String resultadoObtido = ninja.aprenderJutsu(jutsu);
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
    }
    @Test
    public void testAprenderJutsuDuplicado() {
        String jutsu = "Kage Bunshin no Jutsu";
        ninja.aprenderJutsu(jutsu); // Aprende o jutsu pela primeira vez
        String resultadoEsperado = "O ninja Naruto já aprendeu o jutsu " + jutsu + ".";
        String resultadoObtido = ninja.aprenderJutsu(jutsu); // Tenta aprender o mesmo jutsu novamente
        Assertions.assertEquals(resultadoEsperado, resultadoObtido);
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
        String mensagemEsperada = "Um ninja iniciante não consegue ter um chakra superior a 50.";

        String mensagemRecebida = assertThrows(IllegalArgumentException.class, () -> {
            personagem.setChakra(100);
        }).getMessage();

        assertTrue(mensagemRecebida.contains(mensagemEsperada));
    }
    @Test
    @DisplayName("Deve exibir as informações de um ninja")
    public void testExibirInfo() {
        Personagem personagem = new Personagem("Kakashi", 27, "Konoha", 40);
        personagem.aprenderJutsu("Chidori");

        String info = "Personagem:\nNome: Kakashi\nIdade: 27\nAldeia: Konoha\nChakra total: 40\nLista de jutsus: [Chidori]";

        assertEquals(info, personagem.exibirInfo());
    }
    @Test
    @DisplayName("Deve retornar a mensagem informando que o ninja já atingiu o limite de jutsus (3).")
    public void testAprenderMaisDe3Jutsus() {
        ninja.aprenderJutsu("Rasengan");
        ninja.aprenderJutsu("Kage Bunshin no Jutsu");
        ninja.aprenderJutsu("Bola de fogo");
        assertEquals("O ninja Naruto já aprendeu o máximo de jutsus permitido.", ninja.aprenderJutsu("Chidori"));
    }
    @Test
    public void testAprenderMaisUmJutsu(){
        ninja.aprenderJutsu("Rasengan");
        ninja.aprenderJutsu("Chidori");
        String[] jutsus = {"Rasengan", "Chidori", null};
        Assertions.assertEquals(Arrays.toString(jutsus), Arrays.toString(ninja.getJutsus()));
    }
}
