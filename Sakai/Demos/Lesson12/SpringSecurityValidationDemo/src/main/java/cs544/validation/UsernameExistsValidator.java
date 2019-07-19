package cs544.validation;

import cs544.domain.User;
import cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameExistsValidator implements ConstraintValidator<UsernameExists, User> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        User userExists = userService.findByUsername(user.getUsername());
        return userExists == null ? true : false;
    }

    @Override
    public void initialize(UsernameExists constraintAnnotation) {

    }
}
