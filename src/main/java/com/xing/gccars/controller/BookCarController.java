package com.xing.gccars.controller;

import com.xing.gccars.exception.CarNotFoundException;
import com.xing.gccars.model.Car;
import com.xing.gccars.service.BorrowedDateService;
import com.xing.gccars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@RestController
public class BookCarController {

    private final CarService carService;
    private final BorrowedDateService borrowedDateService;

    @Autowired
    public BookCarController(CarService carService,
                             BorrowedDateService borrowedDateService) {
        this.carService = carService;
        this.borrowedDateService = borrowedDateService;
    }

    @GetMapping("/cars/{carId}/books")
    public ModelAndView checkDates(@PathVariable Long carId,
                                   @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar startDate,
                                   @RequestParam(value = "end_date", defaultValue = "3000-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar endDate) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Car car = carService.getCarById(carId);
            boolean isCarAvailable =
                    borrowedDateService.checkAvailabilityCarById(startDate, endDate, carId);
            modelAndView.addObject("carById", car);
            modelAndView.addObject("availableCarById", isCarAvailable);
            modelAndView.setViewName("book");
        } catch (CarNotFoundException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
