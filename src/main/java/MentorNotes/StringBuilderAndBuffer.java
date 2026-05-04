package MentorNotes;

public class StringBuilderAndBuffer {
    static void main() {
        //string is immutable, means: value can not be changed
        //string can be used for passwords/ urls
        String s = "Fazul";
        s.concat("world");
        System.out.println(s); //    s.concat(" World"); we can't add here still s = Fazul
        //The object is stored in Heap memory
        //Heap is a memory area where objects are stored. Mutability depends on the object type, not the heap
        String heap = new String("Java");

//        “Thread-safe means only one thread can access a resource at a time using synchronization, while non-thread-safe allows multiple threads which may lead to inconsistent data.”

//String Builder
        // is Mutable (can change content)
        //Not thread-safe
        //Faster
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb); // Hello World

//String Buffer
        //is Mutable
        //Thread-safe (synchronized)
        //Slower than StringBuilder
        StringBuffer sbf = new StringBuffer("Hi");
        sbf.append(" there");
        System.out.println(sbf); //Hi there

//🔹 When to Use What?
//👉 Use StringBuilder:
//Single-threaded applications
//High performance required
// Most common in real-world coding

//👉 Use StringBuffer:
//Multi-threaded environment
//When thread safety is required

//In 90% of cases:
//👉 Use StringBuilder
//👉 Use StringBuffer only when multiple threads modify the same string

    }
}
