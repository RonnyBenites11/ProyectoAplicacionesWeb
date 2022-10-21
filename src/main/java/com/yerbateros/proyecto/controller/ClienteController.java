package com.yerbateros.proyecto.controller;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinica.project.entity.Medicamento;
import com.clinica.project.entity.TipoMedicamento;
import com.yerbateros.proyecto.entity.Cliente;
import com.yerbateros.proyecto.entity.TipoDoc;
import com.yerbateros.proyecto.entity.Usuario;
import com.yerbateros.proyecto.service.ClienteService;
import com.yerbateros.proyecto.service.TipoDocService;
@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService servicioclie;
	
	@Autowired
	private TipoDocService servicioTipo;
	@RequestMapping("/lista")
	public String inicio(Model model) {
		//recuperar lista de medicamentos
		List<Cliente> info=servicioclie.listarTodos();
		//recuperar lista de tipos medicamentos
		//List<TipoMedicamento> data=servicioTipo.listarTodos();
		//recuperar lista de laboratorios
		List<TipoDoc> dataTipo=servicioTipo.listarTodos();
		//crear atributo
		model.addAttribute("cliente", info);
		//model.addAttribute("tipos",data);
		model.addAttribute("tipodocumento",dataTipo);
		
		return "cliente";
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("CodNro_Cliente") int CodNro_Cliente,
						 @RequestParam("Cod_TipoDoc") int tipodoc,@RequestParam("Nombres_Cliente") String nombre,
					     @RequestParam("Apellidos_Cliente") String apellido,@RequestParam("Cod_Usuario") int codusuario,
					     RedirectAttributes redirect) {
		try {
			//crear objeto de la entidad Medicamento
			Cliente bean=new Cliente();
			//setear
			bean.setCodNro_Cliente(CodNro_Cliente);
			TipoDoc tipod = new TipoDoc();
			//setear
			tipod.setCodDoc(tipodoc);
			bean.setTipodoc(tipod);
			
			bean.setNombre(nombre);
			bean.setApellido(apellido);
			Usuario tipo = new Usuario();
			//setear
			tipo.setCodigo(codusuario);
			bean.setCodusuario(tipo);
			
		
			servicioclie.grabar(bean);
			//
			if(CodNro_Cliente==0)
				redirect.addFlashAttribute("MENSAJE","Cliente registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Cliente actualizado");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/cliente/lista";
	}
	@RequestMapping("/buscarPorID")
	@ResponseBody
	public Cliente buscarPorID(@RequestParam("CodNro_Cliente") int CodNro_Cliente) {
		Cliente med=servicioclie.buscar(CodNro_Cliente);
		return med;
		
	}
	@RequestMapping("/eliminarPorID")
	public String eliminarPorID(@RequestParam("CodNro_Cliente") int CodNro_Cliente,RedirectAttributes redirect) {
		try {
			servicioclie.eliminar(CodNro_Cliente);
			redirect.addFlashAttribute("MENSAJE","Cliente eliminado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/cliente/lista";
	}
	
	@RequestMapping("/listarPorTipo")
	@ResponseBody
	public List<TipoDoc> listarPortipo(@RequestParam("codigo") int cod) {
		List<TipoDoc> lista=servicioTipo.listarTodos(cod);
		return lista;
		
	}
	
	@RequestMapping("/subir-foto")
	public String subirFoto(@RequestParam("data") MultipartFile file,
							RedirectAttributes redirect,@RequestParam("codigoFoto")Integer cod ){
		try {
			String nomArchivo;
			byte[] datos;
			//obtener nombre del archivo
			nomArchivo=file.getOriginalFilename();
			//obtener los bytes del archivo
			datos=file.getBytes();
			//ruta para guardar IMG
			String ruta="c://fotos//";
			//generar archivo
			Files.write(Paths.get(ruta+nomArchivo),datos);
			//actualizar campos "foto,nom_archivo"
			servicioMed.actualizarFoto(datos, nomArchivo, cod);
			redirect.addFlashAttribute("MENSAJE","Foto actualizada");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/medicamento/lista";
	}
}
