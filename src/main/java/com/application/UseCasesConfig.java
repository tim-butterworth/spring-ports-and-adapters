package com.application;

import com.clients.ServiceClient;
import com.patterns.asynchronousObserverPattern.core.IndexAsynchronousUseCase;
import com.patterns.observerExceptionPattern.core.ThingsUseCase;
import com.patterns.responseExceptionWithControllerAdvicePattern.core.IndexSynchronousUseCase;
import com.patterns.simpleObserverPatternWithoutInterfaces.IndexUseCase;
import com.patterns.statefulObserverPattern.core.IndexStatefulUseCase;
import com.patterns.statelessObserverPattern.core.IndexStatelessUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ThingsUseCase.class,
        ServiceClient.class
})
public class UseCasesConfig {

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

    @Bean
    public IndexSynchronousUseCase indexSynchronousUseCase(ServiceClient serviceClient) {
        return new IndexSynchronousUseCase(serviceClient);
    }

}
