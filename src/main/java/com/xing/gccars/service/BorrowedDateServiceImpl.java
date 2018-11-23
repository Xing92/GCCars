package com.xing.gccars.service;

import com.xing.gccars.repository.BorrowedDateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

public class BorrowedDateServiceImpl implements BorrowedDateService {

    private final BorrowedDateRepository borrowedDateRepository;

    @Autowired
    public BorrowedDateServiceImpl(BorrowedDateRepository borrowedDateRepository) {
        this.borrowedDateRepository = borrowedDateRepository;
    }

    @Override
    public boolean checkAvailabilityCarById(Calendar startDate,
                                            Calendar endDate,
                                            Long id) {
        return borrowedDateRepository.checkAvailabilityCarById(startDate, endDate, id);
    }
}