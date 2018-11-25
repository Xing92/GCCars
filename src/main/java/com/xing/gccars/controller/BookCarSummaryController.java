package com.xing.gccars.controller;

import com.xing.gccars.model.BorrowedDate;
import com.xing.gccars.model.Car;
import com.xing.gccars.model.User;
import com.xing.gccars.service.BorrowedDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes({"car", "borrowedDate"})
public class BookResumeController {

    private final BorrowedDateService borrowedDateService;

    @Autowired
    public BookResumeController(BorrowedDateService borrowedDateService) {
        this.borrowedDateService = borrowedDateService;
    }

    @PostMapping("/cars/books/resume")
    public ModelAndView completeAll(BorrowedDate borrowedDate, Car car) {
        User user = borrowedDate.getUser();
        user.getCars().add(car);
        borrowedDateService.addBorrowedDate(borrowedDate);
        return new ModelAndView("redirect:/cars");
    }
}


