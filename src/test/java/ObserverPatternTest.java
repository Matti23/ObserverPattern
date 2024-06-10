import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jaewa.ConcreteObserver;
import com.jaewa.Subject;

public class ObserverPatternTest {
    private Subject subject;
    private ConcreteObserver observer1;
    private ConcreteObserver observer2;

    @BeforeEach
    public void setUp() {
        subject = new Subject();
        observer1 = new ConcreteObserver("Observer 1");
        observer2 = new ConcreteObserver("Observer 2");
    }

    @Test
    public void testObserverNotified() {
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setState("Stato aggiornato");

        assertEquals("Stato aggiornato", observer1.getMessage());
        assertEquals("Stato aggiornato", observer2.getMessage());
    }

    @Test
    public void testObserverRemoved() {
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.removeObserver(observer1);

        subject.setState("Altro aggiornamento");

        assertEquals(null, observer1.getMessage());
        assertEquals("Altro aggiornamento", observer2.getMessage());
    }
}
