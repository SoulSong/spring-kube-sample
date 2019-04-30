package com.shf.spring.kube.exception.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Description:
 * Wrap exception message
 *
 * @Author: songhaifeng
 * @Date: 2019/4/30 22:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorEntity {

    private Date timestamp;
    private String message;
    private String details;

}
