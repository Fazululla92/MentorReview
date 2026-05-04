package MentorNotes;

public class FourPillars {
    static void main() {
        //inheritance
        sub s = new sub();
        s.A();
        s.B();
        s.C();

        //Encapsulation
        Encap en = new Encap();
        en.setId(17);
        System.out.println(en.getId());

        //polymorphism
        polymorphism p = new polymorphism();
        p.add(5,2);
        p.add(2,5,7);

        //Abstraction
        Dog dog = new Dog();
        dog.sound();
        dog.display();
        System.out.println(dog.name);

//        interface
        Environment environment = new Environment();
        environment.sound();
        environment.play();
        environment.music();
        pet.dance();  //static method (via interface name)
        System.out.println(Human.x);

    }
}

class inherit {
    public void A() {
        System.out.println("method A");
    }

    public void B() {
        System.out.println("method B");
    }
    public void C() {
        System.out.println("method C");
    }

}
class sub extends inherit {
    public void A() {
        System.out.println("override method A");
    }

    public void C() {
        System.out.println("override method C");
    }
}

class polymorphism {
    public void add(int a, int b){
        int sum = a+b;
        System.out.println(sum);
    }

    public void add(int a,int b, int c){
        int sum = a+b+c;
        System.out.println(sum);
    }
}



class Encap {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}

abstract class Animal{
        String name = "Animal";
        //Can have abstract methods (no body) and concrete methods (with body)
        abstract void sound();
        //concrete methods
        public void display(){
            System.out.println("This is an Animal");
        }
}

class Dog extends Animal{
        void sound(){
            System.out.println("barking....");
        }

}

interface Human {
    int x = 10;
    void sound();
}

interface pet {
    default void play(){
        System.out.println("play form interface pet");
    }

    void music();
    static void dance(){
        System.out.println("dance from interface pet");
    }
}

class Environment implements Human,pet {
    public void sound(){
        System.out.println("sound from env class");
    }

    public void music(){
        System.out.println("music from env class");
    }

}


    /*Encapsulation
    Wrapping data (variables) and methods into a single unit (class) or
    Encapsulation is used to achieve data hiding by making variables private and providing controlled access through getter and setter methods

    Inheritance helps in code reusability by allowing a child class to use the features of a parent class using the extends keyword.

    Polymorphism allows the same method to perform different tasks, achieved through method overloading (compile-time) and method overriding (runtime).

    Abstraction focuses on what an object does rather than how it does it,
        and it is achieved using abstract classes and interfaces.
    1)Cannot be instantiated (you can’t create objects)
    2)Can have abstract methods (without body) and concrete methods (with body)
    3)Can also have variables

    interface
    1)Contains only abstract methods (by default)
    2)Variables are public, static, final (constants)


*Feature*         	       *Abstract Class*	            *Interface*
Methods	                Abstract + Concrete	        Only abstract (mostly)
Variables	            Normal variables	        Only constants
Constructors	        ✅ Yes	                    ❌ No
Inheritance	            Single	                    Multiple
Keyword	                extends	                    implements
    An abstract class is used when we want partial abstraction with common functionality, whereas an interface is used to achieve full abstraction and multiple inheritance by defining a contract that classes must implement


    */
