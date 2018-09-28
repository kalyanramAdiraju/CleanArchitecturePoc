package com.cleanArchitecturePoc.commons.inject;




import com.cleanArchitecturePoc.CleanArchitectureApplication;
import com.cleanArchitecturePoc.commons.RestClient;
import com.cleanArchitecturePoc.login.domain.LoginService;
import com.cleanArchitecturePoc.login.ui.ILoginView;
import com.cleanArchitecturePoc.login.ui.LoginPresenter;
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
                .baseUrl("")
                .build();
    }


    @Provides
    @Singleton
    public ObjectMapper provideObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setDateFormat(new SimpleDateFormat());
        return mapper;
    }



    @Singleton
    @Provides
    public CleanArchitectureApplication provideCleanArchitecture(){
        return application;
    }

    @Singleton
    @Provides
    public LoginPresenter provideLoginPresenter(ILoginView iLoginView,LoginService loginService){
        return new LoginPresenter(iLoginView,loginService);
    }

    @Singleton
    @Provides
    public LoginService provideLoginService(){
        return new LoginService();
    }


}
