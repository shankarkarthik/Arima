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

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.core.style.ToStringCreator;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * TODO [SPR-8386] Document MergedContextConfiguration.
 * 
 * @author Sam Brannen
 * @since 3.1
 * @see ContextConfiguration
 * @see ActiveProfiles
 */
public class MergedContextConfiguration {

	private final Class<?> testClass;

	private final String[] locations;

	private final Class<?>[] classes;

	private final String[] activeProfiles;

	private final ContextLoader contextLoader;


	private static String[] processLocations(String[] locations) {
		return locations == null ? new String[] {} : locations;
	}

	private static Class<?>[] processClasses(Class<?>[] classes) {
		return classes == null ? new Class<?>[] {} : classes;
	}

	private static String[] processActiveProfiles(String[] activeProfiles) {
		if (activeProfiles == null) {
			return new String[] {};
		}

		// Active profiles must be unique and sorted due to cache key generation
		// in TestContext. Specifically, profile sets {foo,bar} and {bar,foo}
		// must both result in the same array (e.g., [bar,foo]).
		SortedSet<String> sortedProfilesSet = new TreeSet<String>(Arrays.asList(activeProfiles));
		return StringUtils.toStringArray(sortedProfilesSet);
	}

	/**
	 * TODO Document MergedContextConfiguration constructor.
	 *
	 * @param testClass
	 * @param locations
	 * @param classes
	 * @param activeProfiles
	 * @param contextLoader
	 */
	public MergedContextConfiguration(Class<?> testClass, String[] locations, Class<?>[] classes,
			String[] activeProfiles, ContextLoader contextLoader) {
		this.testClass = testClass;
		this.locations = processLocations(locations);
		this.classes = processClasses(classes);
		this.activeProfiles = processActiveProfiles(activeProfiles);
		this.contextLoader = contextLoader;
	}

	/**
	 * TODO Document getTestClass().
	 */
	public Class<?> getTestClass() {
		return this.testClass;
	}

	/**
	 * TODO Document getLocations().
	 */
	public String[] getLocations() {
		return this.locations;
	}

	/**
	 * TODO Document getClasses().
	 */
	public Class<?>[] getClasses() {
		return this.classes;
	}

	/**
	 * TODO Document getActiveProfiles().
	 */
	public String[] getActiveProfiles() {
		return this.activeProfiles;
	}

	/**
	 * TODO Document getContextLoader().
	 */
	public ContextLoader getContextLoader() {
		return this.contextLoader;
	}

	/**
	 * TODO Document overridden toString().
	 */
	@Override
	public String toString() {
		return new ToStringCreator(this)//
		.append("testClass", this.testClass)//
		.append("locations", ObjectUtils.nullSafeToString(this.locations))//
		.append("classes", ObjectUtils.nullSafeToString(this.classes))//
		.append("activeProfiles", ObjectUtils.nullSafeToString(this.activeProfiles))//
		.append("contextLoader", this.contextLoader)//
		.toString();
	}

}
