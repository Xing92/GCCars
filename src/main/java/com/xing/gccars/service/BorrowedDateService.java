package com.xing.gccars.service;

import java.util.Calendar;

public interface BorrowedDateService {

    boolean checkAvailabilityCarById(Calendar startDate, Calendar endDate, Long id);
}
