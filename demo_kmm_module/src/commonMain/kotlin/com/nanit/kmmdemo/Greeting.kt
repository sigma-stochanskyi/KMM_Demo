package com.nanit.kmmdemo

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}