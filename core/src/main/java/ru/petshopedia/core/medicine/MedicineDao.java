package ru.petshopedia.core.medicine;

import ru.petshopedia.common.Medicine;

import java.util.List;

public interface MedicineDao {
    /**
     * Получить все лекарства
     */
    List<Medicine> getMedicines();

    /**
     * Получить лекарство по ID
     */
    Medicine getMedicineById(Integer id);

    /**
     * Добавить лекарство
     */
    void addMedicine(Medicine medicine);

    /**
     * Обновить данные по лекарству
     */
    void updateMedicine(Medicine medicine);

    /**
     * Удалить данные по лекарству
     */
    void deleteMedicine(Integer id);
}
