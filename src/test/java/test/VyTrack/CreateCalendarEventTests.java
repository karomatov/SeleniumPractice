package test.VyTrack;

import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LoginPage;
import utils.TestBase;

public class CreateCalendarEventTests extends TestBase {
    @Test(description = "Verify owners name is equals to Stephan Hayley (it works on qa1 ....")
    public void test(){
        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        loginPage.login("storemanager85", "UserUser123");

        loginPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();

    }
}
