package ru.petshopedia.core.medicine;

import org.springframework.cache.annotation.Cacheable;
import ru.petshopedia.common.Medicine;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    private MedicineDao medicineDao;

    /**
     * see {@inheritDoc}
     */
    @Override
    public List<Medicine> getMedicines() {
        return medicineDao.getMedicines();
    }

    /**
     * see {@inheritDoc}
     */
    @Override
    @Cacheable(value = "medicines", key = "#id")
    public Medicine getMedicineById(Integer id) {
        return medicineDao.getMedicineById(id);
    }

    /**
     * see {@inheritDoc}]
     */
    @Override
    public void addMedicine(Medicine medicine) {
        medicineDao.addMedicine(medicine);
    }

    /**
     * see {@inheritDoc}
     */
    @Override
    public void updateMedicine(Medicine medicine) {
        medicineDao.updateMedicine(medicine);
    }

    /**
     * see {@inheritDoc}
     */
    @Override
    public void deleteMedicine(Integer id) {
        medicineDao.deleteMedicine(id);
    }

    /**
     * see {@link #medicineDao}
     */
    public void setMedicineDao(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }
}
