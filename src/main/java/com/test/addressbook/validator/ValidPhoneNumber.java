package com.test.addressbook.validator;

import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Size(max = 10,min = 1)
@NotBlank
@Pattern(regexp = "^\\d{10}$")
public @interface ValidPhoneNumber {
    String message() default "Not a valid phone number";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
