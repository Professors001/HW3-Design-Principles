import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LoginSystem {

    private static final String NAME_PATTERN = "[a-zA-Z]+";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
    private static final List<String> notAllowDomains = Arrays.asList("dom1.cc", "dom2.cc", "dom3.cc");
    private static final int MIN_AGE = 20;

    public boolean register(User user) {
        checkName(user.getName());
        checkEmail(user.getEmail());
        checkAge(user.getAge());
        return true;
    }

    private void checkName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name should not be empty");
        }

        if (!name.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException("Name is wrong format");
        }
    }

    private void checkEmail(String email) {
        if (isEmpty(email)) {
            throw new IllegalArgumentException("Email should not be empty");
        }
        if (!validEmailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Email is wrong format");
        }
        String domain = email.split("@")[1];
        if (notAllowDomains.contains(domain)) {
            throw new IllegalArgumentException("Domain Email is not allow");
        }
    }

    private void checkAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age should more than 20 years");
        }
    }


    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
//6510451085 อภิสิทธิ์ ประเสริฐเวศยากร