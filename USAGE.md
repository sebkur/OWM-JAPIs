# Usage

## How to use OWM JAPIs?
Anyone with little coding knowledge of Java will feel at home while using this library.  **Identifiers are written to be self-explanatory and APIs' documentation** is also provided. It makes the coding process very easy, even for beginners.

1. Add this JAR file in your project's libraries:
    1. owm-japis.jar
2. Write your code as such:
    1. Create and initialize object {obj1} of "OpenWeatherMap" class
    2. Call this object's {obj1} functions to get the desired weather data (such as current weather, daily forecast, etc.).
    3. The data is returned as a new object {obj2} of a compatible class based on the type of asked/retrieved weather data (current weather data comes in a different class's object than daily forecast data).
    3. Call this returned object's {obj2} functions to get the required information from the collective weather data (such as temperature, pressure, wind speed, etc.).

Kindly have a look on the example(s) below for clear understanding.



## Example
### Basic Example
#### Sample Code

    import java.io.IOException;
    import java.net.MalformedURLException;
    import net.aksingh.owmjapis.CurrentWeather;
    import net.aksingh.owmjapis.OpenWeatherMap;
    import org.json.JSONException;
    
    public class OwmJapisExample1 {
    
        public static void main(String[] args)
                throws IOException, MalformedURLException, JSONException {
                
            // declaring object of "OpenWeatherMap" class
            OpenWeatherMap owm = new OpenWeatherMap("");
    
            // getting current weather data for the "London" city
            CurrentWeather cwd = owm.currentWeatherByCityName("London");
    
            //printing city name from the retrieved data
            System.out.println("City: " + cwd.getCityName());
            
            // printing the max./min. temperature
            System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                                + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");
        }
    }

#### Output

    City: London
    Temperature: 73.4/68.72 'F


### Advance Example
You can simply use the APIs (as given in basic example) for learning, testing or experimenting with the functions provided in this library. But it may not be good enough for production or deployment environment.

Professionally, you should always **write code which can handle errors/exceptions** at the runtime. OWM JAPIs also helps here – by providing checker functions which allows you to **check if a data is available or not**, i.e., that particular data is retrieved and parsed properly or not. Of course, exception handling can still be used, but these functions are really useful and make the retrieved-data-error-handling task very simple.

Using OWM JAPIs, you can always check if a particular data is available or not. This is done by using the **has<DataName>()** functions. For example, **hasResponseCode()** function checks if the retrieved data has a response code or not; and if available, response code can be used to check if the whole data was downloaded and parsed correctly or not.

#### Sample Code

    import java.io.IOException;
    import java.net.MalformedURLException;
    import net.aksingh.owmjapis.CurrentWeather;
    import net.aksingh.owmjapis.OpenWeatherMap;
    import org.json.JSONException;
    
    public class OwmJapisExample2 {
    
        public static void main(String[] args)
                throws IOException, MalformedURLException, JSONException {
    
            // declaring object of "OpenWeatherMap" class
            OpenWeatherMap owm = new OpenWeatherMap("");
    
            // getting current weather data for the "London" city
            CurrentWeather cwd = owm.currentWeatherByCityName("London");
    
            // checking data retrieval was successful or not
            if (cwd.isValid()) {
    
                // checking if city name is available
                if (cwd.hasCityName()) {
                    //printing city name from the retrieved data
                    System.out.println("City: " + cwd.getCityName());
                }
    
                // checking if max. temp. and min. temp. is available
                if (cwd.getMainInstance().hasMaxTemperature() && cwd.getMainInstance().hasMinTemperature()) {
                    // printing the max./min. temperature
                    System.out.println("Temperature: " + cwd.getMainInstance().getMaxTemperature()
                                + "/" + cwd.getMainInstance().getMinTemperature() + "\'F");
                }
            }
        }
    }

#### Output

    City: London
    Temperature: 73.4/68.72 'F
