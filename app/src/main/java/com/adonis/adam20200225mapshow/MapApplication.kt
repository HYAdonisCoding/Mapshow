package com.adonis.adam20200225mapshow

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import com.baidu.mapapi.CoordType
import com.baidu.mapapi.SDKInitializer


class MapApplication() : Application(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate() {
        super.onCreate()
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this)
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MapApplication> {
        override fun createFromParcel(parcel: Parcel): MapApplication {
            return MapApplication(parcel)
        }

        override fun newArray(size: Int): Array<MapApplication?> {
            return arrayOfNulls(size)
        }
    }
}