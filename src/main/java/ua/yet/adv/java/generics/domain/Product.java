package ua.yet.adv.java.generics.domain;

public abstract class Product<T extends Product<T>> implements Comparable<T> {

    protected String name;

    public Product(String name) {
        super();
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    protected abstract int deepCompare(T product);

    @Override
    public int compareTo(T other) {
        if (other != null) {
            if (name == null && other.name == null) {
                return deepCompare(other);
            } else if (name != null) {
                int result = name.compareTo(other.name);
                if (result == 0) {
                    result = deepCompare(other);
                }
                return result;
            } else {
                return 1;
            }
        } else {
            return -1;
        }
    }

}
