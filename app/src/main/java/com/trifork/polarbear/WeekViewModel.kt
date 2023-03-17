package com.trifork.polarbear

import androidx.lifecycle.ViewModel
import com.trifork.polarbear.model.Day
import com.trifork.polarbear.model.DayEnum
import com.trifork.polarbear.model.LocationEnum
import com.trifork.polarbear.model.Week
import kotlinx.coroutines.flow.MutableStateFlow

class WeekViewModel : ViewModel() {
    var weeksState: MutableStateFlow<List<Week>> = MutableStateFlow(getWeeks())
    var weekNumberState: MutableStateFlow<Int> = MutableStateFlow(10)

    fun updateDay(day: Day, weekNumber: Int) {
        val weeks = weeksState.value ?: return
        val week = weeks.find { it.weekNumber == weekNumber } ?: return
        var dayToUpdate = week.days.find { it.day == day.day } ?: return
        dayToUpdate.location = day.location
        weeksState.value = weeks
    }


    fun getWeeks(): List<Week> {
        val weeks = mutableListOf<Week>()
        for (weekNumber in 1..52) {
            val days = mutableListOf<Day>()
            for (dayNumber in 1..5) {
                val day = Day(day = DayEnum.values()[dayNumber - 1], location = LocationEnum.OFFICE)
                days.add(day)
            }
            val week = Week(days = days, weekNumber = weekNumber)
            weeks.add(week)
        }
        return weeks
    }
}