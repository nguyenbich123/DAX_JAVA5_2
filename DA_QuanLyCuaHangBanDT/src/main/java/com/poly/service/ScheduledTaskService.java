package com.poly.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ScheduledTaskService {

    @Autowired
    private GiamGiaService giamGiaService;

    // Định kỳ mỗi ngày lúc 00:00
    @Scheduled(cron = "0 0 0 * * *")
    public void checkAndUpdateGiamGiaTask() {
        giamGiaService.checkAndUpdateGiamGia();
    }
}
