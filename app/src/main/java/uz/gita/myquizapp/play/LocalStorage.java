package uz.gita.myquizapp.play;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import uz.gita.myquizapp.play.model.TestData;

public class LocalStorage {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static LocalStorage localStorage;
    private static Context context;


    public LocalStorage(Context context) {
        pref = context.getSharedPreferences("LOCAL_STORAGE", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public static void init(Context context) {
        LocalStorage.context = context;
    }

    public static LocalStorage getInstance() {

        if (localStorage == null)
            localStorage = new LocalStorage(context);
        return localStorage;
    }
    public void setList(ArrayList<TestData> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString("list", json).apply();
    }
    public ArrayList<TestData> getList(){
        Gson gson = new Gson();
        String json = pref.getString("list", null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        return gson.fromJson(json, type);
    }
    public boolean hasDataInPref(){
        return !pref.getString("list", "").isEmpty();
    }
    public boolean getStateGame(){
        return pref.getBoolean("state",true);
    }
    public void setState(boolean s){
        editor.putBoolean("list",s).apply();
    }
    public void setCurrentPosition(int currentPosition){
        editor.putInt("positon", currentPosition).apply();
    }
    public int getCurrentPosition(){
        return pref.getInt("positon", 0);
    }
    /*public void clear(){
        Log.d("TTT", "clear");
        editor.clear().apply();
    }*/
}
