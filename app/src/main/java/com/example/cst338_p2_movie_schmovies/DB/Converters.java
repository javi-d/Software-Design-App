package com.example.cst338_p2_movie_schmovies.DB;

//import androidx.test.platform.app.InstrumentationRegistry;
import android.content.Context;

import androidx.room.Dao;
import androidx.room.Room;
import androidx.room.TypeConverter;

import com.example.cst338_p2_movie_schmovies.Movie;
import com.example.cst338_p2_movie_schmovies.Theater;
import com.example.cst338_p2_movie_schmovies.Users;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*Hello Dr. C; I know you wanted me to use Gson to transfer it, but it was honestly going to be more
work just trying to rewrite and research how to do that type converters than to slightly manipulate
 the ones I already wrote.*/
public class Converters  {

//    private DAO converterDAO = new Dao();
//    private void getDatabase() {
//        converterDAO = Room.databaseBuilder(useAppContext(), AppDataBase.class, AppDataBase.DATABASE_NAME)
//                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
//                .build()
//                .MovieSchmovieDAO();
//    }
//
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//    }

//    @TypeConverter
//    public JsonElement convertHashMapToJson(HashMap<Theater, List<String>> needToConvert) {
//        Gson converter = new Gson();
//        return new JsonPrimitive( converter.toJson(needToConvert));
//    }
//
//    @TypeConverter
//    public HashMap<Theater, List<String>> convertHashMapToJson( JsonElement needToConvert) {
//        HashMap<Theater, List<String>> backToHashmap = new HashMap<>();
//
//
//    }

    @TypeConverter
    public String convertHashMapToString(HashMap<String, List<String>> theaterTimes) {
        StringBuilder sb = new StringBuilder();
        for (String theaterNames : theaterTimes.keySet()) {
//            converterDAO.insert(theater);
            sb.append(theaterNames);
            sb.append("_");
            List<String> showTimes = theaterTimes.get(theaterNames);
            for (int timeIndex = 0; timeIndex < showTimes.size(); timeIndex++) {
                sb.append(showTimes.get(timeIndex));
                if (timeIndex != showTimes.size() -1) {
                    sb.append(",");
                }
            }
            sb.append(";");
        }
        return sb.toString();
    }

    @TypeConverter
    public HashMap<String, List<String>> convertStringToHashMap(String convertedTimes) {

        HashMap<String, List<String>> convertedBack = new HashMap<>();
        String[] theaterAndTimes = convertedTimes.split(";");

        for (String indexString : theaterAndTimes) {
            String[] almostHashMap = indexString.split("_");
            String hashMapKey = almostHashMap[0];

            String[] almostArraylist = {};
            if (almostHashMap.length != 2) {

            }else {
                String temp = almostHashMap[1];
                 almostArraylist = temp.split(",");
            }
            List<String> times = new ArrayList<>();
            times.addAll(Arrays.asList(almostArraylist));
            convertedBack.put(hashMapKey, times);
        }
        return convertedBack;
    }
}
