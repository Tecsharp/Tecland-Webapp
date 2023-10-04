package com.tecsharp.tecland.web.app.services.informacion.impl;

import org.springframework.stereotype.Service;

import com.tecsharp.tecland.web.app.repositories.informacion.InformacionRepository;
import com.tecsharp.tecland.web.app.repositories.informacion.impl.InformacionRepositoryImpl;
import com.tecsharp.tecland.web.app.services.informacion.InformacionService;

@Service
public class InformacionServiceImpl implements InformacionService {
    @Override
    public String recuperarInformacion(Integer id) {
        InformacionRepository inf = new InformacionRepositoryImpl();

        return inf.infoRecuperada(id);
    }
}
