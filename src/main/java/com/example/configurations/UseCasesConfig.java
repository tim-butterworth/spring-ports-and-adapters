package com.example.configurations;

import com.example.clients.ServiceClient;
import com.example.usecases.IndexAsynchronousUseCase;
import com.example.usecases.IndexStatelessUseCase;
import com.example.usecases.IndexUseCase;
import com.example.usecases.IndexStatefulUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public ServiceClient getServiceClient() {
        return new ServiceClient();
    }

    @Bean
    public IndexUseCase getUsecase(ServiceClient serviceClient) {
        return new IndexUseCase(serviceClient);
    }

    @Bean
    public IndexStatefulUseCase getIndexObserverStateful(ServiceClient serviceClient) {
        return new IndexStatefulUseCase(serviceClient);
    }

    @Bean
    public IndexStatelessUseCase getIndexStatelessUseCase(ServiceClient serviceClient) {
        return new IndexStatelessUseCase(serviceClient);
    }

    @Bean
    public IndexAsynchronousUseCase indexAsynchronousUseCase(ServiceClient serviceClient) {
        return new IndexAsynchronousUseCase(serviceClient);
    }

}
