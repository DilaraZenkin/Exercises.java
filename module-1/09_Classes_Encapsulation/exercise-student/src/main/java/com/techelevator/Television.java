package com.techelevator;

public class Television {
    // DATA: Instance variables
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;


    //Methods

    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
        currentVolume = 2;
        currentChannel = 3;
    }

    public void changeChannel(int newChannel) {
        if (isOn == true) {
            if (newChannel > 2 && newChannel < 19) {
                currentChannel = newChannel;
            }
        }

    }




    public void channelUp() {
        if (isOn == true) {
            currentChannel++;
            if (currentChannel > 18) {
                currentChannel = 3;
            }

        }

    }

    public void channelDown() {
        if (isOn == true) {
            currentChannel--;
            if (currentChannel < 3) {
                currentChannel = 18;
            }
        }

    }

    public void raiseVolume() {
        if (isOn == true) {
            if (currentVolume < 10) {
                currentVolume++;
            }
        }


    }

    public void lowerVolume() {
        if (isOn == true) {
            if (currentVolume > 0) {
                currentVolume--;

            }
        }
    }


    // Getters and Setters


    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }
}


