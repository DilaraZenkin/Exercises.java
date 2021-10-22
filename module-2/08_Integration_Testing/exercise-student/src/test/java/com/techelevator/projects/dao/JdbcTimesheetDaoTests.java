package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;
    private Timesheet testTimesheet;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
        testTimesheet = new Timesheet(5L, 2L, 2L,
                LocalDate.parse("2021-02-01"), 1.25, true, "Timesheet 5");


    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet actualTimeSheet1 = sut.getTimesheet(1L);
        Assert.assertNotNull(actualTimeSheet1);
        assertTimesheetsMatch(TIMESHEET_1, actualTimeSheet1);

        Timesheet actualTimeSheet2 = sut.getTimesheet(2L);
        assertTimesheetsMatch(TIMESHEET_2, actualTimeSheet2);

        Timesheet actualTimeSheet3 = sut.getTimesheet(3L);
        assertTimesheetsMatch(TIMESHEET_3, actualTimeSheet3);

        Timesheet actualTimeSheet4 = sut.getTimesheet(4L);
        assertTimesheetsMatch(TIMESHEET_4, actualTimeSheet4);

    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {

        Timesheet shouldBeNull = sut.getTimesheet(-1L);
        Assert.assertNull(shouldBeNull);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {

        List<Timesheet> timesheets = sut.getTimesheetsByEmployeeId(1L);
        Assert.assertNotNull(timesheets);
        Assert.assertEquals(2, timesheets.size());
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertNotNull(timesheets);
        Assert.assertEquals(3, timesheets.size());

       // private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
               // LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
               Timesheet newTimesheetThatIsNotInDatabase = new Timesheet(5L, 2L, 2L,
               LocalDate.parse("2021-02-01"), 1.25, true, "Timesheet 5");

     Timesheet newTimesheetThatIsNowInDatabase = sut.createTimesheet(newTimesheetThatIsNotInDatabase);

     Long newId = newTimesheetThatIsNowInDatabase.getTimesheetId();
     //Assert.assertTrue(newId>0L);

     newTimesheetThatIsNotInDatabase.setTimesheetId(newId);
     assertTimesheetsMatch(newTimesheetThatIsNotInDatabase, newTimesheetThatIsNowInDatabase);

        //Assert.assertNotEquals();


    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        Long newId = createdTimesheet.getTimesheetId();
        Timesheet retrievedCity = sut.getTimesheet(newId);

        assertTimesheetsMatch(createdTimesheet, retrievedCity);


    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {

        Timesheet timesheetToUpdate = sut.getTimesheet(1L);
        Assert.assertNotNull(timesheetToUpdate);

        timesheetToUpdate.setDateWorked(LocalDate.parse("2021-01-03"));
        timesheetToUpdate.setHoursWorked(4.0);
        timesheetToUpdate.setBillable(false);
        timesheetToUpdate.setDescription("Timesheet 1, updated");

        sut.updateTimesheet(timesheetToUpdate);

        Timesheet retrievedTimesheet = sut.getTimesheet(1L);
        assertTimesheetsMatch(timesheetToUpdate, retrievedTimesheet);
//        Timesheet timesheetToUpdate = sut.getTimesheet(1L);
//        Assert.assertNotNull(timesheetToUpdate);
//
//        timesheetToUpdate.getEmployeeId();
//        timesheetToUpdate.setProjectId(1L);
//        timesheetToUpdate.setDateWorked(LocalDate.parse("2021-01-01"));
//        timesheetToUpdate.setHoursWorked(1.0);
//        timesheetToUpdate.setBillable(true);
//        timesheetToUpdate.setDescription("Timesheet 1");
//
//        sut.updateTimesheet(timesheetToUpdate);
//
//        Timesheet retrieved = sut.getTimesheet(1L);
//        assertTimesheetsMatch(timesheetToUpdate, retrieved);




    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(3L);

        Timesheet retrievetTimesheet = sut.getTimesheet(3L);
        Assert.assertNull(retrievetTimesheet);

        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));


            }

    @Test
    public void getBillableHours_returns_correct_total() {
        double totalBillableHours = sut.getBillableHours(1L, 1L);
    Assert.assertEquals(2.5, totalBillableHours, 0.001);

        double totalBillableHours2 = sut.getBillableHours(1L, 2L);
        Assert.assertEquals(0, totalBillableHours2, 0.001);

        double totalBillableHours3 = sut.getBillableHours(2L, 1L);
        Assert.assertEquals(0.25, totalBillableHours3, 0.001);

        double totalBillableHours4 = sut.getBillableHours(2L, 2L);
        Assert.assertEquals(0.0, totalBillableHours4, 0.001);


    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
