package com.example.module04demo02

class RockBandRepository {
    private val rockBands = listOf("AC/DC", "Queen", "The Stooges", "The Rolling Stones")

    fun getAllRockBands(): List<String> {
        return rockBands
    }
}