package com.hmshohrab.datetimepicker.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.until


object DateUtils {


    fun getTimeMiles(year: Int, month: Int, day: Int): Long {
        val start = LocalDate(year, month, day)
        val end = start.plus(DateTimeUnit.MONTH)
        //val maxDayCount= start.until(end, DateTimeUnit.DAY)

        // val maxDayCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        // start.dayOfMonth = min(day, maxDayCount)

        return start.atStartOfDayIn(timeZone = TimeZone.currentSystemDefault())
            .toEpochMilliseconds()
    }


    fun getCurrentTime(): Long {
        val instant = Clock.System.now()
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return LocalDateTime(
            localDateTime.year,
            localDateTime.monthNumber,
            localDateTime.dayOfMonth,
            0,
            0,
            0,
            0
        ).toInstant(
            TimeZone.currentSystemDefault()
        ).toEpochMilliseconds()
    }

    fun getMonthDayCount(timeStamp: Long): Int {
        val instant = Instant.fromEpochMilliseconds(timeStamp)
        val start = instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
        val end = start.plus(DateTimeUnit.MONTH)
        return start.until(end, DateTimeUnit.DAY)
    }

    fun getDay(timeStamp: Long): Int {
        val instant = Instant.fromEpochMilliseconds(timeStamp)
        val start = instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
        return start.dayOfMonth
    }

    fun getMonth(timeStamp: Long): Int {
        val instant = Instant.fromEpochMilliseconds(timeStamp)
        val start = instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
        return start.monthNumber
    }

    fun getYear(timeStamp: Long): Int {
        val instant = Instant.fromEpochMilliseconds(timeStamp)
        val start = instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
        return start.year
    }


    fun getCurrentHour(): Int {
        val instant = Clock.System.now()
        val start = instant.toLocalDateTime(TimeZone.currentSystemDefault()).time
        return start.hour
    }


    fun getCurrentMinute(): Int {
        val instant = Clock.System.now()
        val start = instant.toLocalDateTime(TimeZone.currentSystemDefault()).time
        return start.minute
    }
}