package com.gene.screenshots.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Job {

    /***
     * name of automated screenshot job
     */
    String name();

    /***
     * ID of the automated screenshot job
     */
    long ID();

    /***
     * label, a description of the screenshot automation job
     */
    String label();

}
