package ru.petshopedia.core.medicine;

import org.springframework.stereotype.Service;
import ru.petshopedia.common.Medicine;

import java.util.List;

/**
 * Серсис предоставляющий работу с лекарствами
 */
@Service("medicineService")
public interface MedicineService {

    /**
     * Получение всех лекарст
     *
     * @return список лекарственных средст
     */
    List<Medicine> getMedicines();

    /**
     * Получение конкретного лекарства
     *
     * @param id идентификатор лекарсвенного средства
     *
     * @return see {@link ru.petshopedia.common.Medicine}
     */
    Medicine getMedicineById(Integer id);

    /**
     * Доавление новго лекарства
     *
     * @param medicine see {@link ru.petshopedia.common.Medicine}
     */
    void addMedicine(Medicine medicine);

    /**
     * Обновление данных по лекарству
     *
     * @param medicine see {@link ru.petshopedia.common.Medicine}
     */
    void updateMedicine(Medicine medicine);

    /**
     * Удаление лекарственного средства
     */
    void deleteMedicine(Integer id);
}
