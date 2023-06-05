package ru.netology.services;

public class Radio {

    private int currentVolume;
    private int currentRadioStation;
    private int quantityRadiostations;
    private int minNumberRadiostation = 0;
    private int maxNumberRadiostation;



    public Radio(int quantityRadiostationsInput) { // конструктор для работы с внешним значением кол-ва станций, через переменную quantityRadiostationsInput
        this.quantityRadiostations = quantityRadiostationsInput;
        this.maxNumberRadiostation = quantityRadiostations - 1; // макс номер станции = кол-во станций минус 1, т.к. нумарция с 0.
    }

    public Radio() { //конструктор для работы с дефолтным значением "10"
        this.quantityRadiostations = 10; // тут указано значение по дефолту из задания - 10
        this.maxNumberRadiostation = quantityRadiostations - 1;
    }

    public int getCurrentRadioStation() { //геттер текущего номера станции
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int newRadiostation) { //сеттер текущего номера станции
        if (newRadiostation > maxNumberRadiostation) {
            return;
        }
        if (newRadiostation < minNumberRadiostation) {
            return;
        }
        currentRadioStation = newRadiostation;
    }

    public void nextStation() { // переключение вперёд
        if (currentRadioStation > minNumberRadiostation) {
            currentRadioStation++;
        }
        if (currentRadioStation > maxNumberRadiostation) {
            currentRadioStation = 0;
            return;
        }
        if (currentRadioStation == minNumberRadiostation) {
            currentRadioStation++;
        }
    }

    public void prevStation() { //переключение назад
        if (currentRadioStation < maxNumberRadiostation) {
            currentRadioStation--;
        }
        if (currentRadioStation < minNumberRadiostation) {
            currentRadioStation = maxNumberRadiostation;
            return;
        }
        if (currentRadioStation == maxNumberRadiostation) {
            currentRadioStation--;
        }

    }

    public void setCurrentRadioStationDirectly(int newRadioStationDirectly) { //прямой ввод номер радиостанции с проверкой валидности вводимого номер (в пределах 0-9)
        if (newRadioStationDirectly < minNumberRadiostation) {
            return;
        }
        if (newRadioStationDirectly > maxNumberRadiostation) {
            return;
        }
        currentRadioStation = newRadioStationDirectly;
    }

    public int getCurrentVolume() { //геттер уровня громкости
        return currentVolume;
    }

    public void setCurrentVolume(int newVolume) { //сеттер уровня громкости
        if (newVolume > 100) {
            return;
        }
        if (newVolume < 0) {
            return;
        }
        currentVolume = newVolume;
    }

    public void increaseVolume() { //увеличение громкости
        if (currentVolume < 100) {
            currentVolume++;
        }
        if (currentVolume >= 100) {
            return;
        }
    }

    public void downVolume() { //уменьшение громкости
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
