package com.example.pw_api_u3_p5_ab.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pw_api_u3_p5_ab.repository.model.Estudiante;
import com.example.pw_api_u3_p5_ab.service.IEstudianteService;
import com.example.pw_api_u3_p5_ab.service.IMateriaService;
import com.example.pw_api_u3_p5_ab.service.to.EstudianteTO;
import com.example.pw_api_u3_p5_ab.service.to.MateriaTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


//API: por el proyecto
//servicio -> controller: clase controller
@RestController//Servicio
@RequestMapping(path="/estudiantes")
@CrossOrigin
public class EstudianteControllerRestFul {

    @Autowired
    private IEstudianteService estudianteService;
    @Autowired
	private IMateriaService materiaService;

 
    @GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)   
    public ResponseEntity<EstudianteTO> consular(@PathVariable Integer id){
        //240: grupo satisfaccion
        //240 Estudiante encontrado: recurso existente
        return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.buscarTO(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void guardar(@RequestBody Estudiante estudiante){
        this.estudianteService.guardar(estudiante);
    }

    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {   
        estudiante.setId(id); 
        this.estudianteService.actualizar(estudiante);
    }

    @PatchMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id){
        estudiante.setId(id);
        this.estudianteService.actualizarParcial(estudiante.getNombre(),estudiante.getApellido(), estudiante.getId());
    }

    //consumes = MediaType.APPLICATION_JSON_VALUE) recibe un json
    //produces = "application/xml") retorna un xml
    //produces = MediaType.APPLICATION_JSON_VALUE) retorna un json

    @DeleteMapping(path="/{id}")
    public void borrar(@PathVariable Integer id){
        this.estudianteService.borrar(id);
    }

    //http://localhost:8080/API/v1.0/Matricula/estudiantes/consultarTodo?genero=M
    @GetMapping (path = "/tmp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estudiante>> consultarTodo() {
        var list_est = estudianteService.consultarTodo();
        HttpHeaders heder = new HttpHeaders();
        heder.add("mensaje 242", "Recurso encontrado, lista creada");
        heder.add("info", "sistema en linea");
        return new ResponseEntity<>(list_est,heder,242);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHateoas() {
		List<EstudianteTO> ls = this.estudianteService.consultarTodoTO();
        for(EstudianteTO esto: ls){
            Link link = linkTo(methodOn(EstudianteControllerRestFul.class).consultarMateriasPorId(esto.getId())).withRel("materias");
            esto.add(link);
        }

		return ResponseEntity.status(HttpStatus.OK).body(ls);
	}

    // http://localhost:8080/API/v1.0/Matricula/estudiantes/1/materias
    @GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>> consultarMateriasPorId(@PathVariable Integer id){
		List<MateriaTO> ls = this.materiaService.selecionarPorIDEstrudiante(id);
		return ResponseEntity.status(HttpStatus.OK).body(ls);
	}

}
