package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CatTest {
    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        cat = new Cat(feline);
    }

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound(), "Звук кошки должен быть \"Мяу\"");
    }

    @Test
    void testGetFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы"));
        assertEquals(List.of("Животные", "Птицы"), cat.getFood(), "Еда кошки должна соответствовать еде хищника");
    }
}