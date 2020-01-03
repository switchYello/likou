package tree;

public class Pair<T, F> {

    private T key;
    private F value;

    public Pair(T key, F value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public F getValue() {
        return value;
    }

    public void setValue(F value) {
        this.value = value;
    }
}
