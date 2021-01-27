package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent") // Se agrega componente a la memoria de Spring cuando se inicie la app
public class ExampleComponent {
    
    private static final Log LOG = LogFactory.getLog(ExampleComponent.class);

    public void sayHello() {
        LOG.info("HELLO FROM EXAMPLECOMPONENT");
    }
}
