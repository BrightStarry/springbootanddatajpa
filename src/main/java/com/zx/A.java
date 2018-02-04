package com.zx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author:ZhengXing
 * datetime:2018-02-04 19:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class A {
    private Emp emp;
    private List<A> child;
}
