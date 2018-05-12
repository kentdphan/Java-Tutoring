//Time-stamp: <2018-03-25 16:27:38 jdm>

// Run this with assertions enabled.

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DataGenerator {

    public static void main(String[] args) throws IOException {

        final DataGenerator dg = new DataGenerator("names.txt", "db.txt");
        dg.run();

    } // main()


    // The number of pseudorandom number generators seems excessive, but
    // good practice dictates a different  generator for each stream.
    private final Scanner     in;
    private final PrintStream out;
    private final Random      idGen       = new Random();
    private final Random      ssn1Gen     = new Random();
    private final Random      ssn2Gen     = new Random();
    private final Random      ssn3Gen     = new Random();
    private final Random      yearGen     = new Random();
    private final Random      monthGen    = new Random();
    private final Random      dayGen      = new Random();
    private final Random      acGen       = new Random();
    private final Random      exchangeGen = new Random();
    private final Random      portGen     = new Random();


    public DataGenerator(final String inName,
                         final String outName) throws IOException {
        in = new Scanner(new File(inName));
        out = new PrintStream(outName);
    } // constructor


    public void run() throws IOException {
        int count = 0;
        while (in.hasNextLine()) {
            String name = in.nextLine();
            String id = makeID(5);        // 5 hex digits for ID
            String ssn = makeSSN();
            String birthdate = makeDOB();
            String phone = makePhone();
            out.print(id + " ");
            out.print(birthdate + " ");
            out.print(phone + " ");
            // In this case, the social security is not included and it is optional
            //out.print(ssn + " ");
            out.println(name + " ");
            ++count;
        } // while
        System.out.println(count + " records generated.");
        out.close();
        in.close();
    } // run()


    private String makeID(final int digits) {   // some danger of repeats
        final int BASE = 16;
        final int BITS_PER_HEX_DIGIT = 4;
        final int limit = 1 << (digits * BITS_PER_HEX_DIGIT);
        final int id = idGen.nextInt(limit);
        return rightJustify(id, digits, BASE);
    } // makeID()


    private String makeSSN() {
        // SSN format, xxx-xx-xxxx is 3 + 2 + 4 digits + 2 hyphens
        final StringBuilder sb = new StringBuilder(3 + 2 + 4 + 2);
        return rightJustify(ssn1Gen.nextInt(1000), 3) + "-"
                + rightJustify(ssn2Gen.nextInt(100), 2) + "-"
                + rightJustify(ssn3Gen.nextInt(10000), 4);
    } // makeSSN()


    private String makeDOB() {
        // places the year from 1955 to 1999
        final int year = 1955 + yearGen.nextInt(45);
        final int month = monthGen.nextInt(12) + 1;   // 1 to 12
        final int day = pickDay(year, month);
        return year + "-"
                + rightJustify(month, 2) + "-"
                + rightJustify(day, 2);
    } // makeDOB()


    private static Integer[] areaCodes = null;
    private String makePhone() throws IOException {
        // read North American area codes -> areaCodes
        if (areaCodes == null)
            areaCodes = getAreaCodes();

        // Each code starts w/country code (1), then a random
        // exchange in range 200 to 999, then a random port number
        // in range 0000 to 9999.
        return "1-"
                + areaCodes[acGen.nextInt(areaCodes.length)] + "-"
                + (200 + exchangeGen.nextInt(800)) + "-"
                + rightJustify(portGen.nextInt(10000), 4);
    } // makePhone()


    private static Integer[] getAreaCodes() throws IOException {
        final Scanner in = new Scanner(new File("area-codes.txt"));
        final List<Integer> aCodes = new ArrayList<>();
        final String COMMENT = "//";
        while (in.hasNextLine()) {
            String line = in.nextLine();
            // if the line is neither empty nor a comment, the first
            // non-whitespace on the line will be an area code.
            if (line.trim().length() > 0 && !line.startsWith(COMMENT)) {
                Scanner extractAC = new Scanner(line);
                int ac = extractAC.nextInt(); // could throw
                assert ac >= 200;
                if (ac < 800)
                    aCodes.add(ac);
            } // if
        } // while
        // Return the area codes as an array.
        return aCodes.toArray(new Integer[0]);
    } // getAreaCodes()


    private int pickDay(final int year, final int month) {
        // The day will be uniformly chosen from 1 to the
        // number of days in this month.
        return 1 + dayGen.nextInt(daysInMonth(year, month));
    } // pickDay()


    private static int daysInMonth(final int year, final int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (isLeapYear(year))
                    return 29;
                else
                    return 28;
            default:
                assert false;
        } // switch
        assert false;
        return -1;        // unreachable if assertions enabled or if the
        // switch statement is coded correctly
    } // daysInMonth()


    private static boolean isLeapYear(final int year) {
        if (year % 4 != 0)
            return false;
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        assert year % 4 == 0;
        return true;
    } // isLeapYear()


    // Right-justify z as a decimal integer with digits digits,
    // padding to the left with zeroes if necessary.
    private static String rightJustify(final long z, final int digits) {
        String s = Long.toString(z);
        while (s.length() < digits)
            s = "0" + s;
        return s;
    } // rightJustify()


    // Right-justify z as a radix base integer with digits digits,
    // padding to the left with zeroes if necessary.
    private static String rightJustify(final long z,
                                       final int digits,
                                       final int base) {
        String s = Long.toString(z, base);
        while (s.length() < digits)
            s = "0" + s;
        return s;
    } // rightJustify()

} // class DataGenerator
