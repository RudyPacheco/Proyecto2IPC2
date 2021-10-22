import { HttpClient } from "@angular/common/http";
import { EventEmitter, Injectable, Output } from "@angular/core";
import { Observable } from "rxjs";
import { revista } from "src/models/revista/revista.model";


@Injectable({
    providedIn:'root'
})


export class revistaService {

    readonly APY_URL="http://localhost:8080/revistas-app-backend/uploadRevista";

    usuario!:string;
    editor!:string;
    revistaSelec!:revista;

    @Output()
    emisorSeleccion: EventEmitter<revista> = new EventEmitter();

    constructor(private httpClient: HttpClient) {}

    public generarRegistro(revista:revista): Observable<revista>{
        return this.httpClient.post<revista>(this.APY_URL,revista);

    }

    public guardarRevista(filetUpload:File): Observable<void>{
        const formData: FormData = new FormData();
        formData.append("datafile", filetUpload,filetUpload.name)
        return this.httpClient.put<void>(this.APY_URL,formData);
        
    }

    public getlistaRevistasGenerales():Observable<revista[]>{
        return this.httpClient.get<revista[]>(this.APY_URL+"?general="+this.usuario);
    }


    public getlistaRevistasEditor():Observable<revista[]>{
        return this.httpClient.get<revista[]>(this.APY_URL+"?editor="+this.editor);
    }

    public getlistaRevistasSuscritas():Observable<revista[]>{
        return this.httpClient.get<revista[]>(this.APY_URL+"?usuario="+this.usuario);
    }


}