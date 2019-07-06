package edu.mum.cs;

import static org.junit.Assert.assertTrue;

import org.hamcrest.text.IsEqualIgnoringCase;

import org.junit.Test;

import edu.mum.cs.domain.a.Employee;

public class EmployeeTest {
    @Test
    public void testEmployeeCreation() {
        Employee e = new Employee("Dawit", "100-1001");
        //assertThat("name Matches", e.getName());

        boolean matchingNames = new IsEqualIgnoringCase("dawit").matchesSafely(e.getName());
        assertTrue(matchingNames);
    }
}