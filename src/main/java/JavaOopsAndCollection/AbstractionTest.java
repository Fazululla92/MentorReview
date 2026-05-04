package JavaOopsAndCollection;

interface first{
    void display();
}

interface second{
    void display();
}
 class AbstractionTest implements first, second{
     public void display() {
         System.out.println("adding dispaly");
     }

     static void main() {
         AbstractionTest id = new AbstractionTest();
         id.display();
     }
 }

//Interface is a set of rules and guidelines and interface is provide protocal for multiple classes.
//Interface variable if by default public static and final
//Interface method is by default abstract
//Interface abstracted till java 1.7
//Abstraction will achieve multiple inheritance in java through interface
