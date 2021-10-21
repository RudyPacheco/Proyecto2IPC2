import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable({
    providedIn: 'root'
  })

export class etiquetasService {

    readonly APY_URL = "http://localhost:8080/revistas-app-backend/";

    constructor(private httpClient : HttpClient) {}

    public getEtiquetas(): Observable<string[]>{
        return this.httpClient.get<string[]>(this.APY_URL+"TagControler");
    }

    public getCategorias(): Observable<string[]>{
        return this.httpClient.get<string[]>(this.APY_URL+"CategoriaControler");
    }




}