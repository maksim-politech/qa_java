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

@RunWith(Parameterized.class)
public class LionParamTest {
    private final boolean expected;
    private final String gender;

    public LionParamTest(boolean expected, String gender) {
        this.expected = expected;
        this.gender = gender;
    }

    @Parameterized.Parameters(name = "gender: {1}")
    public static Object[][] getSumData() {
        return new Object[][] {
            {true,"Самец"},
            {false,"Самка"}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;


    @Test
    public void LionConstructorTest() throws Exception {
        Lion lion =new Lion(gender,feline);
        assertEquals(expected,lion.doesHaveMane());
    }


}
