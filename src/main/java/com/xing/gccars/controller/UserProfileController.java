package com.xing.gccars.controller;

import com.xing.gccars.model.BorrowedDate;
import com.xing.gccars.service.BookCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserProfileController {

    private final BookCarService bookCarService;

    @Autowired
    public UserProfileController(BookCarService bookCarService) {
        this.bookCarService = bookCarService;
    }

    @GetMapping("/users/profile")
    public ModelAndView getUserReservations() {
        List<BorrowedDate> reservations = bookCarService.getBorrowedDates();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_profile");
        modelAndView.addObject("reservations", reservations);
        return modelAndView;
    }

}
