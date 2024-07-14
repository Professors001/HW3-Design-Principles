public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User a = new User("james", "james_123@gmail.com", 21);
        LoginSystem loginSystem = new LoginSystem();
        if(loginSystem.register(a)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
        }
    }
}

//6510451085 อภิสิทธิ์ ประเสริฐเวศยากร