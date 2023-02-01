package com.testvagrant.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.testvagrant.utils.BrowserAbstract.getDriver;

public class ImdbPage {

    public ImdbPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//*[@data-testid=\"title-details-section\"]//li")
    List<WebElement> listInfoData;

    public boolean getListInfoData(String result) {
        for (WebElement list : listInfoData) {
            if (list.getText().contains(result))
                return true;
        }
        return false;
    }
}
