import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { anuncioModel } from "src/models/anuncio/anuncio.model";



@Injectable({
    providedIn:'root'
})

export class anuncioService {

    readonly APY_URL="http://localhost:8080/revistas-app-backend/anuncioConrtoler";
    readonly ANUNCIOIMG_URL="http://localhost:8080/revistas-app-backend/anuncioImagenControler";

    constructor(private httpClient:HttpClient) {   }

    public generarRegistro(anuncio:anuncioModel): Observable<anuncioModel>{
        return this.httpClient.post<anuncioModel>(this.APY_URL,anuncio);
    }

    public generarRegistroImagen(anuncio:anuncioModel): Observable<anuncioModel>{
        return this.httpClient.post<anuncioModel>(this.ANUNCIOIMG_URL,anuncio);
    }

    public guardarImagen(filetUpload:File): Observable<void>{
        const formData: FormData = new FormData();
        formData.append("datafile", filetUpload,filetUpload.name)
        return this.httpClient.put<void>(this.ANUNCIOIMG_URL,formData);
    }
    //listando sin usuario
    public getlistaAnuncios(usuario:string):Observable<anuncioModel[]>{
        return this.httpClient.get<anuncioModel[]>(this.APY_URL);
    }

    public downloadImage(anuncio:anuncioModel): string {
        return this.ANUNCIOIMG_URL+"?anuncio="+anuncio.codigo;
      }



}