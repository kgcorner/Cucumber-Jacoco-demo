package com.kgcorner.Demo.BDD;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kgcorner.Demo.BDD.Model.Book;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by admin on 3/15/2018.
 */
@ConfigTest
public class BooksFeature {

    private String REQUEST_BOOK_URL = "http://localhost:8080/books?count=%d";

    @When("^'(\\d+)' Books are requested$")
    public void booksAreRequested(int count) throws Throwable {
        REQUEST_BOOK_URL = String.format(REQUEST_BOOK_URL, count);
    }

    @Then("^List of '(\\d+)' books should be returned with status '(\\d+)'$")
    public void listOfBooksShouldBeReturnedWithStatus(int count, int status) throws Throwable {
        Response response = HttpUtilForTest.sendGetRequest(REQUEST_BOOK_URL, null);
        Type type = new TypeToken<List<Book>>() {}.getType();
        List<Book> books = new Gson().fromJson(response.getResponseData(), type);
        Assert.assertNotNull("Response is null", books);
        Assert.assertEquals("Number of books returned are not maching", count, books.size());
        Assert.assertEquals("Status code is not maching", status, response.getResponseCode());
    }

    @Given("^Book Library is initialized$")
    public void bookLibraryIsInitialized() throws Throwable {
        Store.initializeLibrary();
    }
}
