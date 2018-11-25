package com.xing.gccars.service;

import com.xing.gccars.model.BorrowedDate;

import java.util.Calendar;

public interface BorrowedDateService {

    boolean checkAvailabilityCarById(Calendar startDate, Calendar endDate, Long id);

    BorrowedDate addBorrowedDate(BorrowedDate borrowedDate);
}
