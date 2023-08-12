package com.example.sharedandswitch

import android.content.ContentProviderOperation
import android.content.Context
import android.content.SharedPreferences

object MyShared {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var color: Boolean
        get() = preferences.getBoolean("count", false)
        set(value) = preferences.edit() {
            if (value != null) {
                it.putBoolean("count", value)
            }
        }

}