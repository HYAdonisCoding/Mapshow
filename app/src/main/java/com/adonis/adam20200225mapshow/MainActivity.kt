package com.adonis.adam20200225mapshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.baidu.mapapi.map.MapView

import kotlinx.android.synthetic.main.activity_main.*
import com.baidu.mapapi.map.MarkerOptions
import android.R
import com.baidu.mapapi.map.BitmapDescriptorFactory
import com.baidu.mapapi.model.LatLng


// Android 地图 SDK V6.2.0

class MainActivity : AppCompatActivity() {
    private var mMapView: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //获取地图控件引用
        mMapView = findViewById(R.id.bmapView)
//        mMapView = MapView(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        print("onCreateOptionsMenu")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        print("onOptionsItemSelected");
        addOverlays()
        return when (item.itemId) {

            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView?.onResume();
    }

    override fun onPause() {
        super.onPause()
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView?.onPause();
    }

    override fun onDestroy() {
        super.onDestroy()
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView?.onDestroy();
    }

    private fun addOverlays() {
        //定义Maker坐标点
        val point = LatLng(39.963175, 116.400244)
        //构建Marker图标
        val bitmap = BitmapDescriptorFactory
            .fromResource(R.drawable.ic_lock_idle_charging)
        //构建MarkerOption，用于在地图上添加Marker
        val option = MarkerOptions()
            .position(point)
            .icon(bitmap)
        option.clickable(true)
        //在地图上添加Marker，并显示
        mMapView?.map?.addOverlay(option)
//        mMapView?.setOnMarkerClickListener(
//        mMapView?.map?.setOnMarkerClickListener(
//            //marker被点击时回调的方法
//
//            //若响应点击事件，返回true，否则返回false
//            //默认返回false
//            mMapView?.map?.
//                OnMarkerClickListener { true })
    }
}
