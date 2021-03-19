package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DirtiesContext // Đánh dấu tệ hơi phương thức bên dưới. Performance thấp hơn phương thức có tên cụ thể
    void findByDescription() {
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", unitOfMeasure.getDescription());
    }

    @Test
    void findByDescriptionEach() {
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findByDescription("Each");

        assertEquals("Each", unitOfMeasure.getDescription());
    }
}