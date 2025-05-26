package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    @ParameterizedTest
    @ValueSource(strings = {"Травоядное", "Хищник"})
    void testEatMeat(String kind) throws Exception {
        Feline feline = new Feline();
        var result = feline.eatMeat();
        assertNotNull(result, "Результат не должен быть null");
//         assertTrue(result.containsAll(List.of("Животные", "Птицы")), "Еда хищника должна включать животных и птиц");
    }

    @Test
    void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily(), "Семейство должно быть Кошачьи");
    }

    @Test
    void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens(), "По умолчанию число детёнышей должно быть 1");
    }

    @Test
    void testGetKittensCustom() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3), "При задании числа детёнышей должно возвращаться указанное значение");
    }
}
