package test.VyTrack;

import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventPage;
import pages.LogInPage;
import utils.TestBase;

public class CreateCalendarEventTests extends TestBase {
    @Test(description = "Verify owners name is equals to Stephan Hayley (it works on qa1 ....")
    public void test(){
        LogInPage loginPage = new LogInPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();
        loginPage.login("storemanager85", "UserUser123");

        loginPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();

    }
}
