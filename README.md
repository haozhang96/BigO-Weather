# BigO Weather
UNCG Fall 2018
 
 
 
 
Software Requirements for
Big O Weather Application
 
December 4, 2018
 
Prepared By:
Hao Zhang
Harman Bains
Isaac Wilkinson
Steven Tran
 

Introduction </br>
The Big O Weather Application is a mobile application developed for Android mobile devices. The app provides weather information to users for zip codes in the United States. By entering a zip code, users can view hourly, daily and weekly weather information up to 7 days in the future. Users will be able to store their favorite locations on their device for faster, more convenient searches. The application displays weather information ranging from current temperature to precipitation to UV index depending on which time frame a user selects (currently, hourly or daily). This document will describe the requirements of the application, requirements of the device, functional requirements and any necessary terms needed to use the application. 

System & Platform Requirements </br>
The Big O Weather Application runs only on Android phones and tablets that are capable of running Android software version 8.0 (Oreo) or newer. The application may require read-write permissions to create and update the necessary files which the user must grant permission. The Android device must also have 50 MB of free space to download and use the application. 

Software Requirements </br>
To download the application, an Android device capable of software Android 8.0 or newer is needed. The Android device will also need an internet connection, whether it is cellular data or Wi-Fi. The Big O Weather Application needs roughly 50 MB of free space on the Android device in order to be downloaded and used. The application will store files on the Android device and will need permission to save, if the user is prompted. 

Functional Requirements </br>
Retrieve and Display Weather Information - Prompt the user for a zip code and display weather information for the location. The input must be a valid United States zip code, or the app will display a “try again” error message to the user.
Store and Display Saved Locations - Store zip code inputs from the user and display them to the user in the search box. Duplicates and invalid entries will not be stored. 
Internet Connection - The Android device will need an internet connection to get weather information and display them. Without an internet connection, the application will display an error message.
Validation of Zip Codes - Each zip code the user enters will go through validation to confirm it is valid. If the zip code is invalid, an error message will be shown prompting the user to try again.

Non-Functional Requirements </br>
User Interface - Have an understandable, simple user interface designed for ease of use. The weather information displayed should be easily legible and coherent.
Clear History - The application has a button to clear stored locations if the user wishes. Invalid zip codes will not be stored and therefore, the button will clear all the valid, stored locations.
Security Requirements
	The Big O Weather Application requires permission to read and write files on the Android device. No other security requirements are necessary for the application to function.

Industry Terms </br>
Listed below are terms the Big O Weather Application displays with its respective data. These terms are a small percentage of the total terms displayed but were chosen due to their uncommon use in many other weather applications.
Apparent Temperature - The temperature humans feel based on temperature, wind and humidity.
Moon Phase - The shape of the moon with sunlight. 
Ozone - A gas present in the atmosphere of Earth.
Precipitation - The different types of water forms that fall from clouds.
UV Index - The measurement of ultraviolet radiation. 





