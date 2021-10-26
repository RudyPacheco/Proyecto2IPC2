import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { loginServices } from "../login/login.services";


@Injectable({
    providedIn: 'root'
  })

export class reportesEditorService {
    
    
    readonly APY_URL="http://localhost:8080/revistas-app-backend/";


    
    constructor(private httpClient:HttpClient,private loginService:loginServices) {   }

    // public verReporte(revista:string,fechaI:string,fechaF:string){
    //     return this.APY_URL+"reporteComentarioServlet";
    // }

    public verReporte(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteComentarioServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF;
    }

    public descargarReporte(codigo:number,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteComentarioServlet?codigo="+codigo+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF+"&descargar=true";
    }

    public veRreporteSuscripciones(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteSuscripcionesServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF;
    }


    public descargarRreporteSuscripciones(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteSuscripcionesServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF+"&descargar=true";
    }

    public veRreporteMeGusta(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteMeGustaServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF;
    }

    public descargaReporteMeGusta(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteMeGustaServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF+"&descargar=true";
    }


    public verReporteGanancias(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteGananciasEServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF;
    }

    public descargarReporteGanancias(revista:string,fechaI:string,fechaF:string):string{
        return this.APY_URL+"reporteGananciasEServlet?revista="+revista+"&editor="+this.loginService.usuario.usuario+"&fechaI="+fechaI+"&fechaF="+fechaF+"&descargar=true";
    }



    


   
    




}