package com.example.Validators;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.model.User;

public class Validators implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "Name cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty");
		
		User user = (User) target;
		
		
		Pattern pattern = Pattern.compile("((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8})", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getPassword()).matches())) {
			errors.rejectValue("password", "Password is invalid");
		}

		
	}

}
