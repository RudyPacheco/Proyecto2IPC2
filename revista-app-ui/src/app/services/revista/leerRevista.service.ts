import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { edicionModel } from "src/models/revista/edicion.model";

@Injectable({
    providedIn:'root'
})


export class leerRevistaService {
    readonly APY_URL="http://localhost:8080/revistas-app-backend/RevistaControler";

    constructor(private httpClient:HttpClient) {
        
    }


    public downloadImage(edicion: edicionModel): string {
        return this.APY_URL+"?paht="+edicion.direccion;
      }



    public downloadImage2(): string {
        return this.APY_URL;
      }



}