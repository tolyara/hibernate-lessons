package main.java.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import main.java.models.magazine.OrderM;
import main.java.models.magazine.ProductM;

public class ValidationUtil {

	public static void checkValidation() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();

		ProductM product = new ProductM();
		product.setTitle("");
		
		OrderM order = new OrderM();
		order.setStatus(true);
		order.setProduct(product);
		
		Set<ConstraintViolation<Object>> violations = validator.validate(order);
		for (ConstraintViolation<Object> violation : violations) {
			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append("invalid value = " + violation.getInvalidValue() + "\n");
			stringBuilder.append("message = " + violation.getMessage() + "\n");
			stringBuilder.append("property = " + violation.getPropertyPath() + "\n");

			System.out.println(stringBuilder);
			System.out.println();
		}
	}

}
