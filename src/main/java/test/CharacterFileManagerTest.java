import org.junit.jupiter.api.Test;
import sample.AppConfig;
import sample.CharacterFileManager;
import sample.RezultatKolokvijuma;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CharacterFileManagerTest {
    @Test
    public void test(){
        CharacterFileManager cfm = new CharacterFileManager();
        List<RezultatKolokvijuma> rez;
        rez = cfm.readFile();
        assertEquals(rez.get(0).getIme(),"David");

        for (RezultatKolokvijuma x : rez) {
            System.out.println(x);
        }
    }
}
