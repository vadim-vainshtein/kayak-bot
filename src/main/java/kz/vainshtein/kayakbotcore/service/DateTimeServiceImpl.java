package kz.vainshtein.kayakbotcore.service;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class DateTimeServiceImpl implements DateTimeService {
    @Override
    public Instant now() {
        return Instant.now();
    }
}
