package uniandes.edu.co.bancodelosandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.bancodelosandes.modelo.TipoIdentificacion;
import uniandes.edu.co.bancodelosandes.modelo.Usuario;
import uniandes.edu.co.bancodelosandes.repositorio.UsuarioRepository;

@Controller
public class UsuariosController {
    @Autowired 
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("usuario/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getTipoIdentificacion(), usuario.getNumIdentificacion(), usuario.getContrasena(), usuario.getNombre(), usuario.getApellido(), usuario.getNacionalidad(), usuario.getDireccion(), usuario.getEmail(), usuario.getTelefono(), usuario.getCiudad(), usuario.getDepartamento(), usuario.getCodigoPostal());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{numIdentificacion}")
    public String usuarioEditarForm(@PathVariable("numIdentificacion") String numIdentificacion, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(numIdentificacion);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{numIdentificacion}/save")
    public String usuarioEditarGuardar(@PathVariable("numIdentificacion") String numIdentificacion, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario.getContrasena(), usuario.getNombre(), usuario.getApellido(), usuario.getNacionalidad(), usuario.getDireccion(), usuario.getEmail(), usuario.getTelefono(), usuario.getCiudad(), usuario.getDepartamento(), usuario.getCodigoPostal(), numIdentificacion);
        return "redirect:/usuarios";
    }
    
    @GetMapping("/usuarios/{numIdentificacion}/delete")
    public String usuarioEliminar(@PathVariable("numIdentificacion") String numIdentificacion) {
        usuarioRepository.eliminarUsuario(numIdentificacion);
        return "redirect:/usuarios";
    }
}
