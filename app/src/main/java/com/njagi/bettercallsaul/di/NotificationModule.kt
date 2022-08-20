package com.njagi.bettercallsaul.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.njagi.bettercallsaul.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Singleton
    @Provides
    fun NotificationBuilder(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder{

        return NotificationCompat.Builder(context, "Main Channel Id")
            .setContentTitle("Better Call Saul")
            .setContentText("The only way to know about Goodman's Story ")
            .setSmallIcon(R.drawable.baseline_notifications_active_24)
    }

    @Singleton
    @Provides
    fun provideNotificationBuilder(@ApplicationContext context: Context): NotificationManagerCompat {

        val notificationManager = NotificationManagerCompat.from(context)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                "Main Channel Id",
                "Main Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
       return notificationManager
    }

}