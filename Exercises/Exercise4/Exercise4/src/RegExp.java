import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegExp {

    public static void main(String[] args) {
        // Pattern 1: Email Address
        test("Email Address", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", new String[]{"user@neu.com"}, new String[]{"user@"});

        // Pattern 2: Time (HH:MM format, 24-hour clock)
        test("Time", "^([01]\\d|2[0-3]):([0-5]\\d)$", new String[]{"14:30", "23:59"}, new String[]{"24:00", "14:60"});

        // Pattern 3: ZIP Code
        test("ZIP Code", "^\\d{5}(?:[-\\s]\\d{4})?$", new String[]{"12345-6789"}, new String[]{"1234"});

        // Pattern 4: Phone Number
        test("Phone Number", "^\\(\\d{3}\\) \\d{3}-\\d{4}$", new String[]{"(123) 456-7890"}, new String[]{"4567890"});

        // Pattern 5: Strong Password
        test("Strong Password", "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", new String[]{"Password@123", "Again&123"}, new String[]{"12345", "password"});

    }

    private static void test(String type, String regex, String[] positiveCases, String[] negativeCases) {
        //System.out.println("Testing " + type + " Pattern:");
        System.out.println("Regex: " + regex);

        // Test positive cases
        //System.out.println("Positive Cases:");
        for (String caseStr : positiveCases) {
            System.out.println("  " + caseStr + " -> " + matches(caseStr, regex));
        }

        // Test negative cases
        //System.out.println("Negative Cases:");
        for (String caseStr : negativeCases) {
            System.out.println("  " + caseStr + " -> " + matches(caseStr, regex));
        }

        System.out.println();
    }

    private static boolean matches(String subject, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(subject);
        return matcher.matches();
    }
}
