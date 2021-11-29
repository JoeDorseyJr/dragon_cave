
import org.junit.Assert;
import org.junit.jupiter.api.*;

class MainTest {

    Main cave;
    @BeforeEach
    void setUp() {
        cave = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    void playAgain() {
    }

    @Test
    void caveNumber() {
    }

    @Test
    void gameStart() {
    }

    @Test
    void resultsMessage() throws InterruptedException {
        Assertions.assertEquals("Tells you all about his day. He is friendly and wants to share his treasure with you.\n\u001B[1mYou survived!\u001B[0m", cave.resultsMessage(true));
        Assertions.assertEquals("Gobbles you down in one bite.\nYou died.", cave.resultsMessage(false));
    }
}