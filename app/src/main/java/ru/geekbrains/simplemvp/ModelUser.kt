package ru.geekbrains.simplemvp

class ModelUser(private val resources: IStringResource, val name: String) {
    fun makeGreeting(): String{
        return "${resources.getHello()} $name"
    }
}