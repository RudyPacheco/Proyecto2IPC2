import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { suscripcion } from "src/models/auth/suscripcion/suscripcion.model";
import { revista } from "src/models/revista/revista.model";



@Injectable({
    providedIn:'root'
})




export class suscripcionService {

    readonly APY_URL="http://localhost:8080/revistas-app-backend/suscripcionControler";
    

    usuario!:string;

    constructor(private httpClient: HttpClient) {
        
    }


    public generarSuscripcion(suscripcion:suscripcion): Observable<suscripcion>{
        return this.httpClient.post<suscripcion>(this.APY_URL,suscripcion);

    }


    public getlistaRevistasSuscritas():Observable<revista[]>{
        return this.httpClient.get<revista[]>(this.APY_URL+"?usuario="+this.usuario);
    }



}