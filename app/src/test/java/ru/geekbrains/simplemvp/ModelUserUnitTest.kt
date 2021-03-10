package ru.geekbrains.simplemvp

import org.junit.Test
import io.mockk.mockk
import io.mockk.every
import io.mockk.verify

import org.junit.Assert.*

class ModelUserUnitTest {

    private val name = "name"

    @Test
    fun makeGreeting_isCorrect() {
        val resources = mockk<IStringResource>()
        every { resources.getHello() } returns ("hello")

        val underTest = ModelUser(resources, name)
        val expected = "hello name"
        val actual = underTest.makeGreeting()
        assertEquals(expected, actual)
        verify { resources.getHello() }
    }

    @Test
    fun name_isCorrect() {
        val resources = mockk<IStringResource>()

        val expected = name
        val underTest = ModelUser(resources, expected)
        val actual = underTest.name
        assertEquals(expected, actual)
        assertFalse(true)
    }
}