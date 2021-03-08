package weather;


import javax.ejb.Singleton;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * ModelWeather - gets the weather in the city via the API
 *
 */

@Singleton
public class ModelWeather {


    /**
    *
    * @return String (HTML format)
    *
    */
    public String getW(String city){
       if (city.equals("")){return "Enter the city";}
       else {
           StringBuffer lines = new StringBuffer();
           try {
               URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(city, "UTF-8") + "&units=metric&mode=html&appid=771a8c89dd0cdc9681c31d38cb745900");
               URLConnection connection = url.openConnection(); // открываем соединение

               BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));  // записываем данные в переменную
               String line;
               while ((line = reader.readLine()) != null) // читаем данные
               {
                   lines.append(line + "\n");
               }
               reader.close();
           } catch (Exception e) {
               System.out.println("UPS");
               e.printStackTrace();
               return null;
           }
           String d = String.valueOf(lines);
           return d;
       }


      /*  JSONObject o=new JSONObject(d);
        String Temp= String.valueOf("Температура: "+o.getJSONObject("main").getDouble("temp"));
        String Fiels= String.valueOf("Ощущается: "+o.getJSONObject("main").getDouble("feels_like"));
        String Max= String.valueOf("Максимум: "+o.getJSONObject("main").getDouble("temp_max"));
        String Min= String.valueOf("Минимум: "+o.getJSONObject("main").getDouble("temp_min"));
        String Pressure= String.valueOf("Давление: "+o.getJSONObject("main").getDouble("pressure"));
        return "Погода в "+city+" сегодня- "+Temp+" "+Fiels+" "+Max+" "+Min+" "+Pressure;*/

    }

}
