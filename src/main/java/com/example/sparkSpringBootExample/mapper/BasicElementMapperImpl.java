package com.example.sparkSpringBootExample.mapper;

import com.example.sparkSpringBootExample.entity.BasicElement;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class BasicElementMapperImpl implements BasicElementMapper {
    @Override
    public BasicElement call(Row value) throws Exception {
        return BasicElement.builder()
                .id(Long.parseLong(value.getAs("ID объекта")))
                .name(value.getAs("Наименование"))
                .type(value.getAs("Тип объекта"))
                .description(value.getAs("Описание"))
                .status(value.getAs("Статус записи"))
                .smId(value.getAs("ID Service Manager"))
                .parentName(value.getAs("Родительский объект"))
                .businessLine(value.getAs("Бизнес-линия заказчика/владельца"))
                .archEa(value.getAs("Архитектор EA"))
                .archSa(value.getAs("Архитектор SA"))
                .businessAdmin(value.getAs("Ответственный от бизнеса"))
                .supportAdmin(value.getAs("Ответственный за сопровождение"))
                .devAdmin(value.getAs("Ответственный за развитие от ИТ"))
                .replaceOn(value.getAs("Заменяется на системы"))
                .solutionStatus(value.getAs("Статус решения"))
                .lifecycleState(value.getAs("Этап жизненного цикла"))
                .priority(value.getAs("Критичность"))
                .place(value.getAs("Размещение"))
                .solDate(value.getAs("Дата ввода") != null ?
                        LocalDate.parse(value.getAs("Дата ввода"), DateTimeFormatter.ofPattern("M/d/yy"))
                        .format(DateTimeFormatter.ofPattern("dd.MM.yyy")):
                        null)
                .eolDate(value.getAs("Дата вывода") != null ?
                        LocalDate.parse(value.getAs("Дата вывода"), DateTimeFormatter.ofPattern("M/d/yy"))
                        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")):
                        null)
                .applicationServer(value.getAs("Сервер приложений"))
                .applicationServerOperatingSystem(value.getAs("ОС сервера приложения"))
                .dbServer(value.getAs("Сервер БД"))
                .dbServerOperatingSystem(value.getAs("ОС сервера БД"))
                .clientLanguage(value.getAs("Язык (клиент)"))
                .serverLanguage(value.getAs("Язык (сервер,бэкэнд)"))
                .vendor(value.getAs("Вендор/разработчик"))
                .build();
    }
}
