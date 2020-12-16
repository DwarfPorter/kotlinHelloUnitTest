package ru.geekbrains.simplemvp

import android.content.Context

class StringResources(private val context: Context) : IStringResource {
    override fun getHello(): String {
        return context.resources.getString(R.string.hello)
    }
}