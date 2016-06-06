Synopsis

weather app demo.  creating a bsic weather forcast app using. Forcast.io's open API. withing the app i follow try to use Hannes Dorfmanns implementation of the MVP pattern. Also I cache the weather forecast data using okhttp and retrieve it from the endpoint using Retrofit. As I build the app I will add in some transitions. Essentially I plan on stealing the Look For the UI from googles Demo Topeka app as it has some really nice transitions and animations.


Code Example

caching example using OkHttp

 	public OkHttpClient getClient()
    	{
        	client = new OkHttpClient
                .Builder()
                .cache(new Cache(cont.getCacheDir(), 1 * 1024 * 1024)) // 1 MB probably a lot more than i need.
                .addInterceptor(new Interceptor() {
                    @Override public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        if (checkConn()) {
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();

                        } else {
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                        }
                        return chain.proceed(request);
                    }
                })
                .build();

        return client;
    	}


 then I add the client to my Retrofit objec twhen instantiated in my WebModule class.

  	@ActivityScope
    @Provides
    public WeatherServiceRepo getRetrofit(@Named("base_url") String url, OkHttpClient client)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(WeatherServiceRepo.class);
    }




Motivation

I did this to refresh my dagger 2 knowledge also thought and review someone elses implementation of MVP.Finally,  practice to Improve my UI building skills. 

API Reference

 testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.3.0'
    compile 'com.jakewharton:butterknife:8.0.1'
    compile 'com.android.support:recyclerview-v7:23.3.0'
    compile 'com.android.support:cardview-v7:23.3.0'
    compile 'com.google.code.gson:gson:2.6.2'
    compile ('com.squareup.retrofit2:retrofit:2.0.2')
            {
                exclude module: 'okhttp'
            }

    compile 'com.squareup.okhttp3:okhttp:3.3.1'
    compile 'com.squareup.retrofit2:converter-gson:2.0.2'


