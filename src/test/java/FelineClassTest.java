import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineClassTest {

    @Test
    public void eatMeatMethodTest() throws Exception {
    Feline feline = new Feline();
    List<String> expected = List.of("Животные", "Птицы", "Рыба");
    assertEquals(expected, feline.eatMeat());
    }


    @Test
    public void getFamilyMethodTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Mock
    Feline feline;
    @Test
    public void getKittensMethodTest() {
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(5);
        assertEquals(5, feline.getKittens(4)); ///Проверка на то, что метод обрабатывает только целые числа
    }


    @Test
    public void getKittensMethod2Test() {
        //Mockito.when(feline.getKittens(1)).thenReturn(1);
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensMethod3Test() {
        Random random = new Random();
        Feline feline = new Feline();
        int value =random.nextInt(11);
        assertEquals(value, feline.getKittens(value));
    }


}



