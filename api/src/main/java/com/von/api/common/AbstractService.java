package com.von.api.common;

import com.von.api.enums.Messenger;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {

    public abstract List<T> findAll();
    public abstract Optional<T> findById(long id);
    public abstract String count();
    public abstract Optional<T> getOne(String id);
    public abstract String delete(T t);
    public abstract Boolean existsById(Long id);

    public abstract Messenger save(T t);





}
