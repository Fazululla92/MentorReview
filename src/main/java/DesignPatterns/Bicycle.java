package DesignPatterns;

public class Bicycle {
    private final boolean gears;
    private final boolean doubleStand;
    private final boolean doubleSeat;
    private final boolean carrier;

    private Bicycle(Builder builder) {
        this.gears = builder.gears;
        this.doubleStand = builder.doubleStand;
        this.doubleSeat = builder.doubleSeat;
        this.carrier = builder.carrier;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "gears=" + gears +
                ", doubleStand=" + doubleStand +
                ", doubleSeat=" + doubleSeat +
                ", carrier=" + carrier +
                '}';
    }

    public static class Builder {

        private boolean gears;
        private boolean doubleStand;
        private boolean doubleSeat;
        private boolean carrier;

        public Builder setGears(boolean gears) {
            this.gears = gears;
            return this;
        }

        public Builder setDoubleStand(boolean doubleStand) {
            this.doubleStand = doubleStand;
            return this;
        }

        public Builder setDoubleSeat(boolean doubleSeat) {
            this.doubleSeat = doubleSeat;
            return this;
        }

        public Builder setCarrier(boolean carrier) {
            this.carrier = carrier;
            return this;
        }

        public Bicycle build() {
            return new Bicycle(this);
        }
    }
    public static void main(String[] args) {

        Bicycle bicycle = new Bicycle.Builder()
                .setGears(true)
                .setDoubleStand(true)
                .setDoubleSeat(false)
                .setCarrier(true)
                .build();

        System.out.println(bicycle);
    }
}