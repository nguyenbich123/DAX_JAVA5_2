package com.poly.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.GiamGia;
import com.poly.repository.GiamGiaDAO;

@Service
public class GiamGiaService {

    @Autowired
    private GiamGiaDAO giamGiaRepository;

    // Hàm kiểm tra và cập nhật số lượng giảm giá
    public void checkAndUpdateGiamGia() {
        Date currentDate = new Date();
        // Tìm tất cả các đợt giảm giá
        Iterable<GiamGia> allGiamGia = giamGiaRepository.findAll();

        for (GiamGia gg : allGiamGia) {
            // Nếu ngày kết thúc giảm giá đã qua
            if (gg.getTgKt().before(currentDate)) {
                gg.setSoLuong(0); // Cập nhật số lượng về 0
                giamGiaRepository.save(gg); // Lưu cập nhật vào CSDL
            }
        }
    }
}
