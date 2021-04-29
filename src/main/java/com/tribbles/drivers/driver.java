package com.tribbles.drivers;

import com.tribbles.model.Lab;
import com.tribbles.model.Tribble;
import com.tribbles.service.LabService;

import java.util.ArrayList;
import java.util.List;

public class driver {
    public static void main(String[] args) {

        Lab newLab;
        LabService labService = new LabService();

        System.out.println(labService.read(5));
    }

}
