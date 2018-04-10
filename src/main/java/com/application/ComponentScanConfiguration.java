package com.application;

import com.patterns.SpringComponentScanPointer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringComponentScanPointer.class)
public class ComponentScanConfiguration {
}
