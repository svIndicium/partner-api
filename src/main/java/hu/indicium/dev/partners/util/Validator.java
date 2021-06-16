package hu.indicium.dev.partners.util;

public interface Validator<T> {
    void validate(T entity);
}
