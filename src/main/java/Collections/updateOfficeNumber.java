package Collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

class NewPostOfficeStorageImpl implements NewPostOfficeStorage {

    private final List<Box> storage = new ArrayList<>();

    @Override
    public boolean acceptBox(Box box) {
        if (box == null) throw new NullPointerException();
        storage.add(box);
        return true;
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if (boxes == null) throw new NullPointerException();

        List<Box> tmp = new ArrayList<>();
        for (Box b : boxes) {
            if (b == null) throw new NullPointerException();
            tmp.add(b);
        }
        storage.addAll(tmp);
        return true;
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if (boxes == null) throw new NullPointerException();

        for (Iterator<Box> it = storage.iterator(); it.hasNext(); ) {
            if (contains(boxes, it.next())) it.remove();
        }
        return true;
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> p) {
        if (p == null) throw new NullPointerException();

        List<Box> res = new ArrayList<>();
        for (Iterator<Box> it = storage.iterator(); it.hasNext(); ) {
            Box b = it.next();
            if (p.test(b)) {
                res.add(b);
                it.remove();
            }
        }
        return res;
    }

    @Override
    public List<Box> getAllWeightLessThan(double w) {
        return filter(b -> b.getWeight() < w);
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal c) {
        if (c == null) throw new NullPointerException();
        return filter(b -> b.getCost().compareTo(c) > 0);
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double v) {
        return filter(b -> b.getVolume() >= v);
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> p) {
        if (p == null) throw new NullPointerException();
        return filter(p);
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> p, int n) {
        if (p == null) throw new NullPointerException();

        for (Box b : storage)
            if (p.test(b)) b.setCost(BigDecimal.valueOf(20));
    }

    private List<Box> filter(Predicate<Box> p) {
        List<Box> res = new ArrayList<>();
        for (Box b : storage)
            if (p.test(b)) res.add(b);
        return res;
    }

    private boolean contains(Collection<Box> boxes, Box target) {
        for (Box b : boxes)
            if (Objects.equals(b, target)) return true;
        return false;
    }
}
