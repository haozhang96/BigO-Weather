package edu.uncg.csc.bigo.weather.views.activities;

/**
 * Wrapper class for multiple strings passes.
 *
 * @Updated: 12/4/2018
 * @Author: Steven Tran
 */
public class Wrapper {

    //Strings that will be converted to the String Messages.
    public String messageOne;
    public String messageTwo;
    public String messageThree;
    public String messageFour;
    public String messageFive;
    public String messageSix;
    public String messageSeven;
    public String messageEight;
    public String messageNine;
    public String messageTen;
    public String messageEleven;
    public String messageTwelve;

    //Array for the hourly messages.
    public String[] hourlyMessages = {messageOne, messageTwo, messageThree, messageFour, messageFive,
            messageSix, messageSeven, messageEight, messageNine, messageTen, messageEleven, messageTwelve};

    //Array for the daily messages.
    public String[] dailyMessages = {messageOne, messageTwo, messageThree, messageFour, messageFive,
            messageSix, messageSeven};

    //Strings for the current message and temperature.
    public String currentMessage;
    public String temperature;

}
