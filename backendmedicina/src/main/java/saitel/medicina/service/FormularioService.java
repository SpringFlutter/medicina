package saitel.medicina.service;

import saitel.medicina.entity.Formulario;

public interface FormularioService {
    Formulario saveFormulario(Formulario formulario);
    Formulario getFormulario(Long idFormulario);
    java.util.List<Formulario> findAll();
    java.util.Optional<Formulario> findById(Long idFormulario);
    Formulario updateFormulario(Long idFormulario, Formulario formulario);
    void deleteById(Long idFormulario);
}
