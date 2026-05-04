package JavaOopsAndCollection;

public class Inheritance {
    public static void main(String[] args) {
        son s = new son();
        s.house();
        s.vehicles();
        s.flat();
    }
}

class grandfather {
    public void house(){
        System.out.println("5 houses");
    }

    public void land(){
        System.out.println("8 acers");
    }

    public void debt(){
        System.out.println("15 lakh loan");
    }
}

class father extends grandfather {
    public void flat(){
        System.out.println("3 flats");
    }
}

class son extends father{
    public void vehicles(){
        System.out.println("2 cars and 4 bikes");
    }
}


//Inheritance :-
//Aquiring properties from super class to subclass
//types of inheritance
//1)single inheritance super class A (B extends A)
