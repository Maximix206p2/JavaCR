package org.itstep.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.itstep.firm.Firm;
import org.itstep.firm.FirmJson;
import org.itstep.firm.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public List<ModelCar> findAll() {
        return modelRepository.findAll();
    }

    public ModelCar findModel(Long id) {
        ModelCar model = modelRepository.findById(id).orElse(null);
        return model;
    }
}
