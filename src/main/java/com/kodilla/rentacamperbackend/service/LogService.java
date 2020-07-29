package com.kodilla.rentacamperbackend.service;

import com.kodilla.rentacamperbackend.domain.Log;
import com.kodilla.rentacamperbackend.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void saveLog(String message) {
        Log log = new Log();
        logRepository.save(log);
    }
}
