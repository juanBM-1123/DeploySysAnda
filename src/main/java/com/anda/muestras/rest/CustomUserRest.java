package com.anda.muestras.rest;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.anda.muestras.service.CustomUserService;
import com.anda.muestras.service.LoteMuestraService;
import com.anda.muestras.model.CustomUser;
import com.anda.muestras.model.LoteMuestras;
import com.anda.muestras.model.Roles;


@RestController
@RequestMapping("/api/users")
public class CustomUserRest {
	
	@Autowired
	private CustomUserService customUserService;
	//private Log log = LogFactory.getLog(getClass());
	@Autowired
	private LoteMuestraService loteMuestraService;
	
	@GetMapping("/byRole")
    public ResponseEntity<List<CustomUser>> getUsersByRole(@RequestParam Roles role) {
        List<CustomUser> users = customUserService.findByRol(role);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
	@Autowired
    public CustomUserRest(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

	
    @GetMapping("/id/{id}")  
    private ResponseEntity<CustomUser> getCustomUserById (@PathVariable("id") long id) {
        CustomUser customUser = this.customUserService.findById(id);

        if (customUser != null) {
            return ResponseEntity.ok(customUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
    @GetMapping()
    private ResponseEntity<CustomUser> getCustomUserAutenticado(){
    	Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Optional<CustomUser> user = this.customUserService.findByUsername(userDetail.getUsername());
		return ResponseEntity.ok(user.get());
		
    }
    
    @GetMapping("/solicitud/muestreador/{idSolicitud}")
    private ResponseEntity<CustomUser> obtenerMuestreadorAsociadoASolicitud(@PathVariable Long idSolicitud){
    	LoteMuestras loteMuestra = this.loteMuestraService.obtenerLotePorSolicitud(idSolicitud);
    	return ResponseEntity.ok(loteMuestra.getCustomUser());
    }
    
}

//http://localhost:9002/api/users/byRole?role=MUESTREADOR