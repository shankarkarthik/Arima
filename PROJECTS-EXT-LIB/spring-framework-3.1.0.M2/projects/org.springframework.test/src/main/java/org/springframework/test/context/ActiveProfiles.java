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

package org.springframework.test.context;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code ActiveProfiles} is a class-level annotation that is used to declare
 * which <em>active bean definition profiles</em> should be used when loading
 * an {@link org.springframework.context.ApplicationContext ApplicationContext}
 * for test classes.
 *
 * @author Sam Brannen
 * @since 3.1
 * @see ContextConfiguration
 * @see ContextLoader
 * @see org.springframework.context.ApplicationContext
 * @see org.springframework.context.annotation.Profile
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ActiveProfiles {

	/**
	 * Alias for {@link #profiles() profiles}.
	 * 
	 * <p>This attribute may <strong>not</strong> be used in conjunction
	 * with {@link #profiles}, but it may be used <em>instead</em> of
	 * {@link #profiles}.
	 */
	String[] value() default {};

	/**
	 * The list of bean definition profiles to activate.
	 * 
	 * <p>This attribute may <strong>not</strong> be used in conjunction
	 * with {@link #value}, but it may be used <em>instead</em> of
	 * {@link #value}.
	 */
	String[] profiles() default {};

	/**
	 * TODO Document inheritProfiles.
	 */
	boolean inheritProfiles() default true;

}
