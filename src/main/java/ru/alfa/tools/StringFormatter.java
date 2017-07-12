/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.alfa.tools;

/**
 *
 * @author Dmitry
 */
public class StringFormatter {
    
    
    public String dateFormat(int day, int month, int year){
        month++;
        String dayString = String.valueOf(day);
        if (dayString.length() == 1) {
            dayString = 0 + dayString;
        }
        String monthString = String.valueOf(month);
        if (monthString.length() == 1) {
            monthString = 0 + monthString;
        }
       return dayString + "/" + monthString + "/" + year;
    }
    
    public String timeFormat(int hour, int minute){
        String hourString = hour < 10 ? "0" + hour : "" + hour;
        String minuteString = minute < 10 ? "0" + minute : "" + minute;
        if (hourString.length() == 1) {
            hourString = 0 + hourString;
        }
        if (minuteString.length() == 1) {
            minuteString = 0 + minuteString;
        }
        return hourString + " : " + minuteString;
    }
    
}
