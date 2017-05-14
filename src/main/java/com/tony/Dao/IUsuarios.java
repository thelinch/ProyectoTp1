package com.tony.Dao;

import java.util.List;

import com.tony.HerenciaEntidades.Persona;
import com.tony.models.Documento.Documento;

public interface IUsuarios {
boolean Registrar(Persona persona);
int NumeroDocumentos(int DniPersona);
List<Documento> DocumentosPersona(Persona person);
boolean AddDocumentosPersona(Persona Actual,Documento doc,Persona Derivada);
}
