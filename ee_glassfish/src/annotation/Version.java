package annotation;

public @interface Version {

    int value();
    double version() default 0.1;
    String author() default "Lopat";
}
