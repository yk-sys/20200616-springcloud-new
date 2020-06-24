package com.aaa.yk.springcloud.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Book implements Serializable {
    private Long id;

    private String bookName;

    private Double bookPrice;


}