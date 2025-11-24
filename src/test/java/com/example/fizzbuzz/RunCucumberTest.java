package com.example.fizzbuzz;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Cucumber test runner class.
 * This class runs all the feature files in the features directory.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class RunCucumberTest {
}