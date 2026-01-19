package test.example.demo2;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(CalculatorTest.class)
@IncludeTags({"dev", "Dev"})
public class DevTaggedTestSuite {

}
