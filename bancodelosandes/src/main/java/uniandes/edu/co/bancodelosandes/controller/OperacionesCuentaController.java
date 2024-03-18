package uniandes.edu.co.bancodelosandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.bancodelosandes.modelo.OperacionCuenta;
import uniandes.edu.co.bancodelosandes.repositorio.OperacionCuentaRepository;

@Controller
public class OperacionesCuentaController {
    @Autowired
    private OperacionCuentaRepository operacionCuentaRepository;

    @GetMapping("/operacionesCuenta")
    public String operacionesCuenta(Model model) {
        model.addAttribute("operacionesCuenta", operacionCuentaRepository.darOperacionesCuenta());
        return "operacionesCuenta";
    }

    @GetMapping("/operacionesCuenta/new")
    public String operacionCuentaForm(Model model) {
        model.addAttribute("operacionCuenta", new OperacionCuenta());
        return "operacionCuentaNuevo";
    }

    @PostMapping("operacionCuenta/new/save")
    public String operacionCuentaGuardar(@ModelAttribute OperacionCuenta operacionCuenta) {
        operacionCuentaRepository.insertarOperacionCuenta(operacionCuenta.getId(), operacionCuenta.getTipoOperacionCuenta(), operacionCuenta.getCuenta(), operacionCuenta.getOperacionBancaria());
        return "redirect:/operacionesCuenta";
    }

    @GetMapping("/operacionesCuenta/{id}")
    public String operacionCuentaEditarForm(@PathVariable("id") Long id, Model model) {
        OperacionCuenta operacionCuenta = operacionCuentaRepository.darOperacionCuenta(id);
        if (operacionCuenta != null) {
            model.addAttribute("operacionCuenta", operacionCuenta);
            return "operacionCuentaEditar";
        } else {
            return "redirect:/operacionesCuenta";
        }
    }

    @PostMapping("/operacionesCuenta/{id}/save")
    public String operacionCuentaEditarGuardar(@PathVariable("id") Long id, @ModelAttribute OperacionCuenta operacionCuenta) {
        operacionCuentaRepository.actualizarOperacionCuenta(operacionCuenta.getTipoOperacionCuenta(), operacionCuenta.getCuenta(), operacionCuenta.getOperacionBancaria(), id);
        return "redirect:/operacionesCuenta";
    }

    @GetMapping("/operacionesCuenta/{id}/delete")
    public String operacionCuentaEliminar(@PathVariable("id") Long id) {
        operacionCuentaRepository.eliminarOperacionCuenta(id);
        return "redirect:/operacionesCuenta";
    }
}
