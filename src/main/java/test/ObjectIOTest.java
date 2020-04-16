import com.sun.xml.internal.fastinfoset.stax.events.ReadIterator;
import org.junit.jupiter.api.Test;
import sample.Kolokvijum;
import sample.ObjectIO;
import sample.RezultatKolokvijuma;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;

public class ObjectIOTest {

    @Test
    public void test(){
        List<RezultatKolokvijuma> rez = new ArrayList<>();
        RezultatKolokvijuma rk = new RezultatKolokvijuma();
        Kolokvijum kolokvijum = new Kolokvijum();
        rk.setIme("David");
        rk.setPrezime("Janjic");
        rk.setBrIndexa("464/16");
        rk.setBrBodova("20");
        rk.setDatum(LocalDate.of(2020,03,24));
        rk.setNapomena("Dodatni poeni od predistpitnih obaveza");
        rez.add(rk);
        kolokvijum.setSviRezultati(rez);
        ObjectIO oio = new ObjectIO();
        oio.writeFile(rez);
        kolokvijum.setSviRezultati(oio.readFile());
        assertEquals(kolokvijum.getSviRezultati().get(0).getIme(),"David");

    }
}
