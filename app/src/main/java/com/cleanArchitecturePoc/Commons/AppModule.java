package com.cleanArchitecturePoc.Commons;


import com.cleanArchitecturePoc.CleanArchitectureApplication;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Singleton
@Module
public class AppModule {

    private CleanArchitectureApplication application;

    public AppModule(CleanArchitectureApplication application) {
        this.application = application;
    }

    @Provides
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create(provideObjectMapper()))
                .baseUrl(provideUrlConfigBase().getBaseUrl())
                .build();
    }


    @Provides
    @Singleton
    public UrlConfigBase provideUrlConfigBase() {
        return new UrlConfigBase(providePropertiesUtility());
    }


    @Provides
    @Singleton
    public PropertiesUtility providePropertiesUtility() {
        return new PropertiesUtility(application);
    }

    @Provides
    @Singleton
    public ObjectMapper provideObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setDateFormat(new SimpleDateFormat());
        return mapper;
    }

}
