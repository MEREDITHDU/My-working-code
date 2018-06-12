package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AccountTest.class,
    TestAssest.class,
    TestSequence.class,})
public class TestSuite {
}
