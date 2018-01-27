package eu.ramich.builditbigger.backend;

/**
 * The object model for the jokes we are sending through endpoints
 */
public class MyBean {

    private String joke;


    public String getJoke() {
        return joke;
    }

    public void setJoke(String newJoke) {
        joke = newJoke;
    }
}
