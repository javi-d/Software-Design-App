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

//    @TypeConverter
//    public String convertHashMapToString(HashMap<Theater, List<String>> theaterTimes) {
//        StringBuilder sb = new StringBuilder();
//        for (Theater theater : theaterTimes.keySet()) {
////            converterDAO.insert(theater);
//            sb.append(theater.getTheaterName());
//            sb.append(":");
//            List<String> showTimes = theaterTimes.get(theater);
//            for (int timeIndex = 0; timeIndex < showTimes.size(); timeIndex++) {
//                sb.append(showTimes.get(timeIndex));
//                if (timeIndex != showTimes.size() -1) {
//                    sb.append(",");
//                }
//            }
//            sb.append(";");
//        }
//        return sb.toString();
//    }
//
//    @TypeConverter
//    public HashMap<Theater, List<String>> convertStringToHashMap(String convertedTimes) {
//
//        HashMap<Theater, List<String>> convertedBack = new HashMap<>();
//        String[] theaterAndTimes = convertedTimes.split(";");
//
//        for (String indexString : theaterAndTimes) {
//            String[] almostHashMap = indexString.split(":");
//            String hashMapKey = almostHashMap[0];
//
//            String[] almostArraylist = almostHashMap[1].split(",");
//            List<String> times = new ArrayList<>();
//            times.addAll(Arrays.asList(almostArraylist));
////            convertedBack.put(converterDAO.getTheaterByName(hashMapKey), times); //TODO: Need to figure out how to convert back into theater object.
//        }
//        return convertedBack;
//    }
}
