package ListIPRange;

import java.util.Scanner;
import java.util.regex.Pattern;

//ipBegin = "192.168.0.1";
//ipEnd = "192.168.0.5";
public class ListIPRange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ipBegin, ipEnd, ipStartRange;
        do {
            System.out.print("IP from (X.X.X.X): ");
            ipBegin = in.next();
        } while (!isValidIP(ipBegin));

        ipStartRange = ipBegin.substring(0, ipBegin.lastIndexOf('.'));

        do {
            System.out.print("IP to (" + ipStartRange + ".X): ");
            ipEnd = in.next();
        } while (!isValidIP(ipEnd) || !ipEnd.matches(ipStartRange + ".*"));
        printRange(ipBegin, ipEnd, ipStartRange);
    }

    public static void printRange(String fromStrIP, String toStrIP, String rangeStrIP) {
        int fromRangeInt = Integer.parseInt(fromStrIP.substring(fromStrIP.lastIndexOf(".")+1));
        int toRangeInt = Integer.parseInt(toStrIP.substring(toStrIP.lastIndexOf(".")+1));

        int fromRangeInt1 = Math.min(toRangeInt,Math.min(255,fromRangeInt));
        int toRangeInt1 = Math.max(fromRangeInt,Math.max(0,toRangeInt));

        for(int ipList=fromRangeInt1+1; ipList<toRangeInt1; ipList++){
            System.out.printf("%s.%d%n", rangeStrIP, ipList);
        }
    }

    public static boolean isValidIP(String strIP) {
        if (Pattern.matches("^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])$", strIP)) {
            return true;
        } else {
            System.out.print("Неверный формат IP адреса! ");
            return false;
        }
    }
}