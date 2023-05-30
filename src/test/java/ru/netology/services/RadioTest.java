package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.TextParsingException;

import java.sql.SQLOutput;

public class RadioTest {

    @Test
    public void NextStation() { //тест на проверку переключения станции по нажатию NEXT
        Radio radio = new Radio();
        radio.setCurrentRadioStation(2);

        int expected = 3;
        int actual = radio.nextStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Номер станции " +actual+ " Ожидаемый " +expected);

    }

    @Test
    public void NextStationAbove9() { //тест на проверку переключения станции по нажатию NEXT если больше 9
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);

        int expected = 0;
        int actual = radio.nextStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Номер станции " + actual + " Ожидаемый " + expected);

    }

    @Test
    public void PrevStation() { //тест на проверку переключения станции по нажатию PREV
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);

        int expected = 8;
        int actual = radio.prevStation();

        Assertions.assertEquals(expected, actual);
        System.out.println("Номер станции " +actual+ " Ожидаемый " +expected);



    }

    @Test
    public void ChangeStationByButton() { //тест на проверку прямого ввода радиостанции с номером в пределаз 0-9 (номер 5)
        Radio radio = new Radio();
        radio.setCurrentRadioStationByButton(5);

        int expected = 5;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ChangeStationByButtonAbove9() { //тест на проверку прямого ввода радиостанции с номером за пределами 0-9 (выше 9)
        Radio radio = new Radio();
        radio.setCurrentRadioStationByButton(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ChangeStationByButtonBelow0() { //тест на проверку прямого ввода радиостанции с номером за пределами 0-9 (меньше 0)
        Radio radio = new Radio();
        radio.setCurrentRadioStationByButton(-2);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);
    }
}
