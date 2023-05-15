package org.itstep;

import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
public class DataCalc {
    private int a;
    private int b;
    private int c;
    private int op;

}
