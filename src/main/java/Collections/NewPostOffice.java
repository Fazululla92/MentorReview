package Collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {

    private Collection<Box> boxes;

    public NewPostOffice() {
        this.boxes = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return boxes;
    }
    public static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal weightCost = BigDecimal.valueOf(weight).multiply(BigDecimal.valueOf(10));
        BigDecimal volumeCost = BigDecimal.valueOf(volume).multiply(BigDecimal.valueOf(20));
        BigDecimal valueCost = BigDecimal.valueOf(value).multiply(BigDecimal.valueOf(0.5));

        return weightCost.add(volumeCost).add(valueCost);
    }

    public boolean addBox(String sender, String recipient, double weight, double volume, int value) {

        if (sender == null || recipient == null || sender.isEmpty() || recipient.isEmpty()) {
            throw new IllegalArgumentException("Sender/Recipient invalid");
        }

        if (weight < 0.5 || weight > 20.0) {
            throw new IllegalArgumentException("Invalid weight");
        }

        if (volume <= 0 || volume >= 0.25) {
            throw new IllegalArgumentException("Invalid volume");
        }

        if (value <= 0) {
            throw new IllegalArgumentException("Invalid value");
        }

        BigDecimal cost = calculateCostOfBox(weight, volume, value);

        Box box = new Box(sender, recipient, weight, volume, value, cost);
        boxes.add(box);

        return true;
    }
    public Collection<Box> deliveryBoxToRecipient(String recipient) {

        Collection<Box> result = new ArrayList<>();
        Iterator<Box> iterator = boxes.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();

            if (box.getRecipient().equals(recipient)) {
                result.add(box);
                iterator.remove(); // safe removal using iterator
            }
        }

        return result;
    }
    public void declineCostOfBox(double percent) {

        if (percent < 0) {
            throw new IllegalArgumentException("Percent cannot be negative");
        }

        Iterator<Box> iterator = boxes.iterator();

        while (iterator.hasNext()) {
            Box box = iterator.next();

            BigDecimal currentCost = box.getCost();
            BigDecimal discount = currentCost.multiply(BigDecimal.valueOf(percent / 100.0));
            BigDecimal newCost = currentCost.subtract(discount);

            box.setCost(newCost);
        }
    }
}
