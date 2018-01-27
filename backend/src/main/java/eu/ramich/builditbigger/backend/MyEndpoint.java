package eu.ramich.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import eu.ramich.builditbigger.libjava.JokeTeller;


/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.ramich.eu",
                ownerName = "backend.builditbigger.ramich.eu",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that returns a random joke
     */
    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        response.setJoke(JokeTeller.getJoke());

        return response;
    }
}
