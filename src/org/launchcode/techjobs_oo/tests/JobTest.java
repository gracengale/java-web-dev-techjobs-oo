package org.launchcode.techjobs_oo.tests;

import org.launchcode.techjobs_oo.*;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.Position;

import static org.junit.Assert.*;


public class JobTest {

    Job testJob1;
    Job testJob2;

    @Before
    public void createJobObjects() {
        testJob1 = new Job();
        testJob2 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, testJob2.getId()-testJob1.getId(), 0);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job tester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue((tester.getEmployer() instanceof Employer));
        assertTrue((tester.getLocation() instanceof Location));
        assertTrue((tester.getPositionType() instanceof PositionType));
        assertTrue((tester.getCoreCompetency() instanceof CoreCompetency));
        assertEquals("Product tester", tester.getName());
        assertEquals("ACME", tester.getEmployer().getValue());
        assertEquals("Desert", tester.getLocation().getValue());
        assertEquals("Quality control", tester.getPositionType().getValue());
        assertEquals("Persistence", tester.getCoreCompetency().getValue());
        assertNotNull(tester.getId());
    }

    @Test
    public void testJobsForEquality() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse((test1.equals(test2)));
    }



}
