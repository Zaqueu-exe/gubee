package com.alves.model.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.METHOD, ElementType.MODULE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction {

}
