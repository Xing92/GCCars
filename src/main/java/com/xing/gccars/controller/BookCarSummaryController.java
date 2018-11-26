package com.xing.gccars.controller;

import com.xing.gccars.model.BorrowedDate;
import com.xing.gccars.model.Car;
import com.xing.gccars.model.User;
import com.xing.gccars.service.BookCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes({"car", "borrowedDate"})
public class BookCarSummaryController {

    private final BookCarService bookCarService;

    @Autowired
    public BookCarSummaryController(BookCarService bookCarService) {
        this.bookCarService = bookCarService;
    }

    @PostMapping("/cars/books/resume")
    public ModelAndView completeAll(BorrowedDate borrowedDate, Car car, SessionStatus status) {
        User user = borrowedDate.getUser();
        user.getCars().add(car);
        bookCarService.addBorrowedDate(borrowedDate);
        status.setComplete();
        return new ModelAndView("redirect:/cars");
    }
}


