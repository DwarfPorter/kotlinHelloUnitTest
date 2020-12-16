package ru.geekbrains.simplemvp

import org.junit.Test
import io.mockk.mockk
import io.mockk.every
import io.mockk.verify

import org.junit.Assert.*

class MainPresenterUnitTest {
    private val name = "name"

    @Test
    fun sayHello_isCorrect() {
        val resources = mockk<IStringResource>()
        every { resources.getHello() } returns ("hello")
        val view = mockk<IViewMainActivity>()
        every { view.name } returns name
        every { view.sayHello(any()) } returns Unit

        val underTest = MainPresenter(resources)
        underTest.attachView(view)
        underTest.sayHello()
        underTest.detachView()
        verify { view.name }
        verify { view.sayHello(any()) }
    }

    @Test
    fun sayHello_isWrong() {
        val resources = mockk<IStringResource>()
        every { resources.getHello() } returns ("hello")
        val view = mockk<IViewMainActivity>()
        every { view.name } returns name
        every { view.sayHello(any()) } returns Unit

        val underTest = MainPresenter(resources)
        underTest.sayHello()
        verify(exactly = 0) { view.name }
        verify(exactly = 0) { view.sayHello(any()) }
    }
}