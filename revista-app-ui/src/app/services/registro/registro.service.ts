import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UsuarioNuevo } from "src/models/register/newUsuario";

@Injectable({
    providedIn:'root'
})

export class registroServices {


    readonly APY_URL="http://localhost:8080/revistas-app-backend/";
    usuarioNuevo!:UsuarioNuevo;


    constructor(private httpClient: HttpClient) {}

    public generarRegistro(usuario:UsuarioNuevo): Observable<UsuarioNuevo>{
        return this.httpClient.post<UsuarioNuevo>(this.APY_URL+"RegistroControler",usuario);
    }

    public setUsuario(usuario:UsuarioNuevo){
        this.usuarioNuevo=usuario;
    }

    public getUsuario(){
        return this.usuarioNuevo;
    }



}