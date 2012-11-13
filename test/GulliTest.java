import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GulliTest {

    @Test
    public void should_say_hello_from_gulli() {
        assertEquals("Here is Gulli!", new Gulli().me());
    }
     @Test
       public void should_say_fire_from_gulli() {
       assertEquals("Fire", new Gulli().fire(32));
    }
         @Test
       public void should_winner_gulli() {
       assertEquals(3, new Gulli().winner());
    }

}
