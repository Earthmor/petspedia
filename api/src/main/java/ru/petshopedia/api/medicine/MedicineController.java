package ru.petshopedia.api.medicine;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.petshopedia.common.Medicine;
import ru.petshopedia.common.Result;
import ru.petshopedia.common.TableResult;
import ru.petshopedia.core.medicine.MedicineService;

import java.util.List;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    /** */
    static final Logger log = Logger.getLogger(MedicineController.class);

    /**
     * Серсис предоставляющий работу с лекарствами
     */
    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    /**
     * Получить всю информацию по лекарствам
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<TableResult> getMedicines() {
        List<Medicine> medicines = medicineService.getMedicines();
        return new ResponseEntity<>(new TableResult("OK", true, medicines), HttpStatus.OK);
    }

    /**
     * Добавление данных о лекарственном средстве
     *
     * @param medicine данные по лекарству
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody ResponseEntity<Result> addMedicine(@RequestBody Medicine medicine){
        try {
            medicineService.addMedicine(medicine);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new Result(e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Result("OK", true), HttpStatus.OK);
    }

    /**
     * Получение данных по лекарственному средству
     *
     * @param id идентификатор лекарства
     *
     * @return see {@link ru.petshopedia.common.Medicine}
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = "application/json")
    public @ResponseBody Medicine getMedicineById(@PathVariable Integer id){
        System.out.println(medicineService.getMedicineById(id).getCreateDate());
        return medicineService.getMedicineById(id);
    }

    /**
     * Обновление информации о лекарственном средстве
     *
     * @param medicine данные по лекарству
     */
    @RequestMapping(method = RequestMethod.POST, value = "/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<Result> updateMedicine(@RequestBody Medicine medicine){
        try {
            medicineService.updateMedicine(medicine);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(new Result(e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Result("OK", true), HttpStatus.OK);
    }

    /**
     * Удаление данных о лекарстве
     *
     * @param id идентификатор лекарсвенного средства
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<Result> deleteMedicine(@PathVariable Integer id){
        try {
            medicineService.deleteMedicine(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(new Result(e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Result("OK", true), HttpStatus.OK);
    }
}
