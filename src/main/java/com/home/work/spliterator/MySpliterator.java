package com.home.work.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class MySpliterator<R> implements Spliterator<R> {
    private final List<R> list;
    private AtomicInteger current = new AtomicInteger();

    public MySpliterator(List<R> list) {
        this.list = list;
        current.set(0);
    }

    public MySpliterator(List<R> list, int index) {
        this.list = list;
        current.set(index);
    }

    @Override
    public boolean tryAdvance(Consumer<? super R> action) {
        action.accept(list.get(current.getAndIncrement()));
        return current.get() < list.size();
    }

    @Override
    public Spliterator<R> trySplit() {
        int center = (int) (estimateSize() >>> 1);

        if(current.get() >= center) return null;
        Spliterator<R> spliterator = new MySpliterator<>(list.subList(current.get(), center));
        current.set(center);
        return spliterator;
    }

    @Override
    public long estimateSize() {
        return list.size() - current.get();
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | CONCURRENT;
    }
}
