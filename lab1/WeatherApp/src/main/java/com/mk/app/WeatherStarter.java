package com.mk.app;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.mk.app.IpmaCityForecast; //may need to adapt package name
import com.mk.app.IpmaService;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    // private static final int CITY_ID_AVEIRO = 1010500;

    public static void  main(String[] args ) {
        if (args.length != 1) {
            System.out.println("Usage: java WeatherStarter <city_code>");
            return;
        }

        int cityCode = Integer.parseInt(args[0]);

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(cityCode);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                CityForecast firstDay = forecast.getData().listIterator().next();

                // System.out.printf( "max temp for %s is %4.1f %n",
                //         firstDay.getForecastDate(),
                //         Double.parseDouble(firstDay.getTMax()));
                        System.out.println("Weather forecast for City Code: " + cityCode);
                        System.out.println("Max temperature: " + firstDay.getTMax());
                        System.out.println("Min temperature: " + firstDay.getTMin());
                        System.out.println("Precipitation probability: " + firstDay.getPrecipitaProb());
                        System.out.println("Wind direction: " + firstDay.getPredWindDir());
                        System.out.println("Class wind speed: " + firstDay.getClassWindSpeed());
                        System.out.println("Weather type: " + firstDay.getIdWeatherType());
                    } else {
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}