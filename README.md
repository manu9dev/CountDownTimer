# CountDownTimer
This is a class written in Java for creating and managing a timer.

# Author
This project was created by Zoumana Emmanuel Traoré

# Chrono - Java Timer

## Description
Chrono is a Java class designed to create a timer with start, stop and display functionality. It counts elapsed time in hours, minutes and seconds, and provides an easy method to start and stop the timer.

## Features
  Counting elapsed time in hours, minutes and seconds.
  Starting and stopping the timer.
  Display of elapsed time.

## Use
    Instantiate a Chrono object using the constructor with hour, minute, and second parameters (optional).
    Call the initializeCurrTime() method to initialize the timer values.
    Use the runTimer() method to start the timer.
    Use the stopTimer() method to stop the timer.
    Use the show() method to display the elapsed time.

## Example of use :
```java
Chrono chrono = new Chrono(1, 30, 0); // Creates a 1 hour and 30 minute timer
chrono.initializeCurrTime(); // Initializes timer values
chrono.runTimer(); // Start the timer
```
