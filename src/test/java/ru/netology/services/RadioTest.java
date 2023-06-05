package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RadioTest {

    int inputQuantityRadiostations = 30; // кол-во станций 30


    @Test
    public void setCurrentRadiostationOverRange0() { //попытка выбрать номер радиостанции вне допустимого диапазона, меньше 0
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("Тест 1-1. Граничные значения -10. Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void setCurrentRadiostationOverRange9() { //попытка выбрать номер радиостанции вне допустимого диапазона, больше 9
        Radio radio = new Radio();
        radio.setCurrentRadioStation(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("Тест 1-2. Граничные значения 10. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void setCurrentRadiostationWithinRange() { //попытка выбрать номер радиостанции в пределах допустимого диапазона
        Radio radio = new Radio();
        radio.setCurrentRadioStation(5);

        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("Тест 1-3. Значение в пределах дапазона 5. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void nextStationTest() { // тест проверки переключения станции на следующую (next) в пределах диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStation(5);

        radio.nextStation();

        int expected = 6;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция в пределах диапазона. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void nextStationTestIf0() { // тест проверки переключения станции вперёд при граничном значении 0 (next)
        Radio radio = new Radio();

        //radio.setCurrentRadioStation(0);

        radio.nextStation();

        int expected = 1;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция, если 0. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void nextStationTestIf9() { // тест проверки переключения станции вперёд при граничном значении 9 (next)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(9);

        radio.nextStation();

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция, если 9. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void nextStationTestOverRange() { // тест проверки переключения станции вперёд при граничном значении -1 (next)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(-1);

        radio.nextStation();

        int expected = 1;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("След. станция, если -1. Номер станции " + actual + " Ожидаемый " + expected);
    }


    @Test
    public void prevStTst() { //тест переключения станции на предидущую (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(5);
        radio.prevStation();

        int expected = 4;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

        System.out.println("Предидущая станция. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void prevStTst0() { //тест переключения станции на предидущую при граничном значении 0 (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(0);
        radio.prevStation();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Предидущая станция, если 0. Номер станции " + actual + " Ожидаемый " + expected);
    }

    @Test
    public void prevStTstIf9() { //тест переключения станции на предидущую при граничном значении 9 (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(9);
        radio.prevStation();

        int expected = 8;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Предидущая станция, если 9. Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void prevStTstBelow0() { //тест переключения станции на предидущую при граничном значении -1 (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(-1);
        radio.prevStation();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Предидущая станция, если -1. Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void prevStTstIF10() { //тест переключения станции на предидущую при граничном значении 10 (prev)
        Radio radio = new Radio();

        radio.setCurrentRadioStation(10);
        radio.prevStation();

        int expected = 9;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Предидущая станция, если 10. Номер станции " + actual + " Ожидаемый " + expected);

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
    public void setCurrentRadiostationInExtendedRange() { //Доп. тест на ввод номера "15" станции в пределах расширенного диапазона (0-29)
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(15);
        Assertions.assertEquals(15, radio.getCurrentRadioStation());
    }

    @Test
    public void setCurrentRadiostationOverExtendedRange() { //Доп. тест на ввод номера "30" станции вне предела расширенного диапазона (0-29)
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(30);
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void nextStationInExtendedRange() { //Доп. тест на переключение станции "вперёд" с 15 на 16 в пределах расширенного диапазона (0-29)
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(15);
        radio.nextStation();
        Assertions.assertEquals(16, radio.getCurrentRadioStation());
    }

    @Test
    public void nextStationOverExtendedRange() { //Доп. тест на переключение станции "вперёд" с 29 на 0
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(29);
        radio.nextStation();
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void previousStationInExtendedRange() { //Доп. тест на переключение станции "назад" с 15 на 14 в пределах расширенного диапазона (0-29)
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(15);
        radio.prevStation();
        Assertions.assertEquals(14, radio.getCurrentRadioStation());
    }

    @Test
    public void previousStationOverExtendedRange() { //Доп. тест на переключение станции "назад" с 0 на 29
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(0);
        radio.prevStation();
        Assertions.assertEquals(29, radio.getCurrentRadioStation());
    }

    @Test
    public void setStationDirectlyInExtendedRange() { // Тест прямого управление номером станции в пределах диапазона
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(15);
        Assertions.assertEquals(15, radio.getCurrentRadioStation());
    }

    @Test
    public void setStationDirectlyOverExtendedRange() { // Тест прямого управление номером станции вне пределов диапазона
        Radio radio = new Radio(inputQuantityRadiostations);
        radio.setCurrentRadioStation(30);
        Assertions.assertEquals(0, radio.getCurrentRadioStation());
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
