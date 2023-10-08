package com.mtbp.db;

import java.util.Optional;

public interface BaseDbService<T, I> {
    T save(T value);

    Optional<T> findById(I id);

    boolean deleteById(I id);
}
