package anderson.app.cbstring01;


public class Q01HelloName {
    public String helloName(String name) { // method prototype or signature
        String helloPrefix = "Hello "; // camelCaseConvention (for JAVA)
        // String hello_prefix = "Hello "; // snake_case_convention (for Python)
        return "Hello " + name + "!";
    }  
    

    public static void main(String[] args) {

        Q01HelloName myProgram = new Q01HelloName();
        System.out.println(myProgram.helloName("Alice"));
        System.out.println(myProgram.helloName("X"));
        System.out.println(myProgram.helloName("Bob"));
        System.out.println(myProgram.helloName("Dolly"));
        System.out.println(myProgram.helloName("Alpha"));
        System.out.println(myProgram.helloName("Omega"));
        System.out.println(myProgram.helloName("Goodbye"));
        System.out.println(myProgram.helloName("ho ho ho"));
        System.out.println(myProgram.helloName("xyz!"));
        System.out.println(myProgram.helloName("Hello"));
    }
}
