package cl.fabioladiaz.contactos.controlador;

import cl.fabioladiaz.contactos.modelo.Contacto;
import cl.fabioladiaz.contactos.servicio.ContactoServicio;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactoControlador {

    private static Logger logger =  LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    ContactoServicio contactoServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Contacto> contactos = contactoServicio.listarContactos();
        contactos.forEach((contacto)->logger.info(contacto.toString()));
        modelo.put("contactos", contactos);
        return "index";
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar";
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto){
        logger.info("Contacto a agregar:" +contacto);
        contactoServicio.guardarContacto(contacto);
        return "redirect:/"; //redirigimos al controlar path
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value="id") int idContacto, ModelMap modelo){
        Contacto contacto = contactoServicio.buscarContactoPorId(idContacto);
        logger.info("Contacto a editar (mostrar): " + contacto);
        modelo.put("contacto", contacto);
        return "editar";

    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto") Contacto contacto){
        logger.info("Contacto aguardar (editar):"+contacto);
        contactoServicio.guardarContacto(contacto);
        return ("redirect:/");
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") int idContacto){
        Contacto contacto = new Contacto();
        contacto.setIdContacto(idContacto);
        contactoServicio.eliminarContacto(contacto);
        return "redirect:/";
    }



}
