package com.example.catdemo.service;

import com.example.catdemo.utils.RequestInfo;
import com.example.catdemo.utils.Response;
import org.springframework.stereotype.Service;


public interface CalendarService {
    Response getAllEvents(RequestInfo requestInfo);
    Response batchAddEvents(RequestInfo requestInfo);
}
