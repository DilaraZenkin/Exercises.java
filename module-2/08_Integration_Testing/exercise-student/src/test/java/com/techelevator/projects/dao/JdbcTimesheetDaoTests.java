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


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);

    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet actualTimeSheet1 = sut.getTimesheet(1L);
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
        Assert.assertEquals(1, timesheets.size());
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertNotNull(timesheets);
        Assert.assertEquals(2, timesheets.size());

    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet newTimesheetThatIsNotInDatabase = new Timesheet(5L, 3L, 2L,
                LocalDate.parse("2021-02-01"), 1.25, true, "Timesheet 5");
        Timesheet newTimesheetThatIsNowInDatabase = sut.createTimesheet(newTimesheetThatIsNotInDatabase);

        //Assert.assertNotEquals();


    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        Assert.fail();
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Assert.fail();
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
