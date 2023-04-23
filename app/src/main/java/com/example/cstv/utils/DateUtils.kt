package com.example.cstv.utils

import android.content.Context
import com.example.cstv.R
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    val apiDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    fun getFullDateTime(dateTime: String): Date? {
        return apiDateFormat.parse(dateTime.replace("T", " "))
    }

    fun formatDateInFull(context: Context, dateTime: String): String {
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.time = getFullDateTime(dateTime)!!

        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        val dayOfWeekString =
            if (isToday(calendar.time))
                context.getString(R.string.today)
            else
                when (dayOfWeek) {
                    Calendar.SUNDAY -> context.getString(R.string.sunday)
                    Calendar.MONDAY -> context.getString(R.string.monday)
                    Calendar.TUESDAY -> context.getString(R.string.tuesday)
                    Calendar.WEDNESDAY -> context.getString(R.string.wednesday)
                    Calendar.THURSDAY -> context.getString(R.string.thursday)
                    Calendar.FRIDAY -> context.getString(R.string.friday)
                    Calendar.SATURDAY -> context.getString(R.string.saturday)
                    else -> String.EMPTY
                }
        
        return context.getString(R.string.date_in_full, dayOfWeekString, "$hour:$minutes")
    }

    fun isToday(date: Date): Boolean {
        val today = Calendar.getInstance()
        val specifiedDate = Calendar.getInstance()
        specifiedDate.time = date

        return (today.get(Calendar.DAY_OF_MONTH) == specifiedDate.get(Calendar.DAY_OF_MONTH)
                && today.get(Calendar.MONTH) == specifiedDate.get(Calendar.MONTH)
                && today.get(Calendar.YEAR) == specifiedDate.get(Calendar.YEAR))
    }
}