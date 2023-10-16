package ListIPRangeTest;

import org.junit.Test;

import java.util.ArrayList;

import static ListIPRange.ListIPRange.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListIPRangeTest {

    @Test
    public void TrueIP() {
        String strIP = "192.168.0.2";

        if (isValidIP(strIP)) {
            System.out.println("TrueIP = Passed");
        } else {
            System.out.println("TrueIP = Error");
        }

        final ArrayList<String> ListStrIP;
        ListStrIP = new ArrayList<String>() {
        };

        ListStrIP.add(0, "");
        ListStrIP.add(1, "X");
        ListStrIP.add(2, "1.");
        ListStrIP.add(3, "1.1");
        ListStrIP.add(4, "1.1.1");
        ListStrIP.add(5, "1.1.1.");

        for (Object element : ListStrIP) {
            System.out.print(element + " ");
            boolean b = (isValidIP(element.toString()));
            assertThat (b, is(false));
        }
        boolean b = (isValidIP("1.1.1.1"));
        assertThat (b, is(true));
    }
}
