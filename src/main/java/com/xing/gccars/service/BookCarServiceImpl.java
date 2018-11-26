package com.xing.gccars.service;

import com.xing.gccars.model.BorrowedDate;
import com.xing.gccars.repository.BookCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class BookCarServiceImpl implements BookCarService {

    private final BookCarRepository bookCarRepository;

    @Autowired
    public BookCarServiceImpl(BookCarRepository bookCarRepository) {
        this.bookCarRepository = bookCarRepository;
    }

    @Override
    public boolean checkAvailabilityCarById(Calendar startDate,
                                            Calendar endDate,
                                            Long id) {
        return bookCarRepository.checkAvailabilityCarById(startDate, endDate, id);
    }

    @Override
    public BorrowedDate addBorrowedDate(BorrowedDate borrowedDate) {
        return bookCarRepository.save(borrowedDate);
    }
}