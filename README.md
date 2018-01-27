# Build It Bigger

This is the fourth project in Udacity's Android Developer Nanodegree. The Build It Bigger app has a single button, which tells a joke after a press. It has two flavors (free & paid), uses multiple libraries, Google Cloud Endpoints and consists of the following four modules: 

- A Java library that provides jokes, 
- a Google Cloud Endpoints (GCE) project that serves those jokes, 
- an Android Library containing an activity for displaying jokes, 
- and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

See the [starting point and instructions](https://github.com/udacity/ud867/tree/master/FinalProject) for this project.

## Getting Started

1. Clone or download the repository and import it in Android Studio.
2. Follow the instructions in `EndpointAsyncTask.class` and for using an emulator also remove the following line in the `build.gradle` of the `backend` module.
    ```gradle
    httpAddress = "0.0.0.0"
    ```
3. Start the local server with "Run `backend`" or use the responsible gradle task
4. and finally run the app, depending the above settings, on a physical device or an Android emulator.

## Difficulties

Since in Android Studio 3.0, the creation of App Engine backends has been removed, this point of implementation was a bit more tricky and also took more time. With the help of forum posts on [Udacity](https://de.udacity.com/) and [Stack Overflow](https://stackoverflow.com/), the problem was finally solved by using an older version of the Gradle and GCE plugin.

## Credits

* Source of the jokes: [10+ Of The Funniest Two-Line Jokes Ever | Bored Banda](https://www.boredpanda.com/funniest-two-line-jokes/)
* App icon generated with [Android Asset Studio](https://romannurik.github.io/AndroidAssetStudio/index.html)

## License

Licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)
