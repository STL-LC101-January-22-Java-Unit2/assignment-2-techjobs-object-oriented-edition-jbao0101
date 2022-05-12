package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job testJob;
    Job testJob2;

    @Before
    public void createJobObject(){
        testJob = new Job("name", new Employer("employer"), new Location("location"), new PositionType("positionType"),
                new CoreCompetency("coreCompetency"));
    }

    @Before
    public void createJobObject2(){
        testJob2 = new Job("name2", new Employer("employer2"), new Location("location2"), new PositionType("positionType2"),
                new CoreCompetency("coreCompetency2"));
    }

    @Test
    public void testSettingJobId(){assertTrue(testJob2.getId() - testJob.getId() == 1);}

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob3.getName(), "Product tester");
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob3.getEmployer() instanceof Employer);
    }

    @Test
    public void testJobsForEquality(){
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob4 == testJob5);
    }

    @Test
    public void testToStringMethod(){
        Job emptyTestJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(testJob.toString().startsWith("\n"), true);
        assertTrue(testJob.toString().indexOf("Index: ")<testJob.toString().indexOf("1"));
        assertTrue(testJob.toString().indexOf("Name: ")<testJob.toString().indexOf("name"));
        assertTrue(testJob.toString().indexOf("Employer: ")<testJob.toString().indexOf("employer"));
        assertTrue(testJob.toString().indexOf("Location: ")<testJob.toString().indexOf("location"));
        assertTrue(testJob.toString().indexOf("Position Type: ")<testJob.toString().indexOf("positionType"));
        assertTrue(testJob.toString().indexOf("Core Competency: ")<testJob.toString().indexOf("coreCompetency"));
        assertEquals(emptyTestJob.toString(), "\nID: " + emptyTestJob.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n");
    }

}