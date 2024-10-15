package com.example.catdemo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author zhanhuibin
 * @since 2024-09-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Repository
public class UploadFile implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String name;
    String status;
    long size;
    String uid;
    String url;
    String type;
}
