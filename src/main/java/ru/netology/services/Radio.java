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

    public void nextStation() {

        if (currentRadioStation > 0) {
            currentRadioStation++;
        }
        if (currentRadioStation > 9) {
            currentRadioStation = 0;
        }
    }

    public void prevStation() {
        if (currentRadioStation < 9) {
            currentRadioStation--;
        }
        if (currentRadioStation < 0) {
            currentRadioStation = 9;
        }

    }

    public void setCurrentRadioStationDirectly(int newRadioStationDirectly) { //прямой ввод номер радиостанции с проверкой валидности вводимого номер (в пределах 0-9)
        if (newRadioStationDirectly < 0) {
            return;
        }
        if (newRadioStationDirectly > 9) {
            return;
        }
        currentRadioStation = newRadioStationDirectly;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newVolume) {
        if (newVolume > 100) {
            return;
        }
        if (newVolume < 0) {
            return;
        }
        currentVolume = newVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
        if (currentVolume >= 100) {
            return;
        }
    }

    public void downVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
//        if (currentVolume < 0) {
//            return;
//        }

    }

}
