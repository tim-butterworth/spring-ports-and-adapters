package com.patterns.responseExceptionWithControllerAdvicePattern.web;

import com.patterns.responseExceptionWithControllerAdvicePattern.core.IndexSynchronousUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("withasynchronoususecasecontroller")
public class WithASynchronousUseCaseController {

    private IndexSynchronousUseCase indexSynchronousUseCase;

    @Autowired
    public WithASynchronousUseCaseController(IndexSynchronousUseCase indexSynchronousUseCase) {
        this.indexSynchronousUseCase = indexSynchronousUseCase;
    }

    @RequestMapping("/index/{value}")
    public ResponseEntity<String> index(@PathVariable String value) {
        String result = indexSynchronousUseCase.execute(value);
        return ResponseEntity.ok(result);
    }
}
