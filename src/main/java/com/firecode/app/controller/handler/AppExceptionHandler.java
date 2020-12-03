package com.firecode.app.controller.handler;

import java.io.IOException;
import javax.security.auth.login.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class AppExceptionHandler extends RuntimeException{
    
     private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);
     


    @ExceptionHandler(LoginException.class)
    public String errorUserBlock(LoginException e, RedirectAttributes attributes) throws IOException {
        log.info("AppExceptionHandler: Sua conta está suspensa momentaneamente.");
        attributes.addFlashAttribute("block");
         return "redirect:/app/error/403";        
    }

}
