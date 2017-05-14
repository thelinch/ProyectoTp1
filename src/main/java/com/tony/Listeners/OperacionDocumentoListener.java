package com.tony.Listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.tony.models.Documento.OperacionDocumento;
import com.tony.models.UsuarioInterno.AuditoriaUsuario;

public class OperacionDocumentoListener {

	@PrePersist
	public void InsertarAuditoriaDocumento(OperacionDocumento operacionDocumento) {
		AuditoriaUsuario aui = new AuditoriaUsuario(operacionDocumento);
		operacionDocumento.getAuditoriaUsuario().size();
		aui.setAccion("Registro");
		operacionDocumento.AddAuditoriaUsuario(aui);

	}
	@PreUpdate
	public void Configuar(OperacionDocumento op){
		
	}

}
