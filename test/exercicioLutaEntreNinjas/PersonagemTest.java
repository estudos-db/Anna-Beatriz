package exercicioLutaEntreNinjas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonagemTest {
    private NinjaDeGenjutsu kakashi;
    private Jutsu chidori;

    @BeforeEach
    public void setUp(){
        kakashi = new NinjaDeGenjutsu("Kakashi");
        chidori = new Jutsu("Chidori",10,5);
    }
    @Test
    @DisplayName("Deve exibir a mensagem informando que o ninja conseguiu aprender um novo jutsu.")
    public void testAprenderJutsu() {
        assertEquals("O ninja Kakashi acabou de aprender o jutsu Chidori!",
               kakashi.aprenderJutsu("Chidori", chidori));
        assertTrue(kakashi.getJutsus().containsKey("Chidori"));
    }
    @Test
    @DisplayName("Deve exibir a mensagem informando que o ninja não pode aprender um jutsu duas vezes.")
    public void testFalharAprenderJutsu(){
        kakashi.aprenderJutsu("Chidori", chidori);

        assertEquals("O ninja Kakashi já aprendeu esse jutsu.",
                kakashi.aprenderJutsu("Chidori", chidori));
    }
    @Test
    @DisplayName("Deve verificar se o ninja possui certo jutsu.")
    public void testTemJutsu(){
            kakashi.aprenderJutsu("Chidori", chidori);
            assertTrue(kakashi.temJutsu("Chidori"));
        }
    @Test
    @DisplayName("Deve consumir a vida do ninja.")
    public void testConsumirVida(){
            kakashi.consumirVida(10);
            assertEquals(90, kakashi.getVida());
    }
   @Test
   @DisplayName("Deve consumir o chakra do ninja.")
    public void testConsumirChakra(){
        kakashi.consumirChakra(5);
        assertEquals(95,kakashi.getChakra());
   }
   @Test
   @DisplayName("Deve retornar mensagem informando que o ninja tem chakra insuficiente para usar certo jutsu.")
    public void testUsarJutsuSemChakra(){
       kakashi.aprenderJutsu("Chidori", chidori);
       kakashi.setChakra(0);
       String resultado = kakashi.usarJutsu(chidori);
       assertEquals("O ninja não pode usar esse jutsu, falta chakra.", resultado);
       assertEquals(0, kakashi.getChakra());
   }
   @Test
   @DisplayName("Deve retornar mensagem informando que o ninja conseguiu atacar usando certo jutsu e diminuir o chakra dele.")
    public void testUsarJutsuComChakra(){
       kakashi.aprenderJutsu("Chidori", chidori);
       String resultado = kakashi.usarJutsu(chidori);
       assertEquals("O ninja Kakashi está atacando usando o Chidori", resultado);
       assertEquals(95, kakashi.getChakra());
   }
   @Test
   @DisplayName("Deve diminuir o chakra do ninja quando ele desviar.")
    public void testConsumirChakraAoDesviar(){
      kakashi.desviar();
      assertEquals(95, kakashi.getChakra());
   }
}
