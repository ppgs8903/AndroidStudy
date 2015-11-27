package com.sharexn.www.study2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        String fontPath = "fonts/System San Francisco Display Thin.ttf";

        // text view label
       // TextView txtGhost = (TextView) findViewById(R.id.ghost);
        // Loading Font Face
     //   Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        // Applying font
       // txtGhost.setTypeface(tf);
        //getURLResponse("http://api.map.baidu.com/telematics/v3/weather?location=beijing&output=json&ak=F6dd64435e628d362c2344bb6401850d");
        new Thread(downloadRun).start();
    }

    /**
     * 下载线程
     */
    Runnable downloadRun = new Runnable(){
        String result= "";
        JSONObject jsonObj = null;
        weather weather = new weather();
        Gson gs = new Gson();
        @Override
        public void run() {
            // TODO Auto-generated method stub
            String result = getURLResponse("http://api.map.baidu.com/telematics/v3/weather?location=beijing&output=json&ak=F6dd64435e628d362c2344bb6401850d");
            try {
                jsonObj = new JSONObject(result);
                weather = gs.fromJson(result, weather.class);
                TextView weather_text = (TextView) findViewById(R.id.weather_text);
                TextView city = (TextView) findViewById(R.id.city);
                TextView thermometer_text = (TextView) findViewById(R.id.thermometer_text);
                TextView pm25 = (TextView) findViewById(R.id.pm25_text);
                TextView clothes_text = (TextView) findViewById(R.id.clothes_text);
                TextView tourism_text = (TextView) findViewById(R.id.tourism_text);
                TextView health_text = (TextView) findViewById(R.id.health_text);
                TextView game_text = (TextView) findViewById(R.id.game_text);
                TextView day_next_1_tem = (TextView) findViewById(R.id.day_next_1_tem);
                TextView day_next_1_weather = (TextView) findViewById(R.id.day_next_1_weather);
                TextView day_next_1_text = (TextView) findViewById(R.id.day_next_1_text);
                TextView day_next_2_tem = (TextView) findViewById(R.id.day_next_2_tem);
                TextView day_next_2_text = (TextView) findViewById(R.id.day_next_2_text);
                TextView day_next_2_weather = (TextView) findViewById(R.id.day_next_2_weather);
                TextView day_next_3_tem = (TextView) findViewById(R.id.day_next_3_tem);
                TextView day_next_3_text = (TextView) findViewById(R.id.day_next_3_text);
                TextView day_next_3_weather = (TextView) findViewById(R.id.day_next_3_weather);

                weather_text.setText((String) weather.getResults().get(0).getWeather_data().get(0).getWeather());
                city.setText(weather.getResults().get(0).getCurrentCity());
                thermometer_text.setText((String) weather.getResults().get(0).getWeather_data().get(0).getTemperature());
                pm25.setText(weather.getResults().get(0).getPm25());
                clothes_text.setText((String) weather.getResults().get(0).getIndex().get(0).getZs());
                tourism_text.setText((String) weather.getResults().get(0).getIndex().get(2).getZs());
                health_text.setText((String) weather.getResults().get(0).getIndex().get(3).getZs());
                game_text.setText((String) weather.getResults().get(0).getIndex().get(4).getZs());
                day_next_1_tem.setText((String) weather.getResults().get(0).getWeather_data().get(1).getTemperature());
                day_next_1_text.setText((String) weather.getResults().get(0).getWeather_data().get(1).getDate());
                day_next_1_weather.setText((String) weather.getResults().get(0).getWeather_data().get(1).getWeather());
                day_next_2_tem.setText((String) weather.getResults().get(0).getWeather_data().get(2).getTemperature());
                day_next_2_text.setText((String) weather.getResults().get(0).getWeather_data().get(2).getDate());
                day_next_2_weather.setText((String) weather.getResults().get(0).getWeather_data().get(2).getWeather());
                day_next_3_tem.setText((String) weather.getResults().get(0).getWeather_data().get(3).getTemperature());
                day_next_3_text.setText((String) weather.getResults().get(0).getWeather_data().get(3).getDate());
                day_next_3_weather.setText((String) weather.getResults().get(0).getWeather_data().get(3).getWeather());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };




    /**
     * 获取指定URL的响应字符串
     * @param urlString
     * @return
     */
    private String getURLResponse(String urlString){
        HttpURLConnection conn = null; //连接对象
        InputStream is = null;
        String resultData = "";
        try {
            URL url = new URL(urlString); //URL对象
            conn = (HttpURLConnection)url.openConnection(); //使用URL打开一个链接
            conn.setDoInput(true); //允许输入流，即允许下载
            conn.setDoOutput(true); //允许输出流，即允许上传
            conn.setUseCaches(false); //不使用缓冲
            conn.setRequestMethod("GET"); //使用get请求
            is = conn.getInputStream();   //获取输入流，此时才真正建立链接
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferReader = new BufferedReader(isr);
            String inputLine  = "";
            while((inputLine = bufferReader.readLine()) != null){
                resultData += inputLine + "\n";
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(conn != null){
                conn.disconnect();
            }
        }

        return resultData;
    }
}
