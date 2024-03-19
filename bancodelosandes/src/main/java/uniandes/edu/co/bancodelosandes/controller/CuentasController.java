package uniandes.edu.co.bancodelosandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.bancodelosandes.modelo.Cuenta;
import uniandes.edu.co.bancodelosandes.repositorio.CuentaRepository;

@Controller
public class CuentasController {
    @Autowired 
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas")
    public String cuentas(Model model) {
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "cuentas";
    }

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        return "cuentaNuevo";
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute Cuenta cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getNumCuenta(), cuenta.getTipoCuenta(), cuenta.getEstadoCuenta(), cuenta.getSaldo(), cuenta.getFechaUtimaTransaccion(), cuenta.getFechaCreacion(), cuenta.getCliente());
        return "redirect:/cuentas";
    }
    
    @GetMapping("/cuentas/{numCuenta}/edit")
    public String cuentaEditarForm(@PathVariable("numCuenta") Long numCuenta, Model model) {
        Cuenta cuenta = cuentaRepository.darCuenta(numCuenta);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar";
        } else {
            return "redirect:/cuentas";
        }
    }

    @PostMapping("/cuentas/{numCuenta}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("numCuenta") Long numCuenta, @ModelAttribute Cuenta cuenta) {
        cuentaRepository.actualizarCuenta(cuenta.getTipoCuenta(), cuenta.getEstadoCuenta(), cuenta.getSaldo(), cuenta.getFechaUtimaTransaccion(), cuenta.getFechaCreacion(), cuenta.getCliente(), numCuenta);
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{numCuenta}/delete")
    public String cuentaEliminar(@PathVariable("numCuenta") Long numCuenta) {
        cuentaRepository.eliminarCuenta(numCuenta);
        return "redirect:/cuentas";
    }
}
