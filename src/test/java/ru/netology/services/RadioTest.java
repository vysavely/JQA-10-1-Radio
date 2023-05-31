package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void setCurrenRadiostationOver9() { //попытка выбрать номер радиостанции вне допустимого диапазона, как меньще 0 таки выше 9
        Radio radio = new Radio();
        radio.setCurrentRadioStation(10);

        int expected = 0;
        int actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция. Номер станции " + actual + " Ожидаемый " + expected);

        radio.setCurrentRadioStation(-10);

        actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);
        System.out.println("След. станция. Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void nextStTst() { // тест проверки переключения станции на следующую (next)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(5);

        radio.nextStation();

        int expected = 6;
        int actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void nextStTst9() { // тест проверки переключения станции вперёд при граничном значении 9 (next)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(9);

        radio.nextStation();

        int expected = 0;
        int actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция, если 9. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void nextStTst0() { // тест проверки переключения станции вперёд при граничном значении 9 (next)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(-1);

        radio.nextStation();

        int expected = 0;
        int actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция, если 9. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void prevStTst() { //тест переключения станции на предидущую (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(5);
        radio.prevStation();

        int expected = 4;
        int actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);

        System.out.println("Предидущая станция. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void prevStTst0() { //тест переключения станции на предидущую при граничном значении 0 (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(0);
        radio.prevStation();

        int expected = 9;
        int actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);
        System.out.println("Предидущая станция, если 0. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void prevStTstBelow0() { //тест переключения станции на предидущую при граничном значении -1 и 10 (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(-1);
        radio.prevStation();

        int expected = 9;
        int actual = radio.currentRadioStation;

        Assertions.assertEquals(expected, actual);
        System.out.println("Предидущая станция, если 0. Номер станции " + actual + " Ожидаемый " + expected);

        radio.setCurrentRadioStation(10);
        radio.prevStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Предидущая станция, если 0. Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void ChangeStationDirectly() { //тест на проверку прямого ввода радиостанции с номером в пределах 0-9 (номер 5)
        Radio radio = new Radio();
        radio.setCurrentRadioStationDirectly(5);

        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Прямая смена станции. Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void ChangeStationDirectlyAbove9() { //тест на проверку прямого ввода радиостанции вне пределов допустимого диапазона (0-9), номер 10
        Radio radio = new Radio();
        radio.setCurrentRadioStationDirectly(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Прямая смена станции. Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void ChangeStationDirectlyBelow0() { //тест на проверку прямого ввода радиостанции вне пределов допустимого диапазона (0-9), номер -10
        Radio radio = new Radio();
        radio.setCurrentRadioStationDirectly(-10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Прямая смена станции. Номер станции " + actual + " Ожидаемый " + expected);

    }


    @Test
    public void SetSound() { //тест возможности регулировки звука
        Radio radio = new Radio();
        radio.setCurrentVolume(10);

        int expected = 10;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
        System.out.println("Регулировка звука. Уровень звука " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void SetOverMaxSound() { //тест возможности установки звука свыше порога 100
        Radio radio = new Radio();
        radio.setCurrentVolume(105);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
        System.out.println("Регулировка звука. Уровень звука " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void SetBelowMinSound() { //тест возможности установки звука ниже порога 0
        Radio radio = new Radio();
        radio.setCurrentVolume(-105);

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
        System.out.println("Регулировка звука. Уровень звука " + actual + " Ожидаемый " + expected);
    }


    @Test
    public void increaseSoundTest() { //тест увеличения звука
        Radio radio = new Radio();
        radio.setCurrentVolume(95);

        radio.increaseVolume();

        int expected = 96;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
        System.out.println("Регулировка звука выше порога. Уровень звука " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void IncreaseOverMaxSound() { // проверка увеличения звука выше порогового значения 100
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
        System.out.println("Регулировка звука выше порога. Уровень звука " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void downSoundTest() { // проверка уменьшения звука в пределах допустимого диапазона
        Radio radio = new Radio();
        radio.setCurrentVolume(95);

        radio.downVolume();

        int expected = 94;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
        System.out.println("Регулировка звука ниже порога. Уровень звука " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void DownOverMinSound() { //проверка уменьшения громкости звука ниже порогового значения 0
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.downVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
        System.out.println("Регулировка звука ниже порога. Уровень звука " + actual + " Ожидаемый " + expected);
    }
}
