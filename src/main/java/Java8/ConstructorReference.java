package Java8;
import java.util.function.Function;

public class ConstructorReference {
    String name;
    int account;
    double salary;
    ConstructorReference(String name, int account, double salary) {
        this.name = name;
        this.account = account;
        this.salary = salary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Account: " + account);
        System.out.println("Salary: ₹" + salary);
    }
}

interface EmpFactory {
    ConstructorReference create(String name, int account, double salary);
}

class Main {
    public static void main(String[] args) {
        EmpFactory factory = ConstructorReference::new;
        ConstructorReference e = factory.create("John", 12345, 50000);
        e.display();
    }
    }
