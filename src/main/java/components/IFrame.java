package components;

import static pages.BasePage.getDriver;

public interface IFrame {
    default void switchIframe() {
        getDriver().switchTo().frame("framelive");
        System.out.println("I switch to frame");
    }
}
