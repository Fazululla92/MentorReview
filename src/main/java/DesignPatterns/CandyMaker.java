public static class CandyMaker {

    private boolean empty;
    private boolean boiled;

    private static volatile CandyMaker instance;

    private CandyMaker() {
        empty = true;
        boiled = false;
    }

    public static CandyMaker getInstance() {
        if (instance == null) {
            synchronized (CandyMaker.class) {
                if (instance == null) {
                    instance = new CandyMaker();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}

static void main() {
    CandyMaker maker1 = CandyMaker.getInstance();
    CandyMaker maker2 = CandyMaker.getInstance();
    System.out.println(maker1 == maker2);
    maker1.fill();
    maker1.boil();
    maker1.drain();
    System.out.println("Is Empty: " + maker1.isEmpty());
    System.out.println("Is Boiled: " + maker1.isBoiled());
}
