package com.example.cst338_p2_movie_schmovies.DB;

import android.content.Context;

import androidx.room.Room;
import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Converters  {

//    private DAO converterDAO ;
//    private void getDatabase() {
//        converterDAO = Room.databaseBuilder(, AppDataBase.class, AppDataBase.DATABASE_NAME)
//                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
//                .build()
//                .MovieSchmovieDAO();
//    }
    @TypeConverter
    public String convertHashMapToString(HashMap<Theater, List<String>> theaterTimes) {
        StringBuilder sb = new StringBuilder();
        for (Theater theater : theaterTimes.keySet()) {
            sb.append(theater.getTheaterName());
            sb.append(":");
            List<String> showTimes = theaterTimes.get(theater);
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
    public HashMap<Theater, List<String>> convertStringToHashMap(String convertedTimes) {

        HashMap<Theater, List<String>> convertedBack = new HashMap<>();
        String[] theaterAndTimes = convertedTimes.split(";");

        for (String indexString : theaterAndTimes) {
            String[] almostHashMap = indexString.split(":");
            String hashMapKey = almostHashMap[0];

            String[] almostArraylist = almostHashMap[1].split(",");
            List<String> times = new ArrayList<>();
            times.addAll(Arrays.asList(almostArraylist));
            convertedBack.put(hashMapKey, times); //TODO: Need to figure out how to convert back into theater object.
        }
        return convertedBack;
    }
}
