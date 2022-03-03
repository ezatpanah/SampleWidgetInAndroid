package com.ezatpanah.samplewidgetinandroid

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.widget.RemoteViews
import com.ezatpanah.samplewidgetinandroid.databinding.SampleAppWidgetBinding

class SampleAppWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

}

internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {

    val remoteViews = RemoteViews(context.packageName, R.layout.sample_app_widget)
    remoteViews.setInt(R.id.widgetLayout, "setBackgroundColor", Color.TRANSPARENT);

    val intent=Intent(Intent.ACTION_VIEW)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    intent.data= Uri.parse("https://google.com")
    val pendingIntent = PendingIntent.getActivity(context,0,intent,0)
    remoteViews.setOnClickPendingIntent(R.id.btnLoadWeb,pendingIntent)
    appWidgetManager.updateAppWidget(appWidgetId,remoteViews)

}