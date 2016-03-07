package com.lym.ainao.bean;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 闹钟
 * 
 * @author xuyao
 * 
 */
public class AlarmClock {

	/** 常规类型 */
	public static final int type_normal = 0;
	private String objectId;
	private String title;
	private Integer minute;
	private Integer hour;
	private Integer daysOfWeek;
	/** 闹钟类型 */
	private Integer type;
	private boolean open;
	private boolean vibration;
	/** 闹钟主题 */
	private AlarmClockTheme alarmClockTheme;

	public String getObjectId() {
		
	
		Cursor cursor;
		ContentValues contentValues;
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMinute() {
		return minute;
	}

	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Integer getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(Integer daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isVibration() {
		return vibration;
	}

	public void setVibration(boolean vibration) {
		this.vibration = vibration;
	}

	public AlarmClockTheme getAlarmClockTheme() {
		return alarmClockTheme;
	}

	public void setAlarmClockTheme(AlarmClockTheme alarmClockTheme) {
		this.alarmClockTheme = alarmClockTheme;
	}

	public static int getTypeNormal() {
		return type_normal;
	}

}
