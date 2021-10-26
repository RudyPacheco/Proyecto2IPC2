import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { usuarioLoged } from "src/models/auth/usuarioLoged";


@Injectable({
    providedIn:'root'
})



export class editorService {

    readonly APY_URL="http://localhost:8080/revistas-app-backend/editorControler";

    usuarioEditor!:usuarioLoged;
    usuario!:string;


    constructor(private httpClient:HttpClient) {    }


    public getInfoEditor():Observable<usuarioLoged>{
        return this.httpClient.get<usuarioLoged>(this.APY_URL+"?editor="+this.usuario);
    }



}