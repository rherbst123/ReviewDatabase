/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roosevelt.herbst.homework3yaya.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author mruth
 */
@ControllerAdvice
public class MyExceptionHandler {
    //set up a logger
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Exception E?!?");
        logger.error(e + "");
        logger.error(e.getMessage());
        logger.error(e.getStackTrace() + "");
        
        return new ResponseEntity(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRTException(RuntimeException e) {
        logger.error("Exception RT?!?");
        logger.error(e + "");
        logger.error(e.getMessage());
        logger.error(e.getStackTrace() + "");
        
        return new ResponseEntity(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
    }
    
}
