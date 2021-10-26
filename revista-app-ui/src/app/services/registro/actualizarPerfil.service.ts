import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { usuarioLoged } from "src/models/auth/usuarioLoged";
import { UsuarioNuevo } from "src/models/register/newUsuario";
import { UsuarioTag } from "src/models/register/usaurioTags";
import { usaurioActualizacion } from "src/models/register/usuarioActualizacion";
import { UsuarioInfo } from "src/models/register/usuarioInformacion";

@Injectable({
    providedIn:'root'
})

export class edicionPerfilService {


    readonly APY_URL="http://localhost:8080/revistas-app-backend/";

    usuarioNuevo!:UsuarioNuevo;
    

    constructor(private httpClient: HttpClient) {}

    public actualizarDatos(usuario:usaurioActualizacion): Observable<usuarioLoged>{
        return this.httpClient.put<usuarioLoged>(this.APY_URL+"RegistroControler",usuario);
    }

//esto falta terminar 
    


    public setUsuario(usuario:UsuarioNuevo){
        this.usuarioNuevo=usuario;
    }

    public getUsuario(){
        return this.usuarioNuevo;
    }



}