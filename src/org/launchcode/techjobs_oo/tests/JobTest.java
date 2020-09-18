package org.launchcode.techjobs_oo.tests;

import org.launchcode.techjobs_oo.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class JobTest {

    Job testJob1;
    Job testJob2;
    Job testJob3;

    @Before
    public void createJobObjects() {
        testJob1 = new Job();
        testJob2 = new Job();
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, testJob2.getId()-testJob1.getId(), 0);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue((testJob3.getEmployer() instanceof Employer));
        assertTrue((testJob3.getLocation() instanceof Location));
        assertTrue((testJob3.getPositionType() instanceof PositionType));
        assertTrue((testJob3.getCoreCompetency() instanceof CoreCompetency));
        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertEquals("Quality control", testJob3.getPositionType().getValue());
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());
        assertNotNull(testJob3.getId());
    }

    @Test
    public void testJobsForEquality() {
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse((testJob3.equals(testJob4)));
    }

    @Test
    public void testBlankLinesSurroundToString() {
        String whole = testJob3.toString();
        String noBlankLines = testJob3.toString().trim();
        assertFalse((whole.equals(noBlankLines)));
    }

    @Test
    public void testToStringFormat() {
        String expected = "\n" +
                "ID: " + testJob3.getId() +
                "\nName: " + testJob3.getName() +
                "\nEmployer: " + testJob3.getEmployer().getValue() +
                "\nLocation: " + testJob3.getLocation().getValue() +
                "\nPosition Type: " + testJob3.getPositionType().getValue() +
                "\nCore Competency: " + testJob3.getCoreCompetency().getValue() +
                "\n";
        assertEquals(expected, testJob3.toString());
    }

    @Test
    public void testForNullFieldsExceptions() {
        Job testJob5 = new Job(null, new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
        String nullMessage = "Data not available";
        String expected = "\n" +
                "ID: " + testJob5.getId() +
                "\nName: " + nullMessage +
                "\nEmployer: " + testJob5.getEmployer().getValue() +
                "\nLocation: " + nullMessage +
                "\nPosition Type: " + nullMessage +
                "\nCore Competency: " + testJob5.getCoreCompetency().getValue() +
                "\n";
        assertEquals(expected, testJob5.toString());
    }
}
