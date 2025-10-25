package saitel.medicina.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import saitel.medicina.entity.Formulario;
import saitel.medicina.repository.FormularioRepository;

@Service
public class FormularioServiceImplLog implements FormularioService{
    @Autowired
    private FormularioRepository formularioRepository;
    @Override 
    public Formulario saveFormulario(Formulario formulario){
        return formularioRepository.save(formulario);
    }

    @Override
    public Formulario getFormulario(Long idFormulario){
        Optional<Formulario> formulario = formularioRepository.findByIdFormulario(idFormulario);
        if (formulario.isPresent()) {
            return formulario.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Formulario con id " + idFormulario + " no encontrado");
        }
    }

    @Override
    public java.util.List<Formulario> findAll() {
        return formularioRepository.findAll();
    }

    @Override
    public java.util.Optional<Formulario> findById(Long idFormulario) {
        return formularioRepository.findById(idFormulario);
    }

    @Override
    public Formulario updateFormulario(Long idFormulario, Formulario formulario) {
        return formularioRepository.findById(idFormulario)
            .map(existing -> {
                formulario.setIdFormulario(idFormulario);
                return formularioRepository.save(formulario);
            }).orElse(null);
    }

    @Override
    public void deleteById(Long idFormulario) {
        formularioRepository.deleteById(idFormulario);
    }
}
