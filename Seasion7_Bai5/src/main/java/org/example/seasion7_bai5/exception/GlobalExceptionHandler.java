package org.example.seasion7_bai5.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalAccessException.class)
    public String handleFileSize(IllegalStateException ex,  Model model) {
        if (ex.getMessage() != null && ex.getMessage().contains("exceeds maximum size")) {
            model.addAttribute("error", "File qua lon (toi da 10MB)");
            return "error";
        }
        return "error";
    }
}