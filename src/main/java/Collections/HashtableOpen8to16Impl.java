package Collections;

interface HashtableOpen8to16 {

    void insert(int key, Object value);

    Object search(int key);

    void remove(int key);

    int size();

    int[] keys();

    static HashtableOpen8to16 getInstance() {
        return new HashtableOpen8to16Impl();
    }
}

public class HashtableOpen8to16Impl implements HashtableOpen8to16 {

    private static class Entry {
        int key;
        Object value;
        boolean deleted;

        Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] table = new Entry[8];
    private int size = 0;

    private int index(int key, int length) {
        return (key & 0x7fffffff) % length;
    }

    public void insert(int key, Object value) {
        if (value == null) throw new NullPointerException();

        if (size == table.length) resize(table.length * 2);

        int idx = index(key, table.length);

        while (table[idx] != null && !table[idx].deleted && table[idx].key != key) {
            idx = (idx + 1) % table.length;
        }

        if (table[idx] == null || table[idx].deleted) {
            table[idx] = new Entry(key, value);
            size++;
        } else {
            table[idx].value = value;
        }
    }

    public Object search(int key) {
        int idx = index(key, table.length);
        int start = idx;

        while (table[idx] != null) {
            if (!table[idx].deleted && table[idx].key == key) return table[idx].value;
            idx = (idx + 1) % table.length;
            if (idx == start) break;
        }
        return null;
    }

    public void remove(int key) {
        int idx = index(key, table.length);
        int start = idx;

        while (table[idx] != null) {
            if (!table[idx].deleted && table[idx].key == key) {
                table[idx].deleted = true;
                size--;

                if (size > 0 && table.length > 2 && size <= table.length / 4) {
                    resize(table.length / 2);
                }
                return;
            }

            idx = (idx + 1) % table.length;
            if (idx == start) return;
        }
    }

    public int size() {
        return size;
    }

    public int[] keys() {
        int[] res = new int[size];
        int j = 0;

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].deleted) {
                res[j++] = table[i].key;
            }
        }
        return res;
    }

    private void resize(int newCap) {
        if (newCap > 16) {
            if (table.length == 16) throw new IllegalStateException();
            newCap = 16;
        }

        Entry[] old = table;
        table = new Entry[newCap];
        size = 0;

        for (int i = 0; i < old.length; i++) {
            if (old[i] != null && !old[i].deleted) {
                insert(old[i].key, old[i].value);
            }
        }
    }
}