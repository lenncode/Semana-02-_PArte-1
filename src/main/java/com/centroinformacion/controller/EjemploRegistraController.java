package com.centroinformacion.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centroinformacion.entity.Editorial;
import com.centroinformacion.entity.Usuario;
import com.centroinformacion.repository.EditorialRepository;
import com.centroinformacion.util.AppSettings;

@RestController
@RequestMapping("/url/ejemplo")
@CrossOrigin(AppSettings.URL_CROSS_ORIGIN)
public class EjemploRegistraController {
    @Autowired
    private EditorialRepository ejemploService;

    // @GetMapping
    // private ResponseEntity<List<Ejemplo>> lista() {
    //     List<Ejemplo> listSalida = ejemploService.listaEjemplo();
    //     return ResponseEntity.ok(listSalida);

    // }

    @PostMapping
    public ResponseEntity<?> registra(@RequestBody Editorial objEjemplo) {
        HashMap<String, Object> salida = new HashMap<>();



        objEjemplo.setFechaRegistro(new Date());
        objEjemplo.setFechaActualizacion(new Date());
        objEjemplo.setEstado(AppSettings.ACTIVO);
        Usuario objUsuario = new Usuario();
        objUsuario.setIdUsuario(1);
        objEjemplo.setUsuarioRegistro(objUsuario);
		objEjemplo.setUsuarioActualiza(objUsuario);
        Editorial objSalida = ejemploService.save(objEjemplo);
        if (objSalida == null) {
            salida.put("mensaje", "Error en el registro");
        } else {
            salida.put("mensaje", "Registro de Editorial con el ID >>> " );
        }
        return ResponseEntity.ok(salida);
    }

}
