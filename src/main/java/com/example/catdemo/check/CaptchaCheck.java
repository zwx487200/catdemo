package com.example.catdemo.check;

public class CaptchaCheck {
    public boolean checkCaptcha(String inputCaptcha, String storedCaptcha) {
        // Simulated captcha validation logic
        return inputCaptcha.equalsIgnoreCase(storedCaptcha);
    }
}
