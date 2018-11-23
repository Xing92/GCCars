package com.xing.gccars.repository;

import com.xing.gccars.model.BorrowedDate;
import com.xing.gccars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;

public interface BorrowedDateRepository extends JpaRepository<BorrowedDate, Long> {

    List<BorrowedDate> findByCarAndStartDateBetweenOrEndDateBetween(Car car,
                                                                    Calendar startDate,
                                                                    Calendar endDate);

    @Query("select case when count(b) > 0 then true else false end " +
            "from BorrowedDate as b " +
            "where :startDate not between b.startDate and b.endDate " +
            "and :endDate not between b.startDate and b.endDate " +
            "and b.car.id = :carId " +
            "and b.car.id NOT IN (select DISTINCT bd.car.id " +
            "from BorrowedDate bd " +
            "where :startDate between bd.startDate and bd.endDate " +
            "OR :endDate between bd.startDate and bd.endDate)")
    boolean checkAvailabilityCarById(@Param("startDate") Calendar startDate,
                                     @Param("endDate") Calendar endDate,
                                     @Param("carId") Long id);

}
