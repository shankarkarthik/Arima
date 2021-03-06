/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet.mvc.method.annotation.support;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Thrown by {@link RequestResponseBodyMethodProcessor} when an @{@link RequestBody} argument annotated with 
 * {@code @Valid} results in validation errors.
 * 
 * @author Rossen Stoyanchev
 * @since 3.1
 */
@SuppressWarnings("serial")
public class RequestBodyNotValidException extends RuntimeException {

	private final Errors errors;

	/**
	 * @param errors contains the results of validating an @{@link RequestBody} argument.
	 */
	public RequestBodyNotValidException(Errors errors) {
		this.errors = errors;
	}

	/**
	 * Returns an Errors instance with validation errors. 
	 */
	public Errors getErrors() {
		return errors;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder("Request body content validation failed: ");
		sb.append(errors.getErrorCount()).append(" errors");
		for (ObjectError error : errors.getAllErrors()) {
			sb.append('\n').append(error);
		}
		return sb.toString();
	}
	
}
