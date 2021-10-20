package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park actualPark1 = sut.getPark(1); // ACT
        assertParksMatch(PARK_1, actualPark1);

        Park actualPark2 = sut.getPark(2); // ACT
        assertParksMatch(PARK_2, actualPark2);

        Park actualPark3 = sut.getPark(3); // ACT
        assertParksMatch(PARK_3, actualPark3);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park shouldBeNull = sut.getPark(-1);
        Assert.assertNull(shouldBeNull);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parks = sut.getParksByState("AA");
        Assert.assertNotNull(parks);
        Assert.assertEquals(2, parks.size());
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> output = sut.getParksByState("PA");
        Assert.assertNotNull(output);
        Assert.assertEquals(0, output.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park newParkObjectInJavaButNotInDatabase = new Park(-9999, "Park 99999", LocalDate.parse("1800-01-02"), 100, true);
        Park newParkThatIsNowInDatabase = sut.createPark(newParkObjectInJavaButNotInDatabase); // ACT

        Assert.assertNotEquals(newParkThatIsNowInDatabase.getParkId(), -9999);

        newParkObjectInJavaButNotInDatabase.setParkId(newParkThatIsNowInDatabase.getParkId());
        assertParksMatch(newParkObjectInJavaButNotInDatabase, newParkThatIsNowInDatabase);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        Assert.fail();
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        Assert.fail();
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        Assert.fail();
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
