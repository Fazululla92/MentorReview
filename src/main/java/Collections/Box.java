package Collections;

import java.math.BigDecimal;

public class Box {
    private String sender;
    private String recipient;
    private double weight;
    private double volume;
    private int value;
    private BigDecimal cost;

    public Box(String sender, String recipient, double weight, double volume, int value, BigDecimal cost) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
        this.volume = volume;
        this.value = value;
        this.cost = cost;
    }

    public String getSender() { return sender; }
    public String getRecipient() { return recipient; }
    public double getWeight() { return weight; }
    public double getVolume() { return volume; }
    public int getValue() { return value; }
    public BigDecimal getCost() { return cost; }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
