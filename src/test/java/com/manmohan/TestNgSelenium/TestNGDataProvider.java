package com.manmohan.TestNgSelenium;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestNGDataProvider {



@BeforeMethod
public void beforeTest(){
    System.out.println("before test");
}

    @Test(dataProvider="empLogin")
    public void VerifyInvalidLogin(String userName, String title) {
        System.out.println("name: "+userName);
        System.out.println("title: "+title);


    }



   /* public Object[][] loginData() throws Throwable {
        Object[][] arrayObject = getExcelData();
        return arrayObject;
    }*/

    @DataProvider(name="empLogin")
    public Object[][] getExcelData() throws Throwable {
        String[][] arrayExcelData = new String[3][2];

        arrayExcelData[0][0]="Ajay";
        arrayExcelData[0][1]="Singh";

        arrayExcelData[1][0]="deepak";
        arrayExcelData[1][1]="sharma";
        arrayExcelData[2][0]="niraj";
        arrayExcelData[2][1]="Gupta";

        return arrayExcelData;
    }



}
