import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { edicionModel } from "src/models/revista/edicion.model";
import { revista } from "src/models/revista/revista.model";

@Injectable({
    providedIn:'root'
})


export class edicionService {

    readonly APY_URL="http://localhost:8080/revistas-app-backend/edicionControler";

    revistaSelect!:revista;

    constructor(private httpClient: HttpClient) {}

    public generarRegistro(revista:revista): Observable<revista>{
        return this.httpClient.post<revista>(this.APY_URL,revista);

    }

    public guardarRevista(filetUpload:File): Observable<void>{
        const formData: FormData = new FormData();
        formData.append("datafile", filetUpload,filetUpload.name)
        return this.httpClient.put<void>(this.APY_URL,formData);
    }

    public getlistaEdiciones():Observable<edicionModel[]>{
        return this.httpClient.get<edicionModel[]>(this.APY_URL+"?codigo="+this.revistaSelect.codigo);
    }



}