package ru.netology.services;

public class Radio {

    public int currentRadioStation;
    public int currentVolume;

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newRadiostation) {
        if (newRadiostation > 9) {
            return;
        }
        if (newRadiostation < 0) {
            return;
        }
        currentRadioStation = newRadiostation;
    }

    public int nextStation() {
        if (currentRadioStation < 9) {
            currentRadioStation++;
        } else {
            currentRadioStation = 0;
        }
        return currentRadioStation;
    }

    public int prevStation() {
        if (currentRadioStation <= 9) {
            currentRadioStation--;
        } else {
            currentRadioStation = 9;
        }
        return currentRadioStation;
    }

    public void setCurrentRadioStationByButton(int newRadioStationButton) {
        if (newRadioStationButton < 0) {
            return;
        }
        if (newRadioStationButton > 9) {
            return;
        }
        currentRadioStation = newRadioStationButton;
    }


}
