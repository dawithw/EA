package edu.mum.cs;

import static org.junit.Assert.assertTrue;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.hamcrest.*;
import org.junit.Test;

import edu.mum.cs.domain.a.Department;

public class DepartmentTest {
    @Test
    public void testDepartmentCreation() {
        Department d = new Department("ComPro");
        boolean nameMatches = new IsEqualIgnoringCase("ComPro").matches(d.getName());
        
    }
}