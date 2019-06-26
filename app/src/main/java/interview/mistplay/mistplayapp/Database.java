package interview.mistplay.mistplayapp;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Database {
    Game[] gamelist;
    ObjectMapper objectMapper;
    final int MAX_NUM = 15;
    int currentIndex =0;
    public Database() throws Exception{
        objectMapper = new ObjectMapper();
    }
    public Game[] search(String query) throws Exception{
        Game[] gameListReturned;
        class RatingComparator implements Comparator<Game> {
            public int compare(Game m1, Game m2) {
                return (m2.getRating().compareTo(m1.getRating()));
            }
        }

        //checks if user are only entering 1 words (meaning searching by subgenre)
        if(query.split("\\s+").length == 1){
            searchSubgenre(query);
            Arrays.sort(gamelist,new RatingComparator());
            gameListReturned = Arrays.copyOfRange(gamelist, currentIndex, MAX_NUM);
            currentIndex = MAX_NUM +1;
        }else{ //search for title
            searchTitle(query);
            Arrays.sort(gamelist,new RatingComparator());
            if(gamelist.length <1){ //no result found for title

            }
            gameListReturned = Arrays.copyOfRange(gamelist, currentIndex, MAX_NUM);
            currentIndex = MAX_NUM +1;
        }
        //if search by pure title returns nothing

        return gameListReturned;

    }
    /**
     * Search apps based on title given a query
     * @param query
     * @throws Exception
     */
    private void searchTitle(String query) throws Exception{
        String urls="http://localhost:8080/search";
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(urls).newBuilder();
        urlBuilder.addQueryParameter("subgenre", query);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        gamelist = objectMapper.readValue(response.body().toString(), Game[].class);
    }

    /**
     * Search apps based on subgenre given a query
     * @param query
     * @throws Exception
     */
    private void searchSubgenre(String query) throws  Exception{
        String urls="http://localhost:8080/search";
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(urls).newBuilder();
        urlBuilder.addQueryParameter("subgenre", query);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        gamelist = objectMapper.readValue(response.body().toString(), Game[].class);

    }

}
