import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class LionClassTest {
    String gender = "Самец";


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;



    @Test
    public void LionExceptionTest() throws Exception {
        try {
            Lion lion = new Lion(" ", feline);
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка",exception.getMessage());
        }
    }


    @Test
    public void getKittensMethodTest() throws Exception {
        Lion lion =new Lion(gender,feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1,lion.getKittens());
    }

    @Test
    public void getFoodMethodTest() throws Exception {
        Lion lion =new Lion(gender,feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, lion.getFood());
    }
}
