import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { usuarioLogin } from "src/models/auth/usuarioLogin";
import { Observable } from "rxjs";
import { usuarioLoged } from "src/models/auth/usuarioLoged";



@Injectable({
    providedIn:'root'
})

export class loginServices {

    
     TOKEN: string ="";
     usuario!: usuarioLoged;
    readonly APY_URL = "http://localhost:8080/revistas-app-backend/";

    
    constructor(private httpClient: HttpClient) {  }

  /*  public createLogin(usuario: usuarioLogin): Observable<usuarioLogin>{
        return this.httpClient.post<usuarioLogin>(this.APY_URL+"LoginControler",usuario);
    }*/

    public createLogin(usuario: usuarioLogin): Observable<usuarioLoged>{
        return this.httpClient.post<usuarioLoged>(this.APY_URL+"LoginControler",usuario);      
    }

    public agregarToken(token: string){
        this.TOKEN=token;
    }

    public getToken(){
        return this.TOKEN;
    }

    public eliminarToken(){
        this.TOKEN="";
    }

    public agregarUsuario(usuario: usuarioLoged){
        this.usuario=usuario;
    }

    public getUsuario(){
        return this.usuario;
    }



}