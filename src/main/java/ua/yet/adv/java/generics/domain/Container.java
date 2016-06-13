package ua.yet.adv.java.generics.domain;

import java.util.Collection;

public class Container<T extends Product<T>> {

    private T item;

    public Container(T item) {
        this.item = item;
    }

    public void copy(Collection<? extends T> src, Collection<? super T> dest) {
        for (T product : src) {
            dest.add(product);
        }
    }

    public T getItem() {
        return item;
    }

    public static <S extends Product<S>> void copyStatic(Collection<S> src,
            Collection<? super S> dest) {
        for (S product : src) {
            dest.add(product);
        }
    }

}
