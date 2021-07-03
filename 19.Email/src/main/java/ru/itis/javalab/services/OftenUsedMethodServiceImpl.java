package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.javalab.models.OftenUsedMethodModel;
import ru.itis.javalab.repositories.OftenUsedMethodRepository;

@Service
public class OftenUsedMethodServiceImpl implements OftenUsedMethodService {

    @Autowired
    private OftenUsedMethodRepository methodRepository;

    @Override
    public void refresh(String methodName) {
        OftenUsedMethodModel methodModel = null;
        methodModel = methodRepository.getByMethodName(methodName)
                .orElse(methodModel.builder()
                                .methodName(methodName)
                                .count(0)
                                .build());

        methodModel.setCount(methodModel.getCount() + 1);
        methodRepository.save(methodModel);
    }
}
