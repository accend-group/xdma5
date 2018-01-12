package com.gene.screenshots.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// option to use domain from annotation over json
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Environment {

    String dev();

    String local();

    String prod();

    String stage();
}
