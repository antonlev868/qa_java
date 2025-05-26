package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LionTest {
    @Mock
    private Feline feline;

    @Test
    void shouldReturnCorrectNumberOfKittens() throws Exception {
        when(feline.getKittens()).thenReturn(3); // Количество детёнышей задаётся через мок
        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens(), "Количество детёнышей льва неверно.");
    }

    @Test
    void shouldReturnTrueForMaleHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane(), "Самец льва должен иметь гриву.");
    }

    @Test
    void shouldReturnFalseForFemaleDoesNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane(), "Самка льва не должна иметь гриву.");
    }

    @Test
    void shouldThrowExceptionOnInvalidSex() {
        try {
            new Lion("Некорректный пол", feline);
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage(),
                    "Исключение не соответствует ожидаемому сообщению.");
        }
    }

    @Test
    void shouldGetHunterFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы"));
        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Животные", "Птицы"), lion.getFood(), "Список еды хищника неверен.");
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}