package com.jammers;

public interface Listener<T> {

    void trigger(T object);
}
