//package Collections;
//
//import java.util.*;
//
//public class NewPostOfficeManagementImpl implements NewPostOfficeManagement {
//
//    private final List<Box> storage;
//
//    public NewPostOfficeManagementImpl(List<Box> storage) {
//        this.storage = storage;
//    }
//
//    public Optional<Box> getBoxById(int id) {
//
//        List<Box> sorted = new ArrayList<>(storage);
//
//        Comparator<Box> byId = new Comparator<Box>() {
//            public int compare(Box a, Box b) {
//                return Integer.compare(extractId(a), extractId(b));
//            }
//        };
//
//        Collections.sort(sorted, byId);
//
//        int index = Collections.binarySearch(
//                sorted,
//                null,
//                new Comparator<Box>() {
//                    public int compare(Box a, Box b) {
//                        return Integer.compare(a.getId(), id);
//                    }
//                }
//        );
//
//        if (index < 0) return Optional.empty();
//        return Optional.of(sorted.get(index));
//    }
//
//    public String getDescSortedBoxesByWeight() {
//
//        List<Box> sorted = new ArrayList<>(storage);
//
//        Collections.sort(sorted, new Comparator<Box>() {
//            public int compare(Box a, Box b) {
//                return Double.compare(b.getWeight(), a.getWeight());
//            }
//        });
//
//        StringBuilder sb = new StringBuilder();
//
//        for (Box b : sorted) {
//            sb.append(b).append("\n");
//        }
//
//        return sb.toString();
//    }
//
//    public String getAscSortedBoxesByCost() {
//
//        List<Box> sorted = new ArrayList<>(storage);
//
//        Collections.sort(sorted, new Comparator<Box>() {
//            public int compare(Box a, Box b) {
//                return a.getCost().compareTo(b.getCost());
//            }
//        });
//
//        StringBuilder sb = new StringBuilder();
//
//        for (Box b : sorted) {
//            sb.append(b).append("\n");
//        }
//
//        return sb.toString();
//    }
//
//    public List<Box> getBoxesByRecipient(String recipient) {
//
//        if (recipient == null) throw new NullPointerException();
//
//        List<Box> sorted = new ArrayList<>(storage);
//
//        Comparator<Box> byRecipient = new Comparator<Box>() {
//            public int compare(Box a, Box b) {
//                return a.getRecipient().compareTo(b.getRecipient());
//            }
//        };
//
//        Collections.sort(sorted, byRecipient);
//
//        int index = Collections.binarySearch(
//                sorted,
//                null,
//                new Comparator<Box>() {
//                    public int compare(Box a, Box b) {
//                        return a.getRecipient().compareTo(recipient);
//                    }
//                }
//        );
//
//        if (index < 0) return new ArrayList<>();
//
//        List<Box> result = new ArrayList<>();
//
//        int i = index;
//
//        while (i >= 0 && sorted.get(i).getRecipient().equals(recipient)) {
//            i--;
//        }
//
//        i++;
//
//        while (i < sorted.size() && sorted.get(i).getRecipient().equals(recipient)) {
//            result.add(sorted.get(i));
//            i++;
//        }
//
//        return result;
//    }
//}
//
//interface NewPostOfficeManagement {
//
//    Optional<Box> getBoxById(int id);
//
//    String getDescSortedBoxesByWeight();
//
//    String getAscSortedBoxesByCost();
//
//    List<Box> getBoxesByRecipient(String recipient);
//}