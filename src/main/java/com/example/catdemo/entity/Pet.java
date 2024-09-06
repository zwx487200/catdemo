package com.example.catdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author zhanhuibin
 * @since 2024-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Repository
public class Pet implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String Id;

    private String name;

    private String breed;

    private Integer age;

    private String gender;

    private BigDecimal weight;

    private Boolean vaccinated;

    private Boolean neutered;

    private LocalDateTime neuteredTime;

    private String ownerId;

    private LocalDateTime registrationDate;

}
