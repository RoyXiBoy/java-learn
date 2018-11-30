package annotate;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Model excel field bind
 *
 * @author biezhi
 * @date 2018/2/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {

    /**
     * When the same field sequential read and write fields of use, for most cleanup.
     * start from 0
     *
     * @return field order
     */
    int order() default -1;

    /**
     * Set the field to write to the header name of Excel.
     *
     * @return excel header column title
     */
    String columnName() default "";

    /**
     * When a field is a Date or a Time type,
     * the configuration is valid for Date, LocalDate, LocalDateTime.
     *
     * @return Date format pattern
     */
    String datePattern() default "";

    /**
     * When a field is need to make red,
     * 0 no;1 red
     * @return Date format pattern
     */
    int red() default 0;


}
