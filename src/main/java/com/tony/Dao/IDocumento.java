package com.tony.Dao;

import com.tony.models.Documento.Documento;


public interface IDocumento {
boolean Registrar(int IdUsuariointerno,Documento documento,int idTipoDocumento,boolean isTupac,int Usuaraio);
boolean EnviarArea(Documento documento,int TipoEnvio);
boolean EditarDocumento(Documento doc);
}
