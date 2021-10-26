import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { comentario } from "src/models/interacciones/comentario";
import { meGusta } from "src/models/interacciones/megusta.model";
import { permisosModel } from "src/models/interacciones/permisos.model";


@Injectable({
    providedIn: 'root'
  })


export class interaccionService {


    usuario!:string;
    codigoRevista!:number;
    readonly APY_URL = "http://localhost:8080/revistas-app-backend/";


    constructor(private httpClient:HttpClient) {
        
    }


    public crearComentario(comentario:comentario): Observable<comentario>{
        return this.httpClient.post<comentario>(this.APY_URL+"comentarioControler",comentario);      
    }

    public darMegusta(like:meGusta): Observable<meGusta>{
        return this.httpClient.post<meGusta>(this.APY_URL+"meGustaControler",like);      
    }

    public listarComentariosRevista(): Observable<comentario[]>{
        return this.httpClient.get<comentario[]>(this.APY_URL+"comentarioControler"+"?codigo="+this.codigoRevista);      
    }



    public listarMegustaUsuario(): Observable<meGusta[]>{
        return this.httpClient.get<meGusta[]>(this.APY_URL+"meGustaControler"+"?usuario="+this.usuario);      
    }


    //aun no terminado--
    public actualizarPermisos(permiso:permisosModel): Observable<permisosModel>{
        return this.httpClient.post<permisosModel>(this.APY_URL+"permisosControler",permiso);  
    }





}