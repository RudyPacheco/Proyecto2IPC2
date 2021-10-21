import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UsuarioNuevo } from "src/models/register/newUsuario";
import { UsuarioTag } from "src/models/register/usaurioTags";
import { UsuarioInfo } from "src/models/register/usuarioInformacion";

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

    public guardarInformacion(usuario:UsuarioInfo): Observable<UsuarioInfo>{
        return this.httpClient.post<UsuarioInfo>(this.APY_URL+"InfoControler",usuario);
    }


    public guardarInteres(usuario:UsuarioTag): Observable<UsuarioTag>{
        return this.httpClient.post<UsuarioTag>(this.APY_URL+"TagControler",usuario);
    }


    public setUsuario(usuario:UsuarioNuevo){
        this.usuarioNuevo=usuario;
    }

    public getUsuario(){
        return this.usuarioNuevo;
    }



}